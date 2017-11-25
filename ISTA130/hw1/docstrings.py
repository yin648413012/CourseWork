'''
Name: Sam Student
Date: 10/02/14
Class: ISTA 130
Section Leader: Some Section Leader

Description:
This program draws some triangles and then determines whether or not it's Monday.

NOTE:
True, False, and None are not strings (note how in Notepad++ they are dark blue).

True and False are boolean values.

By default (unless you tell a function to return something else), all functions
return None. None is actually a special type of object. This is important
because if None is a value, "returns nothing," "doesn't return anything,"
and "no returns" are incorrect.
'''

import turtle

def triangles(a_turtle, size, num):
    '''
    This function draws a row of triangles.
    
    Parameters:
    a_turtle: a turtle that is used to draw the triangles
    size: an int that determines the size of each triangle
    num: an int that determines the number of triangles to draw
    
    Returns: None
    '''
    
def is_monday(day):
    '''
    This function returns a value that represents if the given day is a Monday.
    
    Parameter:
    day -- a string that represents the day of the week
    
    Returns:
    True if today is Monday
    False otherwise
    '''
    if day == "Monday":
        return True
    else:
        return False
    
def main():
    '''
    Call triangles function and draw 10 triangles with side lengths of 5.
    '''
    yertle = turtle.Turtle()
    triangles(yertle, 5, 10)
    
    today = is_monday("Monday")
    print("Monday, true or false? " + today) #in this case, prints "Monday, true or false? True"
    