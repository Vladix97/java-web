package com.residentevil.models.bindingModels;

import com.residentevil.validations.IsPasswordsMatching;

import javax.validation.constraints.Size;

@IsPasswordsMatching
public class RegistrationModel {

    private String username;

    private String password;

    private String confirmPassword;

    public RegistrationModel() {
        super();
    }

    @Size(min = 5, message = "Username too short!")
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Size(min = 5, message = "Password too short!")
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
