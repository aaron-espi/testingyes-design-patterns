package com.aaron.common;

import static com.aaron.common.CommonLocators.PRODUCT_ITEMS;
import static com.aaron.common.CommonLocators.PRODUCT_TITLE_TEXT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Represents the grid of products displayed on catalog or search result pages.
 * <p>
 * Provides actions and assertions related to product listings, such as
 * selecting a product or verifying if products matching a query are present.
 * Should be instantiated when the product grid is expected to be present on the
 * page.
 */
public class ProductGrid extends AbstractComponent {

    @FindBy(css = PRODUCT_ITEMS)
    private List<WebElement> productItems;

    /**
     * Initializes the ProductGrid component.
     *
     * @param driver the WebDriver instance used to interact with the page. The page
     *               should already contain the product grid.
     */
    public ProductGrid(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks on the product at the given index (1-based).
     *
     * @param index the 1-based index of the product to select
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void selectProductByIndex(int index) {
        this.productItems.get(index - 1).click();
    }

    /**
     * Checks whether any product title in the grid matches the given query
     * (case-insensitive).
     *
     * @param query the text to search for in product titles
     * @return true if at least one product title contains the query, false
     *         otherwise
     */
    public boolean containsProductsMatchingQuery(String query) {
        return this.productItems.stream()
                .map(product -> product.findElement(By.cssSelector(PRODUCT_TITLE_TEXT)).getText().toLowerCase())
                .anyMatch(name -> name.contains(query.toLowerCase()));
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> !this.productItems.isEmpty() && this.productItems.get(0).isDisplayed());
    }
}
