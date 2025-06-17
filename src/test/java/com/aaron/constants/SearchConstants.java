package com.aaron.constants;

/**
 * Contains constant values related to search scenarios and test data fields.
 * <p>
 * This utility class centralizes field names and messages for search-related
 * tests and should not be instantiated.
 * This class is final and cannot be instantiated.
 */
public final class SearchConstants {
    /** Field name for the user's first name. */
    public static final String FIRST_NAME_FIELD = "firstName";
    /** Field name for the user's last name. */
    public static final String LAST_NAME_FIELD = "lastName";
    /** Field name for the user's password. */
    public static final String PASSWORD_FIELD = "password";
    /** Field name for the user's birthday. */
    public static final String BIRTHDAY_FIELD = "birthday";
    /** Message shown when no results are found. */
    public static final String NO_RESULTS_TITLE = "Sorry for the inconvenience.";
    /** Suggestion message shown when no results are found. */
    public static final String NO_RESULTS_SUGGESTION = "Search again what you are looking for";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private SearchConstants() {
    }
}