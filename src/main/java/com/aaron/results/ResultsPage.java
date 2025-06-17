package com.aaron.results;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aaron.common.ProductGrid;
import com.aaron.common.SearchWidget;

/**
 * Represents the search results page of the application.
 * <p>
 * Provides access to all major components present on the results page, such as
 * the product grid, search widget, and panels for no results or sorting.
 * Designed for use in automated UI tests following the Page Object Model
 * pattern.
 */
public class ResultsPage {

    private WebDriver driver;
    private ProductGrid productGrid;
    private SearchWidget searchWidget;
    private NoResultsPanel noResultsPanel;
    private SortByWidget sortByWidget;
    private SearchResultsHeader searchResultsHeader;

    /**
     * Constructs the ResultsPage and initializes all its components.
     *
     * @param driver WebDriver instance to interact with the browser
     */
    public ResultsPage(final WebDriver driver) {
        this.driver = driver;
        this.productGrid = PageFactory.initElements(driver, ProductGrid.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.noResultsPanel = PageFactory.initElements(driver, NoResultsPanel.class);
        this.sortByWidget = PageFactory.initElements(driver, SortByWidget.class);
        this.searchResultsHeader = PageFactory.initElements(driver, SearchResultsHeader.class);
    }

    /**
     * Returns the product grid component showing the list of products.
     *
     * @return ProductGrid component
     */
    public ProductGrid getProductGrid() {
        return productGrid;
    }

    /**
     * Returns the search widget component for entering search queries.
     *
     * @return SearchWidget component
     */
    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    /**
     * Returns the component displayed when no search results are found.
     *
     * @return NoResultsPanel component
     */
    public NoResultsPanel getNoResultsPanel() {
        return noResultsPanel;
    }

    /**
     * Returns the widget for sorting the product results.
     *
     * @return SortByWidget component
     */
    public SortByWidget getSortByWidget() {
        return sortByWidget;
    }

    /**
     * Returns the header section of the search results page.
     *
     * @return SearchResultsHeader component
     */
    public SearchResultsHeader getSearchResultsHeader() {
        return searchResultsHeader;
    }

}
