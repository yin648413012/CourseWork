
/**
 * OrderedSetTest.java
 * 
 * A unit test for OrderedSet.java
 * 
 * @author: Brian Loi
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class OrderedSetTest {

	@Test
	public void testInsertSizeAndTostringinorder() {
		OrderedSet<String> bst = new OrderedSet<String>();
		assertEquals("", bst.toStringInorder());
		assertTrue(bst.insert("d"));
		assertEquals(1, bst.size());
		assertTrue(bst.insert("b"));
		assertTrue(bst.insert("e"));
		assertFalse(bst.insert("e"));
		assertTrue(bst.insert("a"));
		assertEquals(4, bst.size());
		assertEquals("a b d e", bst.toStringInorder());
	}

	@Test
	public void testSize() {
		OrderedSet<String> bst = new OrderedSet<String>();
		assertEquals("", bst.toStringInorder());
		assertEquals(0, bst.size());
		assertTrue(bst.insert("1"));
		assertEquals(1, bst.size());
		assertTrue(bst.insert("2"));
		assertEquals(2, bst.size());
		assertTrue(bst.insert("3"));
		assertEquals(3, bst.size());
		assertFalse(bst.insert("3"));
		assertEquals(3, bst.size());
		assertTrue(bst.insert("4"));
		assertEquals(4, bst.size());
		assertFalse(bst.insert("4"));
		assertEquals(4, bst.size());
		assertTrue(bst.insert("5"));
		assertEquals(5, bst.size());
		assertFalse(bst.insert("2"));
		assertFalse(bst.insert("1"));
		assertEquals(5, bst.size());
		assertTrue(bst.insert("6"));
		assertFalse(bst.insert("6"));
		assertEquals(6, bst.size());
	}

	@Test
	public void testContains() {
		OrderedSet<String> bst = new OrderedSet<String>();
		assertEquals("", bst.toStringInorder());
		assertTrue(bst.insert("d"));
		assertEquals(1, bst.size());
		assertTrue(bst.insert("b"));
		assertTrue(bst.insert("e"));
		assertFalse(bst.insert("e"));
		assertTrue(bst.insert("a"));
		assertEquals(4, bst.size());
		assertEquals(true, bst.contains("a"));
		assertEquals(true, bst.contains("b"));
		assertEquals(true, bst.contains("d"));
		assertEquals(true, bst.contains("e"));
		assertEquals(false, bst.contains("x"));
		assertEquals(false, bst.contains("not here"));
		assertEquals(false, bst.contains("missing"));
		assertEquals(false, bst.contains("gone"));
		assertEquals(false, bst.contains("c"));
	}

	@Test
	public void testNodesAtLevel() {
		OrderedSet<String> bst = new OrderedSet<String>();
		assertEquals("", bst.toStringInorder());
		assertTrue(bst.insert("d"));
		assertTrue(bst.insert("b"));
		assertTrue(bst.insert("e"));
		assertTrue(bst.insert("a"));
		assertTrue(bst.insert("g"));
		assertTrue(bst.insert("c"));
		assertTrue(bst.insert("f"));
		assertTrue(bst.insert("h"));
		assertEquals("a b c d e f g h", bst.toStringInorder());
		assertEquals(1, bst.nodesAtLevel(0));
		assertEquals(2, bst.nodesAtLevel(1));
		assertEquals(3, bst.nodesAtLevel(2));
		assertEquals(2, bst.nodesAtLevel(3));
	}

	@Test
	public void testMax() {
		OrderedSet<String> bst = new OrderedSet<String>();
		assertEquals("", bst.toStringInorder());
		assertTrue(bst.insert("d"));
		assertTrue(bst.insert("b"));
		assertTrue(bst.insert("e"));
		assertTrue(bst.insert("a"));
		assertEquals("e", bst.max());

		OrderedSet<String> single = new OrderedSet<String>();
		assertEquals("", single.toStringInorder());
		assertTrue(single.insert("d"));
		assertEquals("d", single.max());

		OrderedSet<String> big = new OrderedSet<String>();
		assertEquals("", big.toStringInorder());
		assertTrue(big.insert("d"));
		assertTrue(big.insert("b"));
		assertTrue(big.insert("e"));
		assertTrue(big.insert("a"));
		assertTrue(big.insert("g"));
		assertTrue(big.insert("c"));
		assertTrue(big.insert("f"));
		assertTrue(big.insert("h"));
		assertTrue(big.insert("x"));
		assertEquals("x", big.max());
	}

	@Test
	public void testUnion() {
		OrderedSet<String> bst = new OrderedSet<String>();
		assertEquals("", bst.toStringInorder());
		assertTrue(bst.insert("2"));
		assertTrue(bst.insert("4"));
		assertTrue(bst.insert("6"));

		OrderedSet<String> other = new OrderedSet<String>();
		assertEquals("", other.toStringInorder());
		assertTrue(other.insert("2"));
		assertTrue(other.insert("5"));
		assertTrue(other.insert("9"));

		OrderedSet<String> union = bst.union(other);
		assertEquals("2 4 5 6 9", union.toStringInorder());
	}

	@Test
	public void testBigUnion() {
		OrderedSet<String> bst = new OrderedSet<String>();
		assertEquals("", bst.toStringInorder());
		assertTrue(bst.insert("1"));
		assertTrue(bst.insert("3"));
		assertTrue(bst.insert("4"));
		assertTrue(bst.insert("7"));
		assertTrue(bst.insert("2"));
		assertTrue(bst.insert("6"));

		OrderedSet<String> other = new OrderedSet<String>();
		assertEquals("", other.toStringInorder());
		assertTrue(other.insert("5"));
		assertTrue(other.insert("2"));
		assertTrue(other.insert("9"));
		assertTrue(other.insert("7"));
		assertTrue(other.insert("1"));
		assertTrue(other.insert("3"));
		assertTrue(other.insert("8"));

		OrderedSet<String> union = bst.union(other);
		assertEquals("1 2 3 4 5 6 7 8 9", union.toStringInorder());
	}

	@Test
	public void testSubSet() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(12);
		bst.insert(75);
		bst.insert(65);
		bst.insert(90);
		assertEquals("12 25 50 65 75 90", bst.toStringInorder());
		assertEquals("12 25", bst.subset(1, 49).toStringInorder());
		assertEquals("25 50 65", bst.subset(25, 75).toStringInorder());
		assertEquals("", bst.subset(12, 12).toStringInorder()); // 12 < 12 is
																// false
	}

	@Test
	public void testIntersection() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(2);
		bst.insert(4);
		bst.insert(5);
		bst.insert(6);

		OrderedSet<Integer> other = new OrderedSet<Integer>();
		other.insert(2);
		other.insert(5);
		other.insert(6);
		other.insert(9);

		assertEquals("2 5 6", bst.intersection(other).toStringInorder());
	}

	@Test
	public void testBigIntersection() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(1);
		bst.insert(2);
		bst.insert(3);
		bst.insert(4);
		bst.insert(5);
		bst.insert(6);
		bst.insert(7);
		bst.insert(8);
		bst.insert(9);

		OrderedSet<Integer> other = new OrderedSet<Integer>();
		other.insert(1);
		other.insert(4);
		other.insert(3);
		other.insert(6);
		other.insert(7);
		other.insert(9);

		assertEquals("1 3 4 6 7 9", bst.intersection(other).toStringInorder());
	}

	@Test
	public void testSameStructure() {
		OrderedSet<String> bst = new OrderedSet<String>();
		bst.insert("M");
		bst.insert("B");
		bst.insert("F");
		bst.insert("R");
		bst.insert("Z");

		OrderedSet<String> other = new OrderedSet<String>();
		other.insert("P");
		other.insert("F");
		other.insert("Q");
		other.insert("J");
		other.insert("R");

		assertEquals(true, bst.sameStructure(other));
	}

	@Test
	public void testFailSameStruct() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(5);
		bst.insert(10);
		bst.insert(8);
		bst.insert(4);
		bst.insert(12);
		bst.insert(6);
		bst.insert(7);
		bst.insert(1);
		bst.insert(9);

		OrderedSet<Integer> other = new OrderedSet<Integer>();
		other.insert(1);
		other.insert(4);
		other.insert(3);
		other.insert(6);
		other.insert(7);
		other.insert(9);

		assertEquals(false, bst.sameStructure(other));
	}

	@Test
	public void testFailStruct2() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(5);
		bst.insert(10);
		bst.insert(8);
		bst.insert(4);
		bst.insert(12);

		OrderedSet<Integer> other = new OrderedSet<Integer>();
		other.insert(5);
		other.insert(12);
		other.insert(10);
		other.insert(8);

		assertEquals(false, bst.sameStructure(other));
	}

	@Test
	public void testFailStruct3() {
		OrderedSet<String> bst = new OrderedSet<String>();
		bst.insert("M");
		bst.insert("B");
		bst.insert("R");
		bst.insert("F");
		bst.insert("Z");

		OrderedSet<String> other = new OrderedSet<String>();
		other.insert("M");
		other.insert("B");
		other.insert("Z");
		other.insert("F");
		other.insert("R");

		assertEquals(false, bst.sameStructure(other));
	}

	@Test
	public void testSameStruct() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(5);
		bst.insert(10);
		bst.insert(8);
		bst.insert(77);

		OrderedSet<Integer> other = new OrderedSet<Integer>();
		other.insert(55);
		other.insert(89);
		other.insert(79);
		other.insert(99);

		assertEquals(true, bst.sameStructure(other));
	}

	@Test
	public void testSameStruct2() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(3);
		bst.insert(2);
		bst.insert(1);

		OrderedSet<Integer> other = new OrderedSet<Integer>();
		other.insert(99);
		other.insert(88);
		other.insert(77);

		assertEquals(true, bst.sameStructure(other));
	}

	@Test
	public void testSameStruct3() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(13);
		bst.insert(20);
		bst.insert(69);
		bst.insert(98);
		bst.insert(100);
		bst.insert(22);
		bst.insert(63);
		bst.insert(20);
		bst.insert(6);
		bst.insert(17);

		OrderedSet<Integer> other = new OrderedSet<Integer>();
		other.insert(50);
		other.insert(25);
		other.insert(13);
		other.insert(20);
		other.insert(69);
		other.insert(98);
		other.insert(100);
		other.insert(22);
		other.insert(63);
		other.insert(20);
		other.insert(6);
		other.insert(17);

		assertEquals(true, bst.sameStructure(other));
	}

	@Test
	public void testRemoveCase1() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(5);
		bst.insert(10);
		bst.insert(8);
		bst.insert(4);
		bst.insert(12);
		bst.insert(6);
		bst.insert(7);
		bst.insert(1);
		bst.insert(9);

		assertEquals(false, bst.remove(2));
		assertEquals(false, bst.remove(3));
		assertEquals(false, bst.remove(28));
		assertEquals(false, bst.remove(999));
		assertEquals(false, bst.remove(16));
		assertEquals(false, bst.remove(72));

		assertEquals("1 4 5 6 7 8 9 10 12", bst.toStringInorder());
	}

	@Test
	public void testRemoveCase2() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(60);
		bst.insert(55);
		bst.insert(75);
		bst.insert(90);
		bst.insert(79);
		bst.insert(99);

		assertEquals(true, bst.remove(50));

		assertEquals("55 60 75 79 90 99", bst.toStringInorder());
	}

	@Test
	public void testRemoveCase3Left() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(30);
		bst.insert(90);
		bst.insert(80);
		bst.insert(95);

		assertEquals(true, bst.remove(25));

		assertEquals("30 50 75 80 90 95", bst.toStringInorder());
	}

	@Test
	public void testRemoveCase3Right() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(75);
		bst.insert(30);
		bst.insert(90);
		bst.insert(80);
		bst.insert(95);

		assertEquals(true, bst.remove(75));

		assertEquals("25 30 50 80 90 95", bst.toStringInorder());
	}

	@Test
	public void testRemoveCase4() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);
		bst.insert(25);
		bst.insert(90);
		bst.insert(70);
		bst.insert(99);
		bst.insert(60);
		bst.insert(85);

		assertEquals(true, bst.remove(90));

		assertEquals("25 50 60 70 85 99", bst.toStringInorder());
	}

	@Test
	public void testMaxWhenEmpty() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		assertEquals("", bst.toStringInorder());

		assertEquals(null, bst.max());
	}

	@Test
	public void testEmptyUnions() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();

		OrderedSet<Integer> other = new OrderedSet<Integer>();
		other.insert(50);

		assertEquals("50", bst.union(other).toStringInorder());
	}

	@Test
	public void testEmptyUnions2() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(50);

		OrderedSet<Integer> other = new OrderedSet<Integer>();

		assertEquals("50", bst.union(other).toStringInorder());
	}

	@Test
	public void testEmptyUnions3() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();

		OrderedSet<Integer> other = new OrderedSet<Integer>();

		assertEquals("", bst.union(other).toStringInorder());
	}

	@Test
	public void testRemoveRightWhenSizeTwo() {
		OrderedSet<Integer> bst = new OrderedSet<Integer>();
		bst.insert(5);
		bst.insert(9);

		bst.remove(9);
		assertEquals("5", bst.toStringInorder());
	}
}
