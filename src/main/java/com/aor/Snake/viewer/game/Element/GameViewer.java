package com.aor.Snake.viewer.game.Element;

import com.aor.Snake.gui.GUI;
import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.Fruit.Apple;
import com.aor.Snake.model.game.Fruit.Banana;
import com.aor.Snake.model.game.Fruit.Fruit;
import com.aor.Snake.model.game.arena.Arena;
import com.aor.Snake.model.game.elements.Element;
import com.aor.Snake.viewer.Viewer;
import com.aor.Snake.viewer.game.Fruit.AppleViewer;
import com.aor.Snake.viewer.game.Fruit.BananaViewer;
import com.aor.Snake.viewer.game.Fruit.FruitViewer;

import java.awt.desktop.AppForegroundListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getSnake(), new SnakeViewer());
        drawFruit(gui, getModel().getFruit());
        int n = getModel().getWidth() - ("SIZE: " + getModel().getSnake().size()).length();
        String str = "SIZE: " + getModel().getSnake().size();
        String sRepeated = IntStream.range(0, n).mapToObj(i -> " ").collect(Collectors.joining(""));
        str += sRepeated;

        gui.drawText(new Position(0, 0), str, "#FFD700", "#000000");
    }


    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    private <T extends Fruit> void drawFruit(GUI gui, T fruit) {
        if (fruit instanceof Apple) {
            new AppleViewer().draw((Apple) fruit, gui);
        }
        else if (fruit instanceof Banana) {
            new BananaViewer().draw((Banana) fruit, gui);
        }

    }
}
