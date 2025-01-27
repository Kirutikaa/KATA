package com.bnppf.kata.steps;

import files.PayLoad;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.util.Asserts;
import org.junit.Assert;

import static io.restassured.RestAssured.*;


public class GetMessageControllerById {

    Response response;
    String messageId;


    @When("When the user given the valid messageId")
    public void the_user_entered_the_valid_messageId() {
        response = given().contentType("application/json").body(PayLoad.postMessageRequest()).log().all().post();
        JsonPath responseString = new JsonPath(response.asString());
        messageId = responseString.getString("messageid");
        response = given().contentType("application/json").get("https://automationintesting.online/message/" + messageId);

    }
    @Then("The HTTP response code for get message by Id is {int}")
    public void the_http_response_code_for_get_message_by_Id_is(int code) {
        Assert.assertEquals(response.getStatusCode(), code);
    }

    @And("check The HTTP response contains expected response body")
    public void check_the_http_response_contains_expected_response_body() {
        JsonPath responseString = new JsonPath(response.asString());
        String responseMessageId = responseString.getString("messageid");
        Asserts.check(messageId.equals(responseMessageId), "error info not received");
    }

    @When("When the user given the invalid messageId")
    public void the_user_entered_the_invalid_messageId() {
        response = given().contentType("application/json").get("https://automationintesting.online/message/123");
    }

    @And("check The HTTP response contains error message")
    public void check_the_http_response_contains_error_message() {
        JsonPath responseString = new JsonPath(response.asString());
        String errorMessage = responseString.getString("error");
        Asserts.check("Internal Server Error".equals(errorMessage), "error info not received");

    }

}
