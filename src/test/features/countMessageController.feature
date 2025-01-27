Feature: AS a user,  i want to validate the message controller
  Scenario: 1. As a user i want to validate the count of the message

    Given the user wants to call the message controller api
    When the user gets the count of the total messages
    Then user check the response count
    And  the user post the new message
    Then The HTTP response code is 201
    And the user check the count of the total messages after post




