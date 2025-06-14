package com.aaron.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aaron.core.DriverManager;
import com.aaron.login.LoginPage;
import com.aaron.main.MainPage;
import com.aaron.registration.RegistrationPage;
import com.aaron.utils.TestUser;
import com.aaron.utils.TestUserFactory;

import io.cucumber.java.en.*;

public class RegistrationSteps {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private TestUser user;

    @Given("the user navigates to the registration page")
    public void navigateToRegistrationPage() {
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

        mainPage.goTo();
        Assert.assertTrue(mainPage.getTopBar().isDisplayed());

        mainPage.getTopBar().goToLogin();
        Assert.assertTrue(loginPage.getLoginForm().isDisplayed());

        loginPage.getLoginForm().createAccount();
        Assert.assertTrue(registrationPage.getRegistrationForm().isDisplayed());
    }

    @When("the user fills in all required fields with valid data")
    public void fillInValidRegistrationDetails() {
        user = TestUserFactory.generate();
        registrationPage.getRegistrationForm().checkSocialTitleMr();
        registrationPage.getRegistrationForm().typeFirstName(user.firstName);
        registrationPage.getRegistrationForm().typeLastName(user.lastName);
        registrationPage.getRegistrationForm().typeEmail(user.email);
        registrationPage.getRegistrationForm().typePassword(user.password);
        registrationPage.getRegistrationForm().typeBirthday(user.birthday);
        registrationPage.getRegistrationForm().checkTermsAndPrivacy();
    }

    @And("submits the registration form")
    public void submitRegistrationForm() {
        registrationPage.getRegistrationForm().saveCustomer();
    }

    @Then("the user should be redirected to the main page")
    public void shouldBeRedirectedToMainPage() {
        Assert.assertTrue(mainPage.getTopBar().isDisplayed());
    }

    @And("see their name displayed in the top bar")
    public void shouldSeeNameInTopBar() {
        Assert.assertTrue(mainPage.getProductGrid().isDisplayed());
        Assert.assertEquals(mainPage.getTopBar().getLoggedInUsername(), user.firstName + " " + user.lastName);
    }
}