package com.aaron.hooks;

import com.aaron.core.DriverManager;
import io.cucumber.java.Before;
import io.cucumber.java.After;

public class Hooks {

    @Before
    public void setUp() {
        DriverManager.initDriver();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}