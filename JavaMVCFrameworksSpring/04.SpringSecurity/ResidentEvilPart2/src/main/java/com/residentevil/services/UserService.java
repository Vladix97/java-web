package com.residentevil.services;

import com.residentevil.models.bindingModels.RegistrationModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void register(RegistrationModel registerUser);
}
