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
        gui.drawText(new Position(7, 10), "@ SCOREBOARD @", "#000CFF", "#000000");
        gui.drawText(new Position(6, 12), "BEST SCORE: " + getModel().getHighScore(), "#FFD700", "#000000");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(6 + (i*10), 15),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#D97F02" : "#FFFFFF", "#000000");
    }
}
