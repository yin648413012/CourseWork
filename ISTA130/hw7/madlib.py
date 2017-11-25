'''
Author: Brian Loi
Date: November 2, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program simulates the completion of a MAD-Lib. It takes a file input
that is in the format of a MAD-Lib and writes and outputs a text file
consisting of the MAD-Lib completed with the user's word inputs. It also
prints a report of the letters contained in the input file.
'''

def print_report(file_name):
    '''
    Prints a report on the input files characters. Prints the number
    and percentages of vowels, consonants, white spaces, and punctuation
    that are in the parameter file.

    Parameters:
    file_name - a string that represents the name of the input file
    
    Returns: None
    '''
    #Open the input file
    file = open(file_name, 'r')
    vowels = 0
    consonants = 0
    whitespace = 0
    punctuation = 0
    #For every line in the file:
    for line in file:
        #For every index in the line:
        for i in range(len(line)):
            #If the character is a white space, add 1 to the total spaces
            if (line[i].isspace()):
                whitespace += 1
            #Else if the character is vowel, add 1 to the total vowels
            elif (line.lower()[i] == 'a' or line.lower()[i] == 'e' or
                line.lower()[i] == 'i' or line.lower()[i] == 'o' or
                line.lower()[i] == 'u'):
                vowels += 1
            #Else the character is a consonant so add 1 to the total consonants
            elif (line[i].isalpha()):
                consonants += 1
            #Else it is a punctuation, so add 1 to the total punctuations
            else:
                punctuation += 1
    #PRINT THE REPORT
    print()
    print(file_name.center(25, '-'))
    print("Vowels:".ljust(20, ' ') + str(vowels).rjust(5, ' '))
    print("Consonants:".ljust(20, ' ') + str(consonants).rjust(5, ' '))
    print("Whitespace:".ljust(20, ' ') + str(whitespace).rjust(5, ' '))
    print("Punctuation:".ljust(20, ' ') + str(punctuation).rjust(5, ' '))
    print('-'*25)
    total = consonants+whitespace+vowels+punctuation
    print("Total:".ljust(20, ' ') + str(total).rjust(5, ' '))
    vowel_perc = round((vowels/float(total))*100, 1)
    print("Percent vowels:".ljust(20, ' ') + str(vowel_perc).rjust(5, ' '))
    cons_perc = round((consonants/float(total))*100, 1)
    print("Percent consonants:".ljust(20, ' ') + str(cons_perc).rjust(5, ' '))
    space_perc = round((whitespace/float(total))*100, 1)
    print("Percent spaces:".ljust(20, ' ') + str(space_perc).rjust(5, ' '))
    punct_perc = round((punctuation/float(total))*100, 1)
    print("Percent punctuation:".ljust(20, ' ') + str(punct_perc).rjust(5, ' '))
    print("="*25)
    print()
    file.close()    #Close the file
    return None

def replace_parts_of_speech(line, speech):
    '''
    Takes a line as a parameter and modifies that line so that the parameter
    part of speech is replaced by a word input by the user, and then returns
    that new modified line.

    Parameters:
    line - a string that represents a line of text
    speech - a string representing a part of speech in uppercase

    Returns: a string representing the new modified string with the part
    of speech replaced by the user's input.
    '''
    #Store the parameter line in a string
    new_line = line
    #Store the number of occurences of the parameter part of speech in an int
    count = line.count(speech)
    #For every occurence of the part of speech in the line:
    for i in range(count):
        #Replace the part of speech in the line with the a user input
        loc = new_line.find(speech)
        word = input("Enter "+speech.lower()+": ")
        #Modify new_line to replace the part of speech with the user's input
        new_line = new_line[:loc]+word+new_line[loc+len(speech):]
    return new_line

def complete_mad_lib(name):
    '''
    Goes through the parameter file input line by line, and replaces
    all capitalized parts of speech with a word input by the user by
    calling the replace_parts_of_speech() function. Writes and outputs
    a new text file containing the modified lines with the user's inputs. 

    Parameters:
    name - a string that represents a file input that is in MAD-lib format

    Returns: None
    '''
    file_in = open(name, 'r')
    out_name = 'MAD_'+ str(name)
    file_out = open(out_name, 'w')
    for line in file_in:
        new_line = replace_parts_of_speech(line, 'PLURAL NOUN')
        new_line = replace_parts_of_speech(new_line, 'VERB PAST')
        new_line = replace_parts_of_speech(new_line, 'VERB')
        new_line = replace_parts_of_speech(new_line, 'NOUN')
        new_line = replace_parts_of_speech(new_line, 'ADJECTIVE')
        file_out.write(new_line)
    file_in.close()
    file_out.close()
    return None

#==========================================================
def main():
    '''
    Asks the user to enter the name of a Mad-Lib template file. Assume
    the file is in the same directory as this program. Calls the print_report()
    function to print a report on the characters in the file. Then calls the 
    complete_mad_lib() to replace all the parts of speech in the text file with
    user inputs, and write it all to a new text file. Overall, this program 
    takes an input file that is in the format of MAD-Lib, prints
    a report of information about the text file, and then asks the user for
    words particular to a part of speech. Once all parts of speech are filled
    with words, an output file of the completed story is written.
    '''

    #Ask the user for a MAD-Lib file to input
    input_file_name = input("Enter file name: ")
    #Print the report of the input file's characters
    print_report(input_file_name)
    #Complete and write the MAD-Lib file
    complete_mad_lib(input_file_name)

if __name__ == '__main__':
    main()
