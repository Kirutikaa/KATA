Feature: AS a user,  i want to validate the message controller
  Scenario: 1. As a user i want to create a message

    Given the user wants to call the message controller api
    When the user entered the message details
    Then The HTTP response code for post message is 201
    And The HTTP response contains messageId

  Scenario: 2. As a user i want to create a message error case

   Given the user wants to call the message controller api
    When the user entered the incorrect email details
    Then The HTTP response code for post message is 400
    And The HTTP response contains error message



