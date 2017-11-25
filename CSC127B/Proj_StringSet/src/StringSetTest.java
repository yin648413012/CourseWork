
/**
 * StringSetTest.java
 *
 * CSc 127B Spring 16 
 * 
 * Author: Brian Loi 
 * 
 * Instructor: Rick Mercer
 * 
 * A unit test for class StringSet
 * 
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringSetTest {

	@Test
	public void testInsertInOrderWithToString() {
		StringSet set = new StringSet();
		assertEquals("[]", set.toString());
		set.insertInOrder("C");
		assertEquals("[C]", set.toString());
		set.insertInOrder("Gee");
		assertEquals("[C, Gee]", set.toString());
		set.insertInOrder("B");
		assertEquals("[B, C, Gee]", set.toString());
		assertTrue(set.insertInOrder("A"));
		assertEquals("[A, B, C, Gee]", set.toString());
		assertTrue(set.insertInOrder("65"));
		assertEquals("[65, A, B, C, Gee]", set.toString());
	}

	@Test
	public void testTrueAndFalseOfInsertOrder() {
		StringSet set = new StringSet();
		assertEquals("[]", set.toString());
		assertEquals(true, set.insertInOrder("C"));
		set.insertInOrder("C");
		assertEquals("[C]", set.toString());
		assertEquals(false, set.insertInOrder("C"));
		assertEquals(true, set.insertInOrder("F"));
		set.insertInOrder("F");
		assertEquals("[C, F]", set.toString());
		assertEquals(false, set.insertInOrder("F"));
		assertEquals(true, set.insertInOrder("A"));
		set.insertInOrder("A");
		assertEquals("[A, C, F]", set.toString());
		assertEquals(false, set.insertInOrder("A"));
		assertEquals(true, set.insertInOrder("R"));
		set.insertInOrder("R");
		assertEquals("[A, C, F, R]", set.toString());
		assertEquals(true, set.insertInOrder("E"));
		assertEquals(false, set.insertInOrder("R"));
		set.insertInOrder("E");
		assertEquals("[A, C, E, F, R]", set.toString());
		assertEquals(false, set.insertInOrder("E"));
	}

	@Test
	public void testSize() {
		StringSet set = new StringSet();
		assertEquals("[]", set.toString());
		set.insertInOrder("C");
		assertEquals("[C]", set.toString());
		set.insertInOrder("Gee");
		assertEquals("[C, Gee]", set.toString());
		set.insertInOrder("B");
		assertEquals("[B, C, Gee]", set.toString());
		assertTrue(set.insertInOrder("A"));
		assertEquals("[A, B, C, Gee]", set.toString());
		assertTrue(set.insertInOrder("65"));
		assertEquals("[65, A, B, C, Gee]", set.toString());
		assertEquals(5, set.size());
	}

	@Test
	public void testUnion() {
		StringSet set = new StringSet();
		assertEquals("[]", set.toString());
		set.insertInOrder("C");
		assertEquals("[C]", set.toString());
		set.insertInOrder("A");
		assertEquals("[A, C]", set.toString());
		set.insertInOrder("B");
		assertEquals("[A, B, C]", set.toString());
		set.insertInOrder("P");
		assertEquals("[A, B, C, P]", set.toString());
		set.insertInOrder("F");
		assertEquals("[A, B, C, F, P]", set.toString());
		
		StringSet testSet = new StringSet();
		assertEquals("[]", testSet.toString());
		testSet.insertInOrder("C");
		assertEquals("[C]", testSet.toString());
		testSet.insertInOrder("A");
		assertEquals("[A, C]", testSet.toString());
		testSet.insertInOrder("D");
		assertEquals("[A, C, D]", testSet.toString());
		testSet.insertInOrder("P");
		assertEquals("[A, C, D, P]", testSet.toString());
		testSet.insertInOrder("X");
		assertEquals("[A, C, D, P, X]", testSet.toString());
		
		set.union(testSet);
		
		assertEquals("[A, B, C, D, F, P, X]", set.union(testSet).toString());
		
	}

	@Test
	public void testTrueEmpty() {
		StringSet set = new StringSet();
		assertEquals("[]", set.toString());
		assertEquals(true, set.isEmpty());
	}

	@Test
	public void testFalseEmpty() {
		StringSet set = new StringSet();
		set.insertInOrder("C");
		assertEquals("[C]", set.toString());
		set.insertInOrder("A");
		assertEquals("[A, C]", set.toString());
		assertEquals(false, set.isEmpty());
	}

	@Test
	public void testContains() {
		StringSet set = new StringSet();
		assertEquals("[]", set.toString());
		set.insertInOrder("C");
		assertEquals("[C]", set.toString());
		set.insertInOrder("A");
		assertEquals("[A, C]", set.toString());
		set.insertInOrder("B");
		assertEquals("[A, B, C]", set.toString());
		assertEquals(true, set.contains("A"));
		assertEquals(true, set.contains("B"));
		assertEquals(true, set.contains("C"));
		assertEquals(false, set.contains("D"));
		assertEquals(false, set.contains("P"));
	}

	@Test
	public void testRemove() {
		StringSet set = new StringSet();
		assertEquals("[]", set.toString());
		set.insertInOrder("C");
		assertEquals("[C]", set.toString());
		assertEquals(true, set.remove("C"));
		set.remove("C");
		assertEquals("[]", set.toString());
		set.insertInOrder("B");
		set.remove("A");
		assertEquals(false, set.remove("A"));
	}
	
	@Test
	public void testShiftAfterRemove() {
		StringSet set = new StringSet();
		assertEquals("[]", set.toString());
		set.insertInOrder("C");
		assertEquals("[C]", set.toString());
		set.insertInOrder("A");
		assertEquals("[A, C]", set.toString());
		set.insertInOrder("B");
		assertEquals("[A, B, C]", set.toString());
		set.insertInOrder("P");
		assertEquals("[A, B, C, P]", set.toString());
		set.insertInOrder("F");
		assertEquals("[A, B, C, F, P]", set.toString());
		set.remove("B");
		assertEquals("[A, C, F, P]", set.toString());
		set.remove("F");
		assertEquals("[A, C, P]", set.toString());
	}
}