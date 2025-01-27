Feature: AS a user,i want to validate the message controller

  Scenario: 1. As a user i want to get all message response

    Given the user wants to call the message controller api
    When the user gets all the response
    Then The HTTP response code for get message is 200
    And check the response contains expected response body



