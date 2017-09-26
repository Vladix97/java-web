package com.social.entities;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserTest {

    private static final String EXPECTED_ROLE_NAME = "ROLE_USER";

    private User user;

    @Mock
    private Role role;

    @Before
    public void setUp() {
        this.user = new BasicUser();
        when(this.role.getAuthority()).thenReturn(EXPECTED_ROLE_NAME);
    }

    @Test
    public void addRoleToUser_RoleShouldBeAdded() {
        this.user.addRole(this.role);

        String actualRole = this.user.getAuthorities().iterator().next().getAuthority();
        assertEquals(EXPECTED_ROLE_NAME, actualRole);
    }
}