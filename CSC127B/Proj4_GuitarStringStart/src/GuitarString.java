/**
 * GuitarString.java
 *
 * CSc 127B Spring 16
 * 
 * Author: Brian Loi
 * 
 * Instructor: Rick Mercer
 * 
 * A class that creates a GuitarString object which simulates a guitar string
 * though an instance variable of a 1D array, that is a queue. The class
 * contains methods that keep track of the capacity of the 1D array, to see the
 * first value in the queue, pluck the guitar string (which sets all the values
 * in the array to a random number between 0 and 1), and keeps track of the time
 * passed by through tics, and utilizes the Karplus-Strong Update technique so
 * that the guitar string is updated to appear as a real guitar string.
 * 
 * 
 */

public class GuitarString {

	// Instance variables
	private ArrayQueue buffer;
	private int tic;
	private int capacity;

	// This constructor is supplied for the purpose of testing. You know exactly
	// the elements to be added to the ArrayQueue because you have to supply a
	// completely initialized double[]. This constructor creates an ArrayQueue
	// of capacity equal to the size of the array, and initializes the contents
	// of the buffer to the values in the array.
	public GuitarString(double[] init) {

		// Sets the length of the array in the ArrayQueue object equal
		// to the length of the array in the parameter
		buffer = new ArrayQueue(init.length);

		// Iterates over the array of the object and sets them equal to the
		// parameter
		for (int i = 0; i < init.length; i++)
			buffer.enqueue(init[i]);

		// Declares that the capacity is the length of the array in the
		// parameter
		capacity = init.length;
	}

	// The constructor creates a ArrayQueue with the capacity of the ArrayQueue
	// as the samplingRate (44100) divided by the frequency and rounded UP the
	// nearest whole number. Once the ArrayQueue is created, it should be filled
	// with 0's.
	public GuitarString(double frequency) {

		// Declares the capacity of the array equal to the samplingRate (44100)
		// divided by the frequency from the parameter
		//NOTE: Adding (the frequency + 1) to the sampling rate
		//then dividing by the frequency will give the the result ROUNDED UP
		capacity = (int) ((44100 + frequency + 1) / frequency);

		// Sets the length of the array in the ArrayQueue object equal to
		// the calculated capacity
		buffer = new ArrayQueue(capacity);

		// Iterates over the entire array and fills it with zeros
		for (int i = 0; i < capacity; i++)
			buffer.enqueue(0.0);
	}

	// Replace all the items in the ArrayQueue with random values between -0.5
	// and +0.5. You will first have to dequeue all elements. Math.random()
	// returns a random floating point number from 0.0 to 1.0.
	public void pluck() {

		// Iterates over the array and dequeues all values
		for (int i = 0; i < capacity; i++)
			buffer.dequeue();

		// Iterates over the array and queues all values as a number between 0
		// and 1
		for (int i = 0; i < capacity; i++)
			buffer.enqueue(Math.random());
	}

	// Apply the Karplus-Strong update. To do this, remove the sample at the
	// front of the ArrayQueue. Use the sample that was removed and the sample
	// that is
	// now at the front of the ArrayQueue and find their average. Multiply the
	// average of these two numbers with the energy decay factor. The energy
	// decay factor is 0.996. Then, place the result at the end of the
	// ArrayQueue.
	public void tic() {
		// Initializes variables to hold values and sets them to zero
		double result = 0;
		double temp = 0;
		// temp is equal to the first sample in buffer
		temp = sample();
		// the first sample in buffer is removed
		buffer.dequeue();

		// Result becomes temp + the new sample in front divided by 2 times the
		// decay factor
		result = (((temp + sample()) / 2) * 0.996);

		// The result is added to the end of the queue
		buffer.enqueue(result);

		// tic increases by 1
		tic++;
	}

	// Return the value of the item at the front of the ArrayQueue
	public double sample() {

		// Returns the first value in the 2D array through peek()
		return buffer.peek();
	}

	// Return the total number of times tic() was called on this instance.
	// This is a measure of how much time has elapsed.
	public int time() {

		// Returns the variable holding the number of times tic() was called
		return tic;
	}

	// Return the value for the maximum capacity of the ArrayQueue
	public int getCapacity() {

		return capacity;
	}
}
