package com.aaron.common;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Abstract base class for all page components and widgets in the test
 * framework.
 * <p>
 * Provides a shared WebDriverWait and initializes WebElements via Selenium's
 * PageFactory.
 * Subclasses must implement {@code isDisplayed()} to verify their visibility on
 * the page.
 */
public abstract class AbstractComponent {

    protected WebDriverWait wait;

    /**
     * Constructs the component, initializes the WebElements using PageFactory
     * and sets up an explicit wait with 30 seconds timeout.
     *
     * @param driver the WebDriver instance used for interaction
     */
    public AbstractComponent(final WebDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    /**
     * Checks whether the component is currently visible and ready for interaction.
     *
     * @return true if the component is displayed; false otherwise
     */
    public abstract boolean isDisplayed();
}