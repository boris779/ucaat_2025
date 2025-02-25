@all
Feature: [ucaat] Example Feature

  @boris
  Scenario: UCAAT-01 [ucaat]
    Given the start page is loaded
    When switching to the speakertab
    Then "Boris Wrubel" should be listed

