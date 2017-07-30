package com.bookhut.repositories;

import com.bookhut.entities.User;

public interface UserRepository {

    void createUser(User user);

    User findUserByUsernameAndPassword(String username, String password);
}
