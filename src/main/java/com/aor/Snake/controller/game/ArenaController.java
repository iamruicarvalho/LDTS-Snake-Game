package com.aor.Snake.controller.game;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.arena.Arena;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class ArenaController extends GameController {
    private final SnakeController snakeController;
    public ArenaController(Arena arena) {
        super(arena);
        this.snakeController = new SnakeController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException, URISyntaxException, FontFormatException {
        snakeController.step(game, action, time);

    }
}
