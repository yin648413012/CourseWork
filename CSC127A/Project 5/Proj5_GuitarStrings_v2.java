/*Proj5_GuitarString_v2.java
*
* CSc 127A Fall 15, Project 05
*
* Author: Brian Loi
* SL Name: Tori Brenner
*
* ---
*
* This program will create a simulation of guitar strings that will settle down over time.
*/

//Initilizes the random generator
import java.util.Random;

public class Proj5_GuitarStrings_v2
{
    public static void main (String[] args)
    {
        
        Random rand;
        rand = new Random();

        //Creates an array for the height of the points of the lines
        double[] height = new double[100];
        height[0] = 0;
        height[99] = 0;
        
        //Creates an array for the velocity of the points of the lines
        double[] velocity = new double[100];
        double newVel;
        
        //Sets the scale of the draw
        StdDraw.setXscale(0,height.length-1);
        StdDraw.setYscale(-70,70);
        
        //Generates a random number to initialize into an element in height
        for (int i = 1; i < height.length-1; i++)
        {
           height[i] = rand.nextInt(101) - 50;                
        }
        
        
        //Infinite loop
        while (true)
        {
            //Clears the draw
            StdDraw.show(0);
            StdDraw.clear();
            
            //Draws the lines connected to each other, on each x-value
            int num = 0;
            for (int i = 1; i < height.length; i++)
            {
                StdDraw.line(num,height[i-1],num+1,height[i]);
                num = num + 1;
            }
            
            
            //Uses Formula for velocity and inputs it into the array for velocity
            for (int i = 1; i < velocity.length-1; i++)
            {
                velocity[i] = velocity[i] + 0.01*(height[i-1] + height[i+1] - 2 * height[i]);
            }
            
            //Uses the new height formula and inputs it into the array for height
            for (int i = 1; i < height.length-1; i++)
            {
                height[i] = 0.999 * height[i] + velocity[i];
            }
                
            //Draws the basic line
            StdDraw.line(0,0,100,0);   
            StdDraw.show(0);
            
        }

    }
}