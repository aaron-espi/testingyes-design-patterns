package com.aaron.results;

import static com.aaron.results.ResultsLocators.NO_RESULTS_SEARCH_INPUT;
import static com.aaron.results.ResultsLocators.NO_RESULTS_SUGGESTION_TEXT;
import static com.aaron.results.ResultsLocators.NO_RESULTS_TITLE_TEXT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class NoResultsPanel extends AbstractComponent {

    @FindBy(css = NO_RESULTS_TITLE_TEXT)
    private WebElement title;

    @FindBy(css = NO_RESULTS_SUGGESTION_TEXT)
    private WebElement suggestion;

    @FindBy(css = NO_RESULTS_SEARCH_INPUT)
    private WebElement searchInput;

    public NoResultsPanel(WebDriver driver) {
        super(driver);
    }

    public String getTitleText() {
        return this.title.getText().trim();
    }

    public String getSuggestionText() {
        return this.suggestion.getText().trim();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until(driver -> title.isDisplayed() && suggestion.isDisplayed() && searchInput.isDisplayed());
    }

}
