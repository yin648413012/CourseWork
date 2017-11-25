
/**
 * RecursionFunTests.java
 * 
 * CSc 127B Spring 16
 * 
 * This class represents the unit tests for the recursive methods in
 * RecursionFun.java and LinkedList.java.
 * 
 * 
 * @author Brian Loi
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class RecursionFunTests {

	private RecursionFun rf = new RecursionFun();

	// #1
	@Test
	public void testCombinations() {
		assertEquals(10, rf.combinations(5, 2));
		assertEquals(6, rf.combinations(4, 2));
	}

	// #2
	@Test
	public void testFactorials() {
		assertEquals(1, rf.factorial(0));
		assertEquals(1, rf.factorial(1));
		assertEquals(6, rf.factorial(3));
		assertEquals(24, rf.factorial(4));
	}

	// #3
	@Test
	public void testAddReciprocals() {
		assertEquals(1.5, rf.addReciprocals(2), 0.000001);
		assertEquals(1.0, rf.addReciprocals(1), 0.000001);
	}

	// #4
	@Test
	public void testGCD() {
		assertEquals(3, rf.GCD(24, 9));
		assertEquals(10, rf.GCD(50, 20));
		assertEquals(1, rf.GCD(7, 20));
	}

	// #5
	@Test
	public void testFibonacci() {
		assertEquals(8, rf.fibonacci(6));
		assertEquals(5, rf.fibonacci(5));
		assertEquals(2, rf.fibonacci(3));
		assertEquals(1, rf.fibonacci(1));
		assertEquals(1, rf.fibonacci(2));
	}

	// #6
	@Test
	public void testUnderScore() {
		assertEquals("hel_lo", rf.underScore("hello"));
		assertEquals("x_xy_y", rf.underScore("xxyy"));
		assertEquals("a_a_a_a", rf.underScore("aaaa"));
		assertEquals("", rf.underScore(""));
	}

	// #7
	@Test
	public void testNestParen() {
		assertEquals(true, rf.nestParen("(())"));
		assertEquals(true, rf.nestParen("((()))"));
		assertEquals(false, rf.nestParen("((())"));
		assertEquals(false, rf.nestParen("("));
		assertEquals(false, rf.nestParen("(x"));
		assertEquals(false, rf.nestParen("x)"));
		assertEquals(false, rf.nestParen("(yy)"));
		assertEquals(false, rf.nestParen("("));
		assertEquals(false, rf.nestParen("x"));
	}

	// #8
	@Test
	public void testNoAdjacents() {
		assertEquals("yza", rf.noAdjacents("yyyzzzza"));
		assertEquals("abcd", rf.noAdjacents("aabbbbcdd"));
		assertEquals("Helo", rf.noAdjacents("Hello"));
		assertEquals("", rf.noAdjacents(""));
	}

	// #9
	@Test
	public void testConvert() {
		assertEquals("1", rf.convert(1, 2));
		assertEquals("11", rf.convert(3, 2));
		assertEquals("101", rf.convert(5, 2));
		assertEquals("15", rf.convert(13, 8));
		assertEquals("10", rf.convert(8, 8));
		assertEquals("123", rf.convert(123, 10));
		assertEquals("20", rf.convert(16, 8));
	}

	// #10
	@Test
	public void testIntWithCommas() {
		assertEquals("999", rf.intWithCommas(999));
		assertEquals("1,234", rf.intWithCommas(1234));
		// assertEquals("1,007", rf.intWithCommas(1007));
		assertEquals("1,023,004,567", rf.intWithCommas(1023004567));
	}

	// #11
	@Test
	public void testSumArray() {
		int[] x = { 1, 5, 7, 2, 3, 4 };
		assertEquals(9, rf.sumArray(x, 2, 3));
		assertEquals(13, rf.sumArray(x, 0, 2));
		assertEquals(22, rf.sumArray(x, 0, 5));
		assertEquals(0, rf.sumArray(x, 5, 0));
	}

	// #12
	@Test
	public void testSumArrayTotal() {
		int[] a = { 2, 4, 6 };
		assertEquals(12, rf.sumArray(a));
	}

	// #13
	@Test
	public void testReverseArray() {
		int[] a = { 2, 4, 6 };
		rf.reverseArray(a);
		assertEquals(6, a[0]);
		assertEquals(4, a[1]);
		assertEquals(2, a[2]);

		int[] four = { 2, 4, 6, 8 };
		rf.reverseArray(four);
		assertEquals(8, four[0]);
		assertEquals(6, four[1]);
		assertEquals(4, four[2]);
		assertEquals(2, four[3]);

		int[] empty = {};
		rf.reverseArray(empty);
		assertEquals(0, empty.length);

	}

	// #14
	@Test
	public void testArrayRange() {
		assertEquals(2, rf.arrayRange(new int[] { 1, 2, 3 }));
		assertEquals(2, rf.arrayRange(new int[] { 3, 2, 1 }));
		assertEquals(0, rf.arrayRange(new int[] { 3 }));
		assertEquals(3, rf.arrayRange(new int[] { -3, -2, -5, -4 }));
	}

	// #15
	@Test
	public void testIsSorted() {
		int[] intsOne = { 1, 2, 5, 5, 6, 6, 7 };
		int[] intsTwo = { 1, 2, 5, 5, 7, 6, 7 };
		assertTrue(rf.isSorted(intsOne));
		assertFalse(rf.isSorted(intsTwo));

		int[] intsEmpty = {};
		assertTrue(rf.isSorted(intsEmpty));
	}

	// #16
	@Test
	public void testFound() {
		String[] strs = { "Ttt", "Ccc", "Fff", "Ddd", "Hhh", "Aaa" };
		assertTrue(rf.found("Aaa", strs));
		assertTrue(rf.found("Hhh", strs));
		assertFalse(rf.found("Not Here", strs));
	}

	// #17
	@Test
	public void testBinarySearch() {
		String[] strs = { "Aaa", "Ccc", "Ddd", "Fff", "Hhh", "Ttt" };
		assertEquals(0, rf.binarySearch("Aaa", strs));
		assertEquals(4, rf.binarySearch("Hhh", strs));
		assertEquals(-1, rf.binarySearch("Not here", strs));
	}

	// #18
	@Test
	public void testGet() {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
	}

	// #19
	@Test
	public void testMax() {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("D");
		assertEquals("D", list.max());

		LinkedList<String> list2 = new LinkedList<String>();
		list2.addLast("A");
		list2.addLast("T");
		list2.addLast("E");
		list2.addLast("P");
		assertEquals("T", list2.max());

		LinkedList<String> emptyList = new LinkedList<String>();
		assertEquals(null, emptyList.max());
	}

	// #20
	@Test
	public void testOccurencesOf() {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("A");
		list.addLast("O");
		list.addLast("P");
		list.addLast("Q");
		assertEquals(2, list.occurencesOf("A"));

		LinkedList<String> list2 = new LinkedList<String>();
		list2.addLast("R");
		list2.addLast("B");
		list2.addLast("R");
		list2.addLast("R");
		list2.addLast("R");
		list2.addLast("P");
		list2.addLast("R");
		assertEquals(5, list2.occurencesOf("R"));
	}

	// #21
	@Test
	public void testDuplicateAll() {
		LinkedList<String> list = new LinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		list.addLast("X");
		assertEquals("A B X", list.toString());
		assertEquals(3, list.size());
		list.duplicateAll("B");
		assertEquals("A B B X", list.toString());
		assertEquals(4, list.size());

		// Empty LinkedList
		LinkedList<String> empty = new LinkedList<String>();
		assertEquals("", empty.toString());
		assertEquals(0, empty.size());
		empty.duplicateAll("A");
		assertEquals(0, empty.size());
		assertEquals("", empty.toString());

	}

}
