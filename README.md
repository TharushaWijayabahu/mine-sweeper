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

## Rules
- You may NOT use any external libraries that directly solve this problem, but you may use external libraries or tools for building or testing purposes. Specifically, you may use unit-testing libraries or build tools available for your chosen language (e.g., JUnit, NUnit, etc.).
- You should NOT include any executable attachments, including those with .exe or .lib extensions. System security is very important to us and certain file extensions will be blocked for security purposes, resulting in delays to your application. We need to be able to run and build your code ourselves, so please submit your code as a zipped file of source code and supporting files, without any compiled code. If you're submitting in C#, please do not submit your code as a .msi file.
- Please include a brief explanation of your design and assumptions, along with your code, as well as detailed instructions to run your application. Also include the environment required to run the application, e.g., Windows, Linux.
- We assess a number of things including your application code design, your tests, and general readability. While these are relatively small problems, we expect you to submit what you believe is production-quality code; code that you'd be able to run, maintain, and evolve. You don't need to gold plate your solution, however, we are looking for something more than a bare-bones algorithm.

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

### Steps
1. **Clone the Repository:**
    ```bash
    git clone https://github.com/TharushaWijayabahu/mine-sweeper.git
    cd minesweeper
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