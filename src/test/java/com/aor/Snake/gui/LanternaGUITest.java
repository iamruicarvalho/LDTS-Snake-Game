package com.aor.Snake.gui;

import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.elements.Wall;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanternaGUITest {
    private Screen screen;
    private  LanternaGUI lanternaGUI;
    private TextGraphics textGraphics;
    @BeforeEach
    void setUp(){
        screen = Mockito.mock(Screen.class);
        textGraphics = Mockito.mock(TextGraphics.class);

        lanternaGUI = new LanternaGUI(screen);

        Mockito.when(screen.newTextGraphics()).thenReturn(textGraphics);
    }

    @Test
    void getNextActionTest() throws IOException {
        KeyStroke keyStroke = null;
        assertEquals(GUI.ACTION.NONE, lanternaGUI.getNextAction());
    }

    @Test
    void drawWallTest(){
        lanternaGUI.drawWall(new Position(1, 1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(textGraphics,Mockito.times(1)).putString(1, 2, "" + '.');

    }

    @Test
    void drawSnakeBodyTest(){
        lanternaGUI.drawSnakeBody(new Position(1, 1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#00A517"));
        Mockito.verify(textGraphics,Mockito.times(1)).putString(1, 2, "" + '+');
    }

    @Test
    void drawAppleTest(){
        lanternaGUI.drawApple(new Position(1, 1));

        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#FF0000"));
        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(textGraphics,Mockito.times(1)).putString(1, 2, "" + '$');
    }

    @Test
    void clearTest(){
        lanternaGUI.clear();
        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    void refreshTest() throws IOException {
        lanternaGUI.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    void closeTest() throws IOException {
        lanternaGUI.close();
        Mockito.verify(screen, Mockito.times(1)).close();
    }

    @Test
    void changeBackgroundColorTest(){
        lanternaGUI.changeBackgroundColor("#FFFFFF", "#000000");

        Mockito.verify(textGraphics, Mockito.times(1)).setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        Mockito.verify(textGraphics, Mockito.times(1)).setForegroundColor(TextColor.Factory.fromString("#000000"));
        Mockito.verify(textGraphics, Mockito.times(1)).fill(' ');
    }
}
