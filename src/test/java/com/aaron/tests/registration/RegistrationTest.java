package com.aaron.tests.registration;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aaron.BaseTest;
import com.aaron.login.LoginPage;
import com.aaron.main.MainPage;
import com.aaron.registration.RegistrationPage;

public class RegistrationTest extends BaseTest {

    private MainPage mainPage;
    private LoginPage loginPage;
    private RegistrationPage registrationPage;

    @BeforeTest
    public void setupPages() {
        this.mainPage = new MainPage(driver);
        this.loginPage = new LoginPage(driver);
        this.registrationPage = new RegistrationPage(driver);
    }

    @Test(dataProvider = "validRegistrationData")
    public void whenUserSubmitsValidData_thenRegistrationSucceeds(String firstName, String lastName, String email,
            String password,
            String birthday) {
        mainPage.goTo();
        Assert.assertTrue(mainPage.getTopBar().isDisplayed());

        mainPage.getTopBar().goToLogin();
        Assert.assertTrue(loginPage.getLoginForm().isDisplayed());

        loginPage.getLoginForm().createAccount();
        Assert.assertTrue(registrationPage.getRegistrationForm().isDisplayed());

        registrationPage.getRegistrationForm().checkSocialTitleMr();
        registrationPage.getRegistrationForm().typeFirstName(firstName);
        registrationPage.getRegistrationForm().typeLastName(lastName);
        registrationPage.getRegistrationForm().typeEmail(email);
        registrationPage.getRegistrationForm().typePassword(password);
        registrationPage.getRegistrationForm().typeBirthday(birthday);
        registrationPage.getRegistrationForm().checkTermsAndPrivacy();
        registrationPage.getRegistrationForm().saveCustomer();

        Assert.assertTrue(mainPage.getTopBar().isDisplayed());

        Assert.assertEquals(mainPage.getTopBar().getLoggedInUsername(), firstName + " " + lastName);

    }

    @DataProvider(name = "validRegistrationData")
    public Object[][] validRegistrationData() {
        int randomNumber = 10000 + new Random().nextInt(90000);

        return new Object[][] {
                {
                        "Name",
                        "Lastname",
                        "user" + randomNumber + "@example.com",
                        "Password" + randomNumber,
                        "01/01/1999"
                }
        };
    }
}
