/* Repeat
*
* CSc 127A Fall 15, Project 03
*
* Author: Brian Loi
* SL Name: Tori Brenner
*
* ---
*
* This program will print out a word a certain number of times. 
*/

public class Proj3_Repeat
{
    public static void main(String[]args) 
    {
        
        
        //Checks the number of arguments that were passed
        if (args.length == 0)
   {
          System.out.println("No arguments were given.");
          return;
    }
        
        // Sets the strings and args for the first word and how many times it is repeated
        String wordOne = args[0];
        int x = Integer.parseInt(args[1]);
        
        //Looper
        for (int i=0; i<x; i++)
            System.out.println(args[0]);
        
        //Checks the number of arguments that were passed, and returns if there is no more args
        if (args.length == 2)
   {
          return;
    }
        
        //Sets the strings and args for the second word and how many times it is repeated
        String wordTwo = args[2];
        int y = Integer.parseInt(args[3]);
        
        for (int i=0; i<y; i++)
            System.out.println(args[2]);
        
        
        //Checks the number of arguments that were passed, and returns if there is no more args
        if (args.length == 4)
   {
          return;
    }
        
        //Sets the strings and args for the third word and how many times it is repeated
        String wordThree = args[4];
        int z = Integer.parseInt(args[5]);
        
        
        for (int i=0; i<z; i++)
            System.out.println(args[4]);        

        
    }
}