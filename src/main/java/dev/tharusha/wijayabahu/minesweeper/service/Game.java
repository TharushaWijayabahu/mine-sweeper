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
 * Manages the overall game flow for Minesweeper.
 */
public class Game {
    private Board board;
    private final Scanner scanner;
    private final InputHandler inputHandler;

    /**
     * Constructs a new Game with the given Scanner and InputHandler.
     *
     * @param scanner The Scanner to read user input
     * @param inputHandler The InputHandler to handle user input
     */
    public Game(Scanner scanner, InputHandler inputHandler) {
        this.scanner = scanner;
        this.inputHandler = inputHandler;
    }

    /**
     * Starts the Minesweeper game.
     */
    public void start() {
        System.out.println("Welcome to Minesweeper!");

        try {
            int size = inputHandler.getGridSize(scanner);
            int mines = inputHandler.getMineCount(scanner, size);

            board = new Board(size, mines);
            board.display();

            while (!board.isGameOver()) {
                try {
                    Coordinate coordinate = inputHandler.getCoordinate(scanner, size);
                    if (board.isCellRevealed(coordinate)) {
                        System.out.println("You already selected this cell. Please select a different square.");
                    } else {
                        board.revealCell(coordinate);
                    }
                    board.display();
                } catch (MinesweeperException e) {
                    System.out.println(e.getMessage());
                }
            }

            if (board.isWon()) {
                System.out.println("Congratulations, you have won the game!");
            } else {
                System.out.println("Oh no, you detonated a mine! Game over.");
            }

        } catch (MinesweeperException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}