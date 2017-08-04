package com.issue_tracker.controllers;

import com.mvcFramework.annotations.controller.Controller;
import com.mvcFramework.annotations.request.GetMapping;

import javax.ejb.Stateless;

@Stateless
@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomePage(){
        System.out.println("HERE");
        return "/templates/same";
    }
}
