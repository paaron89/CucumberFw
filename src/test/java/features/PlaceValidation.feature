Feature: Validating place APIs

  Scenario: Verify add place functionlity
    Given Add place payload
    When user calls "addPlaceAPI" with POST http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And  "scope" in response body is "APP"