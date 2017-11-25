/*Proj8_ReadTheDB.java
 *
 * CSc 127A Fall 15, Project 08
 *
 * Author: Brian Loi
 * SL Name: Tori Brenner
 *
 * ---
 *
 *This program will scan a text file and print out the lines of text within the file.
 * 
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Proj8_ReadTheDB
{
    public static void main(String[] args) throws FileNotFoundException
    {
        
        //Prints out an error if nothing entered in the command line
        if (args.length == 0)
        {
            System.out.println("ERROR: No File Name Entered");
            return;
        }
        
        //Ints to measure lengths of the arrays
        int MAX_WORDS = 1000;
        int wordsCounter = 1000;
        
        //Creates strings and an array
        String[] string1 = new String[MAX_WORDS];
        String[] string2 = new String[MAX_WORDS];
        int[] array = new int [MAX_WORDS];
        
        //Scanner
        Scanner databaseIn = new Scanner(new File(args[0]));
        
        //Prepares an int that will count how many records have been stored
        int recordCounter = 0;
        //Prepares an int that will count the number of errors
        int errorCounter = 0;
        //Prepares an in that will count the array 
        int arrCount = 0;
        
        //While there is more to read...
        while (databaseIn.hasNextLine())
        {
            String words = databaseIn.nextLine();
            
            //Skips a line silently if it has nothing -- Needs to change!
            if (words.length() == 0)
            {
                continue;
            }
            
            //Checks if the line has a space and prints an error if it does not
            int idx = words.indexOf(' ');
            if (idx == -1)
            {
                System.out.println("'"+words+"' ERROR: Format Incorrect");
                errorCounter++;
                continue;
            }
            
            //Creates a string for the last name and first name
            String firstWord = words.substring(0,idx+1);
            //Second half of words
            String foo = words.substring(idx+1, words.length());
            
            //Checks if there is a space between the first name and age
            int idx2 = foo.indexOf(' ');
            if (idx2 == -1)
            {
                System.out.println("'"+words+"' ERROR: Format Incorrect");
                errorCounter++;
                continue;
            }
            
            //Substring the second half of words to get just the first name
            String secondWord = foo.substring(0, idx2+1);
            
            //Creates a string with just the age number in it
            String ageString = foo.substring(idx2+1, foo.length());
            
            //If there is another space after the age, print an error
            int idx3 = ageString.indexOf(' ');
            if (idx3 > -1)
            {
                System.out.println("'"+words+"' ERROR: Format Incorrect");
                errorCounter++;
                continue;
            }
            
            //Parses the age into an int
            int ageNum = Integer.parseInt(ageString);
            
            //Stores the strings and ints into arrays
            string1[arrCount] = firstWord;
            string2[arrCount] = secondWord;
            array[arrCount] = ageNum;                   
            
            //If the arrays become full, break out of the loop and print an error
            wordsCounter = wordsCounter - firstWord.length() - secondWord.length() - ageString.length();
            
            if (wordsCounter < 0)
            {
                System.out.println("ERROR: The arrays have run out of space");
                errorCounter++;
                break;
            }
            
            //Adds 1 to the counters
            arrCount++;
            recordCounter++;
            
        }
        
        //Copying the arrays and minimizing them
        String[] lastName = new String[recordCounter];
        for (int i=0; i<recordCounter; i++)
        {
            lastName[i] = string1[i];
        }
        
        String[] firstName = new String[recordCounter];
        for (int i=0; i<recordCounter; i++)
        {
            firstName[i] = string2[i];
        }
        
        int[] age = new int[recordCounter];
        for (int i=0; i<recordCounter; i++)
        {
            age[i] = array[i];
        }
        
        //Prints out records       
        System.out.println();
        System.out.println("Records:");
        for (int i = 0; i<recordCounter; i++)
        {
            System.out.println(lastName[i]+firstName[i]+age[i]);
        }
        
        //Prints out number of errors and records
        System.out.println();
        System.out.println("Number of Records: "+recordCounter);
        System.out.println("Number of Errors: "+errorCounter);
        
    }
}