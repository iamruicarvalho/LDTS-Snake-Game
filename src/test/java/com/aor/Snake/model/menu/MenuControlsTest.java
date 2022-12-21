package com.aor.Snake.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenuControlsTest {
    private MenuControls menuControls;

    @BeforeEach
    void setUp(){
        menuControls = new MenuControls();
    }

    @Test
    void nextEntryTest(){
        assertEquals(0, menuControls.getCurrentEntry());
        menuControls.nextEntry();
        assertEquals(1, menuControls.getCurrentEntry());
        menuControls.nextEntry();
        assertEquals(0, menuControls.getCurrentEntry());
    }

    @Test
    void previousEntryTest(){
        assertEquals(0, menuControls.getCurrentEntry());
        menuControls.previousEntry();
        assertEquals(1, menuControls.getCurrentEntry());
        menuControls.previousEntry();
        assertEquals(0, menuControls.getCurrentEntry());
    }

    @Test
    void isSelectedETCTest(){
        assertEquals(menuControls.isSelected(0), menuControls.isSelectedBack());
        menuControls.nextEntry();
        assertEquals(menuControls.isSelected(1), menuControls.isSelectedExit());
    }

    @Test
    void entriesTest(){
        assertEquals(true, menuControls.isSelectedBack());
        menuControls.nextEntry();
        assertEquals(true, menuControls.isSelectedExit());
        menuControls.nextEntry();
        assertEquals(true, menuControls.isSelectedBack());
        assertEquals(false, menuControls.isSelectedExit());
    }
}
