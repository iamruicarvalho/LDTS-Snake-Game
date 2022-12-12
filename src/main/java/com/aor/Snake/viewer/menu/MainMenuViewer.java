package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.MainMenu;
import com.aor.Snake.viewer.Viewer;

import java.io.IOException;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu mainMenu) {
        super(mainMenu);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.changeBackgroundColor("#000000", "#000000");
        gui.drawText(new Position(7, 10), "@ SNAKE GAME @", "#D97F02", "#000000");

        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(10, 13 + i),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#D97F02" : "#FFFFFF", "#000000");
    }
}
