/*Proj7_Chaser.java
*
* CSc 127A Fall 15, Project 07
*
* Author: Brian Loi
* SL Name: Tori Brenner
*
* ---
*
*This program will draw a filled circle that will change to random colors very quickly
*and follow the mouse, leaving traces of the colored circles behind.
*/

//Initializes Random
import java.util.Random;

public class Proj7_Chaser
{
    public static void main(String[] args)
    {
        //Sets the draw scale
        StdDraw.setScale(-100,100);
        
        //Sets the initial coordinates of the circle so that it starts in the middle
        //of the draw
        double x = 0;
        double y = 0;
        
        //Generates a random number up to 255
        Random rand = new Random(256);
        
        //Infinite Loop
        while (true)
        {
            //Animates draw, but slows it down slightly
            StdDraw.show(1);
            
            //Clear the draw if the mouse is pressed
            if (StdDraw.mousePressed())
            {
                StdDraw.clear();
            }
            
            //Stores random color values into integers
            int red = rand.nextInt(256);
            int blue = rand.nextInt(256);
            int green = rand.nextInt(256);
            
            StdDraw.setPenColor(red, green, blue);

            //Makes the circle follow the mouse in a straight line or 45 degree angle
            if (StdDraw.mouseX() > x)
            {
                x = x+1;
            }
            if (StdDraw.mouseY() > y)
            {
                y = y+1;
            }
            if (StdDraw.mouseX() < x)
            {
                x = x-1;
            }
            if (StdDraw.mouseY() < y)
            {
                y = y-1;
            }

            //Draws the circle with a radius of 10
            StdDraw.filledCircle(x,y,10);
            
            StdDraw.show(1);
        
        }
    }
}