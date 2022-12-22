package com.aor.Snake.viewer.game.Fruit;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.Fruit.Fruit;

public interface FruitViewer <T extends Fruit> {
    void draw(T fruit, GUI gui);
}
