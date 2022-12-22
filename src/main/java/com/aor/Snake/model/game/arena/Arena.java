package com.aor.Snake.model.game.arena;

import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.Fruit.*;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.model.game.elements.Wall;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private List<SnakeBody> Snake;
    private List<Wall> walls;

    private Integer Score = 0;
    private Fruit fruit;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
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

    public void IncrementScore(int increment) {Score += increment;}
    public void MultiplyScore(double multiplier) {
        double aux = Score * multiplier;
        if (aux > Score) {Score = (int) Math.ceil(aux);}
        else {IncrementScore(5);}
    }


    public int getScore() {return Score;}

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
            if (fruit instanceof Apple) {IncrementScore(1);}
            else if (fruit instanceof Banana) {IncrementScore(2);}
            else if (fruit instanceof Cherry) {MultiplyScore(1.5);}
            int aux_score = Score;

            while (new_fruit == null || !isEmpty(new_fruit.getPosition()) || fruit.getPosition() == new_fruit.getPosition()) {
                Score = aux_score;
                int randPosX = (int) Math.floor(Math.random() * (max - min + 1) + min);
                int randPosY = (int) Math.floor(Math.random() * (max - min + 1) + min);

                Position pos = new Position(randPosX, randPosY);
                String randomFruit;
                int randFruit = (int) Math.floor(Math.random() * (100  + 1));
                if (randFruit <= 25) {randomFruit = "Banana";}
                else if (randFruit >= 95) {randomFruit = "Cherry";}
                else {randomFruit = "Apple";}
                new_fruit = FruitFactory.createFruit(randomFruit, pos);
            }
            setFruit(new_fruit);
            return true;
        }
        return false;
    }
}
