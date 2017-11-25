
/**
 * ProbTextWithMap.java
 * 
 * ProbTextWithMap creates probabilistic text (500 characters) from an 
 * input file and desired length of an nGram, using an ordered map (from OrderedMap) and
 * randomly choosing from an ArrayList of characters that follow an nGram inside the ordered
 * map.
 * 
 * @author Brian Loi
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ProbTextWithMap {

	public static void main(String[] args) {
		ProbTextWithMap rw = new ProbTextWithMap("Alice", 5);
		System.out.println("Print 500 random letters using an OrderedMap");
		System.out.println("==========================================");
		rw.printRandom(500);
	}

	// External References
	private int seedLength;
	private String fileName;
	private StringBuilder theText;
	private static Random generator;
	private String nGram;

	private StringBuilder text = new StringBuilder();
	private OrderedMap<String, ArrayList<Character>> map = new OrderedMap<String, ArrayList<Character>>();

	public ProbTextWithMap(String fileName, int seedLength) {
		this.fileName = fileName;
		this.seedLength = seedLength;
		generator = new Random();
		// makeTheText();
		// Creates a StringBuild with the entire text from a file
		Scanner in = null;
		try {
			in = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
		}
		while (in.hasNextLine()) {
			text.append(in.nextLine());
			text.append(' ');
		}

		// nGram = randomNGram();
		int textSize = text.length();
		int rand = generator.nextInt(textSize - seedLength);
		nGram = text.substring(rand, rand + seedLength);

		// setUpMap(); // Algorithm considered during lab
		String book = text.toString();
		String keyNGram = book.substring(0, seedLength);

		// Fills map with all keys and adds characters to lists
		while (book.length() > seedLength) {
			ArrayList<Character> list;
			// Stores the character after the keyNGram into a char
			char newChar = book.charAt(seedLength);
			// If the key does not already exist make a new list, else add refer
			// to the list
			if (map.get(keyNGram) == null) {

				list = new ArrayList<Character>();
			} else {
				list = map.get(keyNGram);
			}
			// Add the new character to the list
			list.add(newChar);
			// Puts the list back into the map
			map.put(keyNGram, list);
			// Changes the keyNGram
			keyNGram = changeKeyNGram(keyNGram, newChar);
			// Moves through the book character by character
			book = new String(book.substring(1));
		}
	}

	// Returns a string (that will represent the new keyNGram) that has
	// had its first character removed and a new character added to the end of
	// it
	private String changeKeyNGram(String keyNGram, char newChar) {
		keyNGram = keyNGram.substring(1);
		keyNGram = "" + keyNGram + newChar;
		return keyNGram;
	}

	// Print n characters using a probabilistic text generation scheme
	public void printRandom(int n) {
		// Int to represent when to print a new line character
		int lineBreak = 0;
		System.out.print(nGram);
		// While there are more characters to print
		while (n > 0) {
			String book = text.toString();
			// Saves a next character into a char
			char newChar = newChar(nGram, book);
			// Changes the nGram
			changeNGram(newChar);
			// Prints the new character
			System.out.print(newChar);
			lineBreak++;
			// When over 55 characters are printed and there is a space, print a
			// new line
			if (lineBreak > 55 && newChar == ' ') {
				System.out.println("");
				lineBreak = 0;
			}
			// There is one less character to print
			n--;
		}
	}

	// Returns a character from an ArrayList with the nGram key inside the
	// ordered map
	private char newChar(String nGram, String book) {
		// References list to be the ArrayList of the nGram
		ArrayList<Character> list = map.get(nGram);
		// Randomly chooses a character from the list
		int randChar = generator.nextInt(list.size());
		char newChar = list.get(randChar);
		return newChar;
	}

	// Modifies the current nGram so that the first character is removed and a
	// new character is added
	private void changeNGram(char newChar) {
		nGram = nGram.substring(1);
		nGram = "" + nGram + newChar;
		return;
	}
}