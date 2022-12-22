package com.aor.Snake.Controller.menu;

import com.aor.Snake.Game;
import com.aor.Snake.Controller.Controller;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.arena.LoaderArenaBuilder;
import com.aor.Snake.model.menu.DificultyMenu;
import com.aor.Snake.model.menu.MainMenu;
import com.aor.Snake.states.GameState;
import com.aor.Snake.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class DificultyMenuController extends Controller<DificultyMenu> {

    public DificultyMenuController(DificultyMenu model) {super(model);}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP -> getModel().previousEntry();
            case DOWN -> getModel().nextEntry();
            case SELECT -> {
                if (getModel().isSelectedEasy()) {
                    game.setFPS(10);
                    game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                }
                if (getModel().isSelectedMedium()) {
                    game.setFPS(15);
                    game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                }
                if (getModel().isSelectedHard()) {
                    game.setFPS(25);
                    game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                }
                if (getModel().isSelectedBack()) game.setState(new MainMenuState(new MainMenu()));
                if (getModel().isSelectedExit()) game.setState(null);
            }
        }
    }
}

