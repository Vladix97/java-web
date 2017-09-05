package com.filter.controllers;

import com.filter.models.view.game.GameDetailsView;
import com.filter.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("games")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("{id}")
    public String details(Model model, @PathVariable Long id) {
        model.addAttribute("view", "games/details");

        GameDetailsView game = gameService.get(id);

        model.addAttribute("game", game);
        model.addAttribute("title", game.getTitle());

        return "base-layout";
    }
}
