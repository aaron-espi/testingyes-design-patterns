package com.aaron.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class RegistrationForm extends AbstractComponent {

    @FindBy(css = "input[name='id_gender'][value='1']")
    private WebElement socialTitleMr;

    @FindBy(css = "input[name='id_gender'][value='2']")
    private WebElement socialTitleMrs;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "birthday")
    private WebElement birthday;

    @FindBy(name = "optin")
    private WebElement receiveOffers;

    @FindBy(name = "newsletter")
    private WebElement newsletterSignup;

    @FindBy(name = "psgdpr")
    private WebElement termsAndPrivacy;

    @FindBy(xpath = "//button[@data-link-action='save-customer']")
    private WebElement save;

    @FindBy(css = "div.help-block ul li.alert.alert-danger")
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
        return this.wait.until((d) -> save.isDisplayed());
    }

}
