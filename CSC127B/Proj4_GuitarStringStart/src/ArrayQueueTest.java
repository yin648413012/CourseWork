
/**
 * ArrayQueueTest.java
 *
 * CSc 127B Spring 16 
 * 
 * Author: Brian Loi 
 * 
 * Instructor: Rick Mercer
 * 
 * A unit test for class ArrayQueue
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayQueueTest {

	// Tests several methods
	@Test
	public void testShowAFewMethods() {
		ArrayQueue queue = new ArrayQueue(5);
		assertTrue(queue.isEmpty());
		assertFalse(queue.isFull());
		assertEquals(0, queue.size());

		queue.enqueue(1.1);
		queue.enqueue(2.2);
		assertEquals(2, queue.size());
		assertEquals(1.1, queue.peek(), 0.0001);

		assertEquals(1.1, queue.dequeue(), 0.0001);
		assertEquals(2.2, queue.dequeue(), 0.0001);
		assertTrue(queue.isEmpty());
	}

	// Tests the Size() method
	@Test
	public void testSize() {
		ArrayQueue queue = new ArrayQueue(15);
		assertEquals(0, queue.size());

		ArrayQueue waitlist = new ArrayQueue(10);
		waitlist.enqueue(7.9);
		waitlist.enqueue(2.8);
		waitlist.enqueue(12.8);
		waitlist.enqueue(5.3);
		assertEquals(4, waitlist.size());
		waitlist.dequeue();
		waitlist.dequeue();
		assertEquals(2, waitlist.size());

		ArrayQueue waiting = new ArrayQueue(10);
		waiting.enqueue(6.7);
		waiting.enqueue(9.6);
		waiting.enqueue(50.8);
		waiting.enqueue(12.3);
		waiting.enqueue(92.12);
		waiting.enqueue(142.4);
		waiting.enqueue(7.34);
		waiting.enqueue(6.91);
		waiting.enqueue(21.24);
		assertEquals(9, waiting.size());
		waiting.dequeue();
		assertEquals(8, waiting.size());
	}

	// Tests the enqueue() and dequeue() methods
	@Test
	public void testEnqueueAndDequeue() {
		ArrayQueue queue = new ArrayQueue(10);
		queue.enqueue(34.1);
		queue.enqueue(72.4);
		queue.enqueue(3.9);
		queue.enqueue(6.5);
		queue.enqueue(2.8);
		queue.enqueue(7.6);
		assertEquals(34.1, queue.dequeue(), 1e-13);
		assertEquals(72.4, queue.dequeue(), 1e-13);
		assertEquals(3.9, queue.dequeue(), 1e-13);
		assertEquals(6.5, queue.dequeue(), 1e-13);
		assertEquals(2.8, queue.dequeue(), 1e-13);
	}

	// Tests the peek() method
	@Test
	public void testPeek() {
		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue(3.9);
		queue.enqueue(6.5);
		queue.enqueue(7.6);
		assertEquals(3.9, queue.peek(), 1e-13);

		ArrayQueue waiting = new ArrayQueue(10);
		waiting.enqueue(50.8);
		waiting.enqueue(142.4);
		waiting.enqueue(7.34);
		waiting.enqueue(6.91);
		waiting.enqueue(21.24);
		assertEquals(50.8, waiting.peek(), 1e-13);

		ArrayQueue waitlist = new ArrayQueue(10);
		waitlist.enqueue(7.9);
		waitlist.enqueue(2.8);
		waitlist.enqueue(12.8);
		waitlist.enqueue(5.3);
		waitlist.dequeue();
		assertEquals(2.8, waitlist.peek(), 1e-13);
	}

	// Tests the isEmpty() method
	@Test
	public void testIsEmpty() {
		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue(3.9);
		queue.enqueue(6.5);
		queue.enqueue(7.6);
		assertFalse(queue.isEmpty());

		ArrayQueue waitlist = new ArrayQueue(7);
		assertTrue(waitlist.isEmpty());
	}

	// Tests the isFull() method
	@Test
	public void testIsFull() {
		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue(3.9);
		queue.enqueue(6.5);
		queue.enqueue(7.6);
		queue.enqueue(34.1);
		queue.enqueue(72.4);
		assertEquals(5, queue.size());
		assertTrue(queue.isFull());

		ArrayQueue waitlist = new ArrayQueue(3);
		waitlist.enqueue(9.2);
		assertFalse(waitlist.isFull());
	}

	// Tests the enqueue() and dequeue() method back to back
	@Test
	public void testRepeatingEnqueueAndDequeue() {
		ArrayQueue queue = new ArrayQueue(5);
		queue.enqueue(3.9);
		queue.enqueue(6.5);
		queue.enqueue(7.6);
		queue.dequeue();
		queue.enqueue(9.3);
		queue.dequeue();
		queue.enqueue(4.5);
		queue.dequeue();
		queue.enqueue(1.5);
		assertEquals(9.3, queue.peek(), 0.00001);

	}
}