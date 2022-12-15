package com.aor.Snake.Controller.game;

import com.aor.Snake.Controller.Controller;
import com.aor.Snake.model.game.arena.Arena;

public abstract class GameController extends Controller<Arena> {
    public GameController(Arena arena) {
        super(arena);
    }
}
