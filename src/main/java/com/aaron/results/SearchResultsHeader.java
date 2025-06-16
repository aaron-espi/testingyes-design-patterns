package com.aaron.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class SearchResultsHeader extends AbstractComponent {

    @FindBy(css = "nav.breadcrumb")
    private WebElement breadcrumbNav;

    @FindBy(id = "js-product-list-header")
    private WebElement title;

    public SearchResultsHeader(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> breadcrumbNav.isDisplayed() && title.isDisplayed());
    }

}
