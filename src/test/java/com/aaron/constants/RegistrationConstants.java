package com.aaron.constants;

/**
 * Contains constant values related to user registration scenarios.
 * <p>
 * This utility class centralizes error messages and other registration-related
 * constants for use in tests.
 * This class is final and cannot be instantiated.
 */
public final class RegistrationConstants {
    /**
     * Error message shown when the email is already used during registration.
     */
    public static final String ALREADY_USED_EMAIL_ERROR = "The email is already used, please choose another one or sign in";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private RegistrationConstants() {
    }
}