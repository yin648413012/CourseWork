
/**
 * ProbTextWithList.java
 * 
 * ProbTextWithList creates probabilistic text (500 characters) from an 
 * input file and desired length of an nGram, using an ArrayList and randomly
 * choosing the next character from a list.
 * 
 * @author Brian Loi
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class ProbTextWithList {

	// Main Method - Constructs the StringBuilder and random nGram
	// and calls the printRandom method to print Probabilistic Text
	public static void main(String[] args) {
		ProbTextWithList rw = new ProbTextWithList("Alice", 5);
		System.out.println("Print 500 probable letters using an ArrayList");
		System.out.println("============================================");
		rw.printRandom(500);
	}

	// External References
	private String fileName; // name of file
	private Random generator;
	private int nGramLength;
	private String nGram;

	private StringBuilder text = new StringBuilder();

	// Constructor
	public ProbTextWithList(String fileName, int nGramLength) {
		this.fileName = fileName;
		this.nGramLength = nGramLength;
		generator = new Random();

		// MakeTheText();
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
		// Randomly chooses an nGram with the length of nGramLength
		int textSize = text.length();
		int rand = generator.nextInt(textSize - nGramLength);
		nGram = text.substring(rand, rand + nGramLength);
	}

	// Returns a character randomly from an ArrayList that contains every
	// character following the current nGram from the input text
	private char newChar(String nGram, String book) {
		// Builds the ArrayList with characters following nGram
		ArrayList<Character> list = new ArrayList<Character>();
		while (book.length() > nGramLength) {
			if (nGram.equals(book.substring(0, nGram.length()))) {
				list.add(book.charAt(nGram.length()));
			}
			book = new String(book.substring(1));
		}

		// Randomly chooses character from list
		int randChar = generator.nextInt(list.size());
		char newChar = list.get(randChar);
		return newChar;
	}

	// Print n characters using a probabilistic text generation scheme
	public void printRandom(int charsToPrint) {
		// Int representing when to print a new line character
		int lineBreak = 0;
		System.out.print(nGram);
		// While there are more characters to print
		while (charsToPrint > 0) {
			String book = text.toString();
			// Saves a next character into a char
			char newChar = newChar(nGram, book);
			// Changers the nGram
			changeNGram(newChar);
			// Prints the new char
			System.out.print(newChar);
			lineBreak++;
			// When over 55 characters are printed and there is a space, print a
			// new line
			if (lineBreak > 55 && newChar == ' ') {
				System.out.println("");
				lineBreak = 0;
			}
			// There is one less character to print
			charsToPrint--;
		}
	}

	// Modifies the current nGram so that the first character is removed and a
	// new character is added
	private void changeNGram(char newChar) {
		nGram = nGram.substring(1);
		nGram = "" + nGram + newChar;
		return;
	}

}