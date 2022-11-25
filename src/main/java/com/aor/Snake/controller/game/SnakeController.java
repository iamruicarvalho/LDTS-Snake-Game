package com.aor.Snake.controller.game;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.elements.Element;
import com.aor.Snake.model.game.elements.SnakeBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakeController extends GameController {

    private String Direction = "Left";
    public SnakeController(Arena arena) {
        super(arena);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        //Moving in one direction
        if (Direction.equals("Up")) moveUp();
        if (Direction.equals("Down")) moveDown();
        if (Direction.equals("Right")) moveRight();
        if (Direction.equals("Left")) moveLeft();

        //Change direction
        if (action == GUI.ACTION.UP) DirectionUp();
        if (action == GUI.ACTION.RIGHT) DirectionRight();
        if (action == GUI.ACTION.DOWN) DirectionDown();
        if (action == GUI.ACTION.LEFT) DirectionLeft();
    }

    public void DirectionLeft() {
        if (!Direction.equals("Right")) Direction = "Left";
    }

    public void DirectionDown() {
        if (!Direction.equals("Up")) Direction = "Down";
    }

    public void DirectionRight() {
        if (!Direction.equals("Left")) Direction = "Right";
    }

    public void DirectionUp() {
        if (!Direction.equals("Down")) Direction = "Up";
    }

    public void moveLeft() {
        List<SnakeBody> new_snake = new ArrayList<>();
        //Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX() - 1, getModel().getSnake().get(0).getPosition().getY());
        new_snake.add(head);
        //Body
        for (int i = 0; i < getModel().getSnake().size()-1; i++) {
            new_snake.add(getModel().getSnake().get(i));
        }
        getModel().setSnake(new_snake);
    }

    public void moveRight() {
        List<SnakeBody> new_snake = new ArrayList<>();
        //Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX() + 1, getModel().getSnake().get(0).getPosition().getY());
        new_snake.add(head);
        //Body
        for (int i = 0; i < getModel().getSnake().size()-1; i++) {
            new_snake.add(getModel().getSnake().get(i));
        }
        getModel().setSnake(new_snake);
    }

    public void moveUp() {
        List<SnakeBody> new_snake = new ArrayList<SnakeBody>();
        //Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX(), getModel().getSnake().get(0).getPosition().getY() - 1);
        new_snake.add(head);
        //Body
        for (int i = 0; i < getModel().getSnake().size()-1; i++) {
            new_snake.add(getModel().getSnake().get(i));
        }
        getModel().setSnake(new_snake);
    }

    public void moveDown() {
        List<SnakeBody> new_snake = new ArrayList<>();
        //Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX(), getModel().getSnake().get(0).getPosition().getY() + 1);
        new_snake.add(head);
        //Body
        for (int i = 0; i < getModel().getSnake().size()-1; i++) {
            new_snake.add(getModel().getSnake().get(i));
        }
        getModel().setSnake(new_snake);
    }

}
