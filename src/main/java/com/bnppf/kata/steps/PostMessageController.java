package com.bnppf.kata.steps;

import files.PayLoad;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.util.Asserts;


import static io.restassured.RestAssured.*;

public class PostMessageController {
    Response response;

    @Given("the user wants to call the message controller api")
    public void the_user_wants_to_call_the_post_message_controller_api() {
        RestAssured.baseURI = "https://automationintesting.online/message/";

    }

    @When("the user entered the message details")
    public void the_user_entered_the_message_details() {
        response = given().contentType("application/json").body(PayLoad.postMessageRequest()).log().all().post();

    }

    @Then("The HTTP response code is {int}")
    public void the_http_response_code_is(int code) {
        expect().statusCode(code);
    }

    @Then("The HTTP response contains messageId")
    public void the_http_response_contains_messageId() {
        JsonPath responseString = new JsonPath(response.asString());
        Asserts.notNull(responseString, responseString.getString("messageid"));

    }
    @When("the user entered the incorrect email details")
    public void the_user_entered_the_incorrect_message_details() {
        response = given().contentType("application/json").body(PayLoad.postMessageIncorrectEmailRequest()).post();

    }
    @And("The HTTP response contains error message")
    public void the_http_response_contains_error_message() {
        JsonPath responseString = new JsonPath(response.asString());
        Asserts.notNull(responseString, responseString.getString("error"));

    }

}
