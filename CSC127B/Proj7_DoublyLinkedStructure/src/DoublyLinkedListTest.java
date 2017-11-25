import static org.junit.Assert.*;

/**
 * A pretty good start to a Unit test for DoublyLinkedList
 * 
 * @author Rick Mercer
 */
import org.junit.Test;

public class DoublyLinkedListTest {

	@Test
	public void testInsertInOrderAndGet() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		assertEquals(0, list.size());
		list.insertInorder("D");
		list.insertInorder("B");
		list.insertInorder("E");
		list.insertInorder("A");
		list.insertInorder("C");

		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));
	}

	@Test
	public void testInsertInOrderAndGetWithIntegers() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		assertEquals(0, list.size());
		list.insertInorder(12);
		list.insertInorder(4);
		list.insertInorder(-3);
		list.insertInorder(-2);

		assertEquals(-3, (int) list.get(0));
		assertEquals(-2, (int) list.get(1));
		assertEquals(4, (int) list.get(2));
		assertEquals(12, (int) list.get(3));
	}

	@Test
	public void testForwardIterator() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		assertEquals(0, list.size());
		list.insertInorder(12);
		list.insertInorder(4);
		list.insertInorder(-3);
		list.insertInorder(-2);

		ForwardIterator<Integer> fItr = list.forwardIterator();

		assertTrue(fItr.hasNext());
		assertEquals(-3, (int) fItr.next());
		assertEquals(-2, (int) fItr.next());
		assertTrue(fItr.hasNext());
		assertEquals(4, (int) fItr.next());
		assertTrue(fItr.hasNext());
		assertEquals(12, (int) fItr.next());
		assertFalse(fItr.hasNext());
	}

	@Test
	public void testReverseIterator() {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		assertEquals(0, list.size());
		list.insertInorder(12);
		list.insertInorder(4);
		list.insertInorder(-3);
		list.insertInorder(-2);

		ReverseIterator<Integer> fItr = list.reverseIterator();

		assertTrue(fItr.hasPrev());
		assertEquals(12, (int) fItr.prev());
		assertEquals(4, (int) fItr.prev());
		assertEquals(-2, (int) fItr.prev());
		assertTrue(fItr.hasPrev());
		assertEquals(-3, (int) fItr.prev());
		assertFalse(fItr.hasPrev());
	}

	@Test
	public void testRemove() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertInorder("D");
		list.insertInorder("B");
		list.insertInorder("E");
		list.insertInorder("A");
		list.insertInorder("C");

		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));

		assertEquals(5, list.size());
		list.remove("C");
		assertEquals(4, list.size());

		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("D", list.get(2));
		assertEquals("E", list.get(3));
	}

	@Test
	public void testRemove2() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		list.insertInorder("D");
		list.insertInorder("B");
		list.insertInorder("E");
		list.insertInorder("A");
		list.insertInorder("C");

		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));

		assertEquals(5, list.size());
		assertEquals(true, list.remove("A"));
		list.remove("A");
		assertEquals(4, list.size());
		assertEquals("B", list.get(0));
		assertEquals("C", list.get(1));
		assertEquals("D", list.get(2));
		assertEquals("E", list.get(3));
	}

	@Test
	public void testRemove3() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		assertEquals(0, list.size());
		list.insertInorder("D");
		list.insertInorder("B");
		list.insertInorder("E");
		list.insertInorder("A");
		list.insertInorder("C");

		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
		assertEquals("E", list.get(4));

		assertEquals(5, list.size());
		list.remove("E");
		assertEquals(4, list.size());

		list.remove("E");
		list.remove("E");
		list.remove("E");

		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
		assertEquals("D", list.get(3));
	}

	@Test
	public void testRemoveWhemEmpty() {
		DoublyLinkedList<String> list = new DoublyLinkedList<String>();
		assertFalse(list.remove("A"));
		assertEquals(0, list.size());
	}

}
