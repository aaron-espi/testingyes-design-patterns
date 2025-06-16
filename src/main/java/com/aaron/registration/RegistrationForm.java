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

    public RegistrationForm(final WebDriver driver) {
        super(driver);
    }

    public void checkSocialTitleMr() {
        this.socialTitleMr.click();
    }

    public void checkSocialTitleMrs() {
        this.socialTitleMrs.click();
    }

    public void typeFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void typeLastName(String lastName) {
        this.lastName.sendKeys(lastName);

    }

    public void typeEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public void typePassword(String password) {
        this.password.sendKeys(password);
    }

    public void typeBirthday(String birthdate) {
        this.birthday.sendKeys(birthdate);
    }

    public void checkReceiveOffers() {
        this.receiveOffers.click();
    }

    public void checkNewsletterSignup() {
        this.newsletterSignup.click();
    }

    public void checkTermsAndPrivacy() {
        this.termsAndPrivacy.click();
    }

    public void saveCustomer() {
        this.save.click();
    }

    public String getErrorMessageText() {
        return this.errorMessage.getText().trim();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(
                (d) -> firstName.isDisplayed() && email.isDisplayed() && password.isDisplayed() && save.isDisplayed());
    }

}
