package com.aaron.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class SortByWidget extends AbstractComponent {

    @FindBy(css = "span.sort-by")
    private WebElement label;

    @FindBy(css = "div.dropdown-menu")
    private WebElement sortDropdown;

    public SortByWidget(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> label.isDisplayed() && sortDropdown.isDisplayed());
    }
}
