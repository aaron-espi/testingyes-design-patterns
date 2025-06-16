package com.aaron.common;

import static com.aaron.common.CommonLocators.LOGGED_IN_USERNAME_TEXT;
import static com.aaron.common.CommonLocators.LOGIN_LINK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBar extends AbstractComponent {

    @FindBy(id = LOGIN_LINK)
    private WebElement login;

    @FindBy(css = LOGGED_IN_USERNAME_TEXT)
    private WebElement username;

    public TopBar(final WebDriver driver) {
        super(driver);
    }

    public void goToLogin() {
        this.login.click();
    }

    public String getLoggedInUsername() {
        return this.username.getText().trim();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> login.isDisplayed());
    }

}
