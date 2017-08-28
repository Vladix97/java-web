package com.security.services;

import com.security.constants.Error;
import com.security.entities.User;
import com.security.models.RegistrationModel;
import com.security.parsers.interfaces.ModelParser;
import com.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ModelParser modelParser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder,
                           ModelParser modelParser) {
        this.userRepository = userRepository;
        this.modelParser = modelParser;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(Error.USER_NOT_FOUND);
        }

        return user;
    }

    @Override
    public void register(RegistrationModel registrationModel) {
        User user = this.modelParser.convert(registrationModel, User.class);
        String password = this.bCryptPasswordEncoder.encode(registrationModel.getPassword());

        user.setPassword(password);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);

        this.userRepository.saveAndFlush(user);
    }
}
