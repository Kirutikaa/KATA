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

public class PostMessageController {
    Response response;

    @When("the user entered the message details")
    public void the_user_entered_the_message_details() {
        response = given().contentType("application/json").body(PayLoad.postMessageRequest()).log().all().post();

    }

    @Then("The HTTP response code for post message is {int}")
    public void the_http_response_code_for_post_message_is(int code) {
        Assert.assertEquals(response.getStatusCode(), code);
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
        Assert.assertNotNull(responseString.getString("error"));
        Assert.assertEquals("BAD_REQUEST", responseString.getString("error"));
    }

}
