package com.aor.Snake.Controller;

import com.aor.Snake.Game;
import com.aor.Snake.controller.game.SnakeController;
import com.aor.Snake.controller.menu.MainMenuController;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.model.game.elements.Wall;
import com.aor.Snake.model.menu.mainMenu;
import com.aor.Snake.states.GameState;
import com.aor.Snake.states.MainMenuState;
import com.sun.tools.javac.Main;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnakeControllerTest {
    private SnakeController snakeController;
    private Arena arena;
    private Game game;


    @BeforeEach
    void setup() {
        arena = new Arena(29, 29);

        arena.setWalls(Arrays.asList());

        snakeController = new SnakeController(arena);
        game = Mockito.mock(Game.class);

    }

    @Test
    void SnakeMovement() throws IOException, URISyntaxException, FontFormatException {
        List<SnakeBody> snake = new ArrayList<>();
        snake.add(new SnakeBody(10, 10));
        snake.add(new SnakeBody(10, 11));
        arena.setSnake(snake);

        snakeController.DirectionLeft();
        snakeController.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(9, 10), arena.getSnake().get(0).getPosition());
        assertEquals(new Position(10, 10), arena.getSnake().get(1).getPosition());

        snakeController.DirectionDown();
        snakeController.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(9, 11), arena.getSnake().get(0).getPosition());
        assertEquals(new Position(9, 10), arena.getSnake().get(1).getPosition());

        snakeController.DirectionRight();
        snakeController.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(10, 11), arena.getSnake().get(0).getPosition());
        assertEquals(new Position(9, 11), arena.getSnake().get(1).getPosition());

        snakeController.DirectionUp();
        snakeController.step(game, GUI.ACTION.NONE, 1000);

        assertEquals(new Position(10, 10), arena.getSnake().get(0).getPosition());
        assertEquals(new Position(10, 11), arena.getSnake().get(1).getPosition());

    }

    @Test
    void HitWall() throws IOException, URISyntaxException, FontFormatException {
        List<SnakeBody> snake = new ArrayList<>();
        snake.add(new SnakeBody(10, 10));
        snake.add(new SnakeBody(10, 11));
        arena.setSnake(snake);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(10, 9));
        arena.setWalls(walls);

        snakeController.DirectionUp();
        snakeController.step(game, GUI.ACTION.NONE, 1000);


        assertEquals(true, snakeController.getLost());

    }
}
