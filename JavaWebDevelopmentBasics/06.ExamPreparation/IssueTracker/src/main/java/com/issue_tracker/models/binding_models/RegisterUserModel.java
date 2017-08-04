package com.issue_tracker.models.binding_models;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterUserModel {

    @Size(min = 5, max = 30, message = "The username is invalid")
    private String username;

    @Size(min = 5, message = "The full name is invalid")
    private String fullName;

    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*,.])[A-Za-z\\d!@#$%^&*,.&]{8,}$", message = "The password is invalid" )
    private String password;

    private String confirmPassword;

    public RegisterUserModel() {
        super();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}