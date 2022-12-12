package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.ScoreBoardMenu;
import com.aor.Snake.viewer.Viewer;

import java.io.IOException;

public class ScoreBoardMenuViewer extends Viewer<ScoreBoardMenu> {

    public ScoreBoardMenuViewer(ScoreBoardMenu ScoreBoarMenu) {
        super(ScoreBoarMenu);
    }

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawText(new Position(8, 10), "SCOREBOARD", "#21F20A", "#000000");
        gui.drawText(new Position(6, 11), "BEST SCORE: " + getModel().gethightScore(), "#FFD700", "#000000");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 13 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#EA0D0D" : "#21F20A", "#000000");
    }
}
