package com.aaron.results;

import static com.aaron.results.ResultsLocators.SORT_BY_DROPDOWN_MENU;
import static com.aaron.results.ResultsLocators.SORT_BY_LABEL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

/**
 * Represents the "Sort By" widget on the search results page.
 * <p>
 * Provides access to the sort label and dropdown menu for sorting product
 * listings.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class SortByWidget extends AbstractComponent {

    @FindBy(css = SORT_BY_LABEL)
    private WebElement label;

    @FindBy(css = SORT_BY_DROPDOWN_MENU)
    private WebElement sortDropdown;

    /**
     * Constructs the SortByWidget component and initializes its elements.
     *
     * @param driver the WebDriver instance used to interact with the widget
     */
    public SortByWidget(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks whether the sort label and dropdown menu are visible.
     *
     * @return true if both elements are displayed, false otherwise
     */
    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> label.isDisplayed() && sortDropdown.isDisplayed());
    }
}
