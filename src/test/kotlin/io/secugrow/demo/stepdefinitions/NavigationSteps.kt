package io.secugrow.demo.stepdefinitions

import io.secugrow.demo.pageobjects.MainPage
import io.secugrow.demo.pageobjects.PageUrls


class NavigationSteps(testDataContainer: TestDataContainer) : AbstractStepDefs(testDataContainer) {

    init {
        Given("the start page is loaded") {
            getWebDriverSession().gotoUrl(PageUrls.HOME, MainPage::class, testDataContainer)
        }


        When("switching to the speakertab") {
            getPage(MainPage::class).switchTabWithText("Speakers Bios")
        }

    }

}
