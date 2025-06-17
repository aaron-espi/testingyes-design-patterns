package com.aaron.registration;

/**
 * Contains the CSS selectors and XPath locators used in the registration page.
 * <p>
 * This utility class centralizes all selectors for registration-related
 * elements and should not be instantiated.
 */
public final class RegistrationLocators {

    /** CSS selector for the "Mr" social title radio button. */
    public static final String SOCIAL_TITLE_MR_RADIO = "input[name='id_gender'][value='1']";

    /** CSS selector for the "Mrs" social title radio button. */
    public static final String SOCIAL_TITLE_MRS_RADIO = "input[name='id_gender'][value='2']";

    /** Name attribute for the first name input field. */
    public static final String FIRSTNAME_INPUT = "firstname";

    /** Name attribute for the last name input field. */
    public static final String LASTNAME_INPUT = "lastname";

    /** Name attribute for the birthday input field. */
    public static final String BIRTHDAY_INPUT = "birthday";

    /** Name attribute for the checkbox to receive offers. */
    public static final String RECEIVE_OFFERS_CHECK = "optin";

    /** Name attribute for the newsletter subscription checkbox. */
    public static final String NEWSLETTER_CHECK = "newsletter";

    /** Name attribute for the terms and privacy policy checkbox. */
    public static final String TERMS_AND_PRIVACY_CHECK = "psgdpr";

    /** XPath locator for the save customer button. */
    public static final String SAVE_BUTTON = "//button[@data-link-action='save-customer']";

    /** CSS selector for the error message displayed on registration failure. */
    public static final String ERROR_MESSAGE = "div.help-block ul li.alert.alert-danger";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private RegistrationLocators() {
    }
}