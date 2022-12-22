package com.aor.Snake.viewer.menu;

import com.aor.Snake.gui.LanternaGUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.menu.DificultyMenu;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DificultyMenuViewerTest {

    private DificultyMenuViewer dificultyMenuViewer;
    private DificultyMenu model;
    private LanternaGUI gui;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        model = new DificultyMenu();
        dificultyMenuViewer = new DificultyMenuViewer(model);
        gui = Mockito.mock(LanternaGUI.class);
        graphics = Mockito.mock(TextGraphics.class);
    }

    @Test
    void getModelTest(){
        assertEquals(model, dificultyMenuViewer.getModel());
    }

    @Test
    void drawElementsTest() throws IOException {
        dificultyMenuViewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1)).changeBackgroundColor("#000000", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(7, 10), "@ DIFFICULTY @", "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(11, 13), dificultyMenuViewer.getModel().getEntry(0), dificultyMenuViewer.getModel().isSelected(0) ? "#D97F02" : "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(11, 13), dificultyMenuViewer.getModel().getEntry(0), "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(11, 13), "EASY", "#D97F02", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(11, 14), "MEDIUM", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(11, 15), "HARD", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(11, 16), "BACK", "#FFFFFF", "#000000");
        Mockito.verify(gui, Mockito.times(1)).drawText(new Position(11, 17), "EXIT", "#FFFFFF", "#000000");
    }

}
