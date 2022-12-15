package com.aor.Snake.states;

import com.aor.Snake.Controller.Controller;
import com.aor.Snake.Controller.menu.GameOverMenuController;
import com.aor.Snake.model.menu.GameOverMenu;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.viewer.menu.GameOverMenuViewer;

public class GameOverMenuState extends State<GameOverMenu> {
    public GameOverMenuState(GameOverMenu model) {
        super(model);
    }
    @Override
    protected Viewer<GameOverMenu> getViewer() {return new GameOverMenuViewer(getModel());}

    @Override
    protected Controller<GameOverMenu> getController() {
        return new GameOverMenuController(getModel());
    }
}

