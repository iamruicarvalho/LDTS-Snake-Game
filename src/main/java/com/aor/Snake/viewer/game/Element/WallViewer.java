package com.aor.Snake.viewer.game.Element;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.elements.Wall;

public class WallViewer implements ElementViewer<Wall> {
    @Override
    public void draw(Wall wall, GUI gui) {
        gui.drawWall(wall.getPosition());
    }
}
