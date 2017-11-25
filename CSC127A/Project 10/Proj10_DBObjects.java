/*Proj10_DBObjects.java
 *
 * CSc 127A Fall 15, Project 10
 *
 * Author: Brian Loi
 * SL Name: Tori Brenner
 *
 * ---
 *
 *This program will scan a text file and print out lines depending if the command
 * line calls for a last name, first name, or age, through an array of objects.
 * 
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Proj10_DBObjects
{
    public static void main(String[] args) throws FileNotFoundException
    {
        
        //Prints out an error if nothing entered in the command line
        if (args.length != 1)
        {
            System.out.println("ERROR: No File Name Entered");
            return;
        }
        
        //Ints to measure lengths of the arrays
        int MAX_WORDS = 1000;
        int wordsCounter = 1000;
        
        //Creates an array of objects with 1000 elements
        Record[] maxData = new Record[1000];
        for (int i = 0; i<maxData.length; i++)
        {
            maxData[i] = new Record();
        }
        
        
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
                //System.out.println("'"+words+"' ERROR: Format Incorrect");
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
                //System.out.println("'"+words+"' ERROR: Format Incorrect");
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
                //System.out.println("'"+words+"' ERROR: Format Incorrect");
                errorCounter++;
                continue;
            }
            
            //Parses the age into an int
            int ageNum = Integer.parseInt(ageString);
            
            //Stores the strings and ints into the object array
            maxData[arrCount].last = firstWord;
            maxData[arrCount].first = secondWord;
            maxData[arrCount].age = ageNum;                   
            
            //If the arrays become full, break out of the loop and print an error
            wordsCounter = wordsCounter - firstWord.length() - secondWord.length() - ageString.length();
            
            if (wordsCounter < 0)
            {
                System.out.println("ERROR: The arrays have run out of space");
                errorCounter++;
                //!!!!!!!!!!!!!
                break;
            }
            
            //Adds 1 to the counters
            arrCount++;
            recordCounter++;
            
        }
        
        //Creates a new object array to resize into 
        Record[] data = new Record[recordCounter];
        
        for (int i = 0; i<data.length; i++)
        {
            data[i] = new Record();
        }
        
        
        //Copies the object array with info into the new resized array
        for (int i = 0; i<data.length; i++)
        {
            data[i] = maxData[i];
        }
        
        
        System.out.println("Number of Records: "+recordCounter);
        System.out.println("Number of Errors: "+errorCounter);
        
///////////////////////////////////////////////////////////////////////////////      
        
        
        //Stores scanner in a new object
        Scanner in = new Scanner(System.in);
        
        //While scanner has more to read...
        while (in.hasNextLine())
        {
            //Stores the line into a string 
            String command = in.nextLine();
            
            //Stores the element of the space into an int
            int space = command.indexOf(' ');
            
            ////////////////////////////////////////////////////////////
            
            //calls the listAll method, if listAll is typed into the command line
            if (command.compareTo("listAll") == 0)
            {
                listAll(data);
            }
            
            ///////////////////////////////////////////////////////////
            
            else
            {

            //Stores the second word in the command line into a string
            String search = command.substring(space+1, command.length());
            
            //if there are more than two words, print an error
            int spaceCheck = search.indexOf(' ');
            if (spaceCheck > -1)
            {
                System.out.println("ERROR: Command Line Error");
                continue;
            }
            
            int wop = command.indexOf(' ');
            
            //If there is no space after the first word, print an error and continue
            if (wop == -1)
            {
                System.out.println("ERROR: COMMAND NOT RECOGNIZED");
                continue;
            }
            //Stores the first word in the command line into a string
            String firstWord = command.substring(0,wop);
            
            
            //////////////////////////////////////////////////////////////
            
            
            //if the first word is lastName, then use the findByLastName method
            if (firstWord.compareTo("lastName") == 0)
            {
                search = ""+search+' ';
                findByLastName(data, search);
            }
            else
            //if the first word is firstName, then use the firstName method
            if (firstWord.compareTo("firstName") == 0)
            {
                search = ""+search+' ';
                findByFirstName(data, search);
            }
            else
            //if the first word is age, then use the age method
            if (firstWord.compareTo("age") == 0)
            {
                //Parses the age into an int
                int searchAge = Integer.parseInt(search);
                findByAge(data, searchAge);
            }
            //Prints out an error if no valid commands were entered
            else
            {
                System.out.println("ERROR: COMMAND NOT RECOGNIZED");
            }
            
            }
            
            
        }
    }

    
    //Methods:
    
    
    //listAll Method -> Prints out all the records in the database
    public static void listAll(Record[] data)
    {
        System.out.println("Records:");
        //iterates over all the elements of the arrays and prints them out
        for (int i = 0; i<data.length; i++)
        {
            System.out.println(data[i].toString());
        }
        System.out.println("");
        System.out.println(data.length+" RECORDS FOUND");
    }
    
    //findbyLastName Method
    public static void findByLastName(Record[] data, String search)
    {
        //int to store record count
        int wordCount = 0;
        System.out.println("Records:");
        //iterates over object array for all elements that match search and print them out
        for (int i = 0; i<data.length; i++)
        {
            if (data[i].last .compareTo(search) == 0)
            {
                System.out.println(data[i].toString());
                wordCount++;
            }
        }
        System.out.println("");
        System.out.println(wordCount+" RECORDS FOUND");
    }

    //findByFirstName method
    public static void findByFirstName(Record[] data, String search)
    {
        int wordCount = 0;
        System.out.println("Records:");
        for (int i = 0; i<data.length; i++)
        {
            if (data[i].first .compareTo(search) == 0)
            {
                System.out.println(data[i].toString());
                wordCount++;
            }
        }
        System.out.println("");
        System.out.println(wordCount+" RECORDS FOUND");
    }

    //findByAge method
    public static void findByAge(Record[] data, int search)
    {
        int wordCount = 0;
        System.out.println("Records:");
        for (int i = 0; i<data.length; i++)
        {
            if (data[i].age == search)
            {
                System.out.println(data[i].toString());
                wordCount++;
            }
        }
        System.out.println("");
        System.out.println(wordCount+" RECORDS FOUND");
    }

}