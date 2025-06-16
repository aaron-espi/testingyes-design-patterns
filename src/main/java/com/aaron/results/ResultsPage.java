package com.aaron.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aaron.common.ProductGrid;
import com.aaron.common.SearchWidget;

public class ResultsPage {

    private WebDriver driver;
    private ProductGrid productGrid;
    private SearchWidget searchWidget;
    private NoResultsPanel noResultsPanel;
    private SortByWidget sortByWidget;
    private SearchResultsHeader searchResultsHeader;

    public ResultsPage(final WebDriver driver) {
        this.driver = driver;
        this.productGrid = PageFactory.initElements(driver, ProductGrid.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.noResultsPanel = PageFactory.initElements(driver, NoResultsPanel.class);
        this.sortByWidget = PageFactory.initElements(driver, SortByWidget.class);
        this.searchResultsHeader = PageFactory.initElements(driver, SearchResultsHeader.class);
    }

    public ProductGrid getProductGrid() {
        return productGrid;
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public NoResultsPanel getNoResultsPanel() {
        return noResultsPanel;
    }

    public SortByWidget getSortByWidget() {
        return sortByWidget;
    }

    public SearchResultsHeader getSearchResultsHeader() {
        return searchResultsHeader;
    }

}
