package com.aor.Snake.states;

import com.aor.Snake.controller.Controller;
import com.aor.Snake.controller.menu.DificultyMenuController;
import com.aor.Snake.model.menu.DificultyMenu;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.viewer.menu.DificultyMenuViewer;
import com.aor.Snake.viewer.menu.GameOverMenuViewer;

public class DificultyMenuState extends State<DificultyMenu> {

    public DificultyMenuState(DificultyMenu model) {super(model);}

    @Override
    protected Viewer<DificultyMenu> getViewer() {
        return new DificultyMenuViewer(getModel());
    }

    @Override
    protected Controller<DificultyMenu> getController() {
        return new DificultyMenuController(getModel());
    }
}
