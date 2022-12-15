package com.aor.Snake.Controller.menu;

import com.aor.Snake.Game;
import com.aor.Snake.Controller.Controller;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.menu.ScoreBoardMenu;
import com.aor.Snake.model.menu.MainMenu;
import com.aor.Snake.states.MainMenuState;

import java.io.IOException;

public class ScoreBoardMenuController extends Controller<ScoreBoardMenu> {

    public ScoreBoardMenuController(ScoreBoardMenu scoreBoardMenu) {
        super(scoreBoardMenu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case LEFT:
                getModel().previousEntry();
                break;
            case RIGHT:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedBack()) game.setState(new MainMenuState(new MainMenu()));
        }
    }
}
