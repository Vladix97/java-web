package com.residentevil.controllers;

import com.residentevil.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VirusController {

    @Autowired
    private CapitalService capitalService;

    @Autowired
    private VirusService virusService;
}
