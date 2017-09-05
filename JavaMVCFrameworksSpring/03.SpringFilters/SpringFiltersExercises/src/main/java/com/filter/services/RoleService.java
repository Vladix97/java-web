package com.filter.services;


import com.filter.entities.Role;

public interface RoleService {
    Role findByName(String name);
}
