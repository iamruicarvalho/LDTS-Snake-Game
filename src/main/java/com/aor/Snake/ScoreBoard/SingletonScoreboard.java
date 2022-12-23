package com.aor.Snake.ScoreBoard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SingletonScoreboard {
    private static SingletonScoreboard instance; // The singleton instance
    private int highScore; // Current HighScore
    private int lastScore; // Last ScoreObtained during the gameplay

    public static SingletonScoreboard getInstance() {
        if (instance == null) {
            instance = new SingletonScoreboard();
        }
        return instance;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    //Loads HighScore from file
    public void LoadHighScore() {
        File file = new File("scoreBoard/Scoreboard.txt");
        String filePath = file.getAbsolutePath();
        List<String> lines = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            for (String line; (line = bufferedReader.readLine()) != null; ) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!lines.isEmpty()) {
            highScore = Integer.parseInt(lines.get(0));
        }
        highScore = 0;
    }

    //Changes HighScore if higher than the one on the file
    public void UpdateHighScore(int score) {
        File file = new File("scoreBoard/Scoreboard.txt");
        boolean newHighScore = score > highScore;

        if (newHighScore) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false))) {
                bufferedWriter.write(Integer.toString(score) + '\n');
                highScore = score;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getLastScore() {
        return lastScore;
    }

    public void setLastScore(int lastScore) {
        this.lastScore = lastScore;
    }
}
