package com.aor.Snake.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DificultyMenuTest {

    private DificultyMenu dificultyMenu;


    @BeforeEach
    void setUp(){
        dificultyMenu = new DificultyMenu();
    }

    @Test
    void nextEntryTest(){
        assertEquals(0, dificultyMenu.getCurrentEntry());
        dificultyMenu.nextEntry();
        assertEquals(1, dificultyMenu.getCurrentEntry());
        dificultyMenu.nextEntry();
        dificultyMenu.nextEntry();
        dificultyMenu.nextEntry();
        dificultyMenu.nextEntry();
        assertEquals(0, dificultyMenu.getCurrentEntry());
    }

    @Test
    void previousEntryTest(){
        assertEquals(0, dificultyMenu.getCurrentEntry());
        dificultyMenu.previousEntry();
        assertEquals(dificultyMenu.getNumberEntries() - 1, dificultyMenu.getCurrentEntry());
        assertEquals(4, dificultyMenu.getCurrentEntry());
        dificultyMenu.previousEntry();
        assertEquals(3, dificultyMenu.getCurrentEntry());
        dificultyMenu.previousEntry();
        assertEquals(2, dificultyMenu.getCurrentEntry());
    }

    @Test
    void isSelectedETCTest(){
        assertEquals(true, dificultyMenu.isSelectedEasy());
        assertEquals(dificultyMenu.isSelected(0), dificultyMenu.isSelectedEasy());
        assertEquals(dificultyMenu.isSelected(1), dificultyMenu.isSelectedMedium());
        assertEquals(dificultyMenu.isSelected(2), dificultyMenu.isSelectedHard());
        assertEquals(dificultyMenu.isSelected(3), dificultyMenu.isSelectedBack());
        assertEquals(dificultyMenu.isSelected(4), dificultyMenu.isSelectedExit());
    }

    @Test
    void entriesTest(){
        assertEquals(true, dificultyMenu.isSelectedEasy());
        dificultyMenu.nextEntry();
        assertNotEquals(true, dificultyMenu.isSelectedEasy());
        assertEquals(true, dificultyMenu.isSelectedMedium());
        dificultyMenu.nextEntry();
        assertEquals(true, dificultyMenu.isSelectedHard());
        dificultyMenu.nextEntry();
        assertEquals(true, dificultyMenu.isSelectedBack());
        dificultyMenu.nextEntry();
        assertEquals(true, dificultyMenu.isSelectedExit());
        assertEquals(false, dificultyMenu.isSelectedMedium());
        dificultyMenu.nextEntry();
        assertEquals(true, dificultyMenu.isSelectedEasy());
    }
}
