package com.aaron.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class LoginForm extends AbstractComponent {

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "submit-login")
    private WebElement login;

    @FindBy(css = "a[data-link-action='display-register-form']")
    private WebElement register;

    public LoginForm(final WebDriver driver) {
        super(driver);
    }

    public void createAccount() {
        this.register.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.email.isDisplayed());
    }

}
