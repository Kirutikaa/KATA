package com.bnppf.kata.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.util.Asserts;

import static io.restassured.RestAssured.given;

public class GetMessageController {
    private Response response;

    @When("the user gets all the response")
    public void the_user_gets_all_the_response() {
        response = given().contentType("application/json").get("https://automationintesting.online/message/");

    }

    @Then("check the response contains expected response body")
    public void check_the_response_contains_expected_response_body() {
        JsonPath responseString = new JsonPath(response.asString());
        Asserts.notNull(responseString, responseString.getString("messages"));

    }

}
