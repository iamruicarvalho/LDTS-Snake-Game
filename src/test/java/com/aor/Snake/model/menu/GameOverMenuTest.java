package com.aor.Snake.model.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverMenuTest {
     private GameOverMenu gameOverMenu;

     @BeforeEach
     void setUp(){
         gameOverMenu = new GameOverMenu();
     }

     @Test
     void nextEntryTest(){
         assertEquals(0, gameOverMenu.getCurrentEntry());
         gameOverMenu.nextEntry();
         assertEquals(1, gameOverMenu.getCurrentEntry());
         gameOverMenu.nextEntry();
         gameOverMenu.nextEntry();
         assertEquals(0, gameOverMenu.getCurrentEntry());
     }

     @Test
     void previousEntryTest(){
         assertEquals(0, gameOverMenu.getCurrentEntry());
         gameOverMenu.previousEntry();
         assertEquals(2, gameOverMenu.getCurrentEntry());
         gameOverMenu.previousEntry();
         assertEquals(1, gameOverMenu.getCurrentEntry());
     }

    @Test
    void isSelectedETCTest(){
         assertEquals(gameOverMenu.isSelected(0), gameOverMenu.isSelectedRestart());
         assertEquals(gameOverMenu.isSelected(1), gameOverMenu.isSelectedMenu());
         assertEquals(gameOverMenu.isSelected(2), gameOverMenu.isSelectedExit());
    }

    @Test
    void entriesTest(){
         assertEquals(true, gameOverMenu.isSelectedRestart());
         gameOverMenu.nextEntry();
         assertEquals(true, gameOverMenu.isSelectedMenu());
         gameOverMenu.nextEntry();
         assertEquals(true, gameOverMenu.isSelectedExit());
         gameOverMenu.nextEntry();
         assertEquals(true, gameOverMenu.isSelectedRestart());
         assertEquals(false, gameOverMenu. isSelectedMenu());
         gameOverMenu.previousEntry();
         assertEquals(true, gameOverMenu.isSelectedExit());
    }
}
