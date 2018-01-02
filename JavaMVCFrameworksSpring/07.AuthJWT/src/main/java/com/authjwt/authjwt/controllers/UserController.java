package com.authjwt.authjwt.controllers;

import com.authjwt.authjwt.models.view_models.User;
import com.authjwt.authjwt.security.JWTTokenUtil;
import com.authjwt.authjwt.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private static final List<User> persons;

    static {
        persons = new ArrayList<>();
        persons.add(new User("Hello", "World"));
        persons.add(new User("Foo", "Bar"));
    }

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/persons", method = RequestMethod.GET)
    public static List<User> getPersons() {
        return persons;
    }

    @RequestMapping(path = "/persons/{name}", method = RequestMethod.GET)
    public static User getPerson(@PathVariable("name") String name) {
        return persons.stream()
                .filter(person -> name.equalsIgnoreCase(person.getName()))
                .findAny().orElse(null);
    }

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public UserDetails getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader).substring(7);
        String username = this.jwtTokenUtil.getUsernameFromToken(token);
        UserDetails user = this.userService.loadUserByUsername(username);
        return user;
    }

}
