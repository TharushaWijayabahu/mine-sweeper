/*
 * Minesweeper Game
 * Developer: Tharusha Wijayabahu
 * Website: https://www.tharushawijayabahu.dev/
 * LinkedIn: https://www.linkedin.com/in/tharusha-wijayabahu
 *
 * Copyright (c) 2024 Tharusha Wijayabahu
 */

package dev.tharusha.wijayabahu.minesweeper.service;

import dev.tharusha.wijayabahu.minesweeper.dto.Cell;
import dev.tharusha.wijayabahu.minesweeper.dto.Coordinate;
import java.util.Random;

/**
 * Represents the game board for Minesweeper.
 */
public class Board {
    private final Cell[][] cells;
    private final int size;
    private final int totalMines;
    private boolean gameOver;
    private boolean won;

    /**
     * Constructs a new Board with the specified size and number of mines.
     *
     * @param size       The size of the board (size x size)
     * @param totalMines The number of mines to place on the board
     */
    public Board(int size, int totalMines) {
        this.size = size;
        this.totalMines = totalMines;
        this.cells = new Cell[size][size];
        this.gameOver = false;
        this.won = false;
        initializeBoard();
        placeMines();
    }

    /**
     * Initializes the board with empty cells.
     */
    private void initializeBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    /**
     * Places mines randomly on the board.
     */
    private void placeMines() {
        Random rand = new Random();
        int placedMines = 0;
        while (placedMines < totalMines) {
            int row = rand.nextInt(size);
            int col = rand.nextInt(size);
            if (!cells[row][col].isMine()) {
                cells[row][col].setMine(true);
                incrementAdjacentCells(row, col);
                placedMines++;
            }
        }
    }

    /**
     * Increments the adjacent mine count for cells around a mine.
     *
     * @param row The row of the mine
     * @param col The column of the mine
     */
    private void incrementAdjacentCells(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValidCell(i, j) && !cells[i][j].isMine()) {
                    cells[i][j].incrementAdjacentMines();
                }
            }
        }
    }

    /**
     * Checks if the specified cell coordinates are valid.
     *
     * @param row The row to check
     * @param col The column to check
     * @return True if the cell coordinates are valid, false otherwise
     */
    public boolean isValidCell(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    /**
     * Displays the current state of the board.
     */
    public void display() {
        System.out.print("  ");
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + " ");
        }
        System.out.println();

        for (int i = 0; i < size; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < size; j++) {
                System.out.print(cells[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Reveals the cell at the specified coordinates.
     *
     * @param coordinate The coordinates of the cell to reveal
     */
    public void revealCell(Coordinate coordinate) {
        int row = coordinate.getRow();
        int col = coordinate.getCol();

        if (cells[row][col].isRevealed()) {
            return;
        }

        cells[row][col].setRevealed(true);

        if (cells[row][col].isMine()) {
            gameOver = true;
            return;
        }

        if (cells[row][col].getAdjacentMines() == 0) {
            revealAdjacentCells(row, col);
        }

        checkWinCondition();
    }

    /**
     * Reveals all adjacent cells recursively.
     *
     * @param row The row of the current cell
     * @param col The column of the current cell
     */
    private void revealAdjacentCells(int row, int col) {
        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (isValidCell(i, j) && !cells[i][j].isRevealed()) {
                    revealCell(new Coordinate(i, j));
                }
            }
        }
    }

    /**
     * Checks if the player has won the game.
     */
    private void checkWinCondition() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!cells[i][j].isMine() && !cells[i][j].isRevealed()) {
                    return;
                }
            }
        }
        won = true;
        gameOver = true;
    }

    /**
     * Returns whether the game is over.
     *
     * @return True if the game is over, false otherwise
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * Returns whether the player has won the game.
     *
     * @return True if the player has won, false otherwise
     */
    public boolean isWon() {
        return won;
    }

    /**
     * Returns the cell at the specified coordinates.
     *
     * @param row The row of the cell
     * @param col The column of the cell
     * @return The cell at the specified coordinates
     */
    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    /**
     * Checks if the cell at the specified coordinates is already revealed.
     *
     * @param coordinate The coordinates of the cell
     * @return True if the cell is already revealed, false otherwise
     */
    public boolean isCellRevealed(Coordinate coordinate) {
        int row = coordinate.getRow();
        int col = coordinate.getCol();
        return cells[row][col].isRevealed();
    }
}