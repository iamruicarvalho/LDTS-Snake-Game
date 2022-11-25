package com.aor.Snake.states;

import com.aor.Snake.controller.Controller;
import com.aor.Snake.controller.menu.MenuController;
import com.aor.Snake.model.menu.Menu;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.viewer.menu.MenuViewer;

public class MenuState extends State<Menu> {
    public MenuState(Menu model) {
        super(model);
    }

    @Override
    protected Viewer<Menu> getViewer() {
        return new MenuViewer(getModel());
    }

    @Override
    protected Controller<Menu> getController() {
        return new MenuController(getModel());
    }
}
