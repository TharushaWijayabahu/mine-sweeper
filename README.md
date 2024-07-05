---

# Minesweeper Game

## Overview
This project is a command-line implementation of the classic Minesweeper game. The game prompts the user to enter the grid size and the number of mines. The game then randomly places the mines on the grid and allows the user to uncover squares one at a time. The game displays the minefield after each user input, tracking the user's progress. The game ends when the user uncovers a mine (loses) or uncovers all non-mine squares (wins).

## Features
- Customizable grid size and number of mines.
- Random placement of mines on the grid.
- User input to uncover squares.
- Automatic uncovering of adjacent squares with no mines.
- Game ends when a mine is uncovered or all non-mine squares are uncovered.
- Displays the minefield after each user input.

## Design and Assumptions
- The grid size must be between 2x2 and 10x10.
- The number of mines must be at least 1 and at most 35% of the total grid squares.
- The game runs in a command-line interface.
- User inputs are validated for correctness.
- The grid is displayed after each user input to show the current state of the game.

## How to Run
### Requirements
- Java Development Kit (JDK) 11 or higher
- Maven
- Platform: Platform-independent (Windows, Linux, macOS)

### Steps
1. **Clone the Repository:**
    ```bash
    git clone https://github.com/TharushaWijayabahu/mine-sweeper.git
    cd mine-sweeper
    ```

2. **Build the Project:**
    ```bash
    mvn clean install
    ```

3. **Run the Application:**
    ```bash
    mvn exec:java -Dexec.mainClass="dev.tharusha.wijayabahu.minesweeper.MinesweeperGame"
    ```

### Running Tests
To run the tests, use the following command:
```bash
mvn test
```

## Classes and Responsibilities
### `MinesweeperGame`
- The main class that starts the game.

### `Game`
- Manages the overall game flow.
- Interacts with the user for inputs.
- Displays the game grid after each move.

### `Board`
- Represents the game board.
- Handles mine placement and cell revealing logic.

### `InputHandler`
- Handles and validates user inputs.

### `Cell`
- Represents a single cell on the board.

### `Coordinate`
- Represents the coordinates of a cell on the board.

### `MinesweeperException`
- Custom exception class for handling invalid inputs and other game-related exceptions.

## Example Gameplay
```
Welcome to Minesweeper!

Enter the size of the grid (e.g., 4 for a 4x4 grid): 
4
Enter the number of mines to place on the grid (maximum is 35% of the total squares): 
3

Here is your minefield:
  1 2 3 4
A _ _ _ _
B _ _ _ _
C _ _ _ _
D _ _ _ _

Select a square to reveal (e.g., A1): A1
This square contains 0 adjacent mines.

Here is your updated minefield:
  1 2 3 4
A 0 _ _ _
B 0 _ _ _
C 0 _ _ _
D 0 _ _ _

Select a square to reveal (e.g., A1): B2
This square contains 1 adjacent mine.

Here is your updated minefield:
  1 2 3 4
A 0 1 _ _
B 0 1 _ _
C 0 1 _ _
D 0 1 _ _

Select a square to reveal (e.g., A1): A1
You already selected this cell. Please select a different square.

Here is your updated minefield:
  1 2 3 4
A 0 1 _ _
B 0 1 _ _
C 0 1 _ _
D 0 1 _ _
```

## Contact
For any questions or issues, please contact the developer:
- Name: Tharusha Wijayabahu
- Website: [tharushawijayabahu.dev](https://www.tharushawijayabahu.dev/)
- LinkedIn: [Tharusha Wijayabahu](https://www.linkedin.com/in/tharusha-wijayabahu)

---
