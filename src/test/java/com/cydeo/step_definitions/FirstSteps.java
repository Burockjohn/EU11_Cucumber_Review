package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FirstSteps {

    @Given("I provide my credentials")
    public void ı_provide_my_credentials() {
        System.out.println("i provide  my credentials");
    }
    @When("I print them")
    public void ı_print_them() {
        System.out.println("i print them");
    }
    @Then("I should see them in the console")
    public void ı_should_see_them_in_the_console() {
        System.out.println("i sgould see them in the console");
    }

}
