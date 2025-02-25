package io.secugrow.demo.pageobjects

enum class PageUrls(val subUrl: String) {
    HOME("/");

    fun getFullUrl(baseUrl: String): String {
        return baseUrl + subUrl
    }
}

enum class Tabs(val id: Int, val title: String) {
    HOME(0, "Home"),
    ABOUT(1, "About"),
    SPEAKERS(7, "Speakers Bios")
}
