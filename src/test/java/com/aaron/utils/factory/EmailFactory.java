package com.aaron.utils.factory;

public final class EmailFactory {

    private static final String DOMAIN = "@example.com";
    private static final String ALREADY_USED_EMAIL_PREFIX = "john.doe";
    private static final String UNIQUE_EMAIL_PREFIX = "user";

    private EmailFactory() {
    }

    public static String alreadyUsedEmail() {
        return ALREADY_USED_EMAIL_PREFIX + DOMAIN;
    }

    public static String generateUniqueEmail() {
        long timestamp = System.currentTimeMillis();
        return UNIQUE_EMAIL_PREFIX + timestamp + DOMAIN;
    }
}