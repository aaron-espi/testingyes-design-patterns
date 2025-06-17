package com.aaron.utils.factory;

/**
 * Utility class for generating test email addresses for registration scenarios.
 * <p>
 * Provides methods to generate unique and already-used email addresses for use
 * in automated tests.
 * This class is final and cannot be instantiated.
 */
public final class EmailFactory {

    private static final String DOMAIN = "@example.com";
    private static final String ALREADY_USED_EMAIL_PREFIX = "john.doe";
    private static final String UNIQUE_EMAIL_PREFIX = "user";

    /**
     * Returns an email address that is already registered in the system.
     *
     * @return a static email address known to be already used
     */
    public static String alreadyUsedEmail() {
        return ALREADY_USED_EMAIL_PREFIX + DOMAIN;
    }

    /**
     * Generates a unique email address using the current timestamp.
     *
     * @return a unique email address for test registration
     */
    public static String generateUniqueEmail() {
        long timestamp = System.currentTimeMillis();
        return UNIQUE_EMAIL_PREFIX + timestamp + DOMAIN;
    }

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private EmailFactory() {
    }
}