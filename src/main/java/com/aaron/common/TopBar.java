package com.aaron.common;

import static com.aaron.common.CommonLocators.LOGGED_IN_USERNAME_TEXT;
import static com.aaron.common.CommonLocators.LOGIN_LINK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Represents the top navigation bar of the application UI.
 * <p>
 * Provides access to login navigation and displays the logged-in user's
 * username.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class TopBar extends AbstractComponent {

    @FindBy(id = LOGIN_LINK)
    private WebElement login;

    @FindBy(css = LOGGED_IN_USERNAME_TEXT)
    private WebElement username;

    /**
     * Constructs the TopBar component and initializes its elements.
     *
     * @param driver the WebDriver instance to interact with the top bar
     */
    public TopBar(final WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks the login link to navigate to the login page.
     */
    public void goToLogin() {
        this.login.click();
    }

    /**
     * Returns the text of the logged-in user's username.
     *
     * @return the trimmed username string displayed in the top bar
     */
    public String getLoggedInUsername() {
        return this.username.getText().trim();
    }

    /**
     * Waits until the login link is displayed.
     *
     * @return true if the login link is visible, false otherwise
     */
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> login.isDisplayed());
    }

}
