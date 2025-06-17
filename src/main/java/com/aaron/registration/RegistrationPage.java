package com.aaron.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Represents the user registration page of the application.
 * <p>
 * Encapsulates the registration form component and provides access to
 * registration-related interactions.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class RegistrationPage {

    private RegistrationForm registrationForm;

    /**
     * Constructs the RegistrationPage and initializes its components using
     * PageFactory.
     *
     * @param driver the WebDriver instance used for page interactions
     */
    public RegistrationPage(final WebDriver driver) {
        this.registrationForm = PageFactory.initElements(driver, RegistrationForm.class);

    }

    /**
     * Returns the registration form component of this page.
     *
     * @return the RegistrationForm instance
     */
    public RegistrationForm getRegistrationForm() {
        return registrationForm;
    }

}
