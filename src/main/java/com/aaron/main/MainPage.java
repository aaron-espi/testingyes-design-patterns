package com.aaron.main;

import static com.aaron.config.EnvironmentConfig.BASE_URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aaron.common.ProductGrid;
import com.aaron.common.SearchWidget;
import com.aaron.common.TopBar;

/**
 * Represents the main page of the application.
 * <p>
 * Provides access to common components such as the top bar, search widget, and
 * product grid.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class MainPage {

    private WebDriver driver;
    private TopBar topBar;
    private SearchWidget searchWidget;
    private ProductGrid productGrid;

    /**
     * Constructs the MainPage and initializes its components.
     *
     * @param driver the WebDriver instance to interact with the page
     */
    public MainPage(final WebDriver driver) {
        this.driver = driver;
        this.topBar = PageFactory.initElements(driver, TopBar.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.productGrid = PageFactory.initElements(driver, ProductGrid.class);
    }

    /**
     * Navigates the WebDriver to the base URL of the main page.
     */
    public void goTo() {
        this.driver.get(BASE_URL);
    }

    /**
     * Returns the TopBar component of the main page.
     *
     * @return the TopBar instance
     */
    public TopBar getTopBar() {
        return topBar;
    }

    /**
     * Returns the SearchWidget component of the main page.
     *
     * @return the SearchWidget instance
     */
    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    /**
     * Returns the ProductGrid component of the main page.
     *
     * @return the ProductGrid instance
     */
    public ProductGrid getProductGrid() {
        return productGrid;
    }

}
