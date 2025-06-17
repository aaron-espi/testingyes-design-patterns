package com.aaron.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Manages the lifecycle of WebDriver instances for test execution.
 * <p>
 * Uses ThreadLocal to support parallel execution and thread safety. This class
 * should be used to initialize, retrieve, and clean up WebDriver instances in
 * tests.
 */
public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    /**
     * Initializes the WebDriver instance for the current thread if not already
     * initialized.
     * Sets up FirefoxDriver using WebDriverManager.
     */
    public static void initDriver() {
        if (driver.get() == null) {
            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());
        }
    }

    /**
     * Retrieves the current thread's WebDriver instance.
     *
     * @return WebDriver instance assigned to the current thread
     */
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Quits and removes the WebDriver instance for the current thread, if present.
     * Cleans up to avoid memory leaks.
     */
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}