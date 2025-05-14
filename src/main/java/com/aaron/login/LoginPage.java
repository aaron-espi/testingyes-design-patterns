package com.aaron.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private LoginForm loginForm;

    public LoginForm getLoginForm() {
        return loginForm;
    }

    public LoginPage(final WebDriver driver) {
        this.loginForm = PageFactory.initElements(driver, LoginForm.class);
    }

}
