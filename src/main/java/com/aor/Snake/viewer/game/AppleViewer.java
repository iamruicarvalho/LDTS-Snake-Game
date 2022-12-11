package com.aor.Snake.viewer.game;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.elements.Apple;

public class AppleViewer implements ElementViewer<Apple> {
    @Override
    public void draw(Apple apple, GUI gui) {
        gui.drawApple(apple.getPosition());
    }
}
