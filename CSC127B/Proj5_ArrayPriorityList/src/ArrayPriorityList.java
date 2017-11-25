/**
 * ArrayPriorityList.java
 *
 * Author: Brian Loi
 * 
 * CSc 127B Spring 16
 *
 * This class implements a generic collection to store elements where indexes
 * represent priorities and the priorities can change in several ways.
 *
 * @author Rick Mercer
 * @param <E>
 *            The type of all elements stored in this collection
 */
public class ArrayPriorityList<E> implements PriorityList<E> {

	private Object[] data; // The data structure storing elements
	private int n; // The number of meaningful elements

	// Create an empty list with zero elements
	public ArrayPriorityList() {
		data = new Object[20]; // Do NOT increase the initial capacity
		//n holds the number of elements in the array
		n = 0;
	}

	/**
	 * Return the number of elements currently in this PriorityList
	 *
	 * @return The number of elements in this PriorityList
	 */
	public int size() {
		//n is equal to the size(number of elements in the array)
		return n;
	}

	/**
	 * Return true if there are zero elements in this PriorityList
	 *
	 * @return true if size() == 0 or false if size() > 0
	 */
	public boolean isEmpty() {

		//If n (the size) is 0, return true; else false
		if (n == 0)
			return true;
		else
			return false;
	}

	/**
	 * If possible, insert the element at the given index. If index is out of
	 * the valid range of 0..size(), throw new IllegalArgumentException(); When
	 * size is 3, the only possible values for index are 0, 1, 2, AND 3 because
	 * you can add an element as the new last.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @param el
	 *            The element to insert
	 * @throws IllegalArgumentException
	 */
	public void insertElementAt(int index, E el) throws IllegalArgumentException {

		//Throws exception if the index is higher than the number of elements
		//or if it is lower than zero
		if (index > size() || index < 0)
			throw new IllegalArgumentException();

		//If the array is full 
		if (n == data.length) {
			
			//Creates new temp object array with a bigger length
			Object[] temp = new Object[data.length+5];
			
			//Iterates over the original array and copies elements over to
			//the temp array
			for (int i = 0; i < data.length; i++)
				temp[i] = data[i];
			
			//The original array becomes the temp array
			data = temp;
		}
		
		//If the index in the array is empty, fill it with the parameter element
		if (data[index] == null) {
			data[index] = el;
			n++;
		} else {
			//Shift everything right of the index(including element at index)
			for (int i = size(); i > index; i--)
				data[i] = data[i - 1];
			//The index of the array becomes the parameter element
			data[index] = el;
			//Increase the number of elements in the array
			n++;
		}

	}

	/**
	 * If possible, return a reference to the element at the given index. If
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @return A reference to the element at index index.
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	public E getElementAt(int index) throws IllegalArgumentException {

		//Throws exception if index is out of bounds of the size
		if (index >= size() || index < 0)
			throw new IllegalArgumentException();

		//Returns the element at the index, casts the element
		return (E) data[index];
	}

	/**
	 * If possible, remove the element at the given index. If index is out of
	 * the valid range of 0..size()-1, throw new IllegalArgumentException();
	 * When size is 3, the only possible values for index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void removeElementAt(int index) throws IllegalArgumentException {

		//Throw exception if the index is out of bounds of the size
		if (index >= size() || index < 0)
			throw new IllegalArgumentException();

		//Makes the element at the index null
		data[index] = null;

		//Shifts everything to the left from the index
		for (int i = index; i < size(); i++)
			data[i] = data[i + 1];

		//Decreases the number of elements
		n--;

	}

	/**
	 * If possible, swap the element located at index with the element at index
	 * + 1. An attempt to lower the priority of the element at index size()-1
	 * has no effect. If index is out of the valid range of 0..size()-1, throw
	 * new IllegalArgumentException(); When size is 3, the only possible values
	 * for index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void lowerPriorityOf(int index) throws IllegalArgumentException {

		//Throw exception if index is out of bounds
		if (index >= size() || index < 0)
			throw new IllegalArgumentException();

		//Create a temp object to hold element
		Object temp;

		//Swaps the elements (the element of the index and element of the next index)
		if (index != size() - 1) {
			temp = data[index];
			data[index] = data[index + 1];
			data[index + 1] = temp;
		}

	}

	/**
	 * If possible, swap the element located at index with the element at
	 * index-1. An attempt to raise the priority at index 0 has no effect. If
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move
	 * @throws IllegalArgumentException
	 */
	public void raisePriorityOf(int index) throws IllegalArgumentException {

		//Throws exception if index out of bounds
		if (index >= size() || index < 0)
			throw new IllegalArgumentException();

		//Create temp object for swap
		Object temp;

		//Swaps elements (index element and element of index before
		if (index != 0) {
			temp = data[index];
			data[index] = data[index - 1];
			data[index - 1] = temp;
		}

	}

	/**
	 * Return a copy of all elements as an array of Objects that is the size of
	 * this PriorityList and in the same order. If there are no elements in this
	 * list, return new Object[0]; A change to the return value must not affect
	 * this PriorityList object.
	 *
	 * @return An array of Objects where capacity == size()
	 */
	public Object[] toArray() {

		//Returns an object array of size 0 if the size is 0
		if (size() == 0)
			return new Object[0];

		//Creates object array with length of the size
		Object[] copy = new Object[size()];

		//Iterates over the object array and copies into the new array
		for (int i = 0; i < size(); i++)
			copy[i] = data[i];

		return copy;
	}

	/**
	 * If possible, move the element at the given index to the end of this list.
	 * An attempt to move the last element to the last has no effect. If the
	 * index is out of the valid range 0..size()-1 throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToLast(int index) throws IllegalArgumentException {

		//Throws exception if index out of bounds
		if (index >= size() || index < 0)
			throw new IllegalArgumentException();

		//Creates temp object to hold element at index
		Object temp = data[index];

		//Shifts every element to the left
		for (int i = index; i < size() - 1; i++)
			data[i] = data[i + 1];

		//The index at the end of the list becomes the temp element
		data[n - 1] = temp;
	}

	/**
	 * If possible, move the element at the given index to the front of this
	 * list An attempt to move the top element to the top has no effect. If the
	 * index is out of the valid range of 0..size()-1, throw new
	 * IllegalArgumentException(); When size is 3, the only possible values for
	 * index are 0, 1, and 2.
	 *
	 * @param index
	 *            The index of the element to move.
	 * @throws IllegalArgumentException
	 */
	public void moveToTop(int index) throws IllegalArgumentException {

		//Throws exception if index out of bounds
		if (index >= size() || index < 0)
			throw new IllegalArgumentException();

		//Creates a temp object to hold element at index
		Object temp = data[index];

		//Shifts every element to the right
		for (int i = index; i > 0; i--)
			data[i] = data[i - 1];

		//The first index becomes the temp element
		data[0] = temp;
	}
}