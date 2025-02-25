package io.secugrow.demo.pageobjects

import io.secugrow.demo.driverutil.WebDriverSession
import org.openqa.selenium.By
import org.openqa.selenium.support.ui.ExpectedConditions

class AboutPage(session: WebDriverSession) : MainPage(session) {

    init {
        id = Tabs.ABOUT.id
    }
}