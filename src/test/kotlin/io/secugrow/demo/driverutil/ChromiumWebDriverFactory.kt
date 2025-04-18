package io.secugrow.demo.driverutil

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class ChromiumWebDriverFactory : WebDriverFactory() {

    override fun createDriver(): WebDriver {

        val options = ChromeOptions()

        webDriver = ChromeDriver(options)
        webDriver.manage().window().size = screenDimension.dimension

        return webDriver
    }


}
