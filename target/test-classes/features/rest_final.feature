@rest
Feature: CreateReadUpdateDelete operations for Careers final

  @rest1
  Scenario: REST API Positions CRUD
    Given I login via REST as "recruiter"
    When I create via REST "automation" position
    Then I verify via REST new position is in the list
    When I update via REST "automation" position
    Then I verify via REST new position is updated
    When I delete via REST new position
    Then I verify via REST new position is deleted
