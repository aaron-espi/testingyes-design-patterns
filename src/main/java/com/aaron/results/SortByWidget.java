package com.aaron.results;

import static com.aaron.results.ResultsLocators.SORT_BY_DROPDOWN_MENU;
import static com.aaron.results.ResultsLocators.SORT_BY_LABEL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class SortByWidget extends AbstractComponent {

    @FindBy(css = SORT_BY_LABEL)
    private WebElement label;

    @FindBy(css = SORT_BY_DROPDOWN_MENU)
    private WebElement sortDropdown;

    public SortByWidget(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> label.isDisplayed() && sortDropdown.isDisplayed());
    }
}
