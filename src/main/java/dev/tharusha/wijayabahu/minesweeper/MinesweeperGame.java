/*
 * Minesweeper Game
 * Developer: Tharusha Wijayabahu
 * Website: https://www.tharushawijayabahu.dev/
 * LinkedIn: https://www.linkedin.com/in/tharusha-wijayabahu
 *
 * Copyright (c) 2024 Tharusha Wijayabahu
*/

package dev.tharusha.wijayabahu.minesweeper;

import dev.tharusha.wijayabahu.minesweeper.service.Game;
import dev.tharusha.wijayabahu.minesweeper.service.InputHandler;

import java.util.Scanner;

/**
 * Main class to start the Minesweeper game.
 */
public class MinesweeperGame {
    /**
     * Main method to start the Minesweeper game.
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        Game game = new Game(scanner, inputHandler);
        game.start();
    }
}