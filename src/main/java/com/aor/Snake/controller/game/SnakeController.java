package com.aor.Snake.controller.game;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.model.menu.mainMenu;
import com.aor.Snake.states.MainMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class SnakeController extends GameController {

    private String Direction = "Left";
    private boolean Lost = false;
    public SnakeController(Arena arena) {
        super(arena);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
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
        if (action == GUI.ACTION.QUIT) game.setState(new MainMenuState(new mainMenu()));
        if (Lost) game.setState(new MainMenuState(new mainMenu()));

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

    public void moveLeft() throws IOException, URISyntaxException, FontFormatException {
        //New Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX() - 1, getModel().getSnake().get(0).getPosition().getY());
        moveBody(head);
    }

    public void moveRight() throws IOException, URISyntaxException, FontFormatException {
        //New Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX() + 1, getModel().getSnake().get(0).getPosition().getY());
        moveBody(head);
    }

    public void moveUp() throws IOException, URISyntaxException, FontFormatException {
        //New Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX(), getModel().getSnake().get(0).getPosition().getY() - 1);
        moveBody(head);
    }

    public void moveDown() throws IOException, URISyntaxException, FontFormatException {
        //New Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX(), getModel().getSnake().get(0).getPosition().getY() + 1);
        moveBody(head);
    }

    private void moveBody(SnakeBody head) throws URISyntaxException, FontFormatException {
        List<SnakeBody> new_snake = new ArrayList<>();
        if (getModel().isEmpty(head.getPosition())) {
            new_snake.add(head);
            //New Body
            for (int i = 0; i < getModel().getSnake().size() - 1; i++) {
                new_snake.add(getModel().getSnake().get(i));
            }
            getModel().setSnake(new_snake);
        }
        else {
            Lost = true;
        }
    }
}
