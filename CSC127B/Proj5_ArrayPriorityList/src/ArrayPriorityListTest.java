
// ArrayPriorityListTest.java
//
// Author: Brian Loi
//
// CSc 127B Spring 16
//
// Unit test for ArrayPriorityList<E> implements PriorityList<E>
//
import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayPriorityListTest {

	@Test
	public void testInsertToLeft() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "First");
		assertEquals("First", list.getElementAt(0));
		// Must shift array elements in this case
		list.insertElementAt(0, "New First");
		assertEquals("New First", list.getElementAt(0));
		assertEquals("First", list.getElementAt(1));
	}

	// Write short test methods to ensure methods throw exceptions
	// when they are supposed to throw new IllegalArgumentException();
	@Test(expected = IllegalArgumentException.class)
	public void testExceptionGetElementAtZeroWhenSizeIsZero() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.getElementAt(0);
	}
	
	@Test
	public void testGrowArray() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "one");
		list.insertElementAt(0, "two");
		list.insertElementAt(0, "three");
		list.insertElementAt(0, "four");
		list.insertElementAt(0, "five");
		list.insertElementAt(0, "six");
		list.insertElementAt(0, "seven");
		list.insertElementAt(0, "8");
		list.insertElementAt(0, "9");
		list.insertElementAt(0, "10");
		list.insertElementAt(0, "11");
		list.insertElementAt(0, "12");
		list.insertElementAt(0, "13");
		list.insertElementAt(0, "14");
		list.insertElementAt(0, "15");
		list.insertElementAt(0, "16");
		list.insertElementAt(0, "17");
		list.insertElementAt(0, "18");
		list.insertElementAt(0, "19");
		list.insertElementAt(0, "20");
		list.insertElementAt(0, "21");
		
	}

	@Test
	public void testSize() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Blah");
		list.insertElementAt(0, "x");
		list.insertElementAt(0, "foo");
		assertEquals(3, list.size());
		list.insertElementAt(3, "element");
		list.insertElementAt(0, "Haha");
		assertEquals(5, list.size());
		list.removeElementAt(0);
		list.removeElementAt(1);
		assertEquals(3, list.size());
		list.removeElementAt(0);
		assertEquals(2, list.size());
	}

	@Test
	public void testIsEmpty() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		assertEquals(true, list.isEmpty());
		list.insertElementAt(0, "Train");
		assertEquals(false, list.isEmpty());
	}

	@Test
	public void testInsertingElements() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Poo");
		list.insertElementAt(0, "Tree");
		list.insertElementAt(0, "Line");
		assertEquals("Line", list.getElementAt(0));
		assertEquals("Tree", list.getElementAt(1));
		assertEquals("Poo", list.getElementAt(2));
	}

	@Test
	public void testRemovingElements() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Truck");
		list.insertElementAt(0, "Stone");
		list.insertElementAt(0, "Lost");
		assertEquals("Lost", list.getElementAt(0));
		assertEquals("Stone", list.getElementAt(1));
		assertEquals("Truck", list.getElementAt(2));
		list.removeElementAt(0);
		assertEquals("Stone", list.getElementAt(0));
		assertEquals("Truck", list.getElementAt(1));
		assertEquals(2, list.size());
		list.removeElementAt(1);
		assertEquals(1, list.size());
		assertEquals("Stone", list.getElementAt(0));
	}

	@Test
	public void testGetElement() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Igloo");
		list.insertElementAt(1, "Cute");
		list.insertElementAt(2, "Frozen");
		list.insertElementAt(3, "Tickle");
		list.insertElementAt(4, "Bomb");
		list.insertElementAt(5, "River");
		assertEquals("Igloo", list.getElementAt(0));
		assertEquals("Bomb", list.getElementAt(4));
		assertEquals("Tickle", list.getElementAt(3));
		assertEquals("Cute", list.getElementAt(1));
		assertEquals("River", list.getElementAt(5));
	}

	@Test
	public void testLowerPriority() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Hat");
		list.insertElementAt(1, "Cool");
		list.insertElementAt(2, "Boat");
		list.insertElementAt(3, "Crisp");
		list.lowerPriorityOf(1);
		assertEquals("Boat", list.getElementAt(1));
		list.lowerPriorityOf(2);
		assertEquals("Crisp", list.getElementAt(2));
		list.lowerPriorityOf(0);
		assertEquals("Boat", list.getElementAt(0));
		assertEquals("Hat", list.getElementAt(1));
	}

	@Test
	public void testRaisePriority() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Bob");
		list.insertElementAt(1, "Chris");
		list.insertElementAt(2, "Dylan");
		list.insertElementAt(3, "Adam");
		list.raisePriorityOf(2);
		assertEquals("Dylan", list.getElementAt(1));
		assertEquals("Chris", list.getElementAt(2));
		list.raisePriorityOf(3);
		assertEquals("Adam", list.getElementAt(2));
		assertEquals("Chris", list.getElementAt(3));
		list.raisePriorityOf(1);
		assertEquals("Bob", list.getElementAt(1));
		assertEquals("Dylan", list.getElementAt(0));
	}

	@Test
	public void testToArray() {

		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "People");
		list.insertElementAt(1, "Trick");
		list.insertElementAt(2, "Grip");
		list.insertElementAt(3, "Free");

		Object[] temp = list.toArray();

		assertEquals("People", temp[0]);
		assertEquals("Trick", temp[1]);
		assertEquals("Grip", temp[2]);
		assertEquals("Free", temp[3]);
		assertEquals(4, temp.length);
	}

	@Test
	public void testMoveToFront() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Focus");
		list.insertElementAt(1, "Lens");
		list.insertElementAt(2, "Mirror");
		list.insertElementAt(3, "Light");

		list.moveToTop(3);
		assertEquals("Light", list.getElementAt(0));
		assertEquals("Focus", list.getElementAt(1));
		assertEquals("Lens", list.getElementAt(2));
		assertEquals("Mirror", list.getElementAt(3));

		list.moveToTop(2);
		assertEquals("Lens", list.getElementAt(0));
		assertEquals("Light", list.getElementAt(1));
		assertEquals("Focus", list.getElementAt(2));
		assertEquals("Mirror", list.getElementAt(3));
	}

	@Test
	public void testMoveToLast() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Tuna");
		list.insertElementAt(1, "Break");
		list.insertElementAt(2, "Milk");
		list.insertElementAt(3, "Small");

		list.moveToLast(1);
		assertEquals("Tuna", list.getElementAt(0));
		assertEquals("Milk", list.getElementAt(1));
		assertEquals("Small", list.getElementAt(2));
		assertEquals("Break", list.getElementAt(3));

		list.moveToLast(0);
		assertEquals("Milk", list.getElementAt(0));
		assertEquals("Small", list.getElementAt(1));
		assertEquals("Break", list.getElementAt(2));
		assertEquals("Tuna", list.getElementAt(3));
	}

	@Test
	public void testSizeZeroToArray() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		Object[] temp = list.toArray();
		assertEquals(0, temp.length);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionsAtInsertElements() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(-1, "Throw");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionAtGetElementAt() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Tuna");
		list.insertElementAt(1, "Break");
		list.insertElementAt(2, "Milk");
		list.insertElementAt(3, "Small");
		list.getElementAt(5);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionAtRemoveElementAt() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Tuna");
		list.insertElementAt(1, "Break");
		list.insertElementAt(2, "Milk");
		list.insertElementAt(3, "Small");
		list.removeElementAt(7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionAtLowerPriority() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Tuna");
		list.insertElementAt(1, "Break");
		list.insertElementAt(2, "Milk");
		list.insertElementAt(3, "Small");
		list.lowerPriorityOf(4);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionAtRaisePriority() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Tuna");
		list.insertElementAt(1, "Break");
		list.insertElementAt(2, "Milk");
		list.insertElementAt(3, "Small");
		list.raisePriorityOf(17);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionAtMoveToTop() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Tuna");
		list.insertElementAt(1, "Break");
		list.insertElementAt(2, "Milk");
		list.insertElementAt(3, "Small");
		list.moveToTop(6);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testThrowExceptionAtMoveToLast() {
		PriorityList<String> list = new ArrayPriorityList<String>();
		list.insertElementAt(0, "Tuna");
		list.insertElementAt(1, "Break");
		list.insertElementAt(2, "Milk");
		list.insertElementAt(3, "Small");
		list.moveToLast(-1);
	}

	//
	// You must add MANY, MANY more @Tests here.
	//
	// WebcCat test has 33 @Tests, 52 assertions, in 475 lines.
	//
	// In addition to the obvious, try inserting at index 0 when the list has
	// three elements, in the middle, and at size()

	// Every method that throws an exception has a test cases when index == -1,
	// index == size()-1, index == size()
	//
	// Add an @Test to requires insertElementAt to grow the array several times.
	//
	// Add @Test to ensure your cloned the array in toArray. A change to the
	// returned array must NOT change the ArrayPriorityList. The capacity of the
	// returned array must be equal to the size() of the PriorityList (not 20).
	//
} // End unit test for ArrayPriorityList
