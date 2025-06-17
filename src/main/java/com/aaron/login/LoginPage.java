package com.aaron.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the login page of the application.
 * <p>
 * Encapsulates the login form component and provides access to login-related
 * interactions.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class LoginPage {

    private LoginForm loginForm;

    /**
     * Constructs the LoginPage and initializes its components using PageFactory.
     *
     * @param driver the WebDriver instance used for page interactions
     */
    public LoginPage(final WebDriver driver) {
        this.loginForm = PageFactory.initElements(driver, LoginForm.class);
    }

    /**
     * Returns the login form component of this page.
     *
     * @return the LoginForm instance
     */
    public LoginForm getLoginForm() {
        return loginForm;
    }

}
