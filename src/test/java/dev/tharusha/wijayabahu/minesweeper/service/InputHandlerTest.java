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
import org.mockito.Mockito;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class InputHandlerTest {

    private Scanner scanner;
    private InputHandler inputHandler;

    @BeforeEach
    public void setUp() {
        scanner = Mockito.mock(Scanner.class);
        inputHandler = new InputHandler();
    }

    @Test
    public void testGetGridSizeWithValidInput() {
        Mockito.when(scanner.hasNextInt()).thenReturn(true);
        Mockito.when(scanner.nextInt()).thenReturn(5);
        assertEquals(5, inputHandler.getGridSize(scanner));
    }

    @Test
    public void testGetGridSizeWithInvalidInput() {
        Mockito.when(scanner.hasNextInt()).thenReturn(false);
        assertThrows(MinesweeperException.class, () -> inputHandler.getGridSize(scanner));
    }

    @Test
    public void testGetMineCountWithValidInput() {
        int size = 5;
        Mockito.when(scanner.hasNextInt()).thenReturn(true);
        Mockito.when(scanner.nextInt()).thenReturn(3);
        assertEquals(3, inputHandler.getMineCount(scanner, size));
    }

    @Test
    public void testGetMineCountWithInvalidInput() {
        int size = 5;
        Mockito.when(scanner.hasNextInt()).thenReturn(false);
        assertThrows(MinesweeperException.class, () -> inputHandler.getMineCount(scanner, size));
    }

    @Test
    public void testGetCoordinateWithValidInput() {
        int size = 5;
        Mockito.when(scanner.next()).thenReturn("A1");
        Coordinate coordinate = inputHandler.getCoordinate(scanner, size);
        assertEquals(0, coordinate.getRow());
        assertEquals(0, coordinate.getCol());
    }

    @Test
    public void testGetCoordinateWithInvalidInput() {
        int size = 5;
        Mockito.when(scanner.next()).thenReturn("Z9");
        assertThrows(MinesweeperException.class, () -> inputHandler.getCoordinate(scanner, size));
    }
}
