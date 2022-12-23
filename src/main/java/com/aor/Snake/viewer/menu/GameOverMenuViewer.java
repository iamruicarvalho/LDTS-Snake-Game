package com.aor.Snake.viewer.menu;

import com.aor.Snake.ScoreBoard.SingletonScoreboard;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.GameOverMenu;
import com.aor.Snake.viewer.Viewer;

import java.io.IOException;

public class GameOverMenuViewer extends Viewer<GameOverMenu> {
    public GameOverMenuViewer(GameOverMenu model) {super(model);}

    @Override
    protected void drawElements(GUI gui) throws IOException {
        SingletonScoreboard scoreboard = SingletonScoreboard.getInstance();
        int score = scoreboard.getLastScore();

        gui.changeBackgroundColor("#000000", "#000000");
        gui.drawText(new Position(7, 10), "@ GAME OVER @", "#FF0000", "#000000");
        gui.drawText(new Position(10, 11), "SCORE:" + score, "#FFF300", "#000000");
        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 13 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#D97F02" : "#FFFFFF", "#000000");
    }
}

