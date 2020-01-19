@careers
Feature: Careers scenarios

  @careers1
  Scenario: Recruiter creates position
    Given I navigate to "careers" page
    And I login as "recruiter"
    Then I verify "recruiter" login
    When I create new "automation" position
    And I verify "automation" position created

  @careers2
  Scenario: Careers candidate scenario
    Given I navigate to "careers" page
    And I apply to "automation" position
    Then I verify profile is created
    And I see "automation" position in my jobs
