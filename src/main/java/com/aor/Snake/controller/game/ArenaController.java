package com.aor.Snake.controller.game;

import com.aor.Snake.Game;
import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.menu.Menu;
import com.aor.Snake.states.MenuState;

import java.io.IOException;

public class ArenaController extends GameController {
    private final SnakeController snakeController;
    public ArenaController(Arena arena) {
        super(arena);

        this.snakeController = new SnakeController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {
            snakeController.step(game, action, time);
        }
}
