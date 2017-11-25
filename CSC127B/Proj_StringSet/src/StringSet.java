/**
 * StringSet.java
 *
 * CSc 127B Spring 16
 * 
 * Author: Brian Loi
 * 
 * Instructor: Rick Mercer
 * 
 * A class that creates an object of a 1D array of strings. The object is
 * organized alphabetically through an insertInOrder method. The class can check
 * if the string contains a string, can remove a string, can tell the amount of
 * strings(elements) in the array, and if the array is empty. The array never
 * has duplicates.
 * 
 */
public class StringSet {

	private String[] elements;
	private int n = 0;

	// Construct an empty StringSet with the capacity to store 20 elements.
	// Assume no test inserts more than 20 elements
	public StringSet() {
		elements = new String[20];
	}

	// Insert the new element in the correct position according to compareTo if
	// element
	// does not exist in this set, then return true. If element exists, return
	// false.
	public boolean insertInOrder(String element) {

		if (contains(element) == true)
			return false;

		int spotToInsert = findInsertionIndex(element);
		// elements -> "C" | "Gee" | null | null ...
		shiftRightFrom(spotToInsert);
		// elements -> "C" | "C" | "Gee" | null | null ...
		elements[spotToInsert] = element;
		n++;
		return true;
	}

	// Return a textual version of this set where elements are separate by ", ".
	// For example: '[Element1, Element2, Third, 4th]' or '[]' if empty
	public String toString() {
		String result = "[";
		for (int index = 0; index < n - 1; index++) {
			result = result + elements[index] + ", ";
		}

		if (n > 0)
			result = result + elements[n - 1];
		result = result + "]";

		return result;
	}

	// Return true if there are no elements in this Bag.
	public boolean isEmpty() {

		if (size() == 0)
			return true;

		else
			return false;

	}

	// Return the number of elements in this StringSet.
	public int size() {
		int elementCount = 0;

		for (int index = 0; index < elements.length; index++)
			if (elements[index] != null)
				elementCount++;

		return elementCount;

	}

	// Return true if element is found in this StringSet, false if element does
	// not exist
	public boolean contains(String element) {

		for (int index = 0; index < elements.length; index++)
			if (elements[index] == element)
				return true;

		return false;

	}

	// Remove the element if found and return true.
	// Return false if this set does not contains element
	public boolean remove(String element) {
		for (int index = 0; index < elements.length; index++)
			if (elements[index] == element) {
				shiftLeftFrom(index);
				n--;
				return true;
				}

		return false;
	}

	// Return a StringSet that is the union of this StringSet
	// and the other StringSet. Don't modify original, return a new object
	// In simplest terms, combines the arrays of the two objects into one array
	// and returns a new object
	public StringSet union(StringSet other) {
		
		//Creates a new object to modify and return
		StringSet set = new StringSet();
		//Sets the 1D array in the new object equal to the original
		for (int index = 0; index < elements.length; index++) 
		set.insertInOrder(elements[index]);
		
		//Iterates over the entire original array
		for (int index = 0; index < other.elements.length; index++)
		{
			set.insertInOrder(other.elements[index]);
		}
		
		return set;

	}

	
	private void shiftLeftFrom(int spotToRemove) {
		for (int index = spotToRemove; index < n; index++)
			elements[index] = elements[index+1];
		
	}
	
	private void shiftRightFrom(int spotToInsert) {
		for (int index = n; index > spotToInsert; index--) {
			elements[index] = elements[index - 1];
		}
	}

	private int findInsertionIndex(String element) {
		int index = 0;
		while (index < n && element.compareTo(elements[index]) > 0) {
			index++;
		}
		return index;
	}

}
