package com.residentevil.controllers;

import com.residentevil.models.viewModels.VirusViewModel;
import com.residentevil.services.VirusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cures")
public class CuresController {

    private final VirusService virusService;

    @Autowired
    public CuresController(VirusService virusService) {
        this.virusService = virusService;
    }

    @GetMapping("")
    public String getVirusHomePage(Model model) {
        List<VirusViewModel> viruses = this.virusService.findAllViruses();
        model.addAttribute("viruses", viruses);
        return "cures";
    }

    @GetMapping("/delete/{virusId}")
    public String deleteVirus(@PathVariable long virusId) {
        this.virusService.deleteById(virusId);
        return "redirect:/cures";
    }
}
