

package io.secugrow.demo.driverutil

import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URI

class RemoteFirefoxWebDriverFactory : RemoteWebDriverFactory() {

    override fun createDriver(): WebDriver {

        val options = FirefoxOptions()
        options.setCapability(CapabilityType.BROWSER_NAME, "firefox")
        webDriver = RemoteWebDriver(URI.create("${ getRemoteTestingServer()}/wd/hub").toURL(),  options.merge(caps))
        webDriver.manage().window().maximize()

        return webDriver
    }

}
