package com.aor.Snake.states;

import com.aor.Snake.controller.Controller;
import com.aor.Snake.controller.menu.MainMenuController;
import com.aor.Snake.model.menu.ScoreBoardMenu;
import com.aor.Snake.model.menu.mainMenu;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.viewer.menu.MainMenuViewer;

public class MainMenuState extends State<mainMenu> {
    public MainMenuState(mainMenu model) {
        super(model);
    }
    @Override
    protected Viewer<mainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }
    @Override
    protected Controller<mainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
