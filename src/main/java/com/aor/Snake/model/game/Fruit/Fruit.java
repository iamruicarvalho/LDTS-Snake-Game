package com.aor.Snake.model.game.Fruit;

import com.aor.Snake.model.Position;

public abstract class Fruit {
    private final Position position;

    public Fruit(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }
}
