package com.aor.Snake.Controller.menu;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.menu.ScoreBoardMenu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ScoreBoardMenuControllerTest {
    private ScoreBoardMenuController scoreBoardMenuController;
    private ScoreBoardMenu scoreBoardMenu;
    private Game game;

    @BeforeEach
    void setUp(){
        scoreBoardMenu = Mockito.mock(ScoreBoardMenu.class);
        game = Mockito.mock(Game.class);
        scoreBoardMenuController = new ScoreBoardMenuController(scoreBoardMenu);
    }

    @Test
    void stepCaseLeft() throws IOException {
        scoreBoardMenuController.step(game, GUI.ACTION.LEFT, 1000);

        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(0)).isSelectedBack();
    }

    @Test
    void stepCaseRight() throws IOException {
        scoreBoardMenuController.step(game, GUI.ACTION.RIGHT, 1000);

        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(0)).isSelectedBack();
    }

    @Test
    void stepCaseSelectExit() throws IOException {
        Mockito.when(scoreBoardMenuController.getModel().isSelectedExit()).thenReturn(true);
        scoreBoardMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(1)).isSelectedBack();
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }

    @Test
    void stepCaseSelectBack() throws IOException {
        Mockito.when(scoreBoardMenuController.getModel().isSelectedBack()).thenReturn(true);
        scoreBoardMenuController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(scoreBoardMenuController.getModel(), Mockito.times(1)).isSelectedBack();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
}
