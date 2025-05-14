package com.aaron.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private RegistrationForm registrationForm;

    public RegistrationPage(final WebDriver driver) {
        this.registrationForm = PageFactory.initElements(driver, RegistrationForm.class);

    }

    public RegistrationForm getRegistrationForm() {
        return registrationForm;
    }

}
