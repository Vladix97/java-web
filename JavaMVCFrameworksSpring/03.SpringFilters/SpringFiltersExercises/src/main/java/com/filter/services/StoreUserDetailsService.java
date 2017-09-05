package com.filter.services;

import com.filter.models.binding.user.UserRegistrationModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface StoreUserDetailsService extends UserDetailsService {
    void register(UserRegistrationModel userRegistrationModel);
}
