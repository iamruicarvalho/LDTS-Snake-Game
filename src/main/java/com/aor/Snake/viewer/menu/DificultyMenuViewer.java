package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.DificultyMenu;
import com.aor.Snake.viewer.Viewer;

import java.io.IOException;

public class DificultyMenuViewer extends Viewer<DificultyMenu> {
    public DificultyMenuViewer(DificultyMenu model) {super(model);}

    @Override
    protected void drawElements(GUI gui) throws IOException {
        gui.drawText(new Position(10, 10), "DIFFICULTY", "#EE4B2B", "#000000");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 13 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#EA0D0D" : "#21F20A", "#000000");
    }
}

