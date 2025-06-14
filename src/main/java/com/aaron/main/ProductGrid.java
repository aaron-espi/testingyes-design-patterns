package com.aaron.main;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aaron.common.AbstractComponent;

public class ProductGrid extends AbstractComponent {
    @FindBy(css = "article.product-miniature")
    private List<WebElement> productItems;

    public ProductGrid(WebDriver driver) {
        super(driver);
    }

    public void selectProductByIndex(int index) {
        this.productItems.get(index - 1).click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.productItems.size() > 5);
    }
}
