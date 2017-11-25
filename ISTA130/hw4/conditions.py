'''
Author: Brian Loi
Date: October 5, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program contains various functions that perform specific tasks.
'''

def word_length(word, num):
    '''
    This function prints a message about the relationship between the length of
    the word and a parameter number given.

    Parameters:
    word: a string that will have its character length compared
    num: an int to compare the length of the string with

    Returns: None
    '''
    if (len(word) > num):
        print("Longer than", num,"characters:",word)
    elif (len(word) < num):
        print("Shorter than", num,"characters:",word)
    else:
        print("Exactly", num,"characters:",word)
    return None

def stop_light(color, time):
    '''
    This function determines whether a stop light should change color, and
    if so, what color it should change to.

    Parameters:
    color: a string that represents the current color of the stop light
    time: an int that represents how long the light has been a color

    Returns: a string that represents the color of the stop light
    '''
    if (color == 'green' and time > 60):
        return 'yellow'
    elif (color == 'yellow' and time > 5):
        return 'red'
    elif (color == 'red' and time > 55):
        return 'green'
    else:
        return color

def is_normal_blood_pressure(systolic, diastolic):
    '''
    This functions determines whether or not a blood pressure is normal
    based on systolic and diastolic blood pressure. Blood pressure is normal
    if systolic blood pressure is less than 120 and diastolic blood pressure
    is less than 80.

    Parameters:
    systolic: an int that represents the systolic blood pressure
    diastolic: an int that represents the diastolic blood pressure

    Returns: 
    True if the blood pressure is normal
    False otherwise
    '''
    if (systolic < 120 and diastolic < 80):
        return True
    else:
        return False

def doctor():
    '''
    This function prints whether or not a blood pressure is high based
    on a systloic blood pressure and diastolic blood pressure that are
    input by the user.

    Parameters: None

    Returns: None
    '''
    systolic_reading = input('Enter your systolic reading:')
    diastolic_reading= input('Enter your diastolic reading:')
    if (is_normal_blood_pressure(systolic_reading, diastolic_reading) == True):
        print('Your blood pressure is normal.')
    else:
        print('Your blood pressure is high.')
    return None

def pants_size(waist_size):
    '''
    This function returns the size of a person's waist as a string. Waist
    measurements that are 34 inches are larger are considered large, 30-34
    inches are considered medium, and anything smaller than 30 inches is
    considered small.

    Parameters:
    waist_size: an int that represents a person's waist size in inches

    Returns: a string representing the size of a person's waist
    '''
    if (waist_size >= 34):
        return 'large'
    elif (waist_size >= 30):
        return 'medium'
    else:
        return 'small'

def pants_fitter():
    '''
    This function asks the user for their name, prints a greeting, asks
    the user for their waist size in inches, how many pairs of pants
    they want, and if the user wants regular or fancy pants. The function
    then calculates the cost of the pants and prints the cost.

    Parameters: None

    Returns: None
    '''
    name = input('Enter your name:')
    print('Greetings',name,'welcome to Pants-R-Us')
    waist = input('Enter your waist size in inches:')
    size = pants_size(waist)
    pairs = input('How many pairs of pants would you like:')
    pants_type = input('Would you like regular or fancy pants?')
    if (pants_type == 'fancy'):
        cost = pairs*100
    else:
        cost = pairs*40
    print(pairs,'pairs of',size, pants_type,'pants: $', cost)
    return None

def digdug(num):
    '''
    This function prints 'dig' if an integer is evenly divisible by 3, 'dug'
    if the integer is evenly divisible by 5, and 'digdug' if the integer
    is evenly dividible by both 3 and 5 for every integer from 1 up to (and 
    including) the parameter number. The function prints nothing if the integer
    is not divisible by 3 or 5.

    Parameters:
    num: an int that represents the maximum number that the function
        calculates to.

    Returns: None
    '''
    i = 1
    while (i <= num):
        if (i % 3 == 0 and i % 5 == 0):
            print(i,': digdug')
            i+=1
        elif (i % 3 == 0):
            print(i,': dig')
            i+=1
        elif (i % 5 == 0):
            print(i,': dug')
            i+=1
        else:
            i+=1
            continue
    return None

def beef_type(percent_lean):
    '''
    This function returns a type of beef based on how lean (in percentage)
    that the beef is. 

    Parameters:
    percent_lean: an int that represents how lean beef is as a percentage

    Returns: 
    A string that represents the type of beef
    Otherwise 'Unknown'
    '''
    if (percent_lean < 78):
        return 'Hamburger'
    elif (percent_lean < 85):
        return 'Chuck'
    elif (percent_lean < 90):
        return 'Round'
    elif (percent_lean <= 95):
        return 'Sirloin'
    else:
        return 'Unknown'

def species_height(specie, height):
    '''
    This function prints a message about the relationship between the height of
    a Human or Klingon and the average height of the correlating species. The
    average human heigh is considered 67 inches and the average Klingon
    is considered 71 inches. The function prints 'Below average', 'Average',
    or 'Above Average'.

    Parameters:
    specie: a string that represents the type of species (Human or Klingon)
    height: an int that represents the height of a Human of Klingon

    Returns: None
    '''
    if (specie == 'Human'):
        if (height > 67):
            print('Above Average')
        elif (height < 67):
            print("Below Average")
        else:
            print('Average')
    else:
        if (height > 71):
            print('Above Average')
        elif (height < 71):
            print('Below Average')
        else:
            print('Average')
    return None

def sooner_date(month1, day1, month2, day2):
    '''
    This function calculates which date comes sooner out of two dates
    that are input through the parameters, and prints out that date in
    the format month / day. 

    Parameters:
    month1: an int that represents a month(1-12) of the first date
    day1: an int that represents a day(1-31) of the first date
    month2: an int that represents a month(1-12) of the second date
    day2: an int that represents a day(1-31) of the second date

    Returns: None
    '''
    if (month1 < month2):
        print(month1,'/',day1)
    elif (month1 > month2):
        print(month2,'/',day2)
    else:
        if (day1 < day2):
            print(month1,'/',day1)
        else:
            print(month2,'/',day2)
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
