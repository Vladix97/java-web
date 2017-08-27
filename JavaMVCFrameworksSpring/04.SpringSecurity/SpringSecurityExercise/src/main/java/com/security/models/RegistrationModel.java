package com.security.models;

import com.security.constants.Error;

import javax.validation.constraints.Size;

public class RegistrationModel {

    @Size(min = 5, message = Error.USERNAME_TOO_SHORT)
    private String username;

    @Size(min = 5, message = Error.PASSWORD_TOO_SHORT)
    private String password;

    private String confirmPassword;

    public RegistrationModel() {
        super();
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
