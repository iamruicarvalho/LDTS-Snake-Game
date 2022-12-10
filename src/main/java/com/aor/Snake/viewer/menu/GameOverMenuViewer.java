package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.GameOverMenu;
import com.aor.Snake.viewer.Viewer;

public class GameOverMenuViewer extends Viewer<GameOverMenu> {
    public GameOverMenuViewer(GameOverMenu model) {super(model);}

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(10, 10), "GAME OVER", "#000000", "#21F20A");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 13 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#EA0D0D" : "#000000", "#21F20A");
    }
}

