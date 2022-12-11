package com.aor.Snake.controller.game;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.elements.Apple;
import com.aor.Snake.model.game.elements.SnakeBody;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class AppleController extends GameController {
    SnakeBody snake;
    public AppleController(Arena arena) {
        super(arena);
    }
    private int max = 28;
    private int min = 1;

    @Override
    public void step(Game game, GUI.ACTION action, long time) {

    }

    private void showApple(Apple apple) {
        List<Position> possiblePositions = new ArrayList<>();
        int nrApples = 10;

        //generate random positions
        for (int i = 0; i < nrApples; i++) {
            int randPosX = (int) Math.floor(Math.random() * (max-min+1) + min);
            int randPosY = (int) Math.floor(Math.random() * (max-min+1) + min);

            possiblePositions.add(new Position(randPosX, randPosY));
        }
        for (int i = 0; i < nrApples; i++) {
            if (possiblePositions.get(i).equals(snake.getPosition())) {
                
            }
        }

    }

}
