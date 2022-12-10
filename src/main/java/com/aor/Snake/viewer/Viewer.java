package com.aor.Snake.viewer;

import com.aor.Snake.gui.GUI;

import java.io.IOException;

public abstract class Viewer<T> {
    private final T model;

    public Viewer(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public void draw(GUI gui) throws IOException {
        gui.clear();
        gui.changeBackgroundColor();
        drawElements(gui);
        gui.refresh();
    }

    protected abstract void drawElements(GUI gui);
}
