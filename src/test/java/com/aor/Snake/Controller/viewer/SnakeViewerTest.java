package com.aor.Snake.Controller.viewer;

import com.aor.Snake.Game;
import com.aor.Snake.controller.game.SnakeController;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.viewer.game.SnakeViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakeViewerTest {
    private List<SnakeBody> snake;
    private SnakeViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp(){
        viewer = new SnakeViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawSnake(){
        snake = new ArrayList<>();
        snake.add(new SnakeBody(10, 10));
        snake.add(new SnakeBody(10, 11));
        viewer.draw(snake.get(0), gui);
        viewer.draw(snake.get(1), gui);
        Mockito.verify(gui, Mockito.times(1)).drawSnakeBody((snake.get(0).getPosition()));
        Mockito.verify(gui, Mockito.times(1)).drawSnakeBody((snake.get(1).getPosition()));
    };
}
