package com.aaron.common;

import static com.aaron.common.CommonLocators.PRODUCT_ITEMS;
import static com.aaron.common.CommonLocators.PRODUCT_TITLE_TEXT;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductGrid extends AbstractComponent {

    @FindBy(css = PRODUCT_ITEMS)
    private List<WebElement> productItems;

    public ProductGrid(WebDriver driver) {
        super(driver);
    }

    public void selectProductByIndex(int index) {
        this.productItems.get(index - 1).click();
    }

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
