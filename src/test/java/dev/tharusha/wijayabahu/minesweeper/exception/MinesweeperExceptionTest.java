/*
 * Minesweeper Game
 * Developer: Tharusha Wijayabahu
 * Website: https://www.tharushawijayabahu.dev/
 * LinkedIn: https://www.linkedin.com/in/tharusha-wijayabahu
 *
 * Copyright (c) 2024 Tharusha Wijayabahu
 */

package dev.tharusha.wijayabahu.minesweeper.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MinesweeperExceptionTest {

    @Test
    public void testExceptionMessage() {
        MinesweeperException exception = new MinesweeperException("Test message");
        assertEquals("Test message", exception.getMessage());
    }
}
