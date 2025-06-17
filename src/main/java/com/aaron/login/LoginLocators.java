package com.aaron.login;

/**
 * Contains locator constants used in the login page components.
 * <p>
 * This utility class centralizes selectors for login-related elements and
 * should not be instantiated.
 */
public final class LoginLocators {

    /** Locator for the login button. */
    public static final String LOGIN_BUTTON = "submit-login";

    /** Locator for the register link. */
    public static final String REGISTER_LINK = "a[data-link-action='display-register-form']";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private LoginLocators() {
    }
}