import java.util.Random;
import java.util.Stack;

/**
 * This class represents the model for a game of MineSweeper. It has a
 * constructor that takes a preset boolean 2D array where true means there is a
 * mine. This first constructor (you'll need 2) is for testing the methods of
 * this class.
 * 
 * The second constructor that takes the number of rows, the number of columns,
 * and the number of mines to be set randomly in that sized mine field. Do this
 * last.
 * 
 * @author Brian Loi
 */
public class MineSweeper implements MineSweeperModel {

	private class GameSquare {

		private boolean isMine;
		private int row;
		private int col;
		private boolean isVisible;
		private boolean isFlagged;
		private int mineNeighbors;

		// Construct a GameSquare object with all values initialized except
		// mineNeighbors, which is an instance variables that can only be set
		// after
		// all
		// GameSquare objects have been constructed in the 2D array.
		public GameSquare(boolean isMine, int row, int col) {
			this.isMine = isMine;
			this.row = row;
			this.col = col;
			isVisible = false; // Default until someone starts clicking
			isFlagged = false; // Default until someone starts clicking
			// call setAdjacentMines() from both constructors
			// to set this for each new GameSquare.
			mineNeighbors = 0;
		}
	}

	// The instance variable represents all GameSquare objects where each knows
	// its row,
	// column, number of mines around it, if it is a mine, flagged, or visible
	private GameSquare[][] board;

	// Initializes an int representing when the game is lost
	private int gameLoss = 0;

	/**
	 * Construct a MineSweeper object using a given mine field represented by an
	 * array of boolean values: true means there is mine, false means there is
	 * not a mine at that location.
	 * 
	 * @param mines
	 *            A 2D array to represent a mine field so all methods can be
	 *            tested with no random placements.
	 */
	public MineSweeper(boolean[][] mines) {
		// Complete this constructor first so you can test preset mine
		// fields
		// (later on you will need to write another constructor for random
		// boards).
		// new GameSquare objects store all info about one square on the board
		// such
		// as its row, column, if it's flagged, visible, or is a mine.

		board = new GameSquare[mines.length][mines[0].length];

		// Example construction of one GameSquare stored in row 2, column 4:
		// /// board[2][4] = new GameSquare(mines[2][4], 2, 4);
		// Use a nested for loop to change all board array elements
		// from null to a new GameSquare

		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[0].length; col++) {
				board[row][col] = new GameSquare(mines[row][col], row, col);
			}

		// You will need to call private void setAdjacentMines() to set
		// mineNeighbors for all GameSquare objects because each GameSquare
		// object
		// must first know if it is a mine or not. Set mineNeighbors for each.
		setAdjacentMines();
	}

	/**
	 * Use the almost initialized 2D array of GameSquare objects to set the
	 * instance variable mineNeighbors for every 2D array element (even if that
	 * one GameSquare has a mine). This is similar to GameOfLife neighborCount.
	 */
	private void setAdjacentMines() {
		// Example to set the instance variable mineNeighbors of the one
		// GameSquare
		// object stored in row 2, column 4 to 8:
		///// board[2][4].mineNeighbors = 8;
		// Use a nested for loop to set mineNeighbors for ALL GameSquare objects

		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				board[i][j].mineNeighbors = 3;
			}
	}

	/**
	 * This method returns the number of mines surrounding the requested
	 * GameSquare (the mineNeighbors value of the square). A square with a mine
	 * may return the number of surrounding mines, even though it will never
	 * display that information.
	 * 
	 * @param row
	 *            - An int value representing the row in board.
	 * @param column
	 *            - An int value representing the column in board.
	 * @return The number of mines surrounding to this GameSquare
	 *         (mineNeighbors)
	 * 
	 *         Must run O(1)
	 */
	public int getAdjacentMines(int row, int column) {

		// Re-initializes neighborCount to 0
		int neighborCount = 0;
		// Creates variables to holds values for the potential neighbors
		int tempRow;
		int tempCol;

		// Iterates around the entire GameSquare
		for (int r = -1; r < 2; r++) {
			for (int c = -1; c < 2; c++) {

				// Ensures that the GameSquare itself is not considered a
				// neighbor
				if (r == 0 && c == 0)
					continue;

				// If the row or column reaches over an edge in the 2D array
				// when
				// searching
				// for a neighbor, continue;
				if (row + r == board.length)
					continue;
				else if (row + r == -1)
					continue;

				if (column + c == board[0].length)
					continue;
				else if (column + c == -1)
					continue;

				// Sets the temp variables to the neighboring squares
				tempRow = row + r;
				tempCol = column + c;

				// If the neighbor element is a mine, 1 is added onto
				// neighborCount
				if (board[tempRow][tempCol].isMine == true)
					neighborCount++;
			}
		}

		board[row][column].mineNeighbors = neighborCount;

		return neighborCount;
	}

	/**
	 * Construct a MineSweeper of any size that has numberOfMines randomly set
	 * so we get different games.
	 * 
	 * @param rows
	 *            Height of the board
	 * @param columns
	 *            Width of the board
	 * @param numberOfMines
	 *            How m any mines are to randomly placed
	 */
	public MineSweeper(int rows, int columns, int numberOfMines) {

		board = new GameSquare[rows][columns];
		Random generator = new Random();
		int r = generator.nextInt(rows);
		int c = generator.nextInt(columns);
		int mineCount = 0;

		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[0].length; col++) {
				board[row][col] = new GameSquare(false, row, col);
			}

		// While there are more mines to add
		while (mineCount != numberOfMines) {
			// Sets random ints
			r = generator.nextInt(rows);
			c = generator.nextInt(columns);

			// Prevents mines from becoming mines
			if (board[r][c].isMine == true)
				continue;
			else {
				board[r][c].isMine = true;
				mineCount++;
			}

		}

		// Complete this constructor after all other methods
		//
		// Consider using class Random with its nextInt(int) method
		//
		// Random generator = new Random();
		// int r = generator(rows);
		// assertTrue(r >= 0 && r < rows);
	}

	/**
	 * This method returns the number of mines found in the game board.
	 * 
	 * @return The number of mines.
	 */
	public int getTotalMineCount() {

		// Initialize int to hold number of mines
		int mineCount = 0;

		// Iterates over the entire grid, if a mine is found, add one to
		// mineCount
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].isMine == true)
					mineCount++;
			}
		return mineCount;
	}

	/**
	 * This method returned whether or not the square has been flagged by the
	 * user. Flags are a tool used by players to quickly tell which squares they
	 * think contain mines as well as prevent accidental clicking on those
	 * squares.
	 * 
	 * @param row
	 *            - An int value representing the row (x) value in the game
	 *            board.
	 * @param column
	 *            - An int value representing the column (y) value in the game
	 *            board.
	 * @return A boolean value representing the flagged state of this location.
	 */
	public boolean isFlagged(int row, int column) {

		if (board[row][column].isFlagged == true)
			return true;
		else
			return false;
	}

	// Changes a flagged square to unflagged, and an unflagged square to flagged
	public void toggleFlagged(int row, int column) {

		// If a square is flagged, it becomes false, else it becomes flagged
		if (board[row][column].isFlagged == true) {
			board[row][column].isFlagged = false;
		} else
			board[row][column].isFlagged = true;
	}

	/**
	 * This method determines if the square in question is a mine.
	 * 
	 * @param row
	 *            - An int value representing the row (x) value in the game
	 *            board.
	 * @param column
	 *            - An int value representing the column (y) value in the game
	 *            board.
	 * @return A boolean representing the mine status of the square.
	 */
	public boolean isMine(int row, int column) {

		if (board[row][column].isMine == true)
			return true;
		else
			return false;
	}

	/**
	 * This method gets the visibility of the square in question. Visibilty is
	 * initially defined for all squares to be false and uncovered when the
	 * click method checks the square.
	 * 
	 * @param row
	 *            - An int value representing the row (x) value in the game
	 *            board.
	 * @param column
	 *            - An int value representing the column (y) value in the game
	 *            board.
	 * @return A boolean representing whether or not the square is set to be
	 *         visible.
	 */
	public boolean isVisible(int row, int column) {

		if (board[row][column].isVisible == true)
			return true;
		else
			return false;
	}

	/**
	 * This method determines if the player has lost on the current board. A
	 * player loses if and only if they have clicked on a mine.
	 * 
	 * @return A boolean representing player failure.
	 */
	public boolean lost() {
		// If the int representing if the game is lost = 1, return true, else
		// false
		if (gameLoss == 1)
			return true;
		else
			return false;
	}

	/**
	 * Returns a textual representation of the GameBoard.
	 * 
	 * @return A String representation of the game board data.
	 */
	public String toString() {

		String str = "";

		// Iterates over the entire grid and adds the booleans of the squares to
		// a string
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (board[r][c].isMine == true)
					str = "" + str + "true ";
				if (board[r][c].isMine == false)
					str = "" + str + "false ";
			}
			if (board.length - 1 != r)
				str = "" + str + '\n';
		}

		return str;
	}

	/**
	 * This method determines if a player has won the game. Winning means all
	 * non-mine squares are visible and no mines have been detonated.
	 * 
	 * @return A boolean representing whether or not the player has won.
	 */
	public boolean won() {

		// Iterates over the entire grid
		// If a square is not visible and not a mine, return false, else true
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].isVisible == false && board[i][j].isMine == false)
					return false;
			}

		return true;
	}

	/**
	 * This method alerts the Game Board the user has clicked on the square at
	 * the given row/column. There are five possibilities for updating the board
	 * during the click messages to your MineSweeper. The GameSquare object
	 * stored at the just clicked row and column
	 * 
	 * 1. is flagged (do nothing)
	 * 
	 * 2. is a mine (player loses)
	 * 
	 * 3. is visible already (do nothing)
	 * 
	 * 4. has mineNeighbors >- 1 (simply mark that visible)
	 * 
	 * 5. is not adjacent to any mines with mineNeighbors == 0 (mark many
	 * visible)
	 * 
	 * Because MineSweeper automatically clears all squares adjacent to any
	 * blank square connected to the square clicked, a special algorithm is
	 * needed to set the proper part of the board visible. This pseudo-code
	 * shows the suggested algorithm.
	 */
	// Check special cases first, there may be little or nothing to do
	// if the clicked GameSquare is flagged or visible
	// return // nothing to do
	// else if the clicked GameSquare is a mine
	// record loss
	// else if the clicked GameSquare has 1 or more neighboring mines
	// set the square to be visible // Clear only the clicked GameSquare when it
	// is numbered 1..8
	// else
	// // Clear all possible GameSquares up to the border or until GameSquares
	// with numbers 1..8 are found
	// create a new stack
	// mark the ClickedSquare as visible
	// push the GameSquare onto a stack
	// while the stack is not empty:
	// pop the stack and mark square as the current square
	// if the current square must has no neighboring mines (not 1..8)
	// for each adjacent square
	// if it's not visible and not flagged
	// push adjacent GameSquare on stack and change isVisible to true
	/**
	 * @param row
	 *            - An int value representing the row (x) value in the game
	 *            board.
	 * @param column
	 *            - An int value representing the column (y) value in the game
	 *            board.
	 */
	public void click(int row, int column) {

		// Sets the game to not a loss
		gameLoss = 0;

		// Case: If a mine is clicked, record loss by changing gameLoss to 1 and
		// calling lost()
		if (board[row][column].isMine == true) {
			gameLoss = 1;
			lost();
			return;
		} else
		// Special Case: GameSquare is flagged or visible, do nothing
		if (board[row][column].isFlagged == true) {
			return;
		}

		if (board[row][column].isVisible == true)
			return;

		// Case: If GameSquare has 1 or more neighboring neighboring mines,
		// set the square to be visible and do nothing else if that square's
		// neighbor count is 1-8

		if (getAdjacentMines(row, column) > 0) {
			board[row][column].isVisible = true;
			return;
		}

		// Else if that squares, neighborCount is 0, spread until numbers appear
		Stack<Object> myStack = new Stack<Object>();
		board[row][column].isVisible = true;
		myStack.push(board[row][column]);
		while (myStack.isEmpty() != true) {
			// Marks the square as the currentSquare
			GameSquare currentSquare = (GameSquare) myStack.peek();
			// Gets the row and column of the current square
			int currentRow = currentSquare.row;
			int currentCol = currentSquare.col;
			myStack.pop();
			board[currentRow][currentCol].isVisible = true;
			if (getAdjacentMines(currentRow, currentCol) == 0) {
				int tempRow;
				int tempCol;
				// Iterates over the adjacent squares
				for (int r = -1; r < 2; r++) {
					for (int c = -1; c < 2; c++) {

						// Does not include the current square itself
						if (r == 0 && c == 0)
							continue;

						// Prevents array out of bounds
						if (currentRow + r == board.length)
							continue;
						else if (currentRow + r == -1)
							continue;

						// Prevents array out of bounds
						if (currentCol + c == board[0].length)
							continue;
						else if (currentCol + c == -1)
							continue;

						tempRow = currentRow + r;
						tempCol = currentCol + c;

						// If the adj square is not flagged or visible, push the
						// square onto the stack and make it visible
						if (board[tempRow][tempCol].isFlagged == false && board[tempRow][tempCol].isVisible == false) {
							myStack.push(board[tempRow][tempCol]);
							board[tempRow][tempCol].isVisible = true;
						}

						// Recursion: NOT ALLOWED!
						// if (getAdjacentMines(tempRow, tempCol) == 0)
						// click(tempRow, tempCol);
					}
				}
			}
		}
	}
}