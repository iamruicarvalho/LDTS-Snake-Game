package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.MenuControls;
import com.aor.Snake.viewer.Viewer;

public class MenuControlsViewer extends Viewer<MenuControls> {
    public MenuControlsViewer (MenuControls menuControls) {
        super(menuControls);
    }

    @Override
    public void drawElements(GUI gui) {
        gui.drawText(new Position(9, 10), "CONTROLS", "#21F20A", "#000000");
        gui.drawText(new Position(1, 12), "RightKey - DIRECTION TO RIGHT", "#21F20A", "#000000");
        gui.drawText(new Position(1, 13), "LeftKey - DIRECTION TO LEFT", "#21F20A", "#000000");
        gui.drawText(new Position(1, 14), "UpKey - DIRECTION TO UP", "#21F20A", "#000000");
        gui.drawText(new Position(1, 15), "DownKey - DIRECTION TO DOWN", "#21F20A", "#000000");



        for (int i = 0; i < getModel().getNumberEntries(); i++)
            gui.drawText(
                    new Position(6 + (i*10), 25),
                    getModel().getEntry(i),
                    getModel().isSelected(i) ? "#EA0D0D" : "#21F20A", "#000000");
    }
}
