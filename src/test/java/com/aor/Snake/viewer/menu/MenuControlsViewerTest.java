package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.LanternaGUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.GameOverMenu;
import com.aor.Snake.model.menu.MenuControls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuControlsViewerTest {

    private MenuControlsViewer menuControlsViewer;
    private MenuControls model;
    private LanternaGUI gui;

    @BeforeEach
    void setUp(){
        model = new MenuControls();
        menuControlsViewer = new MenuControlsViewer(model);
        gui = Mockito.mock(LanternaGUI.class);
    }

    @Test
    void getModelTest(){
        assertEquals(model, menuControlsViewer.getModel());
    }

    @Test
    void drawElementsTest() throws IOException {
        menuControlsViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).changeBackgroundColor("#000000", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(9, 10), "CONTROLS", "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 12), "> - SNAKE RIGHT", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 13), "< - SNAKE LEFT", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 14), "^ - SNAKE UP", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 15), "; - SNAKE DOWN", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 16), "Q - QUIT", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 17), "' - SELECT", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 25), menuControlsViewer.getModel().getEntry(0), menuControlsViewer.getModel().isSelected(0) ? "#D97F02" : "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 25), menuControlsViewer.getModel().getEntry(0), "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(6, 25), "BACK", "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(16, 25), "EXIT", "#FFFFFF", "#000000");
    }
}
