import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

plugins {
    with(Plugins) {
        // Language Plugins
        `java-library`

        // Git Repo Information
        id("org.ajoberstar.grgit") version GRGIT

        // Maven Publication
        id("io.github.gradle-nexus.publish-plugin") version NEXUS_PUBLISH
        `maven-publish`
        signing
    }
}

group = Coordinates.GROUP
version = Coordinates.VERSION

// What JVM version should this project compile to
val targetVersion = "1.8"
// What JVM version this project is written in
val sourceVersion = "1.8"

// Maven Repositories
repositories {
    mavenLocal()
    mavenCentral()
    maven("https://jitpack.io")
}

// Project Dependencies
dependencies {
    with(Dependencies) {
        annotationProcessor("com.github.stardust-enterprises", "uncheck", UNCHECK)
        testImplementation("org.junit.jupiter", "junit-jupiter", JUNIT)
    }
}

tasks {
    test {
        useJUnitPlatform()
    }

    // Configure JVM versions
    compileJava {
        targetCompatibility = targetVersion
        sourceCompatibility = sourceVersion
    }

    // The original artifact, we just have to add the API source output and the
    // LICENSE file.
    jar {
        fun normalizeVersion(versionLiteral: String): String {
            val regex = Regex("(\\d+\\.\\d+\\.\\d+).*")
            val match = regex.matchEntire(versionLiteral)
            require(match != null) {
                "Version '$versionLiteral' does not match version pattern, e.g. 1.0.0-QUALIFIER"
            }
            return match.groupValues[1]
        }

        val buildTimeAndDate = OffsetDateTime.now()
        val buildDate = DateTimeFormatter.ISO_LOCAL_DATE.format(buildTimeAndDate)
        val buildTime = DateTimeFormatter.ofPattern("HH:mm:ss.SSSZ").format(buildTimeAndDate)

        mapOf("Created-By" to "${System.getProperty("java.version")} (${System.getProperty("java.vendor")} ${
            System.getProperty("java.vm.version")
        })",
            "Build-Date" to buildDate,
            "Build-Time" to buildTime,
            "Build-Revision" to grgit.log()[0].id,
            "Specification-Title" to project.name,
            "Specification-Version" to normalizeVersion(project.version.toString()),
            "Specification-Vendor" to Coordinates.VENDOR,
            "Implementation-Title" to Coordinates.NAME,
            "Implementation-Version" to Coordinates.VERSION,
            "Implementation-Vendor" to Coordinates.VENDOR,
            "Bundle-Name" to Coordinates.NAME,
            "Bundle-Description" to Coordinates.DESC,
            "Bundle-DocURL" to "https://${Coordinates.GIT_HOST}/${Coordinates.REPO_ID}",
            "Bundle-Vendor" to Coordinates.VENDOR,
            "Bundle-SymbolicName" to Coordinates.GROUP + '.' + Coordinates.NAME).forEach { (k, v) ->
            manifest.attributes[k] = v
        }

        from("LICENSE")
    }

    // Source artifact, including everything the 'main' does but not compiled.
    create("sourcesJar", Jar::class) {
        group = "build"

        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)

        from("LICENSE")
    }

    // The Javadoc artifact, containing the Dokka output and the LICENSE file.
    create("javadocJar", Jar::class) {
        group = "build"

        archiveClassifier.set("javadoc")
        dependsOn(javadoc)
        from(javadoc)

        from("LICENSE")
    }
}

// Define the default artifacts' tasks
val defaultArtifactTasks = arrayOf(
    tasks["sourcesJar"],
    tasks["javadocJar"],
)

// Declare the artifacts
artifacts {
    defaultArtifactTasks.forEach(::archives)
}

publishing.publications {
    // Sets up the Maven integration.
    create("mavenJava", MavenPublication::class.java) {
        from(components["java"])
        defaultArtifactTasks.forEach(::artifact)

        with(Coordinates) {
            pom {
                name.set(NAME)
                description.set(DESC)
                url.set("https://$GIT_HOST/$REPO_ID")

                with(Pom) {
                    licenses {
                        licenses.forEach {
                            license {
                                name.set(it.name)
                                url.set(it.url)
                                distribution.set(it.distribution)
                            }
                        }
                    }

                    developers {
                        developers.forEach {
                            developer {
                                id.set(it.id)
                                name.set(it.name)
                            }
                        }
                    }
                }

                scm {
                    connection.set("scm:git:git://$GIT_HOST/$REPO_ID.git")
                    developerConnection.set("scm:git:ssh://$GIT_HOST/$REPO_ID.git")
                    url.set("https://$GIT_HOST/$REPO_ID")
                }
            }
        }

        // Configure the signing extension to sign this Maven artifact.
        signing.sign(this)
    }
}

// Configure publishing to Maven Central
nexusPublishing.repositories.sonatype {
    nexusUrl.set(uri("https://s01.oss.sonatype.org/service/local/"))
    snapshotRepositoryUrl.set(uri("https://s01.oss.sonatype.org/content/repositories/snapshots/"))

    // Skip this step if environment variables NEXUS_USERNAME or NEXUS_PASSWORD aren't set.
    username.set(properties["NEXUS_USERNAME"] as? String ?: return@sonatype)
    password.set(properties["NEXUS_PASSWORD"] as? String ?: return@sonatype)
}

// Task priority
tasks.getByName("closeAndReleaseSonatypeStagingRepository")
    .mustRunAfter("publishToSonatype")

// Wrapper task since calling both one after the other
// in IntellIJ seems to cause some problems.
tasks.create("releaseToSonatype") {
    this.dependsOn(
        "publishToSonatype",
        "closeAndReleaseSonatypeStagingRepository"
    )
    this.group = "publishing"
}
