package com.aaron.results;

/**
 * Provides CSS selectors and locators used by components on the search results page.
 * <p>
 * This utility class centralizes selectors for results-related elements such as titles, breadcrumbs, no-results messages, and sorting widgets.
 * <p>
 * This class is final and cannot be instantiated.
 */
public final class ResultsLocators {

    /** Selector for the main title text of the search results page. */
    public static final String RESULTS_PAGE_TITLE_TEXT = "js-product-list-header";

    /** Selector for the breadcrumb navigation on the results page. */
    public static final String RESULTS_PAGE_BREADCRUMB_NAVIGATION = "nav.breadcrumb";

    /** Selector for the title text shown when no search results are found. */
    public static final String NO_RESULTS_TITLE_TEXT = "section.page-not-found > h4";

    /** Selector for the suggestion text shown when no search results are found. */
    public static final String NO_RESULTS_SUGGESTION_TEXT = "section.page-not-found > p";

    /** Selector for the search input field shown in the no results panel. */
    public static final String NO_RESULTS_SEARCH_INPUT = "div#search_widget input[name='s']";

    /** Selector for the label text of the "Sort By" widget. */
    public static final String SORT_BY_LABEL = "span.sort-by";

    /** Selector for the dropdown menu in the "Sort By" widget. */
    public static final String SORT_BY_DROPDOWN_MENU = "div.dropdown-menu";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private ResultsLocators() {
    }
}