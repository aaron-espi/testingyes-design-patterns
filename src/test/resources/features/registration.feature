Feature: User Registration

    As a new user  
    I want to register with valid information  
    So that I can access my personal account

  Scenario: Successful registration with valid details
    Given the user is on the registration page
    When the user fills in all required fields with valid data  
    And submits the registration form  
    Then the user should be redirected to the main page  
    And see their name displayed in the top bar

  Scenario: Registration attempt with an already registered email
    Given the user is on the registration page
    When the user fills in all required fields with valid data
    But the email is already in use
    And submits the registration form  
    Then an email validation error message is displayed
    And the registration is not successful
    