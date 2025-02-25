package io.secugrow.demo.pageobjects

import io.secugrow.demo.driverutil.WebDriverSession
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

open class MainPage(session: WebDriverSession) : AbstractPage(session) {

    protected var id = 0
    var contentTab = lazy { wdwait.until(ExpectedConditions.presenceOfElementLocated(By.id("pane-$id"))) }

    fun switchTabWithText(tabname: String): MainPage {
        wdwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-toggle='tab'][text()='$tabname']")))
            .click()
        id = Tabs.entries.first { it.title == tabname }.id



        return when (tabname) {
            "Speakers Bios" -> SpeakersPage(session)
            else -> {
                this
            }
        }


    }
}
