package com.aor.Snake.Controller.menu;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.menu.GameOverMenu;
import com.aor.Snake.model.menu.MainMenu;
import com.aor.Snake.states.GameOverMenuState;
import com.aor.Snake.states.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameOverMenuControllerTest {
    private GameOverMenuController gameOverMenuController;
    private GameOverMenu gameOverMenu;
    private Game game;

    @BeforeEach
    void setup(){
        gameOverMenu = Mockito.mock(GameOverMenu.class);
        game = Mockito.mock(Game.class);
        gameOverMenuController = new GameOverMenuController(gameOverMenu);
    }

    @Test
    void stepCaseUp() throws IOException, URISyntaxException, FontFormatException {
        gameOverMenuController.step(game, GUI.ACTION.UP, 1000);

        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).isSelectedMenu();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).isSelectedRestart();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }

    @Test
    void stepCaseDown() throws IOException, URISyntaxException, FontFormatException {
        gameOverMenuController.step(game, GUI.ACTION.DOWN, 1000);

        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).isSelectedMenu();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).isSelectedRestart();
    }

    @Test
    void stepCaseSelectExit() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(gameOverMenuController.getModel().isSelectedExit()).thenReturn(true);
        gameOverMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).isSelectedMenu();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).isSelectedRestart();
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }
    @Test
    void stepCaseSelectMenu() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(gameOverMenuController.getModel().isSelectedMenu()).thenReturn(true);
        gameOverMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).isSelectedMenu();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).isSelectedRestart();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
    @Test
    void stepCaseSelectRestart() throws IOException, URISyntaxException, FontFormatException {
        Mockito.when(gameOverMenuController.getModel().isSelectedRestart()).thenReturn(true);
        gameOverMenuController.step(game, GUI.ACTION.SELECT, 1000);


        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).isSelectedMenu();
        Mockito.verify(gameOverMenuController.getModel(), Mockito.times(1)).isSelectedRestart();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
    
}
