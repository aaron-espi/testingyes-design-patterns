package com.aaron.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aaron.common.ProductGrid;
import com.aaron.common.SearchWidget;

public class ResultsPage {

    private WebDriver driver;
    private ProductGrid productGrid;
    private SearchWidget searchWidget;

    public ResultsPage(final WebDriver driver) {
        this.driver = driver;
        this.productGrid = PageFactory.initElements(driver, ProductGrid.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
    }

    public ProductGrid getProductGrid() {
        return productGrid;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

}
