/*
 * Minesweeper Game
 * Developer: Tharusha Wijayabahu
 * Website: https://www.tharushawijayabahu.dev/
 * LinkedIn: https://www.linkedin.com/in/tharusha-wijayabahu
 *
 * Copyright (c) 2024 Tharusha Wijayabahu
 */

package dev.tharusha.wijayabahu.minesweeper.service;

import dev.tharusha.wijayabahu.minesweeper.dto.Coordinate;
import dev.tharusha.wijayabahu.minesweeper.exception.MinesweeperException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.mockito.Mockito.*;

public class GameTest {

    @Mock
    private InputHandler inputHandler;

    private Scanner scanner;
    private Game game;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
    public void testStartGameWithValidInput() throws Exception {
        String input = "5\n3\nA1\nB1\nC1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);
        game = new Game(scanner, inputHandler);

        when(inputHandler.getGridSize(any(Scanner.class))).thenReturn(5);
        when(inputHandler.getMineCount(any(Scanner.class), eq(5))).thenReturn(3);
        when(inputHandler.getCoordinate(any(Scanner.class), eq(5)))
                .thenReturn(new Coordinate(0, 0))
                .thenReturn(new Coordinate(1, 0))
                .thenReturn(new Coordinate(2, 0));

        game.start();

        // Verify interactions
        verify(inputHandler, times(1)).getGridSize(any(Scanner.class));
        verify(inputHandler, times(1)).getMineCount(any(Scanner.class), eq(5));
        verify(inputHandler, times(3)).getCoordinate(any(Scanner.class), eq(5));
    }

//    @Test
    public void testStartGameWithInvalidInput() throws Exception {
        String input = "invalid\n5\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);
        game = new Game(scanner, inputHandler);

        when(inputHandler.getGridSize(any(Scanner.class)))
                .thenThrow(new MinesweeperException("Invalid grid size"))
                .thenReturn(5);

        game.start();

        // Verify interactions
        verify(inputHandler, times(2)).getGridSize(any(Scanner.class));
    }

//    @Test
    public void testAlreadySelectedCell() throws Exception {
        String input = "5\n3\nA1\nA1\nB1\nC1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);
        game = new Game(scanner, inputHandler);

        when(inputHandler.getGridSize(any(Scanner.class))).thenReturn(5);
        when(inputHandler.getMineCount(any(Scanner.class), eq(5))).thenReturn(3);
        when(inputHandler.getCoordinate(any(Scanner.class), eq(5)))
                .thenReturn(new Coordinate(0, 0))
                .thenReturn(new Coordinate(0, 0))
                .thenReturn(new Coordinate(1, 0))
                .thenReturn(new Coordinate(2, 0));

        game.start();

        // Verify interactions
        verify(inputHandler, times(1)).getGridSize(any(Scanner.class));
        verify(inputHandler, times(1)).getMineCount(any(Scanner.class), eq(5));
        verify(inputHandler, times(4)).getCoordinate(any(Scanner.class), eq(5));
    }
}