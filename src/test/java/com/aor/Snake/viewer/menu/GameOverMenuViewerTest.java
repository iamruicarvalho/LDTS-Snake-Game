package com.aor.Snake.viewer.menu;

import com.aor.Snake.ScoreBoard.SingletonScoreboard;
import com.aor.Snake.gui.LanternaGUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.DificultyMenu;
import com.aor.Snake.model.menu.GameOverMenu;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverMenuViewerTest {

     private GameOverMenuViewer gameOverMenuViewer;
     private GameOverMenu model;
     private LanternaGUI gui;

     private SingletonScoreboard singletonScoreboard;

     @BeforeEach
     void setUp(){
         model = new GameOverMenu();
         gameOverMenuViewer = new GameOverMenuViewer(model);
         gui = Mockito.mock(LanternaGUI.class);
         singletonScoreboard = Mockito.mock(SingletonScoreboard.class);
     }

     @Test
     void getModelTest(){
         assertEquals(model, gameOverMenuViewer.getModel());
     }

    @Test
    void drawElementsTest() throws IOException {
        gameOverMenuViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).changeBackgroundColor("#000000", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(7, 10), "@ GAME OVER @", "#FF0000", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 11), "SCORE:" + singletonScoreboard.getLastScore(), "#FFF300", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 13), gameOverMenuViewer.getModel().getEntry(0), gameOverMenuViewer.getModel().isSelected(0) ? "#D97F02" : "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 13), gameOverMenuViewer.getModel().getEntry(0), "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 13), "RESTART", "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 14), "MENU", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 15), "EXIT", "#FFFFFF", "#000000");
    }
}
