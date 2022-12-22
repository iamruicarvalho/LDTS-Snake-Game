package com.aor.Snake.model.game.Fruit;

import com.aor.Snake.model.Position;

public class FruitFactory {
    public static Fruit createFruit(String fruitType, Position position) {
        if (fruitType.equals("Apple")) {
            return new Apple(position);

        } else if (fruitType.equals("Banana")) {
            return new Banana(position);
        }
        return null;
    }
}
