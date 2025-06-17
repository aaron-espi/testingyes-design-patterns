package com.aaron.hooks;

import com.aaron.core.DriverManager;

import io.cucumber.java.After;
import io.cucumber.java.Before;

/**
 * Cucumber hooks for setting up and tearing down the WebDriver before and after
 * scenarios.
 * <p>
 * Ensures that a new WebDriver instance is available for each scenario and is
 * properly closed afterwards.
 */
public class Hooks {

    /**
     * Initializes the WebDriver before each scenario.
     */
    @Before
    public void setUp() {
        DriverManager.initDriver();
    }

    /**
     * Quits the WebDriver after each scenario.
     */
    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}