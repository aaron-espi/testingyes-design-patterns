package com.aaron.utils.factory;

public final class EmailFactory {

    private static final String DOMAIN = "@example.com";

    private EmailFactory() {
    }

    public static String alreadyUsedEmail() {
        return "john.doe" + DOMAIN;
    }

    public static String generateUniqueEmail() {
        long timestamp = System.currentTimeMillis();
        return "user" + timestamp + DOMAIN;
    }
}