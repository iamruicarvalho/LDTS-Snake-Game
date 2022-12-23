package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.model.menu.DifficultyMenu;

import java.io.IOException;

public class DifficultyMenuViewer extends Viewer<DifficultyMenu> {
    public DifficultyMenuViewer(DifficultyMenu model) {super(model);}

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.changeBackgroundColor("#000000", "#000000");
        gui.drawText(new Position(7, 10), "@ DIFFICULTY @", "#D97F02", "#000000");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(11, 13 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#D97F02" : "#FFFFFF", "#000000");
    }

}

