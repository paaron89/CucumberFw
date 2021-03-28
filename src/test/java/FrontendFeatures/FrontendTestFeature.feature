Feature: Test for Webdriver tests

  Scenario: Test if driver works
    Given webdriver
    When webdriver opens windGuru
    Then searchbox is displayed