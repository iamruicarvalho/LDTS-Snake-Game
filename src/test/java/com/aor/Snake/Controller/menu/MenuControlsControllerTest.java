package com.aor.Snake.Controller.menu;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.menu.MenuControls;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class MenuControlsControllerTest {
    private MenuControlsController menuControlsController;
    private MenuControls menuControls;
    private Game game;

    @BeforeEach
    public void setUp(){
        menuControls = Mockito.mock(MenuControls.class);
        game = Mockito.mock(Game.class);
        menuControlsController = new MenuControlsController(menuControls);
    }

    @Test
    void stepCaseLeft() throws IOException {
        menuControlsController.step(game, GUI.ACTION.LEFT, 1000);

        Mockito.verify(menuControlsController.getModel(), Mockito.times(1)).previousEntry();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(0)).isSelectedBack();
    }

    @Test
    void stepCaseRight() throws IOException {
        menuControlsController.step(game, GUI.ACTION.RIGHT, 1000);

        Mockito.verify(menuControlsController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(1)).nextEntry();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(0)).isSelectedExit();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(0)).isSelectedBack();
    }
    @Test
    void stepCaseSelectExit() throws IOException {
        Mockito.when(menuControlsController.getModel().isSelectedExit()).thenReturn(true);
        menuControlsController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(menuControlsController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(1)).isSelectedBack();
        Mockito.verify(game, Mockito.times(1)).setState(null);
    }
    @Test
    void stepCaseSelectBack() throws IOException {
        Mockito.when(menuControlsController.getModel().isSelectedBack()).thenReturn(true);
        menuControlsController.step(game, GUI.ACTION.SELECT, 1000);

        Mockito.verify(menuControlsController.getModel(), Mockito.times(0)).previousEntry();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(0)).nextEntry();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(1)).isSelectedExit();
        Mockito.verify(menuControlsController.getModel(), Mockito.times(1)).isSelectedBack();
        Mockito.verify(game, Mockito.times(0)).setState(null);
    }
}
