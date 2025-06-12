package com.aaron.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {

    @Given("the user navigates to the registration page")
    public void navigateToRegistrationPage() {
        // TODO: Implement step
    }

    @When("the user fills in all required fields with valid data")
    public void fillInValidRegistrationDetails() {
        // TODO: Implement step
    }

    @And("submits the registration form")
    public void submitRegistrationForm() {
        // TODO: Implement step
    }

    @Then("the user should be redirected to the main page")
    public void shouldBeRedirectedToMainPage() {
        // TODO: Implement step
    }

    @And("see their name displayed in the top bar")
    public void shouldSeeNameInTopBar() {
        // TODO: Implement step
    }
}