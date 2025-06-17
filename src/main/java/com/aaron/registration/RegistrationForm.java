package com.aaron.registration;

import static com.aaron.common.CommonLocators.EMAIL_INPUT;
import static com.aaron.common.CommonLocators.PASSWORD_INPUT;
import static com.aaron.registration.RegistrationLocators.BIRTHDAY_INPUT;
import static com.aaron.registration.RegistrationLocators.ERROR_MESSAGE;
import static com.aaron.registration.RegistrationLocators.FIRSTNAME_INPUT;
import static com.aaron.registration.RegistrationLocators.LASTNAME_INPUT;
import static com.aaron.registration.RegistrationLocators.NEWSLETTER_CHECK;
import static com.aaron.registration.RegistrationLocators.RECEIVE_OFFERS_CHECK;
import static com.aaron.registration.RegistrationLocators.SAVE_BUTTON;
import static com.aaron.registration.RegistrationLocators.SOCIAL_TITLE_MRS_RADIO;
import static com.aaron.registration.RegistrationLocators.SOCIAL_TITLE_MR_RADIO;
import static com.aaron.registration.RegistrationLocators.TERMS_AND_PRIVACY_CHECK;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

/**
 * Represents the registration form on the registration page.
 * <p>
 * Provides methods to interact with form fields and controls, including input
 * fields, checkboxes, radio buttons, and error messages.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class RegistrationForm extends AbstractComponent {

    @FindBy(css = SOCIAL_TITLE_MR_RADIO)
    private WebElement socialTitleMr;

    @FindBy(css = SOCIAL_TITLE_MRS_RADIO)
    private WebElement socialTitleMrs;

    @FindBy(name = FIRSTNAME_INPUT)
    private WebElement firstName;

    @FindBy(name = LASTNAME_INPUT)
    private WebElement lastName;

    @FindBy(name = EMAIL_INPUT)
    private WebElement email;

    @FindBy(name = PASSWORD_INPUT)
    private WebElement password;

    @FindBy(name = BIRTHDAY_INPUT)
    private WebElement birthday;

    @FindBy(name = RECEIVE_OFFERS_CHECK)
    private WebElement receiveOffers;

    @FindBy(name = NEWSLETTER_CHECK)
    private WebElement newsletterSignup;

    @FindBy(name = TERMS_AND_PRIVACY_CHECK)
    private WebElement termsAndPrivacy;

    @FindBy(xpath = SAVE_BUTTON)
    private WebElement save;

    @FindBy(css = ERROR_MESSAGE)
    private WebElement errorMessage;

    /**
     * Constructs a RegistrationForm component and initializes its elements.
     *
     * @param driver the WebDriver instance used to interact with the registration
     *               form
     */
    public RegistrationForm(final WebDriver driver) {
        super(driver);
    }

    /**
     * Selects the 'Mr.' social title option.
     */
    public void checkSocialTitleMr() {
        this.socialTitleMr.click();
    }

    /**
     * Selects the 'Mrs.' social title option.
     */
    public void checkSocialTitleMrs() {
        this.socialTitleMrs.click();
    }

    /**
     * Enters the first name in the registration form.
     *
     * @param firstName the first name to be entered
     */
    public void typeFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    /**
     * Enters the last name in the registration form.
     *
     * @param lastName the last name to be entered
     */
    public void typeLastName(String lastName) {
        this.lastName.sendKeys(lastName);

    }

    /**
     * Enters the email address in the registration form.
     *
     * @param email the email address to be entered
     */
    public void typeEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    /**
     * Enters the password in the registration form.
     *
     * @param password the password to be entered
     */
    public void typePassword(String password) {
        this.password.sendKeys(password);
    }

    /**
     * Enters the birthday in the registration form.
     *
     * @param birthdate the birthday to be entered
     */
    public void typeBirthday(String birthdate) {
        this.birthday.sendKeys(birthdate);
    }

    /**
     * Selects the option to receive offers.
     */
    public void checkReceiveOffers() {
        this.receiveOffers.click();
    }

    /**
     * Selects the option to sign up for the newsletter.
     */
    public void checkNewsletterSignup() {
        this.newsletterSignup.click();
    }

    /**
     * Accepts the terms and privacy policy.
     */
    public void checkTermsAndPrivacy() {
        this.termsAndPrivacy.click();
    }

    /**
     * Submits the registration form.
     */
    public void saveCustomer() {
        this.save.click();
    }

    /**
     * Retrieves the error message text displayed on the form.
     *
     * @return the error message text
     */
    public String getErrorMessageText() {
        return this.errorMessage.getText().trim();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(
                (d) -> firstName.isDisplayed() && email.isDisplayed() && password.isDisplayed() && save.isDisplayed());
    }

}
