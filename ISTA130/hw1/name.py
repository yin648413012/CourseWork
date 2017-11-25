'''
Author: Brian Loi
Date: September 7, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program will use a turtle to write my first name, "Brian", by using 
functions to draw each letter.
'''

import turtle

def draw_b(draw_turtle):
    '''
    This function draws the letter 'B' using a turtle.

    Parameters:
    draw_turtle: a turtle that is used to draw the letter

    Returns: None
    '''
    draw_turtle.pendown()
    draw_turtle.forward(60)
    draw_turtle.right(90)
    draw_turtle.forward(60)
    draw_turtle.right(90)
    draw_turtle.forward(60)
    draw_turtle.right(90)
    draw_turtle.forward(60)
    draw_turtle.right(180)
    draw_turtle.forward(120)
    draw_turtle.left(90)
    draw_turtle.forward(80)
    draw_turtle.left(90)
    draw_turtle.forward(60)
    draw_turtle.left(90)
    draw_turtle.forward(80)
    draw_turtle.left(90)
    draw_turtle.forward(60)
    draw_turtle.left(90)
    draw_turtle.forward(80)
    draw_turtle.seth(0)         #Points the turtle East at the end of function
    draw_turtle.penup()

def draw_r(draw_turtle):
    '''
    This function draws the letter 'r' using a turtle.

    Parameters:
    draw_turtle: a turtle that is used to draw the letter

    Returns: None
    '''
    draw_turtle.pendown()
    draw_turtle.left(90)
    draw_turtle.forward(70)
    draw_turtle.right(90)
    draw_turtle.forward(50)
    draw_turtle.right(90)
    draw_turtle.forward(30)
    draw_turtle.seth(0)         #Points the turtle East at the end of function
    draw_turtle.penup()

def draw_i(draw_turtle):
    '''
    This function draws the letter 'i' using a turtle.

    Parameters:
    draw_turtle: a turtle that is used to draw the letter

    Returns: None
    '''
    draw_turtle.pendown()
    draw_turtle.right(180)
    draw_turtle.forward(70)
    draw_turtle.penup()         #Repositioning turtle to draw the dot of 'i'
    draw_turtle.forward(40)
    draw_turtle.pendown()
    draw_turtle.right(90)
    draw_turtle.forward(5)
    draw_turtle.left(90)
    draw_turtle.forward(10)
    draw_turtle.left(90)
    draw_turtle.forward(10)
    draw_turtle.left(90)
    draw_turtle.forward(10)
    draw_turtle.left(90)
    draw_turtle.forward(10)
    draw_turtle.seth(0)         #Points the turtle East at the end of function
    draw_turtle.penup()

def draw_a(draw_turtle):
    '''
    This function draws the letter 'a' using a turtle.

    Parameters:
    draw_turtle: a turtle that is used to draw the letter

    Returns: None
    '''
    draw_turtle.pendown()
    draw_turtle.forward(50)
    draw_turtle.right(90)
    draw_turtle.forward(70)
    draw_turtle.right(90)
    draw_turtle.forward(50)
    draw_turtle.right(90)
    draw_turtle.forward(70)
    draw_turtle.right(180)
    draw_turtle.forward(70)
    draw_turtle.left(90)
    draw_turtle.forward(80)
    draw_turtle.left(90)
    draw_turtle.forward(55)
    draw_turtle.left(180)
    draw_turtle.forward(55)
    draw_turtle.seth(0)         #Points the turtle East at the end of function
    draw_turtle.penup()

def draw_n(draw_turtle):
    '''
    This function draws the letter 'n' using a turtle.

    Parameters:
    draw_turtle: a turtle that is used to draw the letter

    Returns: None
    '''
    draw_turtle.pendown()
    draw_turtle.right(180)
    draw_turtle.forward(80)
    draw_turtle.right(90)
    draw_turtle.forward(70)
    draw_turtle.right(90)
    draw_turtle.forward(80)
    draw_turtle.seth(0)         #Points the turtle East at the end of function
    draw_turtle.penup()


#==========================================================
def main():
    '''
    A turtle object is created. Its speed is set to 0 and its pen size will be
    set to 20. The turtle will move into position so that there is enough room
    for the entire name. Functions for drawing letters will be called 
    accordingly and the turtle will draw the name "Brian". The turtle will
    reposition itself between the function calls to have spacing in between
    the letters.
    '''

    brian = turtle.Turtle()         #Creates a turtle object, named "brian"
    brian.speed(0)                  #Sets turtle speed to 0 and pen size to 20
    brian.pensize(20)
    brian.penup()
    brian.setposition(-220,100)     #Positions turtle for enough space

    draw_b(brian)                   #Calls function to draw letter 'B'
    brian.forward(30)               #Repositioning turtle for next letter
    draw_r(brian)                   #Calls function to draw letter 'r'
    brian.forward(30)               #Repositioning turtle for next letter
    brian.right(90)
    brian.forward(40)
    draw_i(brian)                   #Calls function to draw letter 'i'
    brian.forward(30)               #Repositioning turtle for next letter
    brian.right(90)
    brian.forward(110)
    brian.right(180)
    draw_a(brian)                   #Calls function to draw letter 'a'
    brian.forward(30)               #Repositioning turtle for next letter
    brian.right(90)
    brian.forward(80)
    draw_n(brian)                   #Calls function to draw letter 'n'

    brian.getscreen().exitonclick()  # keeps the turtle graphics window open

if __name__ == '__main__':
    main()
