package com.bookhut.services;

import com.bookhut.models.binding_models.LoginUserModel;

public interface UserService {

    void createUser(LoginUserModel user);

    LoginUserModel findUserByUsernameAndPassword(String username, String password);
}
