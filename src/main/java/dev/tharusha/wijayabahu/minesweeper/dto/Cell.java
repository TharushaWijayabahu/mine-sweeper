/*
 * Minesweeper Game
 * Developer: Tharusha Wijayabahu
 * Website: https://www.tharushawijayabahu.dev/
 * LinkedIn: https://www.linkedin.com/in/tharusha-wijayabahu
 *
 * Copyright (c) 2024 Tharusha Wijayabahu
 */

package dev.tharusha.wijayabahu.minesweeper.dto;

/**
 * Represents a cell on the Minesweeper board.
 */
public class Cell {
    private boolean mine;
    private boolean revealed;
    private int adjacentMines;

    /**
     * Constructs a new Cell.
     */
    public Cell() {
        this.mine = false;
        this.revealed = false;
        this.adjacentMines = 0;
    }

    /**
     * Returns whether the cell contains a mine.
     *
     * @return True if the cell contains a mine, false otherwise
     */
    public boolean isMine() {
        return mine;
    }

    /**
     * Sets whether the cell contains a mine.
     *
     * @param mine True if the cell contains a mine, false otherwise
     */
    public void setMine(boolean mine) {
        this.mine = mine;
    }

    /**
     * Returns whether the cell is revealed.
     *
     * @return True if the cell is revealed, false otherwise
     */
    public boolean isRevealed() {
        return revealed;
    }

    /**
     * Sets whether the cell is revealed.
     *
     * @param revealed True if the cell is revealed, false otherwise
     */
    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    /**
     * Returns the number of adjacent mines.
     *
     * @return The number of adjacent mines
     */
    public int getAdjacentMines() {
        return adjacentMines;
    }

    /**
     * Increments the number of adjacent mines.
     */
    public void incrementAdjacentMines() {
        this.adjacentMines++;
    }

    /**
     * Returns a string representation of the cell.
     *
     * @return "_" if the cell is not revealed, "*" if it contains a mine,
     * or the number of adjacent mines if it is revealed
     */
    @Override
    public String toString() {
        if (!revealed) {
            return "_";
        } else if (mine) {
            return "*";
        } else {
            return Integer.toString(adjacentMines);
        }
    }
}
