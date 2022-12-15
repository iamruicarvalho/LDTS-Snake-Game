package com.aor.Snake.states;

import com.aor.Snake.Controller.Controller;
import com.aor.Snake.Controller.menu.DificultyMenuController;
import com.aor.Snake.model.menu.DificultyMenu;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.viewer.menu.DificultyMenuViewer;

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
