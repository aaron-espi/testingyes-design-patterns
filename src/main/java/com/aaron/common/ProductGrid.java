package com.aaron.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductGrid extends AbstractComponent {

    @FindBy(css = "article.product-miniature")
    private List<WebElement> productItems;

    public ProductGrid(WebDriver driver) {
        super(driver);
    }

    public void selectProductByIndex(int index) {
        this.productItems.get(index - 1).click();
    }

    public boolean containsProductsMatchingQuery(String query) {
        for (WebElement product : this.productItems) {
            String productName = product.findElement(By.cssSelector("h2.product-title")).getText().toLowerCase();
            if (productName.contains(query.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.productItems.get(0).isDisplayed());
    }
}
