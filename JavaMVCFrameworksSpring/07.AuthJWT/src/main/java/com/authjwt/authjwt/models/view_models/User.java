package com.authjwt.authjwt.models.view_models;

import java.util.Date;

public class User {

    private String username;
    private String email;
    private Date lastPasswordResetDate;

    public User() {
    }

    public User(String name, String email) {
        this.username = name;
        this.email = email;
    }

    public String getName() {
        return this.username;
    }

    public void setName(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
