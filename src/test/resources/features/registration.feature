Feature: User Registration

  As a new user  
  I want to register with valid information  
  So that I can access my personal account

  Scenario: Successful registration with valid details
    Given the user navigates to the registration page  
    When the user fills in all required fields with valid data  
    And submits the registration form  
    Then the user should be redirected to the main page  
    And see their name displayed in the top bar