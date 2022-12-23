package com.aor.Snake.viewer.menu;

import com.aor.Snake.ScoreBoard.SingletonScoreboard;
import com.aor.Snake.gui.LanternaGUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.ScoreBoardMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardMenuViewerTest {
    private ScoreBoardMenuViewer scoreBoardMenuViewer;
    private ScoreBoardMenu model;
    private LanternaGUI gui;

    private SingletonScoreboard singletonScoreboard;

    @BeforeEach
    void setUp(){
        model = new ScoreBoardMenu();
        scoreBoardMenuViewer = new ScoreBoardMenuViewer(model);
        gui = Mockito.mock(LanternaGUI.class);
        singletonScoreboard = new SingletonScoreboard();
    }

    @Test
    void getModelTest(){
        assertEquals(model, scoreBoardMenuViewer.getModel());
    }

    @Test
    void drawElementsTest() throws IOException {
        SingletonScoreboard instance = singletonScoreboard.getInstance();
        scoreBoardMenuViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(7, 10), "@ SCOREBOARD @", "#000CFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 12), "BEST SCORE: " + instance.getHighScore(), "#FFD700", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 15), scoreBoardMenuViewer.getModel().getEntry(0), scoreBoardMenuViewer.getModel().isSelected(0) ? "#D97F02" : "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 15), scoreBoardMenuViewer.getModel().getEntry(0), "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 15), "BACK", "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(16, 15), "EXIT", "#FFFFFF", "#000000");
    }
}
