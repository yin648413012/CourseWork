
/*GameOfLifeTest.Java
 * 
 * Author: Brian Loi
 * 
 * A unit test for class GameOfLife
 * 
 */

import static org.junit.Assert.*;
import org.junit.Test;

public class GameOfLifeTest {

	// Tests the constructor and getter methods
	@Test
	public void testConstructorAndGetters() {
		GameOfLife society = new GameOfLife(5, 8);
		assertEquals(5, society.numberOfRows());
		assertEquals(8, society.numberOfColumns());
		for (int r = 0; r < society.numberOfRows(); r++)
			for (int c = 0; c < society.numberOfColumns(); c++)
				assertFalse(society.cellAt(r, c));
	}

	// Tests the constructor and getter methods
	@Test
	public void testConstructorAndGetters2() {
		GameOfLife society = new GameOfLife(3, 6);
		assertEquals(3, society.numberOfRows());
		assertEquals(6, society.numberOfColumns());
		for (int r = 0; r < society.numberOfRows(); r++)
			for (int c = 0; c < society.numberOfColumns(); c++)
				assertFalse(society.cellAt(r, c));
	}

	// Tests the constructor and getter methods
	@Test
	public void testConstructorandGetters3() {
		GameOfLife society = new GameOfLife(32, 14);
		assertEquals(32, society.numberOfRows());
		assertEquals(14, society.numberOfColumns());
		for (int r = 0; r < society.numberOfRows(); r++)
			for (int c = 0; c < society.numberOfColumns(); c++)
				assertFalse(society.cellAt(r, c));
	}

	// Tests the growCell method and cellAt method
	@Test
	public void testGrowCellAtAndCellAt() {
		GameOfLife society = new GameOfLife(4, 4);
		society.growCellAt(1, 1);
		society.growCellAt(2, 2);
		society.growCellAt(3, 3);

		assertTrue(society.cellAt(1, 1));
		assertTrue(society.cellAt(2, 2));
		assertTrue(society.cellAt(3, 3));
	}

	// Tests the growCell method and cellAt method
	@Test
	public void testGrowCellAtAndCellAt2() {
		GameOfLife society = new GameOfLife(8, 6);
		society.growCellAt(1, 5);
		society.growCellAt(3, 4);
		society.growCellAt(7, 2);
		assertTrue(society.cellAt(1, 5));
		assertTrue(society.cellAt(3, 4));
		assertTrue(society.cellAt(7, 2));
	}

	// Tests the growCell method and cellAt method
	@Test
	public void testGrowCellAtAndCellAt3() {
		GameOfLife society = new GameOfLife(13, 20);
		society.growCellAt(8, 7);
		society.growCellAt(3, 12);
		society.growCellAt(5, 18);

		assertTrue(society.cellAt(8, 7));
		assertTrue(society.cellAt(3, 12));
		assertTrue(society.cellAt(5, 18));
	}

	// Tests the neighbor count and wrapping method
	@Test
	public void testNeighborsWrapping() {
		GameOfLife society = new GameOfLife(10, 16);
		society.growCellAt(3, 3);
		society.growCellAt(3, 4);
		society.growCellAt(3, 5);
		assertEquals(0, society.neighborCount(2, 1));
		assertEquals(1, society.neighborCount(2, 2));
		assertEquals(2, society.neighborCount(2, 3));
		assertEquals(3, society.neighborCount(2, 4));
		assertEquals(2, society.neighborCount(4, 5));
		assertEquals(3, society.neighborCount(4, 4));
		assertEquals(1, society.neighborCount(4, 2));
	}

	// Tests the neighborCount and wrap around
	@Test
	public void testNeighborWrapping2() {
		GameOfLife society = new GameOfLife(4, 4);
		society.growCellAt(0, 1);
		society.growCellAt(0, 3);
		society.growCellAt(3, 2);
		society.growCellAt(0, 3);
		society.growCellAt(2, 2);
		society.growCellAt(3, 3);
		society.growCellAt(0, 0);
		society.growCellAt(2, 0);
		assertEquals(4, society.neighborCount(3, 2));
		assertEquals(4, society.neighborCount(0, 2));
		assertEquals(5, society.neighborCount(3, 3));
		assertEquals(3, society.neighborCount(1, 2));
		assertEquals(3, society.neighborCount(1, 2));
		assertEquals(4, society.neighborCount(2, 3));
	}

	// Tests that the corners wrap
	@Test
	public void testCornerWrapping() {
		GameOfLife society = new GameOfLife(5, 8);
		society.growCellAt(0, 0);
		society.growCellAt(0, 7);
		society.growCellAt(4, 0);
		society.growCellAt(4, 7);
		assertEquals(3, society.neighborCount(0, 0));
		assertEquals(3, society.neighborCount(0, 7));
		assertEquals(3, society.neighborCount(4, 0));
		assertEquals(3, society.neighborCount(4, 7));
	}

	// Tests that wrap around functions correctly
	@Test
	public void testWrapping() {
		GameOfLife society = new GameOfLife(6, 5);
		society.growCellAt(0, 0);
		society.growCellAt(0, 2);
		society.growCellAt(0, 4);
		society.growCellAt(5, 2);
		society.growCellAt(5, 3);
		society.growCellAt(5, 4);
		assertEquals(2, society.neighborCount(0, 0));
		assertEquals(2, society.neighborCount(0, 2));
		assertEquals(3, society.neighborCount(0, 4));
		assertEquals(2, society.neighborCount(5, 2));
		assertEquals(4, society.neighborCount(5, 3));
		assertEquals(3, society.neighborCount(5, 4));
	}

	// Tests the neighborCount method and wrap around
	@Test
	public void testNeighborCount() {
		GameOfLife society = new GameOfLife(7, 7);
		society.growCellAt(0, 0);
		society.growCellAt(0, 2);
		society.growCellAt(0, 4);
		society.growCellAt(5, 2);
		society.growCellAt(5, 3);
		society.growCellAt(5, 4);
		society.growCellAt(3, 3);
		society.growCellAt(6, 6);
		society.growCellAt(2, 0);
		society.growCellAt(6, 4);
		society.growCellAt(1, 6);
		assertEquals(2, society.neighborCount(0, 0));
		assertEquals(3, society.neighborCount(1, 0));
		assertEquals(1, society.neighborCount(0, 4));
		assertEquals(0, society.neighborCount(4, 0));
		assertEquals(3, society.neighborCount(5, 3));
		assertEquals(2, society.neighborCount(5, 4));
		assertEquals(4, society.neighborCount(4, 3));
	}

	// Tests that the update method works
	@Test
	public void testUpdate() {
		GameOfLife society = new GameOfLife(6, 5);
		society.growCellAt(0, 0);
		society.growCellAt(0, 2);
		society.growCellAt(0, 4);
		society.growCellAt(5, 2);
		society.growCellAt(5, 3);
		society.growCellAt(5, 4);
		society.growCellAt(2, 2);
		System.out.println(society.toString());
		society.update();
		assertEquals(false, society.cellAt(2, 2));
		assertEquals(true, society.cellAt(0, 0));
		assertEquals(true, society.cellAt(0, 1));
		assertEquals(true, society.cellAt(0, 2));
		assertEquals(true, society.cellAt(0, 4));
		assertEquals(true, society.cellAt(5, 0));
		assertEquals(true, society.cellAt(5, 1));
		assertEquals(true, society.cellAt(5, 2));
		assertEquals(true, society.cellAt(4, 3));
		assertEquals(true, society.cellAt(5, 4));
	}

	// Tests the toString method
	@Test
	public void toStringTest() {
		GameOfLife society = new GameOfLife(4, 14);
		society.growCellAt(1, 2);
		society.growCellAt(2, 3);
		society.growCellAt(3, 4);
		System.out.println(society.toString());
	}

}