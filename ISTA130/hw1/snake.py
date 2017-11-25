'''
Author: Brian Loi
Date: September 7, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program uses a turtle to draw a specific snake figure consisting of
shapes. The program calls functions that draw a triangle, square, pentagon,
or hexagon using a turtle in order to draw the specific snake figure with
only shapes. 
'''

import turtle

def triangle(some_turtle, length):
    '''
    This function draws a triangle using a turtle
    
    Parameters:
    some_turtle: a turtle that is used to draw the triangle
    length: an int that determines the length of each side of the triangle
    
    Returns: None
    '''
    some_turtle.pencolor("Green")
    some_turtle.forward(length)
    some_turtle.right(120)
    some_turtle.forward(length)
    some_turtle.right(120)
    some_turtle.forward(length)
    some_turtle.right(120)
    some_turtle.forward(length)
    some_turtle.left(60)

def square(some_turtle, length):
    '''
    This function draws a square using a turtle
    
    Parameters:
    some_turtle: a turtle that is used to draw the square
    length: an int that determines the length of each side of the square
    
    Returns: None
    '''
    some_turtle.pencolor("Blue")
    some_turtle.seth(180)
    some_turtle.forward(length)
    some_turtle.right(90)
    some_turtle.forward(length)
    some_turtle.right(90)
    some_turtle.forward(length)
    some_turtle.right(90)
    some_turtle.forward(length)
    some_turtle.right(90)
    some_turtle.forward(length)
    some_turtle.seth(180)
    some_turtle.right(30)

def pentagon(some_turtle, length):
    '''
    This function draws a pentagon using a turtle
    
    Parameters:
    some_turtle: a turtle that is used to draw the pentagon
    length: an int that determines the length of each side of the pentagon
    
    Returns: None
    '''
    some_turtle.pencolor("Red")
    some_turtle.left(90)
    some_turtle.forward(length)
    some_turtle.right(72)
    some_turtle.forward(length)
    some_turtle.right(72)
    some_turtle.forward(length)
    some_turtle.right(72)
    some_turtle.forward(length)
    some_turtle.right(72)
    some_turtle.forward(length)
    some_turtle.seth(180)
    some_turtle.right(30)

def hexagon(some_turtle, length):
    '''
    This function draws a hexagon using a turtle
    
    Parameters:
    some_turtle: a turtle that is used to draw the hexagon
    length: an int that determines the length of each side of the hexagon
    
    Returns: None
    '''
    some_turtle.pencolor("Purple")
    some_turtle.left(60)
    some_turtle.forward(length)
    some_turtle.left(60)
    some_turtle.forward(length)
    some_turtle.left(60)
    some_turtle.forward(length)
    some_turtle.left(60)
    some_turtle.forward(length)
    some_turtle.left(60)
    some_turtle.forward(length)
    some_turtle.left(60)
    some_turtle.forward(length)
    some_turtle.right(120)

#==========================================================
def main():
    '''
    A turtle object is created. Its speed is set to 0 and pen size set to 10.
    Functions that draw shapes (triangle, square, pentagon, and hexagon) using
    turtles are called in a specific order to draw a specific snake figure
    consisting of the shapes.
    '''

    leonardo = turtle.Turtle()      #Creates a turtle object, named "leonardo"
    leonardo.speed(0)               #Sets turtle speed to 0 and pen size to 10
    leonardo.pensize(10)

    pentagon(leonardo, 50)          #Calls functions in order to make the snake
    triangle(leonardo, 50)
    triangle(leonardo, 50)
    hexagon(leonardo, 50)
    triangle(leonardo, 50)
    triangle(leonardo, 50)
    hexagon(leonardo, 50)
    square(leonardo, 50)
    triangle(leonardo, 50)

    leonardo.getscreen().exitonclick()  # keeps the turtle graphics window open

if __name__ == '__main__':
    main()
