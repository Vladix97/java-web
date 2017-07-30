package com.bookhut.serviceImpls;

import com.bookhut.entities.User;
import com.bookhut.models.binding_models.LoginUserModel;
import com.bookhut.repositories.UserRepository;
import com.bookhut.repositoryImpls.UserRepositoryImpl;
import com.bookhut.services.UserService;
import org.modelmapper.ModelMapper;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    public UserServiceImpl() {
        this.userRepository = UserRepositoryImpl.getInstance();
        this.modelMapper = new ModelMapper();
    }

    @Override
    public void createUser(LoginUserModel user) {
        User entityUser = this.modelMapper.map(user, User.class);
        this.userRepository.createUser(entityUser);
    }

    @Override
    public LoginUserModel findUserByUsernameAndPassword(String username, String password) {
        User entityUser = this.userRepository.findUserByUsernameAndPassword(username, password);
        if (entityUser == null) return null;

        return this.modelMapper.map(entityUser, LoginUserModel.class);
    }
}
