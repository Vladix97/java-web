package com.bookhut.repositoryImpls;

import com.bookhut.entities.User;
import com.bookhut.repositories.UserRepository;

import java.util.*;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepositoryImpl userRepository;

    private Map<String, User> users;

    private UserRepositoryImpl() {
        this.users = new LinkedHashMap<>();
    }

    public static UserRepository getInstance() {
        if (UserRepositoryImpl.userRepository == null) {
            UserRepositoryImpl.userRepository = new UserRepositoryImpl();
        }

        return UserRepositoryImpl.userRepository;
    }

    @Override
    public void createUser(User user) {
        String id = user.getUsername() + user.getPassword();
        this.users.put(id, user);
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        String id = username + password;
        return this.users.get(id);
    }
}
