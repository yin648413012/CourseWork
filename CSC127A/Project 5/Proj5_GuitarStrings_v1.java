/*Proj5_GuitarString_v1.java
*
* CSc 127A Fall 15, Project 05
*
* Author: Brian Loi
* SL Name: Tori Brenner
*
* ---
*
* This program will create a simulation of random still, connected lines, that are to represent guitar strings.
*/

//Initializes Random generator
import java.util.Random;

public class Proj5_GuitarStrings_v1
{
    public static void main (String[] args)
    {
        
        Random rand;
        rand = new Random();
        
        //Creates an array for the height of the points of the lines
        double[] height = new double[100];
        height[0] = 0;
        height[99] = 0;
        
        //Sets the scale of the draw screen
        StdDraw.setXscale(0, height.length-1);
        StdDraw.setYscale(-70,70);
        
        //Creates a base line in the middle
        StdDraw.line(0,0,100,0);
        
        //Loops for all elements in the array, makes the height of points a random number between
        //-50 and 50 and draws the lines accordingly
        for (int i = 1; i < height.length-1; i++)
        {
            height[i] = rand.nextInt(101) - 50;
        }
        
        //Sets the initial x-value
        int num = 0;
        
        //Draws the lines connected to each others for every x-value
        for (int i = 1; i < height.length; i++)
        {
            StdDraw.line(num, height[i-1], num + 1, height[i]);
            num = num + 1;
        }
        
    }
}