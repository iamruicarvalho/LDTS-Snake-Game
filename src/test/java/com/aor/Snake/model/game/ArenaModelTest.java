package com.aor.Snake.model.game;

import com.aor.Snake.Game;
import com.aor.Snake.Controller.game.SnakeController;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.elements.Apple;
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

    @BeforeEach
    void setup(){
        arena = new Arena(29,29);

        apple = new Apple(9, 10);
        arena.setApple(apple);

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
        assertEquals(true, arena.isApple(arena.getApple().getPosition()));
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
}
