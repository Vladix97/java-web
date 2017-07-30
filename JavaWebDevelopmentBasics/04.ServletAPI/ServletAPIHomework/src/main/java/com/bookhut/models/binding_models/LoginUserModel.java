package com.bookhut.models.binding_models;

public class LoginUserModel {

    private String username;

    private String password;

    public LoginUserModel() {
        super();
    }

    public LoginUserModel(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
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
}
