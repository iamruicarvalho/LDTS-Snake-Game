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

    public Apple getApple() {return apple;}

    public void setApple(Apple apple) {this.apple = apple;}

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        for (SnakeBody body: Snake)
            if (body.getPosition().equals(position))
                return false;
        return true;
    }

}
