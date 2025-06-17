package com.aaron.login;

import static com.aaron.common.CommonLocators.EMAIL_INPUT;
import static com.aaron.common.CommonLocators.PASSWORD_INPUT;
import static com.aaron.login.LoginLocators.LOGIN_BUTTON;
import static com.aaron.login.LoginLocators.REGISTER_LINK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

/**
 * Represents the login form component in the application UI.
 * <p>
 * Encapsulates interactions with the email and password fields, as well as
 * login and register actions.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class LoginForm extends AbstractComponent {

    @FindBy(name = EMAIL_INPUT)
    private WebElement email;

    @FindBy(name = PASSWORD_INPUT)
    private WebElement password;

    @FindBy(id = LOGIN_BUTTON)
    private WebElement login;

    @FindBy(css = REGISTER_LINK)
    private WebElement register;

    /**
     * Constructs the LoginForm component and initializes its elements.
     *
     * @param driver the WebDriver used to interact with the login form
     */
    public LoginForm(final WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the register link to navigate to the account creation page.
     */
    public void createAccount() {
        this.register.click();
    }

    /**
     * Checks if the login form is displayed and ready for interaction.
     *
     * @return true if the form is displayed, false otherwise
     */
    @Override
    public boolean isDisplayed() {
        return this.wait
                .until((d) -> this.email.isDisplayed() && this.password.isDisplayed() && this.login.isDisplayed());
    }

}
