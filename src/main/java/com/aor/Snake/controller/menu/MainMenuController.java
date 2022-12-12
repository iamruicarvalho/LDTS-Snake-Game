package com.aor.Snake.controller.menu;

import com.aor.Snake.Game;
import com.aor.Snake.controller.Controller;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.arena.LoaderArenaBuilder;
import com.aor.Snake.model.menu.DificultyMenu;
import com.aor.Snake.model.menu.MenuControls;
import com.aor.Snake.model.menu.ScoreBoardMenu;
import com.aor.Snake.model.menu.MainMenu;
import com.aor.Snake.states.DificultyMenuState;
import com.aor.Snake.states.GameState;
import com.aor.Snake.states.MenuControlsState;
import com.aor.Snake.states.ScoreBoardMenuState;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedControls()) game.setState(new MenuControlsState(new MenuControls()));
                if (getModel().isSelectedScoreBoard()) game.setState(new ScoreBoardMenuState(new ScoreBoardMenu()));
                if (getModel().isSelectedStart()) game.setState(new DificultyMenuState(new DificultyMenu()));
        }
    }
}
