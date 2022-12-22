package com.aor.Snake.viewer.game.Fruit;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.Fruit.Apple;

public class AppleViewer implements FruitViewer<Apple> {
    @Override
    public void draw(Apple apple, GUI gui) {
        gui.drawApple(apple.getPosition());
    }
}
