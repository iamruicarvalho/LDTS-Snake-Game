package com.aor.Snake.model.game.arena;


import com.aor.Snake.model.Position;
import com.aor.Snake.model.game.elements.Apple;
import com.aor.Snake.model.game.elements.SnakeBody;
import com.aor.Snake.model.game.elements.Wall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {
    private final int level;
    private final List<String> lines;

    private int max = 28;
    private int min = 1;

    public LoaderArenaBuilder(int level) throws IOException {
        this.level = level;
        URL resource = LoaderArenaBuilder.class.getResource("/levels/level" + level + ".lvl");
        String file_URL = resource.getFile();
        file_URL = file_URL.replace("/", "//");
        BufferedReader br = new BufferedReader(new FileReader(file_URL));

        lines = readLines(br);
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '.') walls.add(new Wall(x, y));
        }

        return walls;
    }

    @Override
    protected List<SnakeBody> createSnake() {
        List<SnakeBody> Snake = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '+') Snake.add(new SnakeBody(x, y));
        }

        return Snake;
    }

    @Override
    protected Apple createApple() {
        Apple apple = new Apple(0, 0);
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '$') apple.setPosition(new Position(x, y));
        }
        return apple;
    }
}