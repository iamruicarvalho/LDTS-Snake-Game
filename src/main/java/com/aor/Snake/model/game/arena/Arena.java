package com.aor.Snake.model.game.arena;

import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.Fruit.Apple;
import com.aor.Snake.model.game.Fruit.Banana;
import com.aor.Snake.model.game.Fruit.Fruit;
import com.aor.Snake.model.game.Fruit.FruitFactory;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.model.game.elements.Wall;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private List<SnakeBody> Snake;
    private List<Wall> walls;
    private Fruit fruit;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<SnakeBody> getSnake() {return Snake;}

    public void setSnake(List<SnakeBody> snake) {this.Snake = snake;}

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Fruit getFruit() {
        return this.fruit;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for (SnakeBody body: Snake)
            if (body.getPosition().equals(position))
                return false;
        return true;
    }
    public boolean isFruit(Position position) {
        Fruit new_fruit = null;
        if (position.equals(fruit.getPosition())) {
            int max = 27;
            int min = 2;
            while (new_fruit == null || !isEmpty(new_fruit.getPosition()) || fruit.getPosition() == new_fruit.getPosition()) {
                int randPosX = (int) Math.floor(Math.random() * (max - min + 1) + min);
                int randPosY = (int) Math.floor(Math.random() * (max - min + 1) + min);
                int randFruit = (int) Math.floor(Math.random() * (2 - 1 + 1) + 1);

                Position pos = new Position(randPosX, randPosY);
                String randomFruit = "";
                if (randFruit == 1) {randomFruit = "Apple";}
                else if (randFruit == 2) {randomFruit = "Banana";}
                new_fruit = FruitFactory.createFruit(randomFruit, pos);
            }
            setFruit(new_fruit);
            return true;
        }
        return false;
    }
}
