package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.MenuControls;
import com.aor.Snake.viewer.Viewer;

import java.io.IOException;

public class MenuControlsViewer extends Viewer<MenuControls> {
    public MenuControlsViewer (MenuControls menuControls) {
        super(menuControls);
    }

    @Override
    public void drawElements(GUI gui) throws IOException {
        gui.changeBackgroundColor("#000000", "#000000");
        gui.drawText(new Position(9, 10), "CONTROLS", "#D97F02", "#000000");
        gui.drawText(new Position(6, 12), "> - SNAKE RIGHT", "#FFFFFF", "#000000");
        gui.drawText(new Position(6, 13), "< - SNAKE LEFT", "#FFFFFF", "#000000");
        gui.drawText(new Position(6, 14), "^ - SNAKE UP", "#FFFFFF", "#000000");
        gui.drawText(new Position(6, 15), "; - SNAKE DOWN", "#FFFFFF", "#000000");
        gui.drawText(new Position(6, 16), "Q - QUIT", "#FFFFFF", "#000000");
        gui.drawText(new Position(6, 17), "' - SELECT", "#FFFFFF", "#000000");


        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(6 + (i*10), 25),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#D97F02" : "#FFFFFF", "#000000");
    }
}
