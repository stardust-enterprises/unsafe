object Coordinates {
    const val NAME = "unsafe"
    const val DESC = "Allows for static access to Java's Unsafe API."
    const val VENDOR = "Stardust Enterprises"

    const val GIT_HOST = "github.com"
    const val REPO_ID = "stardust-enterprises/$NAME"

    const val GROUP = "fr.stardustenterprises"
    const val VERSION = "1.7.1"
}

object Pom {
    val licenses = arrayOf(
        License("CC0-1.0", "https://creativecommons.org/publicdomain/zero/1.0/")
    )
    val developers = arrayOf(
        Developer("xtrm"),
        Developer("auoeke"),
        Developer("gudenau"),
    )
}

data class License(val name: String, val url: String, val distribution: String = "repo")
data class Developer(val id: String, val name: String = id)
