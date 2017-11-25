'''
Author: Brian Loi
Date: September 7, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program will define a function that will draw a shape using a turtle,
and draw the shape in 12 different locations and colors for each time the 
shape is drawn. The shapes will be drawn in 3 different sizes to create a
cool "drawing" or design using the shape.
'''

import turtle

def shape(some_turtle, length):
    '''
    This function draws a specific shape using turtle. The shape is a ring
    of diamonds surounded by a ring of squares.
    
    Parameters:
    some_turtle: a turtle that is used to draw the shape
    length: an int that determines the length of each side of the shape
    
    Returns: None
    '''
    #Draws Diamond 1
    some_turtle.pendown()
    some_turtle.left(30)            
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(135)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(120)
    some_turtle.left(30)            
    #Draws Diamond 2
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(135)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(120)
    some_turtle.left(30)            
    #Draws Diamond 3
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(135)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(120)
    some_turtle.left(30)            
    #Draws Diamond 4
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(135)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(120)
    some_turtle.left(30)            
    #Draws Diamond 5
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(135)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(120)
    some_turtle.left(30)            
    #Draws Diamond 6
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(135)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(120)
    some_turtle.left(30)            
    #Draws Diamond 7
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(135)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(120)
    some_turtle.left(30)            
    #Draws Diamond 8
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(135)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.right(90)           
    #Transition the turtle into position for squares
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)
    some_turtle.left(90)
    some_turtle.forward(length)     
    #Draws Square 1
    some_turtle.left(90)
    some_turtle.forward(length)
    some_turtle.right(45)             
    #Draws Square 2
    some_turtle.forward(length)
    some_turtle.left(90)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)      
    #Draws Square 3
    some_turtle.left(90)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)     
    #Draws Square 5
    some_turtle.left(90)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)     
    #Draws Square 6
    some_turtle.left(90)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)     
    #Draws Square 7
    some_turtle.left(90)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)     
    #Draws Square 8
    some_turtle.left(90)
    some_turtle.forward(length)
    some_turtle.right(45)
    some_turtle.forward(length)     
    #Draws Square 9
    some_turtle.left(90)
    some_turtle.forward(length)
    some_turtle.penup()

#==========================================================
def main():
    '''
    A turtle object is created. Its speed is set to 0 and pen size is set
    to 5. The turtle moves to specific locations and calls the shape
    function to draw the function at that location. Each time the shape is
    drawn, the turtle's color is changed, and its size may be adjusted
    from 10, 20, or 30.
    '''

    timmy = turtle.Turtle()     #Creates a turtle object, named "timmy"
    timmy.speed(0)              #Sets turtle speed to 0 and the pen size to 5
    timmy.pensize(5)
    timmy.penup()
    #Draws four small shapes in four different places, in different colors
    timmy.goto(-200, 200)
    timmy.color("OrangeRed")
    shape(timmy, 10)
    timmy.goto(-200, -200)
    timmy.color("GreenYellow")
    shape(timmy, 10)
    timmy.goto(200, -200)
    timmy.color("BlueViolet")
    shape(timmy, 10)
    timmy.goto(200, 200)
    timmy.color("VioletRed")
    shape(timmy, 10)
    #Draws 8 shapes (medium and large sizes alternating) 
    #in different colors and locations
    timmy.goto(0, 200)
    timmy.color("Red")
    shape(timmy, 30)
    timmy.goto(-100, 100)
    timmy.color("Orange")
    shape(timmy, 20)
    timmy.goto(-200, 0)
    timmy.color("Yellow")
    shape(timmy, 30)
    timmy.goto(-100, -100)
    timmy.color("Green")
    shape(timmy, 20)
    timmy.goto(0, -200)
    timmy.color("Blue")
    shape(timmy, 30)
    timmy.goto(100, -100)
    timmy.color("LightBlue")
    shape(timmy, 20)
    timmy.goto(200, 0)
    timmy.color("Purple")
    shape(timmy, 30)
    timmy.goto(100, 100)
    timmy.color("Violet")
    shape(timmy, 20)

    timmy.getscreen().exitonclick()  # keeps the turtle graphics window open

if __name__ == '__main__':
    main()
