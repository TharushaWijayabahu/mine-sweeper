/*
 * Minesweeper Game
 * Developer: Tharusha Wijayabahu
 * Website: https://www.tharushawijayabahu.dev/
 * LinkedIn: https://www.linkedin.com/in/tharusha-wijayabahu
 *
 * Copyright (c) 2024 Tharusha Wijayabahu
 */

package dev.tharusha.wijayabahu.minesweeper.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testIsMine() {
        Cell cell = new Cell();
        assertFalse(cell.isMine());
        cell.setMine(true);
        assertTrue(cell.isMine());
    }

    @Test
    public void testIsRevealed() {
        Cell cell = new Cell();
        assertFalse(cell.isRevealed());
        cell.setRevealed(true);
        assertTrue(cell.isRevealed());
    }

    @Test
    public void testAdjacentMines() {
        Cell cell = new Cell();
        assertEquals(0, cell.getAdjacentMines());
        cell.incrementAdjacentMines();
        assertEquals(1, cell.getAdjacentMines());
    }

    @Test
    public void testToString() {
        Cell cell = new Cell();
        assertEquals("_", cell.toString());

        cell.setRevealed(true);
        assertEquals("0", cell.toString());

        cell.incrementAdjacentMines();
        assertEquals("1", cell.toString());

        cell.setMine(true);
        assertEquals("*", cell.toString());
    }
}