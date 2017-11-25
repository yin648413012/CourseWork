/* Proj4_Gradient
*
* CSc 127A Fall 15, Project 04
*
* Author: Brian Loi
* SL Name: Tori Brenner
*
* ---
*
* This program will create a color gradient using the colors red, green and blue.
*/


public class Proj4_Gradient
{
    public static void main(String args[])
    {
        //Checks if an argument was given, and prints out an error if none were given
        if (args.length == 0)
            System.out.println("ERROR: No value for blue was given. Enter an argument!");
        if (args.length == 0)
            return;
        
        //Initializes color variables
        int blue = Integer.parseInt(args[0]);
        int red;
        int green;
        
        //If the arg, or value of blue, is less than zero an error will be printed and the program
        //will terminate
        if (blue < 0) 
            System.out.println("ERROR: A color can not be of a value less than zero");
        if (blue < 0)
            return;
        
        //If the arg, or value of blue, is greater than 255, an error will be printed and the
        //program will terminate
        if (blue > 255)
            System.out.println("ERROR: A color can not be of a value greater than 255");
        if (blue > 255)
            return;
        
        //Sets the scale of the grid so that all possible color values can appear
        StdDraw.setScale (0,255);
        StdDraw.clear();
        
        //Speeds up the loading of the gradient
        StdDraw.show(0);
        
        //Loops the values of the colors red and green for all values from 0 to 255
        //and creates a square for each possibility
        for (red = 0; red < 256; red++)
            {
              for (green = 0; green < 256; green++)
              {
                StdDraw.setPenColor(red, green, blue);  
                StdDraw.filledSquare(red,green,1);
              }
            }
        
        //Speeds up the loading of the gradient
        StdDraw.show(0);
        
    }
}