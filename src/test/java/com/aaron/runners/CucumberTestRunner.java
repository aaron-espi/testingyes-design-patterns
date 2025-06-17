package com.aaron.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Test runner for executing Cucumber feature files using JUnit.
 * <p>
 * Configures feature locations, step definitions, and reporting plugins for the
 * test suite.
 * Run this class as a JUnit test to execute all Cucumber scenarios.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "com.aaron.steps", "com.aaron.hooks" }, plugin = {
                "pretty",
                "html:target/cucumber-reports.html",
                "json:target/cucumber-report.json"
}, monochrome = true)
public class CucumberTestRunner {
}
