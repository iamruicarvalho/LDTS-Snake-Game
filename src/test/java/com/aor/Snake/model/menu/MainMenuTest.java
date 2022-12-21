package com.aor.Snake.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuTest {

    private MainMenu mainMenu;

    @BeforeEach
    void setUp(){
        mainMenu = new MainMenu();
    }

    @Test
    void nextEntryTest(){
        assertEquals(0, mainMenu.getCurrentEntry());
        mainMenu.nextEntry();
        assertEquals(1, mainMenu.getCurrentEntry());
        mainMenu.nextEntry();
        assertEquals(2, mainMenu.getCurrentEntry());
        mainMenu.nextEntry();
        assertEquals(3, mainMenu.getCurrentEntry());
        mainMenu.nextEntry();
        assertEquals(0, mainMenu.getCurrentEntry());
    }

    @Test
    void previousEntryTest(){
        assertEquals(0, mainMenu.getCurrentEntry());
        mainMenu.previousEntry();
        assertEquals(3, mainMenu.getCurrentEntry());
        mainMenu.previousEntry();
        assertEquals(2, mainMenu.getCurrentEntry());
    }
    @Test
    void isSelectedETCTest(){
        assertEquals(mainMenu.isSelected(0), mainMenu.isSelectedStart());
        assertEquals(mainMenu.isSelected(1), mainMenu.isSelectedControls());
        assertEquals(mainMenu.isSelected(2), mainMenu.isSelectedScoreBoard());
        assertEquals(mainMenu.isSelected(3), mainMenu.isSelectedExit());
    }

    @Test
    void entriesTest(){
        assertEquals(true, mainMenu.isSelectedStart());
        mainMenu.nextEntry();
        assertEquals(true, mainMenu.isSelectedControls());
        mainMenu.nextEntry();
        assertEquals(true, mainMenu.isSelectedScoreBoard());
        mainMenu.nextEntry();
        assertEquals(true, mainMenu.isSelectedExit());
        mainMenu.nextEntry();
        assertEquals(true, mainMenu.isSelectedStart());
        mainMenu.previousEntry();
        assertEquals(true, mainMenu.isSelectedExit());
        assertEquals(false, mainMenu.isSelectedStart());
    }
}
