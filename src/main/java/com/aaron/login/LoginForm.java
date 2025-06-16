package com.aaron.login;

import static com.aaron.common.CommonLocators.EMAIL_INPUT;
import static com.aaron.common.CommonLocators.PASSWORD_INPUT;
import static com.aaron.login.LoginLocators.LOGIN_BUTTON;
import static com.aaron.login.LoginLocators.REGISTER_LINK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class LoginForm extends AbstractComponent {

    @FindBy(name = EMAIL_INPUT)
    private WebElement email;

    @FindBy(name = PASSWORD_INPUT)
    private WebElement password;

    @FindBy(id = LOGIN_BUTTON)
    private WebElement login;

    @FindBy(css = REGISTER_LINK)
    private WebElement register;

    public LoginForm(final WebDriver driver) {
        super(driver);
    }

    public void createAccount() {
        this.register.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait
                .until((d) -> this.email.isDisplayed() && this.password.isDisplayed() && this.login.isDisplayed());
    }

}
