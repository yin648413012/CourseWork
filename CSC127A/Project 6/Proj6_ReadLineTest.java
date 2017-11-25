/*Proj6_ReadLineTest.java
*
* CSc 127A Fall 15, Project 06
*
* Author: Brian Loi
* SL Name: Tori Brenner
*
* ---
*
*This program will read a line and print out two words from that line in seperate lines.
*/

//Initializes Scanner
import java.util.Scanner;

public class Proj6_ReadLineTest
{
    public static void main(String[] args)
    {
        //Creates an array for strings to be stored into
        int MAX_WORDS = 10000;
        String[] inputWords = new String[MAX_WORDS];
        int wordCount = 0;
        
        //Loops scanner while there is more to be read
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine())
        {
            String words = in.nextLine();
            
            //Checks if there was a space in the line
            int idx = words.indexOf(' ');
            
            //Prints an error if a space was not found and skips to the beginning of the loop
            if (idx == -1)
            {
                System.out.println("ERROR: No 'SPACE' Found!");
                continue;
            }
            
            //Stores the word before the space into a string
            String color = words.substring(0,idx);
            
            //Stores the word after the space into a string
            String shape = words.substring(idx + 1, words.length());
            
            //Prints out the color(first word) and shape(second word)
            System.out.println(color);
            System.out.println(shape);
            
            //Stores the line into an array, and moves on to the next element
            inputWords[wordCount] = words;
            wordCount++;
        }
        in.close();
    }
}