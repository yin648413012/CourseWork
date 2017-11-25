import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * A model for the game of 20 questions, using a binary tree structure
 * 
 * @author Brian Loi
 */
public class GameTree {

	// TreeNode Constructor Class
	private class TreeNode {
		private String data;
		private TreeNode left;
		private TreeNode right;

		// Constructor for a TreeNode with no links to other nodes
		public TreeNode(String theData) {
			data = theData;
			left = null;
			right = null;
		}

		// Constructor for a TreeNode with links to other nodes
		public TreeNode(String dataRef, TreeNode leftTree, TreeNode rightTree) {
			data = dataRef;
			left = leftTree;
			right = rightTree;
		}
	} // end class TreeNode

	// The external reference points
	private TreeNode root;
	private TreeNode current;
	private Scanner inFile;
	private String currentFileName;

	/**
	 * Constructor needed to create the game. Builds an expression tree from an
	 * input file.
	 * 
	 * @param name
	 *            this is the name of the file we need to import the game
	 *            questions and answers from.
	 */
	public GameTree(String name) {
		currentFileName = name;
		try {
			inFile = new Scanner(new File(currentFileName));
		} catch (FileNotFoundException e) {
			// This block would execute if currentFileNane is not found.
			// We will not have tests to construct GameTree objects with
			// non-existent files.
			return;
		}
		root = build();
		current = root;
		inFile.close();
	}

	// Constructs a binary tree data structure from a text file
	// Note: The text file contains the tree nodes in order
	private TreeNode build() {
		if (!inFile.hasNext())
			return null;

		String token = inFile.nextLine();
		token = token.trim();
		// If a leaf:
		if (isLeaf(token) == true)
			return new TreeNode(token);
		else {
			TreeNode left = build();
			TreeNode right = build();
			return new TreeNode(token, left, right);
		}
	}

	// Determines whether or not a tree node is an answer (or leaf) or not
	private boolean isLeaf(String token) {
		if (token.charAt(token.length() - 1) == '?')
			return false;
		else
			return true;
	}

	/*
	 * Add a new question and answer to the currentNode. If the current node has
	 * the answer chicken, theGame.add("Does it swim?", "goose"); should change
	 * that node like this:
	 */
	// -----------Feathers?-----------------Feathers?------
	// -------------/----\------------------/-------\------
	// ------- chicken horse-----Does it swim?-----horse--
	// -----------------------------/------\---------------
	// --------------------------goose--chicken-----------
	/**
	 * @param newQuestion
	 *            The question to add where the old answer was.
	 * @param newAnswer
	 *            The new Yes answer for the new question.
	 */
	public void add(String newQuestion, String newAnswer) {
		String temp = current.data;
		current.data = newQuestion;
		TreeNode left = new TreeNode(newAnswer);
		TreeNode right = new TreeNode(temp);
		current.left = left;
		current.right = right;
	}

	/**
	 * True if getCurrent() returns an answer rather than a question.
	 * 
	 * @return False if the current node is an internal node rather than an
	 *         answer at a leaf.
	 */
	public boolean foundAnswer() {
		if (getCurrent().charAt(getCurrent().length() - 1) == '?')
			return false;
		else
			return true;
	}

	/**
	 * Return the data for the current node, which could be a question or an
	 * answer.
	 * 
	 * @return The current question or answer.
	 */
	public String getCurrent() {
		return current.data;
	}

	/**
	 * Ask the game to update the current node by going left for Choice.yes or
	 * right for Choice.no Example code: theGame.playerSelected(Choice.Yes);
	 * 
	 * @param yesOrNo
	 */
	public void playerSelected(Choice yesOrNo) {
		if (yesOrNo == Choice.Yes)
			current = current.left;
		else
			current = current.right;
	}

	/**
	 * Begin a game at the root of the tree. getCurrent should return the
	 * question at the root of this GameTree.
	 */
	public void reStart() {
		current = root;
	}

	private String result;

	/**
	 * Return a textual version of this object
	 */
	@Override
	public String toString() {
		result = "";
		toString(root, 1);
		return result;
	}

	// Helper toString method, with a int parameter to create spacing between
	// levels
	private void toString(TreeNode t, int level) {
		if (t != null) {
			toString(t.right, level + 1);
			for (int i = 1; i < level; i++) {
				result += "- ";
			}
			result += t.data + '\n';
			toString(t.left, level + 1);
		}
	}

	/**
	 * Overwrite the old file for this gameTree with the current state that may
	 * have new questions added since the game started.
	 * 
	 */
	public void saveGame() {

		String outputFileName = currentFileName;
		FileWriter charToBytesWriter = null;
		try {
			charToBytesWriter = new FileWriter(outputFileName);
		} catch (IOException ioe) {
		}
		PrintWriter diskFile = new PrintWriter(charToBytesWriter);

		String treeInOrder = printInOrder();
		diskFile.print(treeInOrder);

		diskFile.close();
	}

	// Prints out the binary tree in order
	public String printInOrder() {
		return printInOrder(root);
	}

	// Helper Method for printInOrder method
	private String printInOrder(TreeNode t) {
		if (t == null)
			return "";
		else
			return t.data + '\n' + printInOrder(t.left) + printInOrder(t.right);
	}
}