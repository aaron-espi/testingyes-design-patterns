package com.aaron.utils.model;

/**
 * Model class representing a test user with basic registration details.
 * <p>
 * Used to encapsulate user data for registration scenarios in automated tests.
 */
public class TestUser {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String birthday;

    /**
     * Constructs a TestUser with all necessary fields.
     *
     * @param firstName the user's first name
     * @param lastName  the user's last name
     * @param email     the user's email address
     * @param password  the user's password
     * @param birthday  the user's birthday (format: MM-dd-yyyy)
     */
    public TestUser(String firstName, String lastName, String email, String password, String birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    /**
     * Returns the user's first name.
     *
     * @return the user's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the user's first name.
     *
     * @param firstName the first name to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the user's last name.
     *
     * @return the user's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the user's last name.
     *
     * @param lastName the last name to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the user's email address.
     *
     * @return the user's email address
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the user's email address.
     *
     * @param email the email address to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the user's password.
     *
     * @return the user's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password.
     *
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the user's birthday.
     *
     * @return the user's birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * Sets the user's birthday.
     *
     * @param birthday the birthday to set (format: MM-dd-yyyy)
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}