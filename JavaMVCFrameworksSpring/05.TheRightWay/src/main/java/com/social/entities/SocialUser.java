package com.social.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("social_user")
public class SocialUser extends User {

    private String provider;

    public SocialUser() {
        super();
    }

    public String getProvider() {
        return this.provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
