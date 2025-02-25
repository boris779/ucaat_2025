package io.secugrow.demo.stepdefinitions

import io.secugrow.demo.pageobjects.SpeakersPage
import org.assertj.core.api.Assertions.assertThat

class SpeakersSteps(testDataContainer: TestDataContainer) : AbstractStepDefs(testDataContainer) {

    init {
        Then("{string} should be listed") { speakerName: String ->
            val listedSpeakers = getPage(SpeakersPage::class).getAllSpeakers()
            assertThat(listedSpeakers).contains(speakerName)
        }

    }
}
