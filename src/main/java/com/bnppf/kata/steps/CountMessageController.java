package com.bnppf.kata.steps;

import files.PayLoad;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.util.Asserts;

import static io.restassured.RestAssured.given;

public class CountMessageController {

   private Response response;
   private int beforeCount;

    @When("the user gets the count of the total messages")
    public void the_user_gets_the_count_of_the_total_messages() {
        response = given().contentType("application/json").get("https://automationintesting.online/message/count");

    }
    @Then("user check the response count")
    public void user_check_the_response_count() {
        JsonPath responseString = new JsonPath(response.asString());
        beforeCount = responseString.getInt("count");

    }
    @Then("the user post the new message")
    public void the_user_post_the_new_message() {
        response = given().contentType("application/json").body(PayLoad.postMessageRequest()).log().all().post();

    }
    @Then("the user check the count of the total messages after post")
    public void the_user_check_the_count_of_the_total_messages_after_post() {
        response = given().contentType("application/json").get("https://automationintesting.online/message/count");
        JsonPath responseString = new JsonPath(response.asString());
        int afterCount = responseString.getInt("count");
        Asserts.check(beforeCount+1==afterCount, "error info not received");
    }
}
