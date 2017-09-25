package com.social.services;

import com.social.entities.BasicUser;
import com.social.entities.User;
import com.social.models.bindingModels.RegistrationModel;
import com.social.repositories.BasicUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BasicUserServiceImpl implements BasicUserService {

    private final BasicUserRepository basicUserRepository;

    private final RoleService roleService;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ModelMapper modelMapper;

    @Autowired
    public BasicUserServiceImpl(
            BasicUserRepository basicUserRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            ModelMapper modelMapper,
            RoleService roleService) {
        this.basicUserRepository = basicUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.modelMapper = modelMapper;
        this.roleService = roleService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = this.basicUserRepository.findByUsername(username);
        if (byUsername == null)
            throw new UsernameNotFoundException("Invalid Credentials");

        return byUsername;
    }

    @Override
    public void register(RegistrationModel registrationModel) {
        BasicUser user = this.modelMapper.map(registrationModel, BasicUser.class);

        String encryptedPassword = this.bCryptPasswordEncoder.encode(registrationModel.getPassword());
        user.setPassword(encryptedPassword);
        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.addRole(this.roleService.getDefaultRole());

        this.basicUserRepository.saveAndFlush(user);
    }
}
