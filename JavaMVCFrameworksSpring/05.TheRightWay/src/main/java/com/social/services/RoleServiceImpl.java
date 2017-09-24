package com.social.services;

import com.social.entities.Role;
import com.social.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    private static final String DEFAULT_ROLE = "ROLE_USER";

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getDefaultRole() {
        Role byAuthority = this.roleRepository.findByAuthority(DEFAULT_ROLE);
        return byAuthority;
    }
}
