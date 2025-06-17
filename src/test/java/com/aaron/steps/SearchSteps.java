package com.aaron.steps;

import static com.aaron.constants.SearchConstants.NO_RESULTS_SUGGESTION;
import static com.aaron.constants.SearchConstants.NO_RESULTS_TITLE;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.aaron.core.DriverManager;
import com.aaron.main.MainPage;
import com.aaron.results.ResultsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Step definitions for the product search feature in Cucumber scenarios.
 * <p>
 * Each method is mapped to a Gherkin step and prepares, interacts, or validates
 * the product search process in the UI.
 */
public class SearchSteps {

    private WebDriver driver;
    private MainPage mainPage;
    private ResultsPage resultsPage;

    /**
     * Navigates to the main page and ensures the product grid is loaded.
     */
    @Given("the user is on the main page")
    public void navigateToMainPage() {
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        resultsPage = new ResultsPage(driver);

        mainPage.goTo();

        Assert.assertTrue(mainPage.getProductGrid().isDisplayed());
    }

    /**
     * Enters the specified query into the search bar.
     *
     * @param query the search term to enter
     */
    @When("the user enters {string} into the search bar")
    public void enterSearchQuery(String query) {
        mainPage.getSearchWidget().typeSearchQuery(query);
    }

    /**
     * Clicks the search button to submit the query.
     */
    @And("the user clicks the search button")
    public void clickSearchButton() {
        mainPage.getSearchWidget().clickSearchButton();
    }

    /**
     * Verifies that the search results page is displayed.
     */
    @Then("the search results page is displayed")
    public void verifySearchResultsPage() {
        Assert.assertTrue(resultsPage.getSearchResultsHeader().isDisplayed());
    }

    /**
     * Verifies that the search results include products matching the query.
     *
     * @param query the search term to check for in the results
     */
    @And("the search results should include products matching {string}")
    public void verifySearchResultsMatchQuery(String query) {
        Assert.assertTrue(resultsPage.getProductGrid().containsProductsMatchingQuery(query));
    }

    /**
     * Verifies that the user sees a message indicating no products were found.
     */
    @And("the user sees a message indicating no products were found")
    public void verifyNoProductsFoundMessage() {
        Assert.assertTrue(resultsPage.getNoResultsPanel().isDisplayed());
        Assert.assertEquals(NO_RESULTS_TITLE,
                resultsPage.getNoResultsPanel().getTitleText());
        Assert.assertEquals(NO_RESULTS_SUGGESTION,
                resultsPage.getNoResultsPanel().getSuggestionText());
    }
}