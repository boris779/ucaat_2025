

package io.secugrow.demo.driverutil

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.CapabilityType
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URI

class RemoteChromeMobileEmulationWebDriverFactory : RemoteWebDriverFactory() {

    override fun createDriver(): WebDriver {

        caps.browserName = "chrome"
        caps.setVersion(getBrowserVersion())

        val options = ChromeOptions().merge(caps)
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome")
        options.setCapability(CapabilityType.BROWSER_VERSION, getBrowserVersion())

        val mobileEmulation = HashMap<String, String>()
        mobileEmulation["deviceName"] = System.getProperty("emulated.device", emulatedDevices.Pixel_2.phoneName)
        options.setExperimentalOption("mobileEmulation", mobileEmulation)

        webDriver = RemoteWebDriver(URI.create("${ getRemoteTestingServer()}/wd/hub").toURL(), options)
        return webDriver
    }

}
