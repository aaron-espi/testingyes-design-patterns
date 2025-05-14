package com.aaron.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class TopBar extends AbstractComponent {

    @FindBy(id = "_desktop_user_info")
    private WebElement login;

    @FindBy(css = "a.account")
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
