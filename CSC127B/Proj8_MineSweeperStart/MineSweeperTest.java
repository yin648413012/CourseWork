/**
 * The beginning of a unit test for MineSweeper.
 * @author: Brian Loi
 */
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MineSweeperTest {

  @Test
  public void testGetAdjacentMinesWithAGivenTwodArrayOfBooleans() {

    boolean[][] b1 =

    { { false, false, false, false, false },
      { false, false, true,  true,  false },
      { false, false, false, true,  false }, };

    // Use the non-random constructor when testing to avoid random mine placement.
    MineSweeper ms = new MineSweeper(b1);

    // Check adjacent mines around every possible GameSquare
    assertEquals(0, ms.getAdjacentMines(0, 0));
    assertEquals(1, ms.getAdjacentMines(0, 1));
    assertEquals(2, ms.getAdjacentMines(0, 2));
    assertEquals(2, ms.getAdjacentMines(0, 3));
    assertEquals(1, ms.getAdjacentMines(0, 4));

    assertEquals(0, ms.getAdjacentMines(1, 0));
    assertEquals(1, ms.getAdjacentMines(1, 1));
    assertEquals(2, ms.getAdjacentMines(1, 2)); // works even if it is a mine
    assertEquals(2, ms.getAdjacentMines(1, 3));
    assertEquals(2, ms.getAdjacentMines(1, 4));

    assertEquals(0, ms.getAdjacentMines(2, 0));
    assertEquals(1, ms.getAdjacentMines(2, 1));
    assertEquals(3, ms.getAdjacentMines(2, 2));
    assertEquals(2, ms.getAdjacentMines(2, 3));
    assertEquals(2, ms.getAdjacentMines(2, 4));
  }
  
  //Tests the flag features
  @Test
  public void testFlagToggleAndIsFlagged() {
	  boolean[][] b1 =

		    { { false, false, false, false, false },
		      { false, false, true,  true,  false },
		      { false, false, false, true,  false }, };

	 MineSweeper ms = new MineSweeper(b1);
	 assertEquals(false, ms.isFlagged(0, 0));
	 ms.toggleFlagged(0, 0);
	 assertEquals(true, ms.isFlagged(0, 0));
	 ms.toggleFlagged(0, 0);
	 assertEquals(false, ms.isFlagged(0, 0));
  }
  
  //Tests the getAdjacentMines method
  @Test
  public void testGetAdjMines() {
	  boolean[][] b1 =

		    { { false, false, false, false, false },
		      { false, false, true,  true,  false },
		      { false, false, false, true,  false }, };

	 MineSweeper ms = new MineSweeper(b1);
	 assertEquals(3, ms.getAdjacentMines(2,2));
	 assertEquals(1, ms.getAdjacentMines(0,1));
	 assertEquals(2, ms.getAdjacentMines(0, 3));
	 assertEquals(0, ms.getAdjacentMines(1, 0));
  }
  
  //Tests the random MineSweeper Constructor and To string method
  @Test
  public void testMineSweeperRandomAndToString(){
	  MineSweeper ms = new MineSweeper(1,1,0);
	  assertEquals("false ", ms.toString());
	  
	  MineSweeper ms2 = new MineSweeper(1,2,0);
	  assertEquals("false false ", ms2.toString());
	  
	  MineSweeper ms3 = new MineSweeper(2,3,0);
	  assertEquals("false false false "
	  		+ "\n" + "false false false ", ms3.toString());
	  
	  MineSweeper ms4 = new MineSweeper(1,1,1);
	  assertEquals("true ", ms4.toString());
	  
	  MineSweeper ms5 = new MineSweeper(1,2,2);
	  assertEquals("true true ", ms5.toString());
  }
  
  //Tests the getTotalMineCount method
  @Test
  public void testGetTotalMineCount() {
	  MineSweeper ms = new MineSweeper(12,16,7);
	  assertEquals(7, ms.getTotalMineCount());
	  
	  MineSweeper ms2 = new MineSweeper(230,96,43);
	  assertEquals(43, ms2.getTotalMineCount());
	  
	  MineSweeper ms3 = new MineSweeper(124, 245, 78);
	  assertEquals(78, ms3.getTotalMineCount());
	  
	  MineSweeper ms4 = new MineSweeper(46,57,17);
	  assertEquals(17, ms4.getTotalMineCount());
  }
  
  //Tests the win method and click method
  @Test
  public void testWin() {
	  boolean[][] b1 =

		    { { false, false, false, false, false },
		      { false, false, true,  true,  false },
		      { false, false, false, true,  false }, };

	 MineSweeper ms = new MineSweeper(b1);
	 ms.click(0, 0);
	 ms.click(0, 2);
	 assertEquals(false, ms.won());
	 ms.click(0, 3);
	 ms.click(0, 4);
	 assertEquals(false, ms.won());
	 ms.click(1, 4);
	 ms.click(2, 4);
	 assertEquals(false, ms.won());
	 ms.click(2, 2);
	 assertEquals(true, ms.won());
  }
  
  //Tests the lose method
  @Test
  public void testLose() {
	  boolean[][] b1 =

		    { { false, false, false, false, false },
		      { false, false, true,  true,  false },
		      { false, false, false, true,  false }, };

	 MineSweeper ms = new MineSweeper(b1);
	 ms.click(0, 0);
	 assertEquals(false, ms.lost());
	 ms.click(1, 2);
	 assertEquals(true, ms.lost());
  }
  
  //Tests the isMine method
  @Test
  public void testIsMine() {
	  boolean[][] b1 =

		    { { false, false, false, false, false },
		      { false, false, true,  true,  false },
		      { false, false, false, true,  false }, };

	 MineSweeper ms = new MineSweeper(b1);
	 assertEquals(true, ms.isMine(1, 2));
	 assertEquals(true, ms.isMine(1, 3));
	 assertEquals(true, ms.isMine(2, 3));
	 assertEquals(false, ms.isMine(1, 1));
	 assertEquals(false, ms.isMine(2, 2));
	 assertEquals(false, ms.isMine(2, 4));
	 assertEquals(false, ms.isMine(0, 2));
  }
  
  //Tests the isVisible method and click method
  @Test
  public void testIsVisible() {
	  boolean[][] b1 =

		    { { false, false, false, false, false },
		      { false, false, true,  true,  false },
		      { false, false, false, true,  false }, };

	 MineSweeper ms = new MineSweeper(b1);
	 assertEquals(false, ms.isVisible(0, 0));
	 ms.click(0, 0);
	 assertEquals(true, ms.isVisible(0, 0));
	 assertEquals(true, ms.isVisible(1, 0));
	 assertEquals(true, ms.isVisible(2, 0));
	 assertEquals(true, ms.isVisible(0, 1));
	 assertEquals(true, ms.isVisible(1, 1));
	 assertEquals(true, ms.isVisible(2, 1));
	 ms.click(0, 3);
	 assertEquals(false, ms.isVisible(1, 3)); //bomb
	 assertEquals(false, ms.isVisible(1, 2)); //bomb
	 assertEquals(true, ms.isVisible(0, 3));
	 assertEquals(false, ms.isVisible(0, 4));
	 assertEquals(false, ms.isVisible(1, 4));
	 assertEquals(false, ms.isVisible(0, 2));
	 ms.click(0, 4);
	 assertEquals(true, ms.isVisible(0, 4));
	 ms.click(1, 4);
	 assertEquals(true, ms.isVisible(1, 4));
  }
  
  //Tests the click method when clicking a flagged square
  @Test
  public void testClickWhenFlagged() {
	  boolean[][] b1 =

		    { { false, false, false, false, false },
		      { false, false, true,  true,  false },
		      { false, false, false, true,  false }, };

	 MineSweeper ms = new MineSweeper(b1);
	 ms.toggleFlagged(0, 0);
	 ms.click(0, 0);
	 assertEquals(true, ms.isFlagged(0, 0));
	 assertEquals(false, ms.isVisible(0, 0));
	 
	 ms.toggleFlagged(1, 3);
	 ms.click(1, 3);
	 assertEquals(true, ms.isFlagged(1, 3));
	 assertEquals(false, ms.isVisible(1, 3));
  }
  
  //Tests the click method when clicking a visible square
  @Test
  public void testClickWhenVisible() {
	  boolean[][] b1 =

		    { { false, false, false, false, false },
		      { false, false, true,  true,  false },
		      { false, false, false, true,  false }, };

	 MineSweeper ms = new MineSweeper(b1);
	 ms.click(0, 0);
	 assertEquals(false, ms.isFlagged(0, 0));
	 assertEquals(true, ms.isVisible(0, 0));
	 ms.click(0, 0);
	 assertEquals(true, ms.isVisible(0, 0));
	 
	 ms.click(2, 4);
	 assertEquals(true, ms.isVisible(2, 4));
	 ms.click(2, 4);
	 assertEquals(true, ms.isVisible(2, 4));
  }
  
  //Tests the adjacent squares when adj squares are out of bound
  @Test
  public void testColumnOutOfBounds() {
	  MineSweeper ms = new MineSweeper(1,1,0);
	  ms.click(0, 0);
  }
  

}