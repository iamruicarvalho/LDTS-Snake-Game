package com.aor.Snake.gui;

import com.aor.Snake.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawWall(Position position);

    void drawSnakeBody(Position position);

    void drawApple(Position position);

    void drawText(Position position, String text, String color, String backcolor);
    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void changeBackgroundColor(String color, String backcolor) throws IOException;
    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, QUIT, SELECT}
}
