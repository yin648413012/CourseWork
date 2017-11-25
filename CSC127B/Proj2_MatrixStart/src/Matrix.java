/*Matrix.java
 * 
 * Author: Brian Loi
 * 
 * Creates a matrix object which can be mathematically and dimensionally
 * transformed through methods, such as transposing, multiplying elements
 * within the matrix, and attaining the sum of all the elements in the matrix.
 * 
 */
public class Matrix {

//Creates a 2D Array
  private int[][] t = null;
  int rows, cols;

//Creates an object, a matrix, with the 2D array named t
  public Matrix(int[][] table) {
    rows = table.length;
    cols = table[0].length;

    t = new int[table.length][table[0].length];

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        t[r][c] = table[r][c];
      }
    }
  }

//Gets rows (the number of rows)
  public int rows() {
    return rows;
  }

//Gets cols (the number of columns)
  public int columns() {
    return cols;
  }

//gets an element within the 2D Array
  public int get(int row, int column) {
    return t[row][column];
  }

//Adds the elements in two different matrices together and 
//places the value in a new matrix object in the elements' place.
//Returns the matrix (with added values)
  public Matrix add(Matrix b) {
    int[][] temp = new int[rows][cols];
    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < cols; c++) {
        temp[r][c] += this.get(r, c) + b.get(r, c);
      }
    }
    return new Matrix(temp);
  }
  
//Multiply every element in this matrix by factor
//1 2 3  scalarMultiply(2)   ->  2 4 6
//4 5 6                      ->  8 10 12
	public void scalarMultiply(int factor){
		
		//Iterates over the entire matrix
		for (int r = 0; r<rows; r++)
			for (int c = 0; c<cols; c++)
			{
				//Multiplies each element by the factor and stores it in its place
				t[r][c] = t[r][c] * factor;
			}

	}
	  
//Return the sum of all integers in this Matrix  
//1 2 3  sumOfAllElements() returns 1+2+3+4+5+6 = 21
//4 5 6                      
	public int sumOfAllElements(){
		
		//creates an int to hold the sum of the elements
		int sum = 0;
		
		for (int r = 0; r<rows; r++)
			for (int c = 0; c<cols; c++)
			{
				//Sum is continuously added onto for each element
				sum = sum + t[r][c];
			}
		
		return sum;
	}
	 
//Change this Matrix to its transpose. Explained at https://en.wikipedia.org/wiki/Transpose
//1 2 3  transpose()   ->  1 4 
//4 5 6                ->  2 5 
//                     ->  3 6
//The rows become the columns.
//Don't forget to swap rows and columns.
	public void transpose(){
		
		//creates a temporary matrix, in which the number of columns and rows are swapped
		int[][] temp = new int [cols][rows];
		
		//iterates over the entire matrix
		for (int r = 0; r<rows; r++)
			for (int c = 0; c<cols; c++)
			{
				temp[c][r] = t[r][c];
			}
		
		//Modifies the original matrix to become the temporary matrix with the correct dimensions
		t = temp;
		
		//Swaps the variables rows and cols for test casing
		int hold = cols;
		cols = rows;
		rows = hold;
		
	}

 
	
}