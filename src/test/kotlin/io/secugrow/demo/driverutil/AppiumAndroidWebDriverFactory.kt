package io.secugrow.demo.driverutil

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.options.UiAutomator2Options
import org.assertj.core.api.Assertions.fail
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebDriverException
import java.net.URI

class AppiumAndroidWebDriverFactory : RemoteWebDriverFactory() {
    override fun createDriver(): WebDriver {

        val uiAutomator2Options = UiAutomator2Options()
        uiAutomator2Options.setUdid(getMobileDeviceId())
        uiAutomator2Options.setAutomationName("UiAutomator2")
        uiAutomator2Options.setPlatformName("Android")
        uiAutomator2Options.setDeviceName("Appium_Android_Device")
        uiAutomator2Options.withBrowserName("chrome")

        uiAutomator2Options.setNoReset(true)
        uiAutomator2Options.setCapability(
            "chromeOptions", mapOf(
                "args" to listOf("--disable-extensions", "--no-sandbox"),
                "w3c" to false
            )
        )


//        caps.setCapability("appium:chromedriverExecutable", webDriverManager.downloadedDriverPath)

        val appiumServer = URI.create(getRemoteTestingServer()).toURL()

        try {
            webDriver = AndroidDriver(appiumServer, uiAutomator2Options)

        } catch (e: WebDriverException) {
            fail("Appium error: $appiumServer  exception message: ${e.localizedMessage} ::: Appium started?")
        }
        return webDriver
    }

    private fun getMobileDeviceId(): String {
        return System.getProperty("device.id", "emulator-5554")
    }

}
