package com.aaron.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchWidget extends AbstractComponent {

    @FindBy(name = "s")
    private WebElement searchBar;

    @FindBy(xpath = "//button[span[text()='Search']]")
    private WebElement searchButton;

    public SearchWidget(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> searchBar.isDisplayed());
    }

}
