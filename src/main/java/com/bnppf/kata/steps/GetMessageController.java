package com.bnppf.kata.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.util.Asserts;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class GetMessageController {
    private Response response;

    @When("the user gets all the response")
    public void the_user_gets_all_the_response() {
        response = given().contentType("application/json").get("https://automationintesting.online/message/");
        response.then().assertThat().log().all();

    }
    @Then("The HTTP response code for get message is {int}")
    public void the_http_response_code_for_get_message_is(int code) {
        Assert.assertEquals(response.getStatusCode(), code);
    }
    @Then("check the response contains expected response body")
    public void check_the_response_contains_expected_response_body() {
        JsonPath responseString = new JsonPath(response.asString());
        Asserts.notNull(responseString, responseString.getString("messages"));

    }

}
