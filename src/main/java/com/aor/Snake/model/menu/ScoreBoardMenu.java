package com.aor.Snake.model.menu;

import com.aor.Snake.Controller.game.SnakeController;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreBoardMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    public ScoreBoardMenu() {
        this.entries = Arrays.asList("BACK", "EXIT");
    }

    public String gethightScore() throws IOException {
        URL resource = SnakeController.class.getResource("/Score/score.txt");
        List<String> lines = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(resource.getFile()));

        for (String line; (line = bufferedReader.readLine()) != null;)
            lines.add(line);

        if (!lines.isEmpty()) {
            return lines.get(0);
        }
        return "";
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }
    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }

    public boolean isSelectedBack() {
        return isSelected(0);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }
}