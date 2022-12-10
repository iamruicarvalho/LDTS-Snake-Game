package com.aor.Snake.controller.game;

import com.aor.Snake.controller.Controller;
import com.aor.Snake.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
