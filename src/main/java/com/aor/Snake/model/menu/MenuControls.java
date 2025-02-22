package com.aor.Snake.model.menu;

import java.util.Arrays;
import java.util.List;

public class MenuControls {
    private final List<String> entries;
    private int currentEntry = 0;

    public MenuControls() {
        this.entries = Arrays.asList("BACK", "EXIT");
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