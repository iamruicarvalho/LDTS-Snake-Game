package com.aor.Snake.model.game;

import com.aor.Snake.Game;
import com.aor.Snake.Controller.game.SnakeController;
import com.aor.Snake.ScoreBoard.SingletonScoreboard;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.Fruit.Banana;
import com.aor.Snake.model.game.Fruit.Cherry;
import com.aor.Snake.model.game.Fruit.FruitFactory;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.Fruit.Apple;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.model.game.elements.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

public class ArenaModelTest {
    private Arena arena;
    private Game game;
    private SnakeController snakeController;
    private Apple apple;
    private Banana banana;
    private Cherry cherry;

    @BeforeEach
    void setup(){
        arena = new Arena(29,29);

        List<SnakeBody> snake = new ArrayList<>();
        snake.add(new SnakeBody(10, 10));
        snake.add(new SnakeBody(10, 11));
        arena.setSnake(snake);

        List<Wall> walls = new ArrayList<>();
        walls.add(new Wall(28,28));
        arena.setWalls(walls);


        snakeController = new SnakeController(arena);
        game = Mockito.mock(Game.class);
    }


    @Test
    void isAppleWorking(){
        apple = (Apple) FruitFactory.createFruit("Apple", new Position(9, 10));
        arena.setFruit(apple);
        assertEquals(true, arena.isFruit(arena.getFruit().getPosition()));
    }

    @Test
    void isEmptyWorking(){
        //Walls
        assertEquals(false, arena.isEmpty(arena.getWalls().get(0).getPosition()));

        //SnakeBody
        assertEquals(false, arena.isEmpty(arena.getSnake().get(0).getPosition()));

        //EmptySpace
        assertEquals(true, arena.isEmpty(new Position(15, 15)));
    }

    @Test
    void scoreTest(){
        assertEquals(0, arena.getScore());
        arena.IncrementScore(2);
        assertEquals(2, arena.getScore());

        arena.MultiplyScore(2);
        assertNotEquals(4, arena.getScore());
        assertEquals(7, arena.getScore());

        arena.MultiplyScore(3);
        assertEquals(21, arena.getScore());
    }

    @Test
    void moveFruitTest(){
        apple = (Apple) FruitFactory.createFruit("Apple", new Position(9, 10));
        arena.setFruit(apple);

        assertEquals(0, arena.getScore());
        arena.moveFruit();
        assertEquals(1, arena.getScore());

        banana = (Banana) FruitFactory.createFruit("Banana", new Position(20, 10));
        arena.setFruit(banana);

        assertEquals(1, arena.getScore());
        arena.moveFruit();
        assertEquals(3, arena.getScore());

        cherry = (Cherry) FruitFactory.createFruit("Cherry", new Position(21, 10));
        arena.setFruit(cherry);
        arena.IncrementScore(3);
        arena.moveFruit();
        assertEquals(9, arena.getScore());
    }
}
