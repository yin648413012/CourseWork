/**
 * OrderedMap<K, V> implements a Map ADT using a Binary search tree that
 * maintains all element in order based on the key.
 * 
 * @author Rick Mercer and Brian Loi
 * 
 * @param <K>
 *            The key (must implement Comparable)
 * @param <V>
 *            he value mapped the the key K
 */
public class OrderedMap<K extends Comparable<K>, V> {

	// Store one node in the BST data structure
	private class MapNode {
		private K key;
		private V value;
		private MapNode left;
		private MapNode right;

		public MapNode(K theKey, V theValue) {
			key = theKey;
			value = theValue;
			left = null;
			right = null;
		}
	} // end class MapNode

	// The single instance variable
	private MapNode root;
	// Instance variables that represents the size of the BST
	private int size;

	/**
	 * Build an empty BST of MapNodes with size == 0
	 */
	public OrderedMap() { // Create an empty tree
		root = null;
	}

	/**
	 * If the key is not in this Map, add a mapping and return null. If the key
	 * is present, return the previous value to indicate the old mapping is
	 * removed after replacing the old value with newValue.
	 * 
	 * @return null if the key exists or return the old value if the key is
	 *         present
	 */
	public V put(K key, V newValue) {

		MapNode t = root;

		// if the key is already used
		if (containsKey(key) == true) {
			// Stores the old value of the key into a temp variable
			V oldVal = get(key);

			// Find the key
			while (!key.equals(t.key)) {
				if (key.compareTo(t.key) < 0)
					t = t.left;
				else
					t = t.right;
			}
			// Changes the value in the key
			t.value = newValue;

			// Returns the old value
			return oldVal;
		} else {

			insert(key, newValue);
			size++;
			return null;
		}
	}

	// Private Helper method that inserts a key and value as a node into a BST
	private void insert(K key, V value) {
		// Reference nodes
		MapNode current = root;
		MapNode prev = root;
		// If the tree is empty, create the root node
		if (current == null) {
			root = new MapNode(key, value);
			return;
		}
		// Finds the place to insert the new node
		while (current != null) {
			// If a duplicate is found, return false
			if (current.key.equals(key))
				return;
			else {
				if (key.compareTo(current.key) < 0) {
					prev = current;
					current = current.left;
				} else if (key.compareTo(current.key) > 0) {
					prev = current;
					current = current.right;
				}
			}
		}
		// If the element is less than the parent node
		// Add a leaf to the left of the parent
		if (key.compareTo(prev.key) < 0) {
			prev.left = new MapNode(key, value);
			return;
		}
		// Else, the element MUST be greater than the parent node
		// Add leaf to the right of the parent
		else {
			prev.right = new MapNode(key, value);
			return;
		}
	}

	/**
	 * Find out how many mappings exist in this Map.
	 * 
	 * @return The number of key/value mappings.
	 */
	public int size() {
		return size;
	}

	/**
	 * Get the value mapped to the given key or null if the key does not exist
	 * 
	 * @param key
	 *            The key for the desired value
	 * @return the value mapped to the key or null if key was not found
	 */
	public V get(K key) {

		// If the tree map is empty, return null
		if (root == null)
			return null;

		// If the key is not found, return null
		if (containsKey(key) == false)
			return null;

		MapNode t = root;
		// Find the key
		while (!key.equals(t.key)) {
			if (key.compareTo(t.key) < 0)
				t = t.left;
			else
				t = t.right;
		}
		return t.value;
	}

	/**
	 * Determine if searchKey is already in the Map
	 * 
	 * @return true if key exists in the OrderedMap object, or false if it
	 *         doesn't
	 */
	public boolean containsKey(K searchKey) {
		return contains(searchKey, root);
	}

	// Private helper method for contains method with a TreeNode and search
	// parameter
	// Determines whether or not a binary tree contains a key
	// Returns true if the element exists in the tree, false if it does not
	private boolean contains(K searchKey, MapNode t) {
		// If the tree is empty/key is not found return false
		if (t == null)
			return false;
		// If the key is found, return true
		if (t.key.equals(searchKey)) {
			return true;
		}
		// Recursively searches through the BST
		if (searchKey.compareTo(t.key) > 0) {
			return contains(searchKey, t.right);
		} else {
			return contains(searchKey, t.left);
		}
	}

}