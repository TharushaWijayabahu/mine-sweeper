/*
 * Minesweeper Game
 * Developer: Tharusha Wijayabahu
 * Website: https://www.tharushawijayabahu.dev/
 * LinkedIn: https://www.linkedin.com/in/tharusha-wijayabahu
 *
 * Copyright (c) 2024 Tharusha Wijayabahu
 */

package dev.tharusha.wijayabahu.minesweeper;

import dev.tharusha.wijayabahu.minesweeper.service.Game;
import dev.tharusha.wijayabahu.minesweeper.service.InputHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.any;

public class MinesweeperGameTest {

    @Mock
    private InputHandler inputHandler;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
    public void testMain() {
        String input = "5\n3\nA1\nB1\nC1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        try (MockedStatic<Game> mockedGame = Mockito.mockStatic(Game.class)) {
            Game mockGame = Mockito.mock(Game.class);
            mockedGame.when(() -> new Game(any(Scanner.class), any(InputHandler.class))).thenReturn(mockGame);
            MinesweeperGame.main(new String[]{});
            Mockito.verify(mockGame, Mockito.times(1)).start();
        }
    }
}