package com.aor.Snake.states;

import com.aor.Snake.controller.Controller;
import com.aor.Snake.controller.game.ArenaController;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.viewer.game.GameViewer;

public class GameState extends State<Arena> {
    public GameState(Arena arena) {
        super(arena);
    }

    @Override
    protected Viewer<Arena> getViewer() {
        return new GameViewer(getModel());
    }

    @Override
    protected Controller<Arena> getController() {
        return new ArenaController(getModel());
    }
}
