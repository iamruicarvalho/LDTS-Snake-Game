package com.aor.Snake.viewer.game;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.game.elements.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
