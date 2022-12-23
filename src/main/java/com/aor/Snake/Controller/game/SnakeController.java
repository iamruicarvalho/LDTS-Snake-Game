package com.aor.Snake.Controller.game;

import com.aor.Snake.Game;
import com.aor.Snake.ScoreBoard.SingletonScoreboard;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.elements.SnakeBody;

import com.aor.Snake.model.menu.GameOverMenu;
import com.aor.Snake.states.GameOverMenuState;

import java.awt.*;
import java.net.URISyntaxException;

import java.io.IOException;

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
        if (action == GUI.ACTION.QUIT) game.setState(null);

        if (Lost) {
            SingletonScoreboard instance = SingletonScoreboard.getInstance();
            int score = getModel().getScore();  //Score obtained during gameplay
            instance.UpdateHighScore(score);    //Updates if better than the one before

            GameOverMenu gameOverMenu = new GameOverMenu();
            instance.setLastScore(score);
            game.setState(new GameOverMenuState(gameOverMenu));
        }

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
        //New Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX() - 1,
                getModel().getSnake().get(0).getPosition().getY());
        moveBody(head);
    }

    public void moveRight() {
        //New Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX() + 1,
                getModel().getSnake().get(0).getPosition().getY());
        moveBody(head);
    }

    public void moveUp() {
        //New Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX(),
                getModel().getSnake().get(0).getPosition().getY() - 1);
        moveBody(head);
    }

    public void moveDown() {
        //New Head
        SnakeBody head = new SnakeBody(getModel().getSnake().get(0).getPosition().getX(),
                getModel().getSnake().get(0).getPosition().getY() + 1);
        moveBody(head);
    }

    private void moveBody(SnakeBody head) {
        List<SnakeBody> new_snake = new ArrayList<>();

        if (getModel().isFruit(head.getPosition())) {
            new_snake.add(head);
            new_snake.addAll(getModel().getSnake());
            getModel().setSnake(new_snake);
        }
        else if (getModel().isEmpty(head.getPosition())) {
            new_snake.add(head);
            for (int i = 0; i < getModel().getSnake().size() - 1; i++) {
                new_snake.add(getModel().getSnake().get(i));
            }
            getModel().setSnake(new_snake);
        }
        else {
            Lost = true;
        }
    }

    public boolean getLost() {
        return this.Lost;
    }

}
