package com.aor.Snake.Controller.menu;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.menu.DifficultyMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DificultyMenuControllerTest {
    private DifficultyMenuController dificultyMenuController;
    private DifficultyMenu dificultyMenu;
    private Game game;

    @BeforeEach
    void setup(){
        dificultyMenu = Mockito.mock(DifficultyMenu.class);
        game = Mockito.mock(Game.class);
        dificultyMenuController = new DifficultyMenuController(dificultyMenu);
    }

    @Test
    void stepCaseUp() throws IOException, URISyntaxException, FontFormatException {
        dificultyMenuController.step(game, GUI.ACTION.UP, 1000);

        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).isSelectedEasy();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).isSelectedMedium();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).isSelectedHard();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).isSelectedBack();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).isSelectedExit();
    }
    @Test
    void stepCaseDown() throws IOException, URISyntaxException, FontFormatException {
        dificultyMenuController.step(game, GUI.ACTION.DOWN, 1000);

        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).isSelectedEasy();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).isSelectedMedium();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).isSelectedHard();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).isSelectedBack();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).isSelectedExit();
    }
    @Test
    void stepCaseSelectEasy() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(dificultyMenuController.getModel().isSelectedEasy()).thenReturn(true);
        dificultyMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedEasy();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedMedium();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedHard();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedBack();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(game, Mockito.times(1)).setFPS(10);
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
    @Test
    void stepCaseSelectMedium() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(dificultyMenuController.getModel().isSelectedMedium()).thenReturn(true);
        dificultyMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedEasy();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedMedium();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedHard();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedBack();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(game, Mockito.times(1)).setFPS(15);
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
    @Test
    void stepCaseSelectHard() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(dificultyMenuController.getModel().isSelectedHard()).thenReturn(true);
        dificultyMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedEasy();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedMedium();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedHard();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedBack();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(game, Mockito.times(1)).setFPS(25);
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
    @Test
    void stepCaseSelectBack() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(dificultyMenuController.getModel().isSelectedBack()).thenReturn(true);
        dificultyMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedEasy();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedMedium();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedHard();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedBack();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
    @Test
    void stepCaseSelectExit() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(dificultyMenuController.getModel().isSelectedExit()).thenReturn(true);
        dificultyMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedEasy();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedMedium();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedHard();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedBack();
        Mockito.verify(dificultyMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }
}
