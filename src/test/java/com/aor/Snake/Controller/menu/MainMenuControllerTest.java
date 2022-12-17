package com.aor.Snake.Controller.menu;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.menu.MainMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MainMenuControllerTest {
    private MainMenuController mainMenuController;
    private MainMenu mainMenu;
    private Game game;


    @BeforeEach
    public void setUp() {
        mainMenu = Mockito.mock(MainMenu.class);
        game = Mockito.mock(Game.class);
        mainMenuController = new MainMenuController(mainMenu);
    }

    @Test
    void stepCaseUp() throws IOException {
        mainMenuController.step(game, GUI.ACTION.UP, 1000);

        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).isSelectedControls();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).isSelectedScoreBoard();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).isSelectedStart();
    }
    @Test
    void stepCaseDown() throws IOException {
        mainMenuController.step(game, GUI.ACTION.DOWN, 1000);

        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).isSelectedControls();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).isSelectedScoreBoard();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).isSelectedStart();
    }

    @Test
    void stepCaseSelectExit() throws IOException {
        Mockito.when(mainMenuController.getModel().isSelectedExit()).thenReturn(true);
        mainMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedControls();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedScoreBoard();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(game, Mockito.times(1)).setState(null);

    }
    @Test
    void stepCaseSelectControls() throws IOException {
        Mockito.when(mainMenuController.getModel().isSelectedControls()).thenReturn(true);
        mainMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedControls();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedScoreBoard();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(game, Mockito.times(0)).setState(null);

    }
    @Test
    void stepCaseSelectScoreBoard() throws IOException {
        Mockito.when(mainMenuController.getModel().isSelectedScoreBoard()).thenReturn(true);
        mainMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedControls();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedScoreBoard();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
    @Test
    void stepCaseSelectStart() throws IOException {
        Mockito.when(mainMenuController.getModel().isSelectedStart()).thenReturn(true);
        mainMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedControls();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedScoreBoard();
        Mockito.verify(mainMenuController.getModel(), Mockito.times(1)).isSelectedStart();
        Mockito.verify(game, Mockito.times(0)).setState(null);

    }
}


