/**
 * Linked List.java
 * 
 * CSc 127B Spring 16
 * 
 * This class contains 4 (out of 21 total) examples/problems of methods that use
 * recursion in a linked list.
 * 
 * 
 * @author Brian Loi
 */

public class LinkedList<E extends Comparable<E>> {

	// Node Constructor
	private class Node {
		private E data;
		private Node next;

		public Node(E element) {
			data = element;
			next = null;
		}
	}

	private Node first;
	private int n;

	// Linked List Constructor
	public LinkedList() {
		first = null;
		n = 0;
	}

	// Returns the number of elements in the linked list
	public int size() {
		return n;
	}

	// Adds an element to the end of the linked list
	public void addLast(E el) {
		if (first == null)
			first = new Node(el);
		else
			addLast(el, first);
		n++;
	}

	// Adds an element to the linked list, with a reference to the next node
	private void addLast(E el, Node ref) {
		if (ref.next == null)
			ref.next = new Node(el);
		else
			addLast(el, ref.next);
	}

	// Returns a string of the elements in the linked list
	public String toString() {

		String toPrint = "";

		for (Node ref = first; ref != null; ref = ref.next)
			toPrint = "" + toPrint + ref.data + " ";

		return toPrint.trim();
	}

	// #18 get - Return a reference to the element at the given index.
	public E get(int index) {
		return get(index, 0, first);
	}

	private E get(int index, int currentIndex, Node ref) {

		if (currentIndex == index)
			return ref.data;

		return get(index, currentIndex + 1, ref.next);
	}

	// #19 max - Return the largest element in this list according to the type’s
	// compareTo method
	public E max() {
		if (size() == 0)
			return null;

		return max(first.data, first);
	}

	private E max(E max, Node ref) {

		if (max.compareTo(ref.data) <= -1)
			max = ref.data;

		if (ref.next == null)
			return max;

		return max(max, ref.next);
	}

	// #20 occurencesOf - Return how often el occurs in this list
	public int occurencesOf(E el) {
		return occurencesOf(el, first);
	}

	private int occurencesOf(E el, Node ref) {

		if (el.equals(ref.data) && ref.next != null)
			return 1 + occurencesOf(el, ref.next);

		if (el.equals(ref.data) && ref.next == null)
			return 1;

		if (ref.next == null)
			return 0;

		return occurencesOf(el, ref.next);
	}

	// #21 duplicateAll - all elements in the singly linked structure that
	// equals element are repeated next to the original. The size should
	// increase for each element.
	public void duplicateAll(E el) {
		duplicateAll(el, first);
		return;
	}

	private void duplicateAll(E el, Node ref) {

		if (ref == null)
			return;

		if (el.equals(ref.data)) {
			Node dup = new Node(el);
			dup.next = ref.next;
			ref.next = dup;
			n++;
			duplicateAll(el, ref.next.next);
		} else if (ref.next == null)
			return;
		else
			duplicateAll(el, ref.next);
	}
}
