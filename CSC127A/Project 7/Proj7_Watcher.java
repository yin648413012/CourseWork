/*Proj7_Watcher.java
*
* CSc 127A Fall 15, Project 07
*
* Author: Brian Loi
* SL Name: Tori Brenner
*
* ---
*
*This program will draw a set of eyes and the pupils will follow the mouse.
*/

public class Proj7_Watcher
{
    public static void drawEyes(double xCenterOfEye, double yCenterOfEye, double radius)
    {
        
        //Draws an eye, excluding the pupil
        StdDraw.circle(xCenterOfEye, yCenterOfEye, radius);  
        
        //Creates a vector that calculate the movement of the pupils
        double xVector = StdDraw.mouseX() - xCenterOfEye;
        double yVector = StdDraw.mouseY() - yCenterOfEye;
        
        //Stores the calculated distance into a double
        double dist = calcDist(xVector, yVector);
        
        //Stores the limit of the range of the pupils into a double    
        double pupilTargDist = 0.8*radius;
        
        //Changes the vectors according to the dist
        xVector *= pupilTargDist / dist;
        yVector *= pupilTargDist / dist;
        
        //If the mouse is in an eye, the pupil will be under the mouse
        if (StdDraw.mouseX() < xCenterOfEye+(radius-(0.4*radius)) && StdDraw.mouseX() > xCenterOfEye-(radius-(0.4*radius))
           && StdDraw.mouseY() < yCenterOfEye+(radius-(0.4*radius)) && StdDraw.mouseY() > yCenterOfEye-(radius-(0.4*radius)))
        {
            xVector = StdDraw.mouseX() - xCenterOfEye;
            yVector = StdDraw.mouseY() - yCenterOfEye;
        }
        
        //Draws the pupils so that it follows the mouse
        StdDraw.filledCircle(xVector+xCenterOfEye, yVector+yCenterOfEye, 0.2*radius);
    }
    
    //Method used to calculate the distance
    public static double calcDist(double xDistance, double yDistance)
    {
        return Math.sqrt(xDistance*xDistance+yDistance*yDistance);
    }
    
    public static void main(String[] args)
    {
        //Sets the scale of the draw
        StdDraw.setScale(-50,50);
        
        //Infinite Loop
        while (true)
        {
            //Animates the draw
            StdDraw.show(0);
            //Clears the draw
            StdDraw.clear();
            //Draws the left eye
            drawEyes(-15,0,10);
            //Draws the right eye
            drawEyes(15,0,10);
            
            StdDraw.show(0);
        }
        
        
    }
}