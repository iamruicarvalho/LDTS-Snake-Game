package com.aor.Snake.states;

import com.aor.Snake.Controller.Controller;
import com.aor.Snake.Controller.menu.ScoreBoardMenuController;
import com.aor.Snake.model.menu.ScoreBoardMenu;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.viewer.menu.ScoreBoardMenuViewer;

public class ScoreBoardMenuState extends State<ScoreBoardMenu> {

    public ScoreBoardMenuState(ScoreBoardMenu model) {
        super(model);
    }
    @Override
    protected Viewer<ScoreBoardMenu> getViewer() {
        return new ScoreBoardMenuViewer(getModel());
    }
    @Override
    protected Controller<ScoreBoardMenu> getController() {
        return new ScoreBoardMenuController(getModel());
    }
}
