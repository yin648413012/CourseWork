/* Squares
*
* CSc 127A Fall 15, Project 03
*
* Author: Brian Loi
* SL Name: Tori Brenner
*
* ---
*
* This program will print out the squares of arguements from one integer to another 
*/

public class Proj3_Squares
{
    public static void main(String[]args)
    {
        
        //Checks the number of arguements that were passed
        if (args.length == 0)
   {
          System.out.println("ERROR: Exactly two arguements must be given: <start> <end>");
          return;
        }
        
        //Initializes variables 
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        
        //Checks if the second args is bigger than the first
        if (x > y)
   {
          System.out.println("ERROR: The start value must be <= the end!");
          return;
        }
        
        //Looper
        for (int i=x; i<=y; i++)
            System.out.println("The square of "+ i +" is "+(i*i));
        
       return;
       
    }
    
}
    
        
        
        
        