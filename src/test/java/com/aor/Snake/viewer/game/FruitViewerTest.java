package com.aor.Snake.viewer.game;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.gui.LanternaGUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.Fruit.Apple;
import com.aor.Snake.model.game.Fruit.Banana;
import com.aor.Snake.model.game.Fruit.Cherry;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.model.game.elements.Wall;
import com.aor.Snake.viewer.game.Element.GameViewer;
import com.aor.Snake.viewer.game.Element.SnakeViewer;
import com.aor.Snake.viewer.game.Fruit.AppleViewer;
import com.aor.Snake.viewer.game.Fruit.BananaViewer;
import com.aor.Snake.viewer.game.Fruit.CherryViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private AppleViewer appleViewer;
    private Arena arena;
    private Apple apple;
    private BananaViewer bananaViewer;
    private Banana banana;
    private CherryViewer cherryViewer;
    private Cherry cherry;

    @BeforeEach
    void setup(){
        arena = new Arena(29,29);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);
        arena.setWalls( new ArrayList<>());
        arena.setSnake( new ArrayList<>());
    }

    @Test
    void drawAppleTest() throws IOException {
        apple = Mockito.mock(Apple.class);
        appleViewer = Mockito.mock(AppleViewer.class);
        apple = new Apple(new Position(10, 10));
        arena.setFruit(apple);
        viewer.draw(gui);
        appleViewer.draw(apple, gui);
        Mockito.verify(gui, Mockito.times(1)).drawApple(apple.getPosition());
    }

    @Test
    void drawBananaTest() throws IOException {
        banana = Mockito.mock(Banana.class);
        bananaViewer = Mockito.mock(BananaViewer.class);
        banana = new Banana(new Position(11, 10));
        arena.setFruit(banana);
        viewer.draw(gui);
        bananaViewer.draw(banana, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBanana(banana.getPosition());
    }

    @Test
    void drawCherryTest() throws IOException {
        cherry = Mockito.mock(Cherry.class);
        cherryViewer = Mockito.mock(CherryViewer.class);
        cherry = new Cherry(new Position(11, 11));
        arena.setFruit(cherry);
        viewer.draw(gui);
        cherryViewer.draw(cherry, gui);
        Mockito.verify(gui, Mockito.times(1)).drawCherry(cherry.getPosition());
    }
}
