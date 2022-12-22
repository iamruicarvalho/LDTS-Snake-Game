package com.aor.Snake.model.menu;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScoreBoardMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    public ScoreBoardMenu() {
        this.entries = Arrays.asList("BACK", "EXIT");
    }

    public String getHighScore() throws IOException {
        File file = new File("scoreBoard/Scoreboard.txt");
        String filePath = file.getAbsolutePath();
        filePath = filePath.replaceAll("/", "\\\\");

        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            for (String line; (line = bufferedReader.readLine()) != null;) {
                lines.add(line);
            }
        }

        return lines.isEmpty() ? "" : lines.get(0);
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

    public int getCurrentEntry(){ return this.currentEntry;}
}