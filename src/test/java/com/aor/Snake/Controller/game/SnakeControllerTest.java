package com.aor.Snake.Controller.game;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.Fruit.FruitFactory;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.Fruit.Apple;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.model.game.elements.Wall;
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
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SnakeControllerTest {
    private SnakeController snakeController;
    private Arena arena;
    private Game game;

    private Apple apple;


    @BeforeEach
    void setup() {
        arena = new Arena(29, 29);

        apple = (Apple) FruitFactory.createFruit("Apple", new Position(9, 10));
        arena.setFruit(apple);

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
    @Test
    void HitBody() throws IOException, URISyntaxException, FontFormatException {
        List<SnakeBody> snake = new ArrayList<>();
        snake.add(new SnakeBody(12, 10));
        snake.add(new SnakeBody(11, 10));
        snake.add(new SnakeBody(10, 10));
        snake.add(new SnakeBody(10, 11));
        snake.add(new SnakeBody(10, 12));
        arena.setSnake(snake);

        snakeController.DirectionDown();
        snakeController.step(game, GUI.ACTION.NONE, 1000);

        snakeController.DirectionLeft();
        snakeController.step(game, GUI.ACTION.NONE, 1000);

        snakeController.DirectionUp();
        snakeController.step(game, GUI.ACTION.NONE, 1000);

        assertEquals( true, snakeController.getLost());
    }
    @Test
    void checkEatApple() throws IOException, URISyntaxException, FontFormatException {

        List<SnakeBody> snake = new ArrayList<>();
        snake.add(new SnakeBody(10, 10));
        snake.add(new SnakeBody(10, 11));
        arena.setSnake(snake);

        snakeController.DirectionLeft();
        snakeController.step(game, GUI.ACTION.NONE, 1000);


        assertEquals(3, arena.getSnake().size());
    }
    @Test
    void checkAppleMove() throws IOException, URISyntaxException, FontFormatException {
        List<SnakeBody> snake = new ArrayList<>();
        snake.add(new SnakeBody(10, 10));
        snake.add(new SnakeBody(10, 11));
        arena.setSnake(snake);

        snakeController.DirectionLeft();
        snakeController.step(game, GUI.ACTION.NONE, 1000);

        assertNotEquals(true, arena.isFruit(apple.getPosition()));
        assertNotEquals(true, arena.isFruit(arena.getSnake().get(0).getPosition()));
    }
}
