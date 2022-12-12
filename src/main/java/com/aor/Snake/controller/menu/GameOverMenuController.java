package com.aor.Snake.controller.menu;


import com.aor.Snake.Game;
import com.aor.Snake.controller.Controller;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.arena.LoaderArenaBuilder;
import com.aor.Snake.model.menu.GameOverMenu;
import com.aor.Snake.model.menu.MainMenu;
import com.aor.Snake.states.GameState;
import com.aor.Snake.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class GameOverMenuController extends Controller<GameOverMenu> {

    public GameOverMenuController(GameOverMenu model) {super(model);}

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedMenu()) game.setState(new MainMenuState(new MainMenu()));
                if (getModel().isSelectedRestart()) game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
        }
    }
}
