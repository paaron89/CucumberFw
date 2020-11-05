Feature: Validating place APIs

  Scenario Outline: Verify add place functionlity
    Given Add place payload with "<name>" "<language>" "<address>"
    When user calls "addPlaceAPI" with POST http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And  "scope" in response body is "APP"

    Examples:
      | name  | language | address       |
      |AAhouse| HUN      | macska utca 4.|