@usps
Feature: Usps feature

  @usps1

  Scenario Outline: Usps Stamps
    Given I navigate to "usps" page
    When I go to usps "<store>" store
    And I sort usps results by "Price (Low-High)"
    Then I verify that usps "<item>"  is cheapest

     Examples:

    |store | |item         |
    |stamps| |Tiffany Lamp  |
    |boxes | |Priority Mail|

#  @usps2
#  Scenario: Usps Boxes
#    Given I navigate to "usps" page
#    When I go to usps "boxes" store
#    And I sort usps results by "Price(Low-High)"
#    Then I verify that usps "Priority Mail"  is cheapest

  @usps2
    Scenario: Verify login
    Given I navigate to "usps" page
    When I go to "Click-N-Ship" under "Mail & Ship" menu
    Then I verify that "Sign In" is required
    Then I verify that "Sign Up Now" is possible

  @usps3
  Scenario: Validate ZIP code page object
    Given I go to usps page object
    When I go to Lookup ZIP page object by address
    And I fill out "4970 El Camino Real" street, "Los Altos" city, "CA" state page object
    Then I validate "94022" zip code exists in the result page object

  @usps4
  Scenario: Calculate price logic page object
    Given I go to usps page object
    When I go to Calculate Price page object
    And I select "United Kingdom"  with "Postcard" shape
    And I define "2" quantity page object
    Then I calculate the price and validate cost is "$2.30" page object