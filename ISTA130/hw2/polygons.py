'''
Author: Brian Loi
Date: September 14, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program uses turtle graphics to draw triangles, squares, and pentagons
repeatedly using for loops. The polygons are spaced between each time being
drawn and are drawn in a rotating fashion, to create a desired image.
'''

import turtle

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

#==========================================================
def main():
    '''
    Creates three turtles and uses them to draws polygons (triangles,
    squares, and pentagons) repeatedly to create a certain drawing.
    '''

    #Creates a turtle object for the squares
    thor = turtle.Turtle()
    thor.speed(0)
    thor.pencolor("Blue")
    thor.pensize(5)
    #Creates a turtle object for the pentagons
    stark = turtle.Turtle()
    stark.speed(0)
    stark.pencolor("Red")
    stark.pensize(5)
    #Creates a turtle object for the triangles
    hulk = turtle.Turtle()
    hulk.speed(0)
    hulk.pencolor("Green")
    hulk.pensize(5)
    hulk.penup()
    hulk.goto(-100, 0)          #Positions the turtle

    #Repeatedly draws the polygons using the turtles with spacing 5 times
    for i in range(5):
        hulk.seth(60)
        polygon(hulk, 3, 100)   #Draws the triangle
        hulk.seth(150)
        hulk.forward(20)        #Shifts triangles by 20
        stark.seth(180)
        polygon(stark, 5, 100)  #Draws the pentagon
        stark.seth(270)
        stark.forward(20)       #Shifts Pentagons by 20
        thor.seth(30)
        polygon(thor, 4, 100)   #Draws the square
        thor.seth(30)
        thor.forward(20)        #Shifts Squares by 20

    hulk.getscreen().exitonclick()  #Keeps the turtle graphics window open

if __name__ == '__main__':
    main()
