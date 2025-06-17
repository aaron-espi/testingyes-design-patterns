package com.aaron.config;

/**
 * Provides environment-specific configuration constants for the test framework.
 * <p>
 * This utility class centralizes configuration values such as the base URL and
 * should not be instantiated.
 */
public final class EnvironmentConfig {

    /**
     * The base URL for the online shop environment.
     */
    public static final String BASE_URL = "http://www.testingyes.com/onlineshop/";

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private EnvironmentConfig() {
    }
}