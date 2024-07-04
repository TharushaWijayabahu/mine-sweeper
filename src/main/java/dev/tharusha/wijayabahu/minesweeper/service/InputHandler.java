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

import java.util.Scanner;

/**
 * Handles user input for the Minesweeper game.
 */
public class InputHandler {

    /**
     * Prompts the user to enter the grid size.
     *
     * @param scanner The Scanner to read user input
     * @return The size of the grid
     * @throws MinesweeperException if the input is invalid
     */
    public int getGridSize(Scanner scanner) {
        int size;
        while (true) {
            System.out.print("Enter the size of the grid (2-10): ");
            if (!scanner.hasNextInt()) {
                scanner.next();
                throw new MinesweeperException("Incorrect input. Please enter a number between 2 and 10.");
            }
            size = scanner.nextInt();
            if (size < 2) {
                throw new MinesweeperException("Minimum size of grid is 2.");
            }
            if (size > 10) {
                throw new MinesweeperException("Maximum size of grid is 10.");
            }
            return size;
        }
    }

    /**
     * Prompts the user to enter the number of mines.
     *
     * @param scanner The Scanner to read user input
     * @param size    The size of the grid
     * @return The number of mines
     * @throws MinesweeperException if the input is invalid
     */
    public int getMineCount(Scanner scanner, int size) {
        int maxMines = (int) (size * size * 0.35);
        int mines;
        while (true) {
            System.out.print("Enter the number of mines to place on the grid (1-" + maxMines + "): ");
            if (!scanner.hasNextInt()) {
                scanner.next();
                throw new MinesweeperException("Incorrect input. Please enter a number between 1 and " + maxMines + ".");
            }
            mines = scanner.nextInt();
            if (mines < 1) {
                throw new MinesweeperException("There must be at least 1 mine.");
            }
            if (mines > maxMines) {
                throw new MinesweeperException("Maximum number is 35% of total squares.");
            }
            return mines;
        }
    }

    /**
     * Prompts the user to enter a cell to reveal.
     *
     * @param scanner The Scanner to read user input
     * @param size    The size of the grid
     * @return The coordinates of the cell to reveal
     * @throws MinesweeperException if the input is invalid
     */
    public Coordinate getCoordinate(Scanner scanner, int size) {
        while (true) {
            System.out.print("Select a square to reveal (e.g. A1): ");
            String input = scanner.next();
            if (!isValidInput(input, size)) {
                throw new MinesweeperException("Incorrect input. Please enter a valid cell.");
            }
            char rowChar = input.charAt(0);
            int row = rowChar - 'A';
            int col = Integer.parseInt(input.substring(1)) - 1;
            return new Coordinate(row, col);
        }
    }

    /**
     * Validates the input for selecting a cell.
     *
     * @param input The input to validate
     * @param size  The size of the grid
     * @return True if the input is valid, false otherwise
     */
    private boolean isValidInput(String input, int size) {
        if (input.length() < 2) {
            return false;
        }
        char rowChar = input.charAt(0);
        if (rowChar < 'A' || rowChar >= 'A' + size) {
            return false;
        }
        String colStr = input.substring(1);
        int col;
        try {
            col = Integer.parseInt(colStr);
        } catch (NumberFormatException e) {
            return false;
        }
        return col >= 1 && col <= size;
    }
}
