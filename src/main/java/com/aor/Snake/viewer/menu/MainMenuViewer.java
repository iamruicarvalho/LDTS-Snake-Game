package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.mainMenu;
import com.aor.Snake.viewer.Viewer;

public class MainMenuViewer extends Viewer<mainMenu> {
    public MainMenuViewer(mainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(10, 10), "SNAKE GAME @", "#000000", "#21F20A");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 13 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#EA0D0D" : "#000000", "#21F20A");
    }
}
