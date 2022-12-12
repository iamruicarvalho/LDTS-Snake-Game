package com.aor.Snake;

import com.aor.Snake.gui.LanternaGUI;
import com.aor.Snake.model.menu.MainMenu;
import com.aor.Snake.states.MainMenuState;
import com.aor.Snake.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    private int FPS = 10;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(29, 29);
        this.state = new MainMenuState(new MainMenu());

    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public LanternaGUI getGui() {
        return gui;
    }

    public void setState(State state) {
        this.state = state;
    }
    public void setFPS(int FPS) {
        this.FPS = FPS;
    }

    private void start() throws IOException, URISyntaxException, FontFormatException {

        while (this.state != null) {
            int frameTime = 1000 / FPS;
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }

        gui.close();
    }
}
