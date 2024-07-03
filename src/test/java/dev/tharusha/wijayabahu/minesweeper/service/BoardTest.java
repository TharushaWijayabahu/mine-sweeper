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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    public void setUp() {
        board = new Board(5, 5);
    }

    @Test
    public void testIsValidCell() {
        assertTrue(board.isValidCell(0, 0));
        assertFalse(board.isValidCell(-1, 0));
        assertFalse(board.isValidCell(0, 5));
    }

    @Test
    public void testRevealCell() {
        board.revealCell(new Coordinate(0, 0));
        assertTrue(board.getCell(0, 0).isRevealed());
    }

    @Test
    public void testRevealMine() {
        Board mineBoard = new Board(5, 1);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (mineBoard.getCell(i, j).isMine()) {
                    mineBoard.revealCell(new Coordinate(i, j));
                    assertTrue(mineBoard.isGameOver());
                    return;
                }
            }
        }
    }

    @Test
    public void testRevealSafeCells() {
        board.revealCell(new Coordinate(0, 1));
        assertFalse(board.isGameOver());
    }

    @Test
    public void testCheckWinCondition() {
        Board smallBoard = new Board(2, 1);
        smallBoard.revealCell(new Coordinate(0, 0));
        smallBoard.revealCell(new Coordinate(1, 0));
        smallBoard.revealCell(new Coordinate(1, 1));
        assertTrue(smallBoard.isWon());
    }
}