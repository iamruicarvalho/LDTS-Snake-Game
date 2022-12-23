package com.aor.Snake.states;

import com.aor.Snake.Controller.Controller;
import com.aor.Snake.Controller.menu.DifficultyMenuController;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.model.menu.DifficultyMenu;
import com.aor.Snake.viewer.menu.DifficultyMenuViewer;

public class DificultyMenuState extends State<DifficultyMenu> {

    public DificultyMenuState(DifficultyMenu model) {super(model);}

    @Override
    protected Viewer<DifficultyMenu> getViewer() {
        return new DifficultyMenuViewer(getModel());
    }

    @Override
    protected Controller<DifficultyMenu> getController() {
        return new DifficultyMenuController(getModel());
    }
}
