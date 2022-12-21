package com.aor.Snake.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardMenuTest {
    private ScoreBoardMenu scoreBoardMenu;

    @BeforeEach
    void setUp(){
        scoreBoardMenu = new ScoreBoardMenu();
    }

    @Test
    void nextEntryTest(){
        assertEquals(0, scoreBoardMenu.getCurrentEntry());
        scoreBoardMenu.nextEntry();
        assertEquals(1, scoreBoardMenu.getCurrentEntry());
        scoreBoardMenu.nextEntry();
        assertEquals(0, scoreBoardMenu.getCurrentEntry());
    }

    @Test
    void previousEntryTest(){
        assertEquals(0, scoreBoardMenu.getCurrentEntry());
        scoreBoardMenu.previousEntry();
        assertEquals(1, scoreBoardMenu.getCurrentEntry());
        scoreBoardMenu.previousEntry();
        assertEquals(0, scoreBoardMenu.getCurrentEntry());
    }

    @Test
    void isSelectedETCTest(){
        assertEquals(scoreBoardMenu.isSelected(0), scoreBoardMenu.isSelectedBack());
        assertEquals(scoreBoardMenu.isSelected(1), scoreBoardMenu.isSelectedExit());
    }

    @Test
    void entriesTest(){
        assertEquals(true, scoreBoardMenu.isSelectedBack());
        scoreBoardMenu.nextEntry();
        assertEquals(true, scoreBoardMenu.isSelectedExit());
        scoreBoardMenu.nextEntry();
        assertEquals(true, scoreBoardMenu.isSelectedBack());
        assertEquals(false, scoreBoardMenu.isSelectedExit());
    }
}
