
/**
 * GuitarStringTest.java
 *
 * CSc 127B Spring 16 
 * 
 * Author: Brian Loi 
 * 
 * Instructor: Rick Mercer
 * 
 * A unit test for class GuitarString.java
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

public class GuitarStringTest {

	// Tests some of the methods
	@Test
	public void testToShowMostMethods() {
		double[] init = { 0.4, 0.2, -0.1 };

		GuitarString gs = new GuitarString(init);
		assertEquals(3, gs.getCapacity());

		assertEquals(0.4, gs.sample(), 0.0001);
		assertEquals(0, gs.time());

		gs.tic(); // Apply the Karplus-Strong update.

		assertEquals(1, gs.time());
		assertEquals(0.2, gs.sample(), 0.0001);

		gs.tic();
		assertEquals(2, gs.time());
		assertEquals(-0.1, gs.sample(), 0.0001);

		gs.tic(); // See the first ArrayQueue element that was multiplied by the
					// factor
		assertEquals(3, gs.time());
		assertEquals(0.2988, gs.sample(), 0.0001);

	}

	// Tests the pluck() method
	@Test
	public void testPluck() {

		double[] init = { 0.3, 0.6, -0.1, 0.5, 0.7 };
		GuitarString gs = new GuitarString(init);

		gs.pluck();

		for (int tics = 1; tics <= 20; tics++) {
			System.out.println(gs.sample());
			gs.tic();
		}

	}

	// Tests the sample() method
	@Test
	public void testSample() {
		double[] init = { 0.3, 0.6, -0.1, 0.5, 0.7 };
		GuitarString gs = new GuitarString(init);

		assertEquals(0.3, gs.sample(), 0.00001);

		gs.tic();
		assertEquals(0.6, gs.sample(), 0.00001);

		gs.tic();
		assertEquals(-0.1, gs.sample(), 0.00001);

		gs.tic();
		assertEquals(0.5, gs.sample(), 0.00001);
	}

	// Tests the tic() and time() method
	@Test
	public void testTicAndTime() {
		double[] init = { 0.4, 0.2, -0.1, 0.5, 0.7 };

		GuitarString gs = new GuitarString(init);
		assertEquals(5, gs.getCapacity());

		gs.tic();
		assertEquals(0.2, gs.sample(), 0.0001);
		gs.tic();
		assertEquals(-0.1, gs.sample(), 0.0001);
		gs.tic();
		assertEquals(0.5, gs.sample(), 0.0001);
		gs.tic();
		assertEquals(0.7, gs.sample(), 0.00001);
		gs.tic();
		gs.tic();
		gs.tic();
		gs.tic();
		gs.tic();
		gs.tic();

		assertEquals(10, gs.time());

	}

	// Tests the getCapacity() method
	@Test
	public void testGetCapacity() {

		double[] init = { 0.3, 0.2 };

		GuitarString gs = new GuitarString(init);
		assertEquals(2, gs.getCapacity());

		double[] testInit = { 0.7, 0.9, 0.4, 0.3, 0.2, 0.1 };
		GuitarString gsTest = new GuitarString(testInit);
		assertEquals(6, gsTest.getCapacity());
	}

	// Tests the capacity in the frequency GuitarStrings object
	@Test
	public void testFrequency() {

		GuitarString gs = new GuitarString(7.5);
		assertEquals(5881, gs.getCapacity());

		GuitarString guitar = new GuitarString(4.5);
		assertEquals(9801, guitar.getCapacity());

		GuitarString gString = new GuitarString(6.7);
		assertEquals(6583, gString.getCapacity());
	}

}