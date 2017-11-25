/**
 * GameOfLife.java
 *
 * CSc 127B Spring 16 Author: Brian Loi Instructor: Rick Mercer
 * 
 * A model for John Conway's Game of Life. Simulates life, with cells that
 * follow specific rules. If a cell has over 3 neighboring cells, it dies. If it
 * has less than 2, it dies. If a cell has two or three neighbors, it survives,
 * and a new cell is born when there is exactly three neighboring cells.
 * 
 * The design (methods, parameters, return types) by Rick Mercer
 */
public class GameOfLife {

	// Initializes variables to hold the number of rows and columns
	int numOfRows = 0;
	int numOfCols = 0;
	// Initializes a boolean 2D array
	private boolean[][] society;

	/**
	 * A constructor that takes two integer arguments to represent the number of
	 * rows and columns in the game of life. It creates a society with no cells
	 * but space to store rows*cols cells.
	 *
	 * @param rows
	 *            The height of the grid that shows the cells.
	 * @param cols
	 *            The width of the grid that shows the cells.
	 */
	public GameOfLife(int rows, int cols) {

		// Sets the number of rows equal into a variable
		numOfRows = rows;
		numOfCols = cols;

		// Creates the 2D array with the lengths of the number of rows and
		// columns
		society = new boolean[rows][cols];

		// Iterates over the entire 2D array and makes every element false
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < cols; c++) {
				society[r][c] = false;
			}
	}

	/**
	 * Returns the number of rows, which can be indexed from
	 * 0..numberOfRows()-1.
	 *
	 * @return The height of the society.
	 */
	public int numberOfRows() {
		return numOfRows;
	}

	/**
	 * Returns the number of columns, which can be indexed from
	 * 0..numberOfColumns()-1.
	 *
	 * @return The height of the society.
	 */
	public int numberOfColumns() {
		return numOfCols;
	}

	/**
	 * Place a new cell in the society. Precondition: row and col are in range.
	 *
	 * @param row
	 *            The row to grow the cell.
	 * @param col
	 *            The column to grow the cell.
	 */
	public void growCellAt(int row, int col) {

		// grows a cell at the specified element by converting it to true
		society[row][col] = true;
	}

	/**
	 * Return true if there is a cell at the given row and column. Return false
	 * if there is none at the specified location.
	 * 
	 * @param row
	 *            The row to check.
	 * @param col
	 *            The column to check.
	 * @return True if there is a cell at the given row or false if there is not
	 */
	public boolean cellAt(int row, int col) {

		// If the element in the specified row and col is true, the method
		// will return true, and if not will return false
		if (society[row][col] == true) {
			return true;
		} else

			return false;
	}

	/**
	 * Return one big string of cells to represent the current state of the
	 * society of cells (see output below where '.' represents an empty space
	 * and 'O' is a live cell. There is no need to test toString. Simply use it
	 * to visually inspect if needed. Here is one sample output from toString:
	 *
	 *
	 * GameOfLife society = new GameOfLife(4, 14); society.growCellAt(1, 2);
	 * society.growCellAt(2, 3); society.growCellAt(3, 4);
	 * System.out.println(society.toString());
	 */
	// Output
	// ..............
	// ..O...........
	// ...O..........
	// ....O.........
	/**
	 * @return A textual representation of this society of cells.
	 */
	@Override
	public String toString() {

		// Initializes an empty string
		String dotSociety = "";
		// Initializes a variable that will count how many columns
		// are been accounted for
		int colCount;

		// Iterates over the entire 2D array
		for (int r = 0; r < numOfRows; r++) {
			// Sets count back to 0 each time the row changes
			colCount = 0;
			for (int c = 0; c < numOfCols; c++) {
				// If there is a cell at the element, a "O" is added to the
				// string
				if (society[r][c] == true)
					dotSociety = "" + dotSociety + "O";
				// if there is no cell at the element, a "." is added to the
				// string
				else
					dotSociety = "" + dotSociety + ".";

				// adds one to count for every column
				colCount++;
				// if the count reaches the number of columns, it is time to
				// move onto
				// the next row, so a new line is added to the string
				if (colCount == numOfCols)
					dotSociety = "" + dotSociety + "\n";
			}
		}
		return dotSociety;
	}

	/**
	 * Count the neighbors around the given location. Use wraparound. A cell in
	 * row 0 has neighbors in the last row if a cell is in the same column, or
	 * the column to the left or right. In this example, cell 0,5 has two
	 * neighbors in the last row, cell 2,8 has four neighbors, cell 2,0 has four
	 * neighbors, cell 1,0 has three neighbors. The cell at 3,8 has 3 neighbors.
	 * The potential location for a cell at 4,8 would have three neighbors.
	 */
	// .....O..O
	// O........
	// O.......O
	// O.......O
	// ....O.O..
	/**
	 * Returns the number of neighbors at a specific element in the 2D array
	 * 
	 * The return values should always be in the range of 0 through 8.
	 * 
	 * @return The number of neighbors around any cell using wrap around.
	 */
	public int neighborCount(int row, int col) {
		// Re-initializes neighborCount to 0
		int neighborCount = 0;
		// Creates variables that hold edge values in case of wrap around
		int wrapRow;
		int wrapCol;
		// Creates variables to holds values for the potential neighbors
		int tempRow;
		int tempCol;

		// Iterates around the entire element
		for (int r = -1; r < 2; r++) {
			for (int c = -1; c < 2; c++) {
				// Sets wrap variables to numbers that can be tested later
				wrapRow = -1;
				wrapCol = -1;
				// Sets the temp variables to the row and col parameters, in
				// case they do not get altered by wraparound.
				tempRow = row;
				tempCol = col;

				// Ensures that the cell itself is not considered a neighbor
				if (r == 0 && c == 0)
					continue;

				// If the row reaches over an edge in the 2D array when
				// searching
				// for a neighbor, wrap variables are set to rows/cols of the
				// opposite ends
				// Simulates the wraparound
				if (row + r == numOfRows)
					wrapRow = 0;
				else if (row + r == -1)
					wrapRow = numOfRows - 1;

				if (col + c == numOfCols)
					wrapCol = 0;
				else if (col + c == -1)
					wrapCol = numOfCols - 1;

				// Sets the temp variables to the neighboring elements
				tempRow = row + r;
				tempCol = col + c;

				// If the wrap variables were altered, the temp variables
				// are set to the wrap variables. (If wrap around occurred,
				// the temp variables become the wrap variables)
				if (wrapRow != -1)
					tempRow = wrapRow;

				if (wrapCol != -1)
					tempCol = wrapCol;

				// If the neighbor element has a cell, 1 is added onto
				// neighborCount
				if (society[tempRow][tempCol] == true)
					neighborCount++;
			}
		}

		return neighborCount;
	}

	/**
	 * Updates the state to represent the next society. Typically, some cells
	 * will die off while others are born.
	 */
	public void update() {

		// Creates a 2D array that represents the update
		boolean[][] temp = new boolean[numOfRows][numOfCols];

		// Iterates over the entire 2D array
		for (int r = 0; r < numOfRows; r++)
			for (int c = 0; c < numOfCols; c++) {
				// Rule: If an element has exactly 3 neighboring cells, a new
				// cell is
				// born at that element
				if (neighborCount(r, c) == 3 && society[r][c] == false)
					temp[r][c] = true;

				// Rule: If a cell has exactly 2 or 3 neighboring cells, it
				// lives
				if ((neighborCount(r, c) == 2 || neighborCount(r, c) == 3) && society[r][c] == true)
					temp[r][c] = true;
				
				//If a cell is alive, it might die if...
				if (society[r][c] == true)
				{
					//Rule: If a cell has over 3 neighbors, it dies
					if (neighborCount(r,c) > 3)
						temp[r][c] = false;
					
					//Rule: If a cell has less than 2 neighbors, it dies
					if (neighborCount(r,c) < 2)
						temp[r][c] = false;
				}
			}

		// The current society becomes the next society, or update
		society = temp;
	}
} // End class GameOfLife