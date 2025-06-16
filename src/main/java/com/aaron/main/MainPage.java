package com.aaron.main;

import static com.aaron.config.EnvironmentConfig.BASE_URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aaron.common.ProductGrid;
import com.aaron.common.SearchWidget;
import com.aaron.common.TopBar;

public class MainPage {

    private WebDriver driver;
    private TopBar topBar;
    private SearchWidget searchWidget;
    private ProductGrid productGrid;

    public MainPage(final WebDriver driver) {
        this.driver = driver;
        this.topBar = PageFactory.initElements(driver, TopBar.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.productGrid = PageFactory.initElements(driver, ProductGrid.class);
    }

    public void goTo() {
        this.driver.get(BASE_URL);
    }

    public TopBar getTopBar() {
        return topBar;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public ProductGrid getProductGrid() {
        return productGrid;
    }

}
