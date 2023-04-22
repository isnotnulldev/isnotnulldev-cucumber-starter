@dev

Feature: SessionTest

  Scenario: As a user, we can verify that our session state across steps is working
    Given I have "testString" stored in my session
    Then the user verifies that the string stored in the session is 'testString'

