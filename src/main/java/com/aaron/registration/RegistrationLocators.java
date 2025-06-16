package com.aaron.registration;

public final class RegistrationLocators {

    public static final String SOCIAL_TITLE_MR_RADIO = "input[name='id_gender'][value='1']";
    public static final String SOCIAL_TITLE_MRS_RADIO = "input[name='id_gender'][value='2']";
    public static final String FIRSTNAME_INPUT = "firstname";
    public static final String LASTNAME_INPUT = "lastname";
    public static final String BIRTHDAY_INPUT = "birthday";
    public static final String RECEIVE_OFFERS_CHECK = "optin";
    public static final String NEWSLETTER_CHECK = "newsletter";
    public static final String TERMS_AND_PRIVACY_CHECK = "psgdpr";
    public static final String SAVE_BUTTON = "//button[@data-link-action='save-customer']";
    public static final String ERROR_MESSAGE = "div.help-block ul li.alert.alert-danger";

    private RegistrationLocators() {
    }
}