'''
Author: Brian Loi
Date: September 14, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program uses turtle graphics to draw a castle.
'''

import turtle

def house(a_turtle, size):
    '''
    Draw a simple house of the given size.

    Parameters:
    a_turtle: a turtle that is used to draw the house
    size: an int that determines the size of the house

    Returns: None
    '''
    polygon(a_turtle, 4, size)
    a_turtle.left(90)
    a_turtle.forward(size)
    a_turtle.right(90)
    polygon(a_turtle, 3, size)
    a_turtle.left(90)
    a_turtle.backward(size)
    a_turtle.right(90)
    return None

def castle(a_turtle, size):
    '''
    Draw a simple castle of the given size.

    Parameters:
    a_turtle: a turtle that is used to draw the castle
    size: an int that determines the size of the castle

    Returns: None
    '''
    polygon(a_turtle, 4, size)
    a_turtle.penup()
    a_turtle.backward(size * 0.25)
    a_turtle.left(90)
    a_turtle.forward(size)
    a_turtle.right(90)
    a_turtle.pendown()
    house(a_turtle, size * 0.5)
    a_turtle.forward(size * 0.5)
    house(a_turtle, size * 0.5)
    a_turtle.forward(size * 0.5)
    house(a_turtle, size * 0.5)
    a_turtle.penup()
    a_turtle.backward(size * 0.75)
    a_turtle.left(90)
    a_turtle.backward(size)
    a_turtle.right(90)
    a_turtle.pendown()
    return None

def polygon(some_turtle, sides, length):
    '''
    Draws a regular polygon using a turtle depending on the specified number
    of sides and length of the sides.

    Parameters:
    some_turtle: a turtle used to draw the polygon
    sides: an int that determines the number of sides in the polgyon
    length: an int that determines the length of the sides in the polygon

    Returns: None
    '''
    for i in range(sides):
        some_turtle.pendown()
        some_turtle.forward(length)
        some_turtle.left(360/sides)
        some_turtle.penup()
    return None

#==============================================
def main():
    '''
    Draws a castle
    '''

    #Creates a turtle object to draw the castle. Sets the turtle's settings.
    yertle = turtle.Turtle()
    yertle.speed(0)
    yertle.penup()
    yertle.backward(200)
    yertle.pendown()
    yertle.pencolor('dark slate grey')
    yertle.pensize(5)

    #Repeatedly draws simple castles 4 times to create a larger castle drawing
    for i in range (4):
        castle(yertle, 100)
        yertle.forward(100)
        yertle.right(180)
        castle(yertle, 100)
        yertle.right(180)

    yertle.getscreen().exitonclick()    #Keeps the turtle graphics window open

if __name__ == '__main__':
    main()
