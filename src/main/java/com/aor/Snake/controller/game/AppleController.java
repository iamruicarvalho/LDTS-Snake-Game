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

}
