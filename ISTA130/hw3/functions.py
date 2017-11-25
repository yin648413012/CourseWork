'''
Author: Brian Loi
Date: September 21, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program contains various functions that perform specific tasks.
'''

import math

def print_word(num, str):
    '''
    Prints a string on a specified number of lines, each time preceded by a
    line number and an arrow.
    
    Parameters:
    num: an int that determines the number of lines that a string is printed
    str: a string that is to be printed on each line

    Returns: None
    '''
    for i in range(num):
        print(i+1,"-->", str)
    return None

def bacteria(minutes, generations):
    '''
    Prints out the number of bacteria in a Petri dish as times go by.
    It is assumed that the dish always begins with a single bacterium and
    every bacterium splits into exactly two bacteria at the end of a time
    period.
    
    Parameters:
    minutes: an int giving the number of minutes it take for a bacterium to
        split into two new bacterica
    generations: an int giving the number of bacterial generations to include
        in the output

    Returns: None
    '''
    time = 0
    bacteria_amount = 1
    for i in range(generations):
        bacteria_amount = bacteria_amount*2
        time = time+minutes
        print("after", time,"minutes: ", bacteria_amount, "bacteria")
    return None

def convert_to_copper(gold, silver, copper):
    '''
    Prints the number of each type of coin followed by the total value of
    all the coins when converted to copper.
    
    Parameters:
    gold: an int that represents the number of gold coins
    silver: an int that represents the number of silver coins
    copper: an int that represents the number of copper coins

    Returns: None
    '''
    total_copper = 0
    for i in range(gold):
        total_copper = total_copper + 50
    for i in range(silver):
        total_copper = total_copper + 5
    total_copper = total_copper + copper
    print(gold, "gp,", silver, "sp,", copper, "cp converted to copper is:", 
        total_copper, "cp")
    return None

def convert_from_copper(copper):
    '''
    Prints out the number of gold pieces, silver pieces, and copper pieces
    when converting as many of the initial copper pieces into gold
    and silver pieces as possible.
    
    Parameters:
    copper: an int that represents the number of copper pieces

    Returns: None
    '''
    gold = copper // 50
    leftover_copper = copper % 50
    silver = leftover_copper // 5
    leftover_copper = leftover_copper % 5
    print(copper, "copper pieces is:", gold,"gp,", silver,"sp,", 
        leftover_copper, "cp")
    return None

def repeat_word(word, rows, columns):
    '''
    Prints the word in a number of rows equal to the value of the rows
    parameter and each row contains the word repeated a number of times equal
    to the columns parameter.
    
    Parameters:
    word: a string that is a word
    rows: an int representing the number of lines that the word is repeated
    columns: an int representing the number of times the word is repeated in
        a line

    Returns: None
    '''
    for i in range(rows):
        print(word*columns)
    return None

def text_triangle(num):
    '''
    Prints X's in a triangle shape based on the integer parameter.
    The top of the triangle starts with one X, and adds one X each line
    below it until the amount of X's match the integer parameter.
    If the argument is <=0, a blank line is printed.
    
    Parameters:
    num: an int representing the number of X's at the base of the triangle

    Returns: None
    '''
    for i in range(num-1):
        print("X"*(i+1))
    print("X"*num)
    return None

def surface_area_of_cylinder(radius, height):
    '''
    Calculates and prints the surface area of a cylinder with the given
    radius and height.
    
    Parameters:
    radius: a float representing the radius of a cylinder
    height: a float representing the height of a cylinder

    Returns: None
    '''
    surface_area = 2*math.pi*radius**2 + 2*math.pi*radius*height
    print("The surface area of a cylinder with radius", radius,"and height", 
        height,"is", surface_area)
    return None

def tree_height(distance, length):
    '''
    Calculates and prints the height of a tree, in which a kite has become
    stuck in.
    
    Parameters:
    distance: a float that represents the distance from you to the base of the 
        tree
    length: a float representing the length of the kite string

    Returns: None
    '''
    height = math.sqrt(length**2-distance**2)
    print("Kite string:", length)
    print("Distance:", distance)
    print("Height:", height)
    return None
#==========================================================
def main():
    '''
    This file only contains functions that calculate and print specific tasks,
    therefore this file does nothing when run. The main() function is
    technically not needed.
    '''

if __name__ == '__main__':
    main()
