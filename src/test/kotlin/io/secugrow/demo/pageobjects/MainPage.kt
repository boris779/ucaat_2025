package io.secugrow.demo.pageobjects

import io.secugrow.demo.driverutil.WebDriverSession
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

open class MainPage(session: WebDriverSession) : AbstractPage(session) {

    protected var id = 0
    var contentTab = lazy { wdwait.until(ExpectedConditions.presenceOfElementLocated(By.id("pane-$id"))) }

    fun switchTabWithText(tabname: String): MainPage {


        val locator = when  (session.isMobile()) {
            true -> By.xpath("//a[@data-toggle='collapse'][contains(text(),'$tabname')]")
            false ->By.xpath("//a[@data-toggle='tab'][text()='$tabname']")
        }

        wdwait.until(ExpectedConditions.elementToBeClickable(locator))
            .click()
        id = Tabs.entries.first { it.title == tabname }.id



        return when (tabname) {
            "Speakers Bios" -> SpeakersPage(session)
            else -> {
                this
            }
        }


    }

    fun acceptCookies() {
        wdwait.until(ExpectedConditions.elementToBeClickable(By.id("continue_button"))).click()
    }
}
