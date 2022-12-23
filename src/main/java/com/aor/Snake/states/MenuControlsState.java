package com.aor.Snake.states;

import com.aor.Snake.Controller.Controller;
import com.aor.Snake.Controller.menu.MenuControlsController;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.model.menu.MenuControls;
import com.aor.Snake.viewer.menu.MenuControlsViewer;

public class MenuControlsState extends State<MenuControls> {
    public MenuControlsState(MenuControls menuControls) {
        super(menuControls);
    }
    @Override
    protected Viewer<MenuControls> getViewer() {
        return new MenuControlsViewer(getModel());
    }
    @Override
    protected Controller<MenuControls> getController() {
        return new MenuControlsController(getModel());
    }
}
