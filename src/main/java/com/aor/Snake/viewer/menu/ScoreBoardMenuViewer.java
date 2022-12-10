package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.ScoreBoardMenu;
import com.aor.Snake.model.menu.mainMenu;
import com.aor.Snake.viewer.Viewer;

public class ScoreBoardMenuViewer extends Viewer<ScoreBoardMenu> {

    public ScoreBoardMenuViewer(ScoreBoardMenu ScoreBoarMenu) {
        super(ScoreBoarMenu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(8, 10), "SCOREBOARD", "#000000", "#21F20A");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 13 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#EA0D0D" : "#000000", "#21F20A");
    }
}
