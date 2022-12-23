package com.aor.Snake.Controller.game;

import com.aor.Snake.Game;
import com.aor.Snake.ScoreBoard.SingletonScoreboard;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
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
    private SnakeBody SnakeHead;
    private String Direction = "Left";
    private boolean Lost = false;
    public SnakeController(Arena arena) {
        super(arena);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        SnakeHead = new SnakeBody(getModel().getSnake().get(0).getPosition().getX(),
                getModel().getSnake().get(0).getPosition().getY());
        //Change direction
        if (action == GUI.ACTION.UP) DirectionUp();
        if (action == GUI.ACTION.RIGHT) DirectionRight();
        if (action == GUI.ACTION.DOWN) DirectionDown();
        if (action == GUI.ACTION.LEFT) DirectionLeft();
        if (action == GUI.ACTION.QUIT) game.setState(null);

        //Moving in one direction
        if (Direction.equals("Up")) moveUp();
        if (Direction.equals("Down")) moveDown();
        if (Direction.equals("Right")) moveRight();
        if (Direction.equals("Left")) moveLeft();

        LosingCase(game);
    }

    private void LosingCase(Game game) {
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
        SnakeHead.decrementX();
        moveBody();
    }

    public void moveRight() {
        SnakeHead.incrementX();
        moveBody();
    }

    public void moveUp() {
        SnakeHead.decrementY();
        moveBody();
    }

    public void moveDown() {
        SnakeHead.incrementY();
        moveBody();
    }

    private void moveBody() {
        List<SnakeBody> new_snake = new ArrayList<>();

        if (getModel().isFruit(SnakeHead.getPosition())) {
            new_snake.add(SnakeHead);
            new_snake.addAll(getModel().getSnake());
            getModel().setSnake(new_snake);
        }
        else {
            checkCollision(new_snake);
        }
    }

    private void checkCollision(List<SnakeBody> new_snake) {
        if (getModel().isEmpty(SnakeHead.getPosition())) {
            new_snake.add(SnakeHead);
            new_snake.addAll(getModel().getSnake());
            new_snake.remove(new_snake.size()-1);
            getModel().setSnake(new_snake);
        }
        else {Lost = true;}
    }


    public boolean getLost() {
        return this.Lost;
    }

}
