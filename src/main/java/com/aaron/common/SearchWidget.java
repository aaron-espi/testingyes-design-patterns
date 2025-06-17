package com.aaron.common;

import static com.aaron.common.CommonLocators.HEADER_SEARCH_BUTTON;
import static com.aaron.common.CommonLocators.HEADER_SEARCH_INPUT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Represents the search widget located in the header of the page.
 * <p>
 * Provides actions to interact with the search bar and trigger search requests.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class SearchWidget extends AbstractComponent {

    @FindBy(name = HEADER_SEARCH_INPUT)
    private WebElement searchInput;

    @FindBy(xpath = HEADER_SEARCH_BUTTON)
    private WebElement searchButton;

    /**
     * Initializes the SearchWidget component.
     *
     * @param driver the WebDriver instance used to interact with the page. The page
     *               should already contain the search widget.
     */
    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    /**
     * Types the specified query into the search input field.
     *
     * @param query the search term to be entered
     */
    public void typeSearchQuery(String query) {
        searchInput.clear();
        searchInput.sendKeys(query);
    }

    /**
     * Clicks the search button to submit the search query.
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * Checks whether both the search input and button are visible.
     *
     * @return true if both elements are displayed, false otherwise
     */
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> searchInput.isDisplayed() && searchButton.isDisplayed());
    }

}
