package com.aor.Snake.model.menu;

import java.util.Arrays;
import java.util.List;

public class DifficultyMenu {
    private final List<String> entries;
    private int currentEntry = 0;

    public DifficultyMenu() {
        this.entries = Arrays.asList("EASY", "MEDIUM","HARD", "BACK","EXIT");
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

    public boolean isSelectedEasy() {
        return isSelected(0);
    }

    public boolean isSelectedMedium() {
        return isSelected(1);
    }

    public boolean isSelectedHard() {
        return isSelected(2);
    }

    public boolean isSelectedBack() {
        return isSelected(3);
    }

    public boolean isSelectedExit() {
        return isSelected(4);
    }


    public int getNumberEntries() {
        return this.entries.size();
    }

    public int getCurrentEntry(){
        return this.currentEntry;
    }
}
