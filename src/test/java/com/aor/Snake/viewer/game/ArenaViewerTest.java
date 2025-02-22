package com.aor.Snake.viewer.game;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.Fruit.FruitFactory;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.Fruit.Apple;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.model.game.elements.Wall;
import com.aor.Snake.viewer.game.Element.GameViewer;
import com.aor.Snake.viewer.game.Element.SnakeViewer;
import com.aor.Snake.viewer.game.Fruit.AppleViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArenaViewerTest {
    private GUI gui;
    private List<SnakeBody> snake;
    private GameViewer viewer;
    private SnakeViewer snakeViewer;
    private AppleViewer appleViewer;
    private Arena arena;
    private Apple apple;

    @BeforeEach
    void setup(){
        arena = new Arena(29,29);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);
        snakeViewer = new SnakeViewer();
        apple = Mockito.mock(Apple.class);
        appleViewer = Mockito.mock(AppleViewer.class);
        arena.setWalls(Arrays.asList(new Wall(1,2), new Wall(2,3), new Wall(3,4)));
        arena.setSnake( new ArrayList<>());
        snake = new ArrayList<>();
        snake.add(new SnakeBody(10, 10));
        snake.add(new SnakeBody(10, 11));
    }

    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void drawApple() throws IOException {
        apple = new Apple(new Position(10, 10));
        arena.setFruit(apple);
        viewer.draw(gui);
        appleViewer.draw(apple, gui);
        Mockito.verify(gui, Mockito.times(1)).drawApple(apple.getPosition());
    }

    @Test
    void drawSnake() throws IOException {
        viewer.draw(gui);
        snakeViewer.draw(snake.get(0), gui);
        snakeViewer.draw(snake.get(1), gui);

        Mockito.verify(gui, Mockito.times(1)).drawSnakeBody(snake.get(0).getPosition());
        Mockito.verify(gui, Mockito.times(1)).drawSnakeBody(snake.get(1).getPosition());
        Mockito.verify(gui, Mockito.times(2)).drawSnakeBody(Mockito.any(Position.class));
    }


    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }

}
