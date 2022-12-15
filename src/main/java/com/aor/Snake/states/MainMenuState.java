package com.aor.Snake.states;

import com.aor.Snake.Controller.Controller;
import com.aor.Snake.Controller.menu.MainMenuController;
import com.aor.Snake.model.menu.MainMenu;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.viewer.menu.MainMenuViewer;

public class MainMenuState extends State<MainMenu> {
    public MainMenuState(MainMenu model) {
        super(model);
    }
    @Override
    protected Viewer<MainMenu> getViewer() {
        return new MainMenuViewer(getModel());
    }
    @Override
    protected Controller<MainMenu> getController() {
        return new MainMenuController(getModel());
    }
}
