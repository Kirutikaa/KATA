package com.bnppf.kata.steps;

import io.cucumber.java.en.Given;
import io.restassured.RestAssured;

public class CommonSteps {

    @Given("the user wants to call the message controller api")
    public void the_user_wants_to_call_the_post_message_controller_api() {
        RestAssured.baseURI = "https://automationintesting.online/message/";

    }



}
