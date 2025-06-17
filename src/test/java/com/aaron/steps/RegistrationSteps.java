package com.aaron.steps;

import static com.aaron.constants.RegistrationConstants.ALREADY_USED_EMAIL_ERROR;
import static com.aaron.constants.SearchConstants.BIRTHDAY_FIELD;
import static com.aaron.constants.SearchConstants.FIRST_NAME_FIELD;
import static com.aaron.constants.SearchConstants.LAST_NAME_FIELD;
import static com.aaron.constants.SearchConstants.PASSWORD_FIELD;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aaron.core.DriverManager;
import com.aaron.login.LoginPage;
import com.aaron.main.MainPage;
import com.aaron.registration.RegistrationPage;
import com.aaron.utils.factory.EmailFactory;
import com.aaron.utils.model.TestUser;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step definitions for the user registration feature in Cucumber scenarios.
 * <p>
 * Each method is mapped to a Gherkin step and prepares, interacts, or validates
 * the registration process in the UI.
 */
public class RegistrationSteps {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private TestUser user;

    /**
     * Navigates to the registration page by going through the main and login pages.
     * Ensures that each page is loaded before proceeding.
     */
    @Given("the user is on the registration page")
    public void navigateToRegistrationPage() {
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

        mainPage.goTo();
        Assert.assertTrue(mainPage.getProductGrid().isDisplayed());

        mainPage.getTopBar().goToLogin();
        Assert.assertTrue(loginPage.getLoginForm().isDisplayed());

        loginPage.getLoginForm().createAccount();
        Assert.assertTrue(registrationPage.getRegistrationForm().isDisplayed());
    }

    /**
     * Fills the registration form with data provided in the Cucumber DataTable.
     *
     * @param dataTable DataTable containing user registration fields such as
     *                  firstName, lastName, password, and birthday.
     */
    @When("the user fills in the form with the following data")
    public void fillFormWithData(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);

        String firstName = row.get(FIRST_NAME_FIELD);
        String lastName = row.get(LAST_NAME_FIELD);
        String password = row.get(PASSWORD_FIELD);
        String birthday = row.get(BIRTHDAY_FIELD);

        registrationPage.getRegistrationForm().checkSocialTitleMr();
        registrationPage.getRegistrationForm().typeFirstName(firstName);
        registrationPage.getRegistrationForm().typeLastName(lastName);
        registrationPage.getRegistrationForm().typePassword(password);
        registrationPage.getRegistrationForm().typeBirthday(birthday);
        registrationPage.getRegistrationForm().checkTermsAndPrivacy();

        this.user = new TestUser(firstName, lastName, null, password, birthday);
    }

    /**
     * Fills the email field with a dynamically generated unique email address to
     * avoid conflicts.
     */
    @And("uses a unique email address")
    public void fillWithUniqueEmail() {
        String email = EmailFactory.generateUniqueEmail();
        registrationPage.getRegistrationForm().typeEmail(email);
        this.user.setEmail(email);
    }

    /**
     * Submits the registration form by clicking the save/submit button.
     */
    @And("submits the registration form")
    public void submitRegistrationForm() {
        registrationPage.getRegistrationForm().saveCustomer();
    }

    /**
     * Verifies that after successful registration, the user is redirected to the
     * main page.
     */
    @Then("the user is redirected to the main page")
    public void shouldBeRedirectedToMainPage() {
        Assert.assertTrue(mainPage.getProductGrid().isDisplayed());
    }

    /**
     * Verifies that the registered user's full name is displayed in the top bar,
     * confirming login.
     */
    @And("they should see their name displayed in the top bar")
    public void shouldSeeNameInTopBar() {
        String expectedName = user.getFirstName() + " " + user.getLastName();
        Assert.assertEquals(expectedName, mainPage.getTopBar().getLoggedInUsername());
    }

    /**
     * Fills the email field with an email address that is already registered, to
     * test error handling.
     */
    @But("uses an already registered email address")
    public void fillInAlreadyUsedEmail() {
        String email = EmailFactory.alreadyUsedEmail();
        registrationPage.getRegistrationForm().typeEmail(email);
        this.user.setEmail(email);
    }

    /**
     * Verifies that the user sees an error message indicating the email is already
     * in use.
     */
    @Then("the user is informed that the email is already in use")
    public void shouldSeeEmailErrorMessage() {
        Assert.assertEquals(ALREADY_USED_EMAIL_ERROR,
                registrationPage.getRegistrationForm().getErrorMessageText());
    }

    /**
     * Verifies that the registration form is still displayed, indicating
     * registration was not completed.
     */
    @And("the registration should not be completed")
    public void stillInRegistrationPage() {
        Assert.assertTrue(registrationPage.getRegistrationForm().isDisplayed());
    }
}