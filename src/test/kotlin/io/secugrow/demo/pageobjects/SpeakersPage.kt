package io.secugrow.demo.pageobjects

import io.secugrow.demo.driverutil.WebDriverSession
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

class SpeakersPage(session: WebDriverSession) : MainPage(session) {

    init {
        id = Tabs.SPEAKERS.id
    }


    fun getAllSpeakers(): List<String> {
        return wdwait.until(
            ExpectedConditions.presenceOfNestedElementsLocatedBy(
                By.id("pane-$id"),
                By.cssSelector("div.card-body strong:first-of-type")
            )
        ).map { it.text }
    }


}