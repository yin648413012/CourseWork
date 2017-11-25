/////////////////////////////////////////////////
/**
 * A collection class for storing a list of any type elements using a
 * doubly-linked data structure.
 * 
 * author: Brian Loi
 */
public class DoublyLinkedList<E extends Comparable<E>> implements Iterables<E> {

	// Constructs a Node
	private class Node {

		Node prev;
		E data;
		Node next;

		public Node(Node prevRef, E element, Node nextRef) {
			prev = prevRef;
			this.data = element;
			next = nextRef;
		}
	}

	private int n;
	private Node header, trailer;

	// Constructs an empty list
	public DoublyLinkedList() {
		n = 0;
		header = new Node(null, null, null);
		trailer = new Node(header, null, null);
		header.next = trailer;
	}

	// Return the number of elements in this list
	public int size() {
		return n;
	}

	// Insert the element at the given index.
	public void insertInorder(E element) {
		Node temp = header;

		// Finds the index to insert the element (in order)
		while (temp.next != trailer && element.compareTo(temp.next.data) >= 0) {
			temp = temp.next;
		}

		// Creates a new node and configures the references
		Node foo = new Node(temp, element, temp.next);
		temp.next.prev = foo;
		temp.next = foo;
		// Increase size by 1
		n++;
	}

	// Precondition: index > 0 && index < size
	public E get(int index) {
		// Initialize int to keep track of index
		int currentIndex = 0;

		// Initializes temp variable to return
		E temp = null;

		// Iterates over the entire list
		for (Node currentNode = header.next; currentNode != trailer; currentNode = currentNode.next) {
			if (index == currentIndex) {
				// Temp becomes the data in the current Node
				temp = currentNode.data;
				break;
			} else
				currentIndex++;
		}
		return temp;
	}

	// Remove element if found and return true
	// If not found, return false
	public boolean remove(E element) {

		// If empty, return false
		if (size() == 0)
			return false;

		Node temp = header;
		// Initializes int to know when entire list has gone through
		int falseCount = 0;

		// Stops temp at the index before the parameter element
		while (temp.next != trailer && temp.next.data != element) {
			temp = temp.next;
			falseCount++;
			if (falseCount == size()) {
				return false;
			}
		}

		// Configures the reference around the parameter element
		temp.next.next.prev = temp;
		temp.next = temp.next.next;
		// Decrease size by 1
		n--;
		return true;
	}

	// Return a reference to an object that has access to this list's elements
	public ForwardIterator<E> forwardIterator() {
		// This method is complete
		return new ForwardIter<E>();
	}

	private class ForwardIter<T> implements ForwardIterator<T> {

		Node temp = header;

		// Return true if there is a next node
		// Return false if the next node is trailer
		public boolean hasNext() {

			if (temp.next == trailer)
				return false;
			else
				return true;
		}

		// Temp becomes the next node and returns the data in the new temp
		@SuppressWarnings("unchecked")
		public T next() {

			temp = temp.next;
			T value = (T) temp.data;

			return value;
		}
	}

	// Return a reference to an object that has access to this list's elements
	public ReverseIterator<E> reverseIterator() {
		// This method is complete
		return new ReverseItr<E>();
	}

	private class ReverseItr<T> implements ReverseIterator<T> {

		Node temp = trailer;

		// Return true if there is a prev node
		// Return false if the prev node is header
		public boolean hasPrev() {

			if (temp.prev == header)
				return false;
			else
				return true;
		}

		// Temp becomes the prev node and returns the data of the new temp
		@SuppressWarnings("unchecked")
		public T prev() {

			temp = temp.prev;
			T value = (T) temp.data;

			return value;
		}
	}
	
} // end class DoublyLinkedList