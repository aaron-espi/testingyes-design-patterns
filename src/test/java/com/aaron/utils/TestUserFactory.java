package com.aaron.utils;

public class TestUserFactory {

    public static TestUser generate() {
        long timestamp = System.currentTimeMillis();
        return new TestUser(
                "Test",
                "User",
                "user" + timestamp + "@test.com",
                "Password" + timestamp,
                "12/25/2004");
    }
}