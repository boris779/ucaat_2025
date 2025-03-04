package io.secugrow.demo.driverutil

import org.openqa.selenium.Platform
import org.openqa.selenium.remote.RemoteWebDriver

fun RemoteWebDriver.getBrowserName(): String {
    return this.capabilities.browserName
}


fun RemoteWebDriver.isMobile(): Boolean {

    val caps = this.capabilities

    caps.platformName.let { if (it == Platform.ANDROID) return true }
    caps.platformName.let { if (it == Platform.IOS) return true }

    if (caps.browserVersion.contains("mobile")) {
        return true
    }

    if (caps.browserName.contains("mobile")) {
        return true
    }

    if (caps.capabilityNames.contains("mobileEmulationEnabled")) {
        if (caps.getCapability("mobileEmulationEnabled") as Boolean) {
            return true
        }
    }

    if (caps.capabilityNames.contains("appiumVersion")) {
        return true
    }

    if (System.getProperty("browser", "not set").contains("emulation")) {
        return true
    }

    return false
}
