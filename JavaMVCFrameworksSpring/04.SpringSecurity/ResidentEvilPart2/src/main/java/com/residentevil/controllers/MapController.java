package com.residentevil.controllers;

import com.residentevil.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class MapController {

    private final VirusService virusService;

    @Autowired
    public MapController(VirusService virusService) {
        this.virusService = virusService;
    }

    public String getMap(Model model) {
        String geoJson = this.virusService.findAllMapViruses();
        model.addAttribute("geoJson", geoJson);
        return "map";
    }
}
