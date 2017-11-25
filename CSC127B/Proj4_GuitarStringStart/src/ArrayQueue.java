/**
 * ArrayQueue.java
 *
 * CSc 127B Spring 16
 * 
 * Author: Brian Loi
 * 
 * Instructor: Rick Mercer
 * 
 * A class that simulates a queue, a waiting list. It creates an object
 * containing an array of doubles with a wrap around feature. The class contains
 * methods allowing queueing elements into the array, dequeueing an element in
 * the array, finding the amount of elements in the array, seeing the element
 * first in line, and if the array is full or empty.
 * 
 */

// This collection class model a circular queue in that it uses an array as the
// data structure to hold elements. When when an element is added, modulus
// arithmetic is employed to place the new element in the "last" position.
// Another instance variable "first", keeps track of the where the first is.
//
// When first is at index 6 and last is at index 1 in this ArrayQueue:
//
// data-> | 0.2 | 0.4 | 0.6 | -0.1 | -0.4 | 0.2 | 0.5 | 0.2 | -0.1 | -0.4 |
// | |
// last first
//
// peek() would return 0.5 and enqueue(-0.3) would place -0.3 where the 0.6 is.
// This portion is not really in the queue | 0.6 | -0.1 | -0.4 | 0.2 |
//
public class ArrayQueue {

	// Instance Variables:
	private int back;
	private int front;
	private double[] data;

	// Initializes an instance variable that will hold the size of elements in
	// the array
	private int n = 0;

	// Constructor
	public ArrayQueue(int capacity) {
		front = 0;
		back = 0;
		data = new double[capacity];
	}

	// The size() method returns the number of elements currently in this
	public int size() {

		// Returns the variable that holds the size of the elements in the array
		return n;
	}

	// Returns true if this ArrayQueue is empty
	public boolean isEmpty() {
		// If the size is 0, return true else return false
		if (n == 0)
			return true;
		else
			return false;
	}

	// Returns true if this ArrayQueue is full
	public boolean isFull() {

		// If the size of the array is equal to the length of the array, return
		// true, else false
		if (data.length == size())
			return true;
		else
			return false;
	}

	// This method puts element into the ArrayQueue. Since the ArrayQueue is a
	// queue, the element being inserted should be added at the end of the
	// queue.
	// Precondition: the Queue is not full.
	public void enqueue(double element) {

		// Sets the index of the back equal to the new element.
		data[back] = element;

		// If the back is at the end of the array, loop to the beginning of the
		// array (index [0])
		if (back == data.length - 1)
			back = 0;
		else
			back++;

		// Increases the size by one
		n++;
	}

	// Removes the first element from the ArrayQueue and returns it.
	// Precondition: This ArrayQueue is not empty.
	public double dequeue() {

		// Makes a temp variable become the front element of the array
		double temp = data[front];
		// Sets the front element to 0
		data[front] = 0;
		// If front is at the end of the array, loop to the beginning of the
		// array
		// Else increase front by 1
		if (front == data.length - 1)
			front = 0;
		else
			front++;
		// Decreases the size by 1
		n--;
		// Returns the temp variable that held the front element
		return temp;

	}

	// Returns the first element from the ArrayQueue but does NOT remove it.
	// Precondition: This ArrayQueue is not empty.
	public double peek() {

		// Returns the front element
		return data[front];
	}
}
