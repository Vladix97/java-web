package com.filter.services;


import com.filter.models.view.game.GameDetailsView;
import com.filter.models.view.game.HomePageGameView;

import java.util.List;

public interface GameService {
    List<HomePageGameView> getAllHomePage();

    GameDetailsView get(Long id);
}
