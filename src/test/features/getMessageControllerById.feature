Feature: AS a user,  i want to validate the message controller

  Scenario: 1. As a user i want to validate the a messageId
    Given the user wants to call the message controller api
    When When the user given the valid messageId
    Then The HTTP response code for get message by Id is 200
    And check The HTTP response contains expected response body

  Scenario: 2. As a user i want to invalid the a messageId

    Given the user wants to call the message controller api
    When When the user given the invalid messageId
    Then The HTTP response code for get message by Id is 500
    And check The HTTP response contains error message











