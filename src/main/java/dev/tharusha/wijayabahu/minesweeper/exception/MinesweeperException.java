/*
 * Minesweeper Game
 * Developer: Tharusha Wijayabahu
 * Website: https://www.tharushawijayabahu.dev/
 * LinkedIn: https://www.linkedin.com/in/tharusha-wijayabahu
 *
 * Copyright (c) 2024 Tharusha Wijayabahu
 */
package dev.tharusha.wijayabahu.minesweeper.exception;

/**
 * Custom exception class for business logic errors in Minesweeper.
 */
public class MinesweeperException extends RuntimeException{
    /**
     * Constructs a new BusinessException with the specified detail message.
     *
     * @param message The detail message
     */
    public MinesweeperException(String message) {
        super(message);
    }
}
