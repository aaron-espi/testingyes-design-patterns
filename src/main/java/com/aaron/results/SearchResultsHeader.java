package com.aaron.results;

import static com.aaron.results.ResultsLocators.RESULTS_PAGE_BREADCRUMB_NAVIGATION;
import static com.aaron.results.ResultsLocators.RESULTS_PAGE_TITLE_TEXT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class SearchResultsHeader extends AbstractComponent {

    @FindBy(css = RESULTS_PAGE_BREADCRUMB_NAVIGATION)
    private WebElement breadcrumbNav;

    @FindBy(id = RESULTS_PAGE_TITLE_TEXT)
    private WebElement title;

    public SearchResultsHeader(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> breadcrumbNav.isDisplayed() && title.isDisplayed());
    }

}
