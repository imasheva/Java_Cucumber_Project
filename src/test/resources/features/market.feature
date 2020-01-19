@market
  Feature: Marketing application test suite

    @market1
    Scenario: Required fields end-to-end
      Given I navigate to "quote" page
      When I fill out "required" fields
      And I fill out optional fields
      Then I verify "required" fields

     @market2
     Scenario: Submit and verify page object form
       Given I open sample page
       When I fill out all page object fields
       And I submit page object form
       Then I verify all page object fields



