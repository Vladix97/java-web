package com.security.controllers;

import com.security.constants.Error;
import com.security.models.RegistrationModel;
import com.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(@ModelAttribute RegistrationModel registrationModel) {
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute RegistrationModel registrationModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors() ||
                !registrationModel.getPassword().equals(registrationModel.getConfirmPassword())) {
            model.addAttribute("passwordsNotMatching", "Passwords are not matching!");
            return "register";
        }

        this.userService.register(registrationModel);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String getLoginPage(@RequestParam(required = false) String error, Model model){
        if(error != null){
            model.addAttribute("error", Error.USER_NOT_FOUND);
        }

        return "login";
    }

    @GetMapping("/user")
    public String getUserPage() {
        return "user";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

}
