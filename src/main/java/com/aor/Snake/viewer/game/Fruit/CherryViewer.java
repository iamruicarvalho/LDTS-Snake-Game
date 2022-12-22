package com.aor.Snake.viewer.game.Fruit;


import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.Fruit.Cherry;

public class CherryViewer implements FruitViewer<Cherry> {

    @Override
    public void draw(Cherry cherry, GUI gui) {
        gui.drawCherry(cherry.getPosition());
    }
}
