package com.aor.Snake.model.game.arena;

import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.elements.Apple;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.model.game.elements.Wall;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private List<SnakeBody> Snake;
    private List<Wall> walls;
    private Apple apple;

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

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public Apple getApple() {
        return this.apple;
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
    public boolean isApple(Position position) {
        Apple apple_aux = null;
        if (position.equals(apple.getPosition())) {
            int max = 27;
            int min = 2;
            while (apple_aux == null || !isEmpty(apple_aux.getPosition()) || apple.getPosition() == apple_aux.getPosition()) {
                int randPosX = (int) Math.floor(Math.random() * (max - min + 1) + min);
                int randPosY = (int) Math.floor(Math.random() * (max - min + 1) + min);
                apple_aux = new Apple(randPosX, randPosY);
            }
            setApple(apple_aux);
            return true;
        }
        return false;
    }
}
