/**
 * LinkedPriorityList.java
 *
 * Author: Brian Loi
 * 
 * CSc 127B Spring 16
 *
 * This class implements a generic collection to store elements where indexes
 * represent priorities and the priorities can change in several ways in a
 * singly linked list.
 *
 * @param <E>
 *            The type of all elements stored in this collection
 */
public class LinkedPriorityList<E> implements PriorityList<E> {
	// This private inner class saves lots of typing and is hidden from
	// outsiders
	private class Node {
		// These instance variables can be accessed from the enclosing class
		private E data;
		private Node next;

		// Node constructor
		public Node(E element) {
			data = element;
			next = null;
		}

		// Node constructor including a link to the next Node
		public Node(E element, Node link) {
			data = element;
			next = link;
		}
	}

	// These instance variables belong to the enclosing class LinkePriorityList
	private Node first;
	private int size;

	// Create an empty list with zero elements
	public LinkedPriorityList() {
		first = null;
		size = 0;
	}

	/**
	 * Return the number of elements currently in this PriorityList
	 * 
	 * @return The number of elements in this PriorityList
	 */
	public int size() {
		// Returns size, the variable holding the number of elements in the list
		return size;
	}

	/**
	 * Return true if there are zero elements in this PriorityList
	 * 
	 * @return true if size() == 0 or false if size() > 0
	 */
	public boolean isEmpty() {

		if (size == 0)
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

		// Throws exception if the index is higher than the number of elements
		// or if it is lower than zero
		if (index > size() || index < 0)
			throw new IllegalArgumentException();

		// SPECIAL CASE: Inserting in the front of the list
		if (size == 0) {
			// Create a new node with parameter element as data
			Node head = new Node(el);
			// First becomes that new node
			first = head;
			// Increase the size by 1
			size++;
			// Terminate
			return;
		}

		// Create Node representing first
		Node ref = first;

		// SPECIAL CASE: Inserting in front
		if (index == 0 && first != null) {
			Node temp = new Node(el, ref);
			first = temp;
			size++;
			return;
		}

		// SPECIAL CASE: Inserting in middle of list
		if (index != size) {
			// Iterates over the size of the list to iterate over the list
			for (int currentIndex = 0; currentIndex < size(); currentIndex++) {
				// If the next index is the index where the element is inserted
				if (currentIndex == index - 1) {
					// Creates a new node with the parameter element
					// and a reference to the the next node
					Node temp = new Node(el, ref.next);
					// The next reference becomes temp
					ref.next = temp;
					// Increase size by 1
					size++;
					// Terminate
					return;
				}
				// Move on to next node
				ref = ref.next;
			}
		}

		// REGULAR CASE: Inserting at end of list
		// Goes through the entire linked list
		for (int currentIndex = 0; currentIndex <= size(); currentIndex++) {
			if (currentIndex == index - 1) {
				// Creates a new node holding the parameter element
				Node temp = new Node(el);
				// The next reference(the parameter index) becomes the temp node
				ref.next = temp;
				// Increase Size by 1
				size++;
				break;
			}
			// Move on to next node
			ref = ref.next;
		}
		return;
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

		// Throws exception if index is out of bounds
		if (index < 0 || index >= size)
			throw new IllegalArgumentException();

		// Initializes an int the keeps track of the index in the list
		int currentIndex = 0;
		// Initializes a null object
		Object element = null;

		// Iterates over the entire list
		for (Node ref = first; ref != null; ref = ref.next) {
			// If the count is the parameter index
			if (currentIndex == index) {
				// The null object becomes the data in the index node
				element = (E) ref.data;
				break;
			}
			// Add one to the index count
			currentIndex++;
		}
		// Returns the object
		return (E) element;
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

		if (index < 0 || index >= size)
			throw new IllegalArgumentException();

		// SPECIAL CASE: Index is 0
		if (index == 0) {
			Node temp = new Node(first.next.data, first.next.next);
			first = temp;
			size--;
			return;
		}

		// Initializes an int to keep track of the index in the list
		// Set to -1, because the current index is increased at the beginning of
		// each iteration
		int currentIndex = -1;

		// Special CASE: Removing Last Index
		if (index == size - 1) {
			// Iterates over the entire list
			for (Node ref = first; ref != null; ref = ref.next) {
				// Increase index count by 1
				currentIndex++;
				// If the next node is the index
				if (currentIndex == index - 1) {
					// Create a new node with the current node's data,
					// without a link to the last node
					Node temp = new Node(ref.data);
					// The current node becomes the new node
					ref = temp;
					// Decrease the size by 1
					size--;
					// Terminate
					return;
				}
			}
		}

		// Iterates over the entire list
		for (Node ref = first; ref != null; ref = ref.next) {
			// Increase the index count
			currentIndex++;
			if (currentIndex == index - 1) {
				// Creates a new node with the next next node data, and
				// reference to
				// the next next next node
				Node temp = new Node(ref.next.next.data, ref.next.next.next);
				// The next node becomes the temp node
				ref.next = temp;
				// Decrease size by 1
				size--;
				break;
			}
		}
		return;
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

		// Throw exception if index is out of bounds
		if (index >= size() || index < 0)
			throw new IllegalArgumentException();

		int currentIndex = 0;

		// If the index is the last index of the list, return to do nothing
		if (index == size - 1) {
			return;
		}

		// SPECIAL CASE: Index is 0
		if (index == 0) {
			// Swaps the first and second node
			Node temp = new Node(first.next.data, first);
			Node fixLink = new Node(first.data, first.next.next);
			first = temp;
			first.next = fixLink;
			return;
		}

		// Iterates over the entire list
		for (Node ref = first; ref != null; ref = ref.next) {
			if (currentIndex == index - 1) {
				// Swaps the nodes
				Node temp = new Node(ref.next.next.data, ref.next);
				// Creates a node to change the reference link
				Node fixLink = new Node(ref.next.data, ref.next.next.next);
				ref.next = temp;
				ref.next.next = fixLink;
				break;
			}
			// Increases index count by 1
			currentIndex++;
		}
		return;
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

		// Throws exception if index is out of bounds
		if (index < 0 || index >= size)
			throw new IllegalArgumentException();

		int currentIndex = 0;

		// If the index is 0, return to do nothing
		if (index == 0) {
			return;
		} else
		// SPECIAL CASE: Raising priority from index 1 to 0
		if (index == 1) {
			// Swaps the nodes in the in index 0 and 1
			Node temp = new Node(first.next.data, first);
			Node fixLink = new Node(first.data, first.next.next);
			first = temp;
			first.next = fixLink;
			return;
		} else
		// SPECIAL CASE: Raise Priority of Last index
		if (index == size - 1) {
			for (Node ref = first; ref != null; ref = ref.next) {
				if (ref.next.next.next == null) {
					Node temp = new Node(ref.next.next.data, ref.next);
					Node endLink = new Node(ref.next.data);
					ref.next = temp;
					ref.next.next = endLink;
					break;
				}
			}
			return;
		} else

			// Iterates over the entire list
			for (Node ref = first; ref != null; ref = ref.next) {
				if (currentIndex == index - 2) {
					// Swaps the nodes
					Node temp = new Node(ref.next.next.data, ref.next);
					// Creates a node to create to change the reference link
					// after
					// swap
					Node fixLink = new Node(ref.next.data, ref.next.next.next);
					ref.next = temp;
					// Changes the reference link
					ref.next.next = fixLink;
					break;
				}
				// Move onto the next index
				currentIndex++;
			}
		return;
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

		Object[] temp = new Object[size()];

		// Initializes an int representing the index
		int index = 0;

		// Iterates over the entire list
		for (Node ref = first; ref != null; ref = ref.next) {
			// The index in the Object because the data in the node
			temp[index] = ref.data;
			// Increase the index number
			index++;
		}

		// Return the object array
		return temp;
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

		// Throws an exception if the index is out of bounds
		if (index < 0 || index >= size)
			throw new IllegalArgumentException();

		// If index is already last, return to do nothing
		if (index == size - 1)
			return;

		int currentIndex = 0;
		Node mover = null;

		// SPECIAL CASE: Moving Index 0 to the end of the list
		if (index == 0) {
			for (Node ref = first; ref != null; ref = ref.next) {
				if (ref.next.next == null) {
					Node temp = new Node(first.next.data, first.next.next);
					Node hold = new Node(ref.next.data, first);
					first = temp;
					ref.next = hold;
					return;
				}
			}
		}

		// SPEICAL CASE: Moving the second to last index to the end of list
		if (index == size - 2) {
			for (Node ref = first; ref != null; ref = ref.next) {
				if (currentIndex == index - 1) {
					// Swaps the nodes
					Node temp = new Node(ref.next.next.data, ref.next);
					// Creates a node to change the reference link
					Node fixLink = new Node(ref.next.data);
					ref.next = temp;
					ref.next.next = fixLink;
					break;
				}
				// Increases index count by 1
				currentIndex++;
			}
			// Terminate
			return;
		}

		// Regular Case
		for (Node ref = first; ref != null; ref = ref.next) {
			if (currentIndex == index - 1) {
				// Finds the nodes at the index
				mover = new Node(ref.next.data);
				// Creates a node to change the link
				Node fixLink;
				fixLink = new Node(ref.next.next.data, ref.next.next.next);
				ref.next = fixLink;
			}
			// Changes the nodes at the end
			if (ref.next.next == null) {
				Node fixLink = new Node(ref.next.data, mover);
				ref.next = fixLink;
				break;
			}
			// Move onto the next index
			currentIndex++;
		}
		return;
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

		if (index < 0 || index >= size)
			throw new IllegalArgumentException();

		// If index 0 is being moved to the top, return to do nothing
		if (index == 0)
			return;

		int currentIndex = 0;
		Node mover = null;

		// Special Case: Moving index 1 to 0
		if (index == 1) {
			// Swaps the nodes in the in index 0 and 1
			Node temp = new Node(first.next.data, first);
			Node fixLink = new Node(first.data, first.next.next);
			first = temp;
			first.next = fixLink;
			return;
		} else

		// Special Case: Moving last to front
		if (index == size - 1) {
			for (Node ref = first; ref != null; ref = ref.next) {
				if (ref.next.next == null) {
					// Makes the node at the end reference to the first node
					mover = new Node(ref.next.data, first);
					// Makes a node with the data of the node before the last
					// one
					// without a link to become the last node in the list
					Node endLink = new Node(ref.data);
					ref = endLink;
					first = mover;
					break;
				}
			}
			return;
		} else
			// Regular Case
			for (Node ref = first; ref != null; ref = ref.next) {
				// Finds the node before the index
				if (currentIndex == index - 1) {
					// Makes a new node with a link to first
					mover = new Node(ref.next.data, first);
					// Creates a node to become to replace the index node
					Node fixLink;
					if (ref.next.next.next == null) {
						fixLink = new Node(ref.next.next.data);
					} else
						fixLink = new Node(ref.next.next.data, ref.next.next.next);
					first = mover;
					ref.next = fixLink;
					break;
				}
				// Move onto the next Index
				currentIndex++;
			}
		return;
	}
}