package com.aaron.results;

import static com.aaron.results.ResultsLocators.RESULTS_PAGE_BREADCRUMB_NAVIGATION;
import static com.aaron.results.ResultsLocators.RESULTS_PAGE_TITLE_TEXT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

/**
 * Represents the header section of the search results page.
 * <p>
 * Includes the breadcrumb navigation and the page title for search results.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class SearchResultsHeader extends AbstractComponent {

    @FindBy(css = RESULTS_PAGE_BREADCRUMB_NAVIGATION)
    private WebElement breadcrumbNav;

    @FindBy(id = RESULTS_PAGE_TITLE_TEXT)
    private WebElement title;

    /**
     * Constructs the SearchResultsHeader component and initializes its elements.
     *
     * @param driver the WebDriver instance used for interacting with the page
     */
    public SearchResultsHeader(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if both the breadcrumb navigation and the title are visible on the
     * page.
     *
     * @return true if both elements are displayed; false otherwise
     */
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> breadcrumbNav.isDisplayed() && title.isDisplayed());
    }

}
