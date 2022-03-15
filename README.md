# unsafe

[![Build][badge-github-ci]][project-gradle-ci]
[![Maven Central][badge-mvnc]][project-mvnc]

allows for static access to Java's Unsafe API.

this project is a fork of [auoeke's unsafe][auoeke-unsafe], built for [Java 8][jvm] and published on [maven central][mvnc].

**Note:** [proof that I am allowed to publish this.][fork-proof]

# importing

you can import [unsafe][project-url] from [maven central][mvnc] by adding it to your dependencies:

## gradle

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation("fr.stardustenterprises:unsafe:{VERSION}")
}
```

## maven

```xml
<dependency>
    <groupId>fr.stardustenterprises</groupId>
    <artifactId>unsafe</artifactId>
    <version>{VERSION}</version>
</dependency>
```

# troubleshooting

if you ever encounter any problem **related to this project**, you can [open an issue][new-issue] describing what the
problem is. please, be as precise as you can, so that we can help you asap. we are most likely to close the issue if it
is not related to our work.

# contributing

you can contribute by [forking the repository][fork], making your changes and [creating a new pull request][new-pr]
describing what you changed, why and how.

# licensing

this project is under the [CC-BY-4.0 license][project-license], 
as per [requested by gudenau][license-req]

<!-- Links -->

[jvm]: https://adoptium.net "adoptium website"

[kotlin]: https://kotlinlang.org "kotlin website"

[rust]: https://rust-lang.org "rust website"

[mvnc]: https://repo1.maven.org/maven2/ "maven central website"

[auoeke-unsafe]: https://github.com/auoeke/unsafe "auoeke's unsafe project"

<!-- Project Links -->

[project-url]: https://github.com/stardust-enterprises/unsafe "project github repository"

[fork]: https://github.com/stardust-enterprises/unsafe/fork "fork this repository"

[new-pr]: https://github.com/stardust-enterprises/unsafe/pulls/new "create a new pull request"

[new-issue]: https://github.com/stardust-enterprises/unsafe/issues/new "create a new issue"

[project-mvnc]: https://maven-badges.herokuapp.com/maven-central/fr.stardustenterprises/unsafe "maven central repository"

[project-gradle-ci]: https://github.com/stardust-enterprises/unsafe/actions/workflows/gradle-ci.yml "gradle ci workflow"

[project-license]: https://github.com/stardust-enterprises/unsafe/blob/trunk/LICENSE "LICENSE source file"

<!-- Badges -->

[badge-mvnc]: https://maven-badges.herokuapp.com/maven-central/fr.stardustenterprises/unsafe/badge.svg "maven central badge"

[badge-github-ci]: https://github.com/stardust-enterprises/unsafe/actions/workflows/build.yml/badge.svg?branch=trunk "github actions badge"

<!-- Proofs -->

[fork-proof]: https://github.com/stardust-enterprises/unsafe/blob/trunk/.github/screenshots/fork_proof.png, "proof that I can publish this fork"

[license-req]: https://github.com/stardust-enterprises/unsafe/blob/trunk/.github/screenshots/license_proof.png, "license requirement"
