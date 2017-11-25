'''
Author: Brian Loi
Date: September 14, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program uses turtle graphics to draw a shape that is rotated based
on specified amount of times drawn and angles in three different locations.
At each location, the shape will be drawn in rotation in a different color
and size.
'''

import turtle

def shape(some_turtle, size):
    '''
    Draws a shape (a circle of diamond shapes surrounded by squares)

    Parameters:
    some_turtle: a turtle that is used to draw the shape
    size: an int that determines the size of the shape

    Returns: None
    '''
    for i in range(8):
        some_turtle.forward(size)
        some_turtle.left(45)
        some_turtle.forward(size)
        some_turtle.left(135)
        some_turtle.forward(size)
        for i in range(4):
            some_turtle.right(90)
            some_turtle.forward(size)
        some_turtle.left(45)
        some_turtle.forward(size)
        some_turtle.right(180)
    return None

def rotated_shapes(some_turtle, size, amount, angle):
    '''
    Repeatedly draws a shape on a rotation based on a specified amount of
    times, each rotated from the previous shape by the requested angle

    Parameters:
    some_turtle: a turtle that is used to draw the shape
    size: an int that determines the size of the shape
    amount: the number of times that the shape is drawn
    angle: the angle or rotation between each drawn shape

    Returns: None
    '''
    for i in range(amount):
        shape(some_turtle, size)
        some_turtle.right(angle)
    return None

#==========================================================
def main():
    '''
    Draws shapes that are repeatedly rotated on specified angles and a
    specified amount of times in three locations, with different colors
    and specifications in each location.
    '''

    thor = turtle.Turtle()      #Creates a turtle object
    thor.speed(0)               #Sets the turtle's settings
    thor.pensize(3)

    #Draws the rotated shape in the first location
    thor.penup()
    thor.goto(0, 150)
    thor.pendown()
    thor.pencolor("Blue")
    rotated_shapes(thor, 40, 6, 25)
    #Draws the rotated shape in the second location
    thor.penup()
    thor.goto(-150, -90)
    thor.pendown()
    thor.pencolor("DarkGreen")
    rotated_shapes(thor, 50, 3, 15)
    #Draws the rotated shape in the third location
    thor.penup()
    thor.goto(150, -100)
    thor.pendown()
    thor.pencolor("DarkOrange")
    rotated_shapes(thor, 60, 10, 5)


    thor.getscreen().exitonclick()  #Keeps the turtle graphics window open

if __name__ == '__main__':
    main()
