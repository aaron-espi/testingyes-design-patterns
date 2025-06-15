package com.aaron.steps;

import static com.aaron.constants.RegistrationConstants.ALREADY_USED_EMAIL_ERROR;

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

public class RegistrationSteps {

    private WebDriver driver;
    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private TestUser user;

    @Given("the user is on the registration page")
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

    @When("the user fills in the form with the following data")
    public void fillFormWithData(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> row = data.get(0);

        String firstName = row.get("firstName");
        String lastName = row.get("lastName");
        String password = row.get("password");
        String birthday = row.get("birthday");

        registrationPage.getRegistrationForm().checkSocialTitleMr();
        registrationPage.getRegistrationForm().typeFirstName(firstName);
        registrationPage.getRegistrationForm().typeLastName(lastName);
        registrationPage.getRegistrationForm().typePassword(password);
        registrationPage.getRegistrationForm().typeBirthday(birthday);
        registrationPage.getRegistrationForm().checkTermsAndPrivacy();

        this.user = new TestUser(firstName, lastName, null, password, birthday);
    }

    @And("uses a unique email address")
    public void fillWithUniqueEmail() {
        String email = EmailFactory.generateUniqueEmail();
        registrationPage.getRegistrationForm().typeEmail(email);
        this.user.setEmail(email);
    }

    @And("submits the registration form")
    public void submitRegistrationForm() {
        registrationPage.getRegistrationForm().saveCustomer();
    }

    @Then("the user is redirected to the main page")
    public void shouldBeRedirectedToMainPage() {
        Assert.assertTrue(mainPage.getTopBar().isDisplayed());
    }

    @And("they should see their name displayed in the top bar")
    public void shouldSeeNameInTopBar() {
        Assert.assertTrue(mainPage.getProductGrid().isDisplayed());
        Assert.assertEquals(mainPage.getTopBar().getLoggedInUsername(), user.getFirstName() + " " + user.getLastName());
    }

    @But("uses an already registered email address")
    public void fillInAlreadyUsedEmail() {
        String email = EmailFactory.alreadyUsedEmail();
        registrationPage.getRegistrationForm().typeEmail(email);
    }

    @Then("the user is informed that the email is already in use")
    public void shouldSeeEmailErrorMessage() {
        Assert.assertEquals(ALREADY_USED_EMAIL_ERROR,
                registrationPage.getRegistrationForm().getErrorMessageText());
    }

    @And("the registration should not be completed")
    public void stillInRegistrationPage() {
        Assert.assertTrue(registrationPage.getRegistrationForm().isDisplayed());
    }
}