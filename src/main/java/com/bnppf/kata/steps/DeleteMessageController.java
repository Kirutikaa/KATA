package com.bnppf.kata.steps;

import files.PayLoad;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import static io.restassured.RestAssured.given;

public class DeleteMessageController {
    Response response;
    String messageId;

    @When("the user entered the message details before action")
    public void the_user_entered_the_message_details_before_action() {
        response = given().contentType("application/json").body(PayLoad.postMessageRequest()).log().all().post();
    }

    @And("the user delete the message details posted")
    public void the_user_delete_message_details_posted() {

        JsonPath responseString = new JsonPath(response.asString());
        messageId = responseString.getString("messageid");
        response = given().contentType("application/json").delete("https://automationintesting.online/message/" + messageId);


    }
    @Then("The HTTP response code for delete message is {int}")
    public void the_http_response_code_for_delete_message_is(int code) {
        Assert.assertEquals(response.getStatusCode(), code);
    }

    @Then("user checks the message details presents after action")
    public void user_checks_the_message_details_presents_after_action() {
        given().contentType("application/json").get("https://automationintesting.online/message/" + messageId).then()
                .assertThat().statusCode(200);

    }
}
