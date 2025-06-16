package com.aaron.common;

import static com.aaron.common.CommonLocators.HEADER_SEARCH_BUTTON;
import static com.aaron.common.CommonLocators.HEADER_SEARCH_INPUT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchWidget extends AbstractComponent {

    @FindBy(name = HEADER_SEARCH_INPUT)
    private WebElement searchInput;

    @FindBy(xpath = HEADER_SEARCH_BUTTON)
    private WebElement searchButton;

    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    public void typeSearchQuery(String query) {
        searchInput.clear();
        searchInput.sendKeys(query);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> searchInput.isDisplayed() && searchButton.isDisplayed());
    }

}
