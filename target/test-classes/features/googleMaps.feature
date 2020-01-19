Feature: City movies advanced

  @cm3
  Scenario: Get locations

    # for GET request

    Given I perform get request
    When a user performs a post request
    And a user add and deletes place
    Then the response code should be 200
    And I should see json response with apirs on the filtered "Msg" node
