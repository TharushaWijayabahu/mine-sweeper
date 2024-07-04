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
 * Represents coordinates on the Minesweeper board.
 */
public class Coordinate {
    private final int row;
    private final int col;

    /**
     * Constructs a new Coordinate with the specified row and column.
     *
     * @param row The row coordinate
     * @param col The column coordinate
     */
    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the row coordinate.
     *
     * @return The row coordinate
     */
    public int getRow() {
        return row;
    }

    /**
     * Returns the column coordinate.
     *
     * @return The column coordinate
     */
    public int getCol() {
        return col;
    }
}
