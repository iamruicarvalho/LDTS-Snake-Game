package com.aor.Snake.viewer.game;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.elements.SnakeBody;

public class SnakeViewer implements ElementViewer<SnakeBody> {
    @Override
    public void draw(SnakeBody snakeBody, GUI gui) {
        gui.drawSnakeBody(snakeBody.getPosition());
    }
}
