/**
 * OrderedSet.java
 * 
 * This class represents a model for a binary search tree, with constructor
 * methods and methods involving combining and modifying binary trees and
 * inserting and removing elements in a binary search tree so that the tree
 * remains in order.
 * 
 * @author Brian Loi
 */

public class OrderedSet<E extends Comparable<E>> {

	// TreeNode Constructor Class
	private class TreeNode {
		private E data;
		private TreeNode left;
		private TreeNode right;

		// Constructor for a TreeNode with no links to other nodes
		public TreeNode(E theData) {
			data = theData;
			left = null;
			right = null;
		}
	} // end class TreeNode

	// The external reference points
	private TreeNode root;
	// private TreeNode current = root;
	// private TreeNode prev = root;

	// Creates an empty OrderedSet
	public OrderedSet() {
		root = null;
	}

	// 1) Add element to this OrderedSet and return true keeping this a
	// OrderedSet.
	// If element is found to already exist, do not change this OrderedSet,
	// return false.
	public boolean insert(E element) {
		TreeNode current = root;
		TreeNode prev = root;
		// If the tree is empty, create the root node
		if (current == null) {
			root = new TreeNode(element);
			return true;
		}
		while (current != null) {
			// If a duplicate is found, return false
			if (current.data.equals(element))
				return false;
			else {
				if (element.compareTo(current.data) < 0) {
					prev = current;
					current = current.left;
				} else if (element.compareTo(current.data) > 0) {
					prev = current;
					current = current.right;
				}
			}
		}
		// If the element is less than the parent node
		// Add a leaf to the left of the parent
		if (element.compareTo(prev.data) < 0) {
			prev.left = new TreeNode(element);
			return true;
		}
		// Else, the element MUST be greater than the parent node
		// Add leaf to the right of the parent
		else {
			prev.right = new TreeNode(element);
			return true;
		}
	}

	// 2) The number of elements in this OrderedSet, which should be 0 when
	// first constructed.
	// This may run O(n) or O(1)--your choice.
	public int size() {
		return size(root);
	}

	private int size(TreeNode t) {
		if (t == null)
			return 0;
		else {
			return 1 + size(t.left) + size(t.right);
		}
	}

	// 3) Return one string that concatenates all elements in this OrderedSet as
	// they are
	// visited in order. Elements are separated by spaces as in "1 4 9" from
	// this OrderedSet:
	// 4
	// / \
	// 1 9
	public String toStringInorder() {
		return toStringInorder(root).trim();
	}

	// Private helper method for toString method with a TreeNode parameter
	// Returns the nodes in the binary tree in order in the form of a String
	private String toStringInorder(TreeNode t) {
		if (t == null) {
			return "";
		}
		return toStringInorder(t.left) + t.data + " " + toStringInorder(t.right);
	}

	// 4) Return true is search equals an element in this OrderedSet.
	public boolean contains(E search) {
		return contains(search, root);
	}

	// Private helper method for contains method with a TreeNode parameter
	// Determines whether or not a binary tree contains an element
	// Returns true if the element exists in the tree, false if it does not
	private boolean contains(E search, TreeNode t) {
		if (t == null)
			return false;
		if (t.data.equals(search)) {
			return true;
		}
		if (search.compareTo(t.data) > 0) {
			return contains(search, t.right);
		} else {
			return contains(search, t.left);
		}

	}

	// 5) Return the element in this OrderedSet that is greater than all other
	// elements.
	// If this OrderedSet is empty, return null.
	public E max() {
		if (size() == 0)
			return null;
		else
			return max(root.data, root);
	}

	// Private helper method for max method with an E and TreeNode parameter
	// Returns the largest element in the binary tree
	private E max(E max, TreeNode t) {
		if (t == null)
			return max;
		else {
			if (max.compareTo(t.data) < 0) {
				max = t.data;
				return max(max, t.right);
			} else {
				return max(max, t.right);
			}
		}
	}

	// 6) Return how many nodes are at the given level. If level > the height of
	// the tree,
	// return 0. Remember that an empty tree has a height of -1 (see page 252).
	//
	// 4 There is 1 node on level 0
	// / \
	// 3 9 There are 2 nodes on level 1
	// / / \
	// 1 5 11 There are 3 nodes in level 2 (and 0 nodes on levels >= 3)
	public int nodesAtLevel(int level) {
		return nodesAtLevel(level, root);
	}

	// Private helper method for nodesAtLevel method with an int and TreeNode
	// parameter
	// Returns the number of nodes at a level through recursion
	private int nodesAtLevel(int level, TreeNode t) {
		if (t == null)
			return 0;
		if (level == 0)
			return 1;
		else
			return nodesAtLevel(level - 1, t.left) + nodesAtLevel(level - 1, t.right);
	}

	// 7) Return the intersection of this OrderedSet and the other OrderedSet as
	// a new OrderedSet. Do not modify this OrderedSet or the other OrderedSet.
	// The intersection of two sets is the set of elements that are in both
	// sets.
	// The intersection of {2, 4, 5, 6} and {2, 5, 6, 9} is {2, 5, 6}
	public OrderedSet<E> intersection(OrderedSet<E> other) {

		OrderedSet<E> temp = new OrderedSet<E>();

		temp.intersection(other, root);

		return temp;
	}

	// Private helper method for intersection method
	// Inserts data into a binary tree, if both parameter trees contain the same
	// data
	private void intersection(OrderedSet<E> other, TreeNode t) {
		if (t == null)
			return;
		if (other.contains(t.data)) {
			intersection(other, t.left);
			insert(t.data);
			intersection(other, t.right);
		} else {
			intersection(other, t.left);
			intersection(other, t.right);
		}
	}

	// 8) Return the union of this OrderedSet and the other OrderedSet as
	// a new OrderedSet. Do not modify this OrderedSet or the other OrderedSet.
	// The union of two sets is the set all distinct elements in the
	// collection.[
	// The union of {2, 4, 6} and {2, 5, 9} is {2, 4, 5, 6, 9}
	public OrderedSet<E> union(OrderedSet<E> other) {
		if (size() == 0 && other.size() > 0)
			return other;
		else if (size() > 0 && other.size() == 0) {
			OrderedSet<E> rootTree = new OrderedSet<E>();
			rootTree.insertFromATree(root);
			return rootTree;
		} else if (size() == 0 && other.size() == 0) {
			OrderedSet<E> union = new OrderedSet<E>();
			return union;
		} else

			return union(other, root.data);
	}

	// Private helper method for union method
	// Inserts all the elements from the parameter tree(other tree) into a new
	// tree
	// Note: The higher root of the trees becomes the root in the new tree
	private OrderedSet<E> union(OrderedSet<E> other, E maxRoot) {

		if (other.root.data.compareTo(maxRoot) > 0)
			maxRoot = other.root.data;

		OrderedSet<E> union = new OrderedSet<E>();
		union.root = new TreeNode(maxRoot);

		union.insertFromATree(other.root);
		union.insertFromATree(root);

		return union;
	}

	// Private helper method for union method
	// Inserts all data from a tree(parameter) into another tree
	private void insertFromATree(TreeNode t) {
		if (t == null) {
			return;
		} else {
			insert(t.data);
			insertFromATree(t.left);
			insertFromATree(t.right);
		}
	}

	// 9) Return an OrderedSet that contains all elements that are greater than
	// or equal to
	// the first parameter (inclusive) and strictly less than the second
	// parameter (exclusive).
	public OrderedSet<E> subset(E inclusive, E exclusive) {
		OrderedSet<E> sub = new OrderedSet<E>();

		sub.subsetInsert(inclusive, exclusive, root);

		return sub;
	}

	// Private helper method for subset method
	// Inserts data from a tree that are within the inclusive and exclusive
	// parameters
	private void subsetInsert(E inclusive, E exclusive, TreeNode t) {
		if (t == null)
			return;
		else if (inclusive.compareTo(t.data) <= 0 && exclusive.compareTo(t.data) > 0) {
			insert(t.data);
			subsetInsert(inclusive, exclusive, t.left);
			subsetInsert(inclusive, exclusive, t.right);
		} else {
			subsetInsert(inclusive, exclusive, t.left);
			subsetInsert(inclusive, exclusive, t.right);
		}
	}

	// 10) Return true if two different OrderedSet objects have the same exact
	// structure.
	// Each node must have the same number of nodes on every level, the same
	// height,
	// the same size, the same number of leaves, and the same number of internal
	// nodes.
	// Each corresponding node must also have the same number of children (0, 1,
	// or 2)
	// in the same place. The data need NOT be the same. Do not compare
	// corresponding
	// elements. Each of these pairs of OrderedSets have the sameStructure:
	//
	// M P | Lmn Rts | 5 55 | 3 999
	// / \ / \ | / / | \ \ | / /
	// B R F Q | Abc Lmn | 10 89 | 2 888
	// \ \ \ \ | | / \ / \ | / /
	// F Z J R | | 8 77 79 99 | 1 777
	//
	// Empty trees also have the same structure.
	//
	// Each pair of these OrderedSets do NOT have the sameStucture (elements may
	// be "equals")
	//
	// M M | M M | 5 5 | 3 2
	// / \ / \ | / / | \ \ | / / \
	// B R B Z | L A | 10 12 | 2 1 3
	// \ \ \ / | / \ | / \ / | /
	// F Z F R | A L | 8 12 10 | 1
	// | | / |
	// | | 8 |
	//
	// Precondition: E is the same for both OrderedSets
	public boolean sameStructure(OrderedSet<E> other) {
		return sameStructure(other.root, root);
	}

	// Private helper method for sameStructure method
	// Checks that the tree and other tree nodes are null at the same nodes with
	// recursion
	// Returns false if one tree node is null and the other node is NOT null
	// Returns true if all trees have the same null nodes at the spots
	private boolean sameStructure(TreeNode other, TreeNode t) {
		if (t == null && other == null && t == null && other == null) {
			return true;
		} else if ((t != null && other == null) || t == null && other != null) {
			return false;
		} else
			return (sameStructure(other.left, t.left) == true && sameStructure(other.right, t.right) == true);
	}

	// 11) If element equals an element in this OrderedSet, remove it and return
	// true.
	// Return false whenever element is not found. In all cases, this OrderedSet
	// must
	// remain a true OrderedSet. Here is one recommended algorithm
	// http://www.cs.arizona.edu/~mercer/Projects/BSTRemoveGeneric.pdf
	public boolean remove(E element) {
		// References:
		TreeNode current = root;
		TreeNode prev = root;

		// Case 1 (Special Case): Element Not Found
		if (contains(element) == false)
			return false;
		// Case 2 (Special Case): Element removed is the root and root has no
		// left subtree
		else if (root.left == null && element.equals(root.data)) {
			root = root.right;
			return true;
		} else {

			// Finds the element to remove (sets it as current)
			while (!current.data.equals(element)) {
				// If the element to be removed is less than current's data, go
				// left
				if (element.compareTo(current.data) < 0) {
					prev = current;
					current = current.left;
				}
				// Else, the element MUST be greater than current's data, go
				// right
				else {
					prev = current;
					current = current.right;
				}
			}

			// Case 3: the element to remove does not have a left child
			if (current.left == null) {

				// If the element to remove is to the LEFT of its parent
				if (current.equals(prev.left)) {
					prev.left = current.right;
					return true;
				}
				// the element to remove is to the RIGHT of its parent
				else {
					prev.right = current.right;
					return true;
				}
			}
			// Case 4: the element to remove has a left child
			else {
				// Find maximum element in the left subtree of the node being
				// removed
				E maximum = max(current.left.data, current.left);

				// Remove the maximum element to prevent duplicates
				remove(maximum);

				// Make the current node to be removed's data into the max
				current.data = maximum;

				return true;
			}
		}

	}

}
