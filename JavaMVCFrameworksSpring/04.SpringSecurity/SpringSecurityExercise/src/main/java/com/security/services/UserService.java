package com.security.services;

import com.security.models.RegistrationModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void register(RegistrationModel registrationModel);

}
