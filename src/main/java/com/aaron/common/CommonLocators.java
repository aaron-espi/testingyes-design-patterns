package com.aaron.common;

/**
 * Provides commonly used locators shared across multiple pages or components in
 * the application UI.
 * <p>
 * This utility class centralizes selectors for input fields, buttons, and
 * global UI elements to promote reuse and maintainability.
 * <p>
 * This class is final and cannot be instantiated.
 */
public final class CommonLocators {
    /** Locator for the email input field. */
    public static final String EMAIL_INPUT = "email";
    /** Locator for the password input field. */
    public static final String PASSWORD_INPUT = "password";
    /** Locator for the list of product item cards in the product grid. */
    public static final String PRODUCT_ITEMS = "article.product-miniature";
    /** Locator for the title of a product inside a product card. */
    public static final String PRODUCT_TITLE_TEXT = "h2.product-title";
    /** Locator for the search input in the page header. */
    public static final String HEADER_SEARCH_INPUT = "s";
    /** Locator for the search button in the page header. */
    public static final String HEADER_SEARCH_BUTTON = "//button[span[text()='Search']]";
    /** Locator for the text showing the logged-in username in the top bar. */
    public static final String LOGGED_IN_USERNAME_TEXT = "a.account";
    /** Locator for the login link in the top navigation bar. */
    public static final String LOGIN_LINK = "_desktop_user_info";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private CommonLocators() {
    }
}