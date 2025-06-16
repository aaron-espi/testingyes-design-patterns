package com.aaron.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class NoResultsPanel extends AbstractComponent {

    @FindBy(css = "section.page-not-found > h4")
    private WebElement title;

    @FindBy(css = "section.page-not-found > p")
    private WebElement suggestion;

    @FindBy(css = "div#search_widget input[name='s']")
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
