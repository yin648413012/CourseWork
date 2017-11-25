
/*MatrixTest.Java
 * 
 * Author: Brian Loi
 * 
 * A unit test for class Matrix
 * 
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class MatrixTest {

//Tests the rows number and columns number and testes if get works
  @Test
  public void FailedTestingRowsAndColumnsAndGet() {
    int[][] a1 = { { 1, 2, 3 }, { -1, -2, -3 } }; // two rows, three columns

    int[][] a2 = { { 4, 5 }, { 6, 7 }, { 8, 9 } }; // three rows, two columns

    Matrix m1 = new Matrix(a1);
    Matrix m2 = new Matrix(a2);

    // Test m1
    assertEquals(2, m1.rows());
    assertEquals(3, m1.columns());
    assertEquals(1, m1.get(0, 0));
    assertEquals(2, m1.get(0, 1));
    assertEquals(3, m1.get(0, 2));
    assertEquals(-1, m1.get(1, 0));
    assertEquals(-2, m1.get(1, 1));
    assertEquals(-3, m1.get(1, 2));

    // Test m2
    assertEquals(3, m2.rows());
    assertEquals(2, m2.columns());
    assertEquals(4, m2.get(0, 0));
    assertEquals(5, m2.get(0, 1));
    assertEquals(6, m2.get(1, 0));
    assertEquals(7, m2.get(1, 1));
    assertEquals(8, m2.get(2, 0));
    assertEquals(9, m2.get(2, 1));

  }

//Tests if the Add method works
  @Test
  public void FailedTestingAdd() {
    int[][] a1 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
    Matrix a = new Matrix(a1);

    int[][] a2 = { { -2, 2, -2, 2 }, { 4, -4, 4, -4 } };
    Matrix b = new Matrix(a2);

    Matrix c = a.add(b);

    // Check all elements
    assertEquals(-1, c.get(0, 0));
    assertEquals(4, c.get(0, 1));
    assertEquals(1, c.get(0, 2));
    assertEquals(6, c.get(0, 3));
    assertEquals(9, c.get(1, 0));
    assertEquals(2, c.get(1, 1));
    assertEquals(11, c.get(1, 2));
    assertEquals(4, c.get(1, 3));
  }

 //Tests if the Add method works
  @Test
  public void failedTestingAdd() {
    int[][] a1 = { { 14, 9, 3 }, { 2, 11, 15 }, { 5, 2, 3 } };
    Matrix a = new Matrix(a1);

    int[][] a2 = { { 12, 2, 5 }, { 9, 10, 1 }, { 8, 5, -9 } };
    Matrix b = new Matrix(a2);

    Matrix c = a.add(b);
    assertEquals(26, c.get(0, 0));
    assertEquals(11, c.get(0, 1));
    assertEquals(8, c.get(0, 2));
    assertEquals(11, c.get(1, 0));
    assertEquals(21, c.get(1, 1));
    assertEquals(16, c.get(1, 2));
    assertEquals(13, c.get(2, 0));
    assertEquals(7, c.get(2, 1));
    assertEquals(-6, c.get(2, 2));
  }
  
//Multiply every element in this matrix by factor
//1 2 3  scalarMultiply(2)   ->  2 4 6
//4 5 6                      ->  8 10 12
  @Test
  public void scalarMultiply(){
	  
	  int[][] a1 = {{1,2,3},{4,5,6}};
	    Matrix a = new Matrix(a1);
	    
	  a.scalarMultiply(2);
	    
	  assertEquals(2, a.get(0, 0));
	  assertEquals(4, a.get(0,1));
	  assertEquals(6, a.get(0, 2));
	  assertEquals(8, a.get(1,0));
	  assertEquals(10, a.get(1, 1));
	  assertEquals(12, a.get(1, 2));
	  
  }
  
//Multiply every element in this matrix by factor
//2 4 7  scalarMultiply(5)   ->  10 20 35
//1 3 8                      ->  5 15 40
  @Test
  public void scalarMultiplyTest(){
	  
	  int[][] a1 = {{2,4,7},{1,3,8}};
	    Matrix a = new Matrix(a1);
	    
	  a.scalarMultiply(5);
	    
	  assertEquals(10, a.get(0, 0));
	  assertEquals(20, a.get(0,1));
	  assertEquals(35, a.get(0, 2));
	  assertEquals(5, a.get(1,0));
	  assertEquals(15, a.get(1, 1));
	  assertEquals(40, a.get(1, 2));
	  
  }
  
//Return the sum of all integers in this Matrix  
//1 2 3  sumOfAllElements() returns 1+2+3+4+5+6 = 21
//4 5 6              
  @Test
  public void sumOfAllElements(){
	  
	  int[][] a1 = {{1,2,3},{4,5,6}};
	  	Matrix a = new Matrix(a1);
	  
	  assertEquals(21,a.sumOfAllElements());
	  
  }
  
//Return the sum of all integers in this Matrix  
//5 3 7  sumOfAllElements() returns 5+3+7+1+9+8 = 33
//1 9 8              
  @Test
  public void sumOfAllElementsTest(){
	  
	  int[][] a1 = {{5,3,7},{1,9,8}};
	  	Matrix a = new Matrix(a1);
	  
	  assertEquals(33,a.sumOfAllElements());
	  
  }
 
//Change this Matrix to its transpose. Explained at https://en.wikipedia.org/wiki/Transpose
//1 2 3  transpose()   ->  1 4 
//4 5 6                ->  2 5 
//                     ->  3 6
//The rows become the columns.
//Don't forget to swap rows and columns.
  @Test
  public void transpose() {
	  int[][] a1 = {{1,2,3},{4,5,6}};
	  	Matrix a = new Matrix(a1);
	  
	  a.transpose();
	  	
	  assertEquals(1, a.get(0, 0));
	  assertEquals(4, a.get(0,1));
	  assertEquals(2, a.get(1, 0));
	  assertEquals(5, a.get(1, 1));
	  assertEquals(3, a.get(2, 0));
	  assertEquals(6, a.get(2, 1));
  }

//Change this Matrix to its transpose. Explained at https://en.wikipedia.org/wiki/Transpose
//8 2 9  transpose()   ->  8 1 
//1 3 4                ->  2 3 
//                     ->  9 4
//The rows become the columns.
//Don't forget to swap rows and columns.
  @Test
  public void transposeTest() {
	  int[][] a1 = {{8,2,9},{1,3,4}};
	  	Matrix a = new Matrix(a1);
	  
	  a.transpose();
	  	
	  assertEquals(8, a.get(0, 0));
	  assertEquals(1, a.get(0,1));
	  assertEquals(2, a.get(1, 0));
	  assertEquals(3, a.get(1, 1));
	  assertEquals(9, a.get(2, 0));
	  assertEquals(4, a.get(2, 1));
  }
  
}