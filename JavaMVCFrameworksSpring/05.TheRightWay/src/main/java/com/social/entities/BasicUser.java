package com.social.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("basic_user")
public class BasicUser extends User {

    // Can add more logic to a basic user if we want...
}
