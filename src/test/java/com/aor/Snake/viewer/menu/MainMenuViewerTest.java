package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.LanternaGUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.GameOverMenu;
import com.aor.Snake.model.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuViewerTest {
    private MainMenuViewer mainMenuViewer;
    private MainMenu model;
    private LanternaGUI gui;

    @BeforeEach
    void setUp(){
        model = new MainMenu();
        mainMenuViewer = new MainMenuViewer(model);
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void getModelTest(){
        assertEquals(model, mainMenuViewer.getModel());
    }

    @Test
    void drawElementsTest() throws IOException {
        mainMenuViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).changeBackgroundColor("#000000", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(7, 10), "@ SNAKE GAME @", "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 13), mainMenuViewer.getModel().getEntry(0), mainMenuViewer.getModel().isSelected(0) ? "#D97F02" : "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 13), mainMenuViewer.getModel().getEntry(0), "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 13), "START $", "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 14), "CONTROLS", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 15), "SCOREBOARD", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(10, 16), "EXIT", "#FFFFFF", "#000000");
    }
}
