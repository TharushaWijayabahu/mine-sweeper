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

public class CoordinateTest {

    @Test
    public void testGetRow() {
        Coordinate coordinate = new Coordinate(1, 2);
        assertEquals(1, coordinate.getRow());
    }

    @Test
    public void testGetCol() {
        Coordinate coordinate = new Coordinate(1, 2);
        assertEquals(2, coordinate.getCol());
    }
}