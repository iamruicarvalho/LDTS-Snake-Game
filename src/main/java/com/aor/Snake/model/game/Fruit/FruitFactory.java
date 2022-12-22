package com.aor.Snake.model.game.Fruit;

import com.aor.Snake.model.Position;

public class FruitFactory {
    public static Fruit createFruit(String fruitType, Position position) {
        return switch (fruitType) {
            case "Apple" -> new Apple(position);
            case "Banana" -> new Banana(position);
            case "Cherry" -> new Cherry(position);
            default -> null;
        };

    }
}
