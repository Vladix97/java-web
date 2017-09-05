package com.filter.controllers;

import com.filter.models.view.game.HomePageGameView;
import com.filter.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final GameService gameService;

    @Autowired
    public HomeController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<HomePageGameView> games = this.gameService.getAllHomePage();

        model.addAttribute("view", "home/index");
        model.addAttribute("title", "Home");
        model.addAttribute("games", games);

        return "base-layout";
    }

}
