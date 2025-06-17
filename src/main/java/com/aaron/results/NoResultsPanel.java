package com.aaron.results;

import static com.aaron.results.ResultsLocators.NO_RESULTS_SEARCH_INPUT;
import static com.aaron.results.ResultsLocators.NO_RESULTS_SUGGESTION_TEXT;
import static com.aaron.results.ResultsLocators.NO_RESULTS_TITLE_TEXT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

/**
 * Represents the panel displayed when no search results are found.
 * <p>
 * Encapsulates elements such as the title, suggestion message, and search input
 * for further queries.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class NoResultsPanel extends AbstractComponent {

    @FindBy(css = NO_RESULTS_TITLE_TEXT)
    private WebElement title;

    @FindBy(css = NO_RESULTS_SUGGESTION_TEXT)
    private WebElement suggestion;

    @FindBy(css = NO_RESULTS_SEARCH_INPUT)
    private WebElement searchInput;

    /**
     * Constructs the NoResultsPanel component and initializes its elements.
     *
     * @param driver the WebDriver instance to interact with the page
     */
    public NoResultsPanel(WebDriver driver) {
        super(driver);
    }

    /**
     * Returns the text of the "no results" title displayed to the user.
     *
     * @return trimmed title text
     */
    public String getTitleText() {
        return this.title.getText().trim();
    }

    /**
     * Returns the suggestion text prompting the user what to do next.
     *
     * @return trimmed suggestion text
     */
    public String getSuggestionText() {
        return this.suggestion.getText().trim();
    }

    /**
     * Checks if the no results panel is fully displayed, waiting for all key
     * elements to be visible.
     *
     * @return true if the panel is displayed, false otherwise
     */
    @Override
    public boolean isDisplayed() {
        return this.wait.until(driver -> title.isDisplayed() && suggestion.isDisplayed() && searchInput.isDisplayed());
    }

}
