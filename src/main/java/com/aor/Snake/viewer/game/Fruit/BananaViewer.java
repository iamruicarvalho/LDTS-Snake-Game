package com.aor.Snake.viewer.game.Fruit;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.Fruit.Apple;
import com.aor.Snake.model.game.Fruit.Banana;

public class BananaViewer implements FruitViewer<Banana> {

    @Override
    public void draw(Banana banana, GUI gui) {
        gui.drawBanana(banana.getPosition());
    }
}
