package com.aaron.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver driver;
    private TopBar topBar;

    public MainPage(final WebDriver driver) {
        this.driver = driver;
        this.topBar = PageFactory.initElements(driver, TopBar.class);
    }

    public void goTo() {
        this.driver.get("http://www.testingyes.com/onlineshop/");
    }

    public TopBar getTopBar() {
        return topBar;
    }

}
