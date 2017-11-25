/*Proj6_InteractiveDraw.java
*
* CSc 127A Fall 15, Project 06
*
* Author: Brian Loi
* SL Name: Tori Brenner
*
* ---
*
*This program will read two words and draw a colored shape depending on the words.
*/

//Initializes Scanner
import java.util.Scanner;

public class Proj6_InteractiveDraw
{
    public static void main(String[] args)
    {
        //Creates an array for strings to be stored into
        int MAX_WORDS = 10000;
        String[] inputWords = new String[MAX_WORDS];
        int wordCount = 0;
        
        StdDraw.clear(StdDraw.GRAY);
        
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
            
            //Sets the scale of the draw
            StdDraw.setScale(0,100);
            
            //Checks what color the first word is and sets the color to that word
            if (color.compareTo("blue") == 0)
            {
                StdDraw.setPenColor(StdDraw.BLUE);
            }
            else if (color.compareTo("black") == 0)
            {
                StdDraw.setPenColor(StdDraw.BLACK);
            }
            else if (color.compareTo("red") == 0)
            {
                StdDraw.setPenColor(StdDraw.RED);
            }
            else if (color.compareTo("green") == 0)
            {
                StdDraw.setPenColor(StdDraw.GREEN);
            }
            else if (color.compareTo("orange") == 0)
            {
                StdDraw.setPenColor(StdDraw.ORANGE);
            }
            else if (color.compareTo("white") == 0)
            {
                StdDraw.setPenColor(StdDraw.WHITE);
            }
            else 
            {
                System.out.println("ERROR: Color Not Recognized");
            }
            
            //Checks what shape the second word is and draws the shape
            if (shape.compareTo("circle") == 0)
            {
                StdDraw.filledCircle(20,25,10);
            }
            else if (shape.compareTo("square") == 0)
            {
                StdDraw.filledSquare(40,50,10);
            }
            else if (shape.compareTo("rectangle") == 0)
            {
                StdDraw.filledRectangle(70,60,10,25);
            }
            else
            {
                System.out.println("ERROR: Shape Not Recognized");
            }
            
            
            //Stores the line into an array, and moves on to the next element
            inputWords[wordCount] = words;
            wordCount++;
        }
        //Closes Scanner
        in.close();
    }
}