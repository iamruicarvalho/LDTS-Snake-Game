package com.aor.Snake.SingletonScoreboard;

import com.aor.Snake.ScoreBoard.SingletonScoreboard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class SingletonScoreboardTest {

    private SingletonScoreboard singletonScoreboard;

    @BeforeEach
    void setUp(){
        singletonScoreboard = new SingletonScoreboard();
    }

    @Test
    void getHighScoreTest(){
        int highScore = 19;
        singletonScoreboard.setHighScore(highScore);
        assertEquals(19, singletonScoreboard.getHighScore());
        assertNotEquals(20, singletonScoreboard.getHighScore());
    }

    @Test
    void getLasScore(){
        int lastScore = 5;
        singletonScoreboard.setLastScore(lastScore);
        assertEquals(5, singletonScoreboard.getLastScore());
        assertNotEquals(20, singletonScoreboard.getLastScore());
    }
}
