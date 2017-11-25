'''
Author: Brian Loi
Date: November 9, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program will read the data file, collecting the values into lists. It will
then allow the user to view information about an animal, add new animals and/or
remove animals. Once the user is finished modifying the data, the program will
convert all of the weights from kilograms and grams to pounds and write the 
data out to a new file.
'''

def find_insert_position(name, lst):
    '''
    The function returns an integer indicating the position (index) in the list
    of names such that if you inserted the given mammal's name into the list at
    that index the list would still be in alphabetical order.

    Parameters:
    name - a string representing a terrestrial mammal's name
    list - a list of strings in alphabetical order

    Returns: an integer indicating the position (index) in the list of names
    '''
    for i in range(len(lst)):
        if name == lst[i]:          #if the name is in the list
            return i
        if name < lst[i]:   #if the name is < the current name in the list
            return i
    return len(lst)     #name not in list and > all names, return last index

def populate_lists(name_list, body_list, brain_list):
    '''
    This function opens the "BrainBodyWeightKilos.csv" file and then populates
    each of the parameter lists accordingly. The mammals are in title case. The
    names list contains all the names, the body weight list contains all the body
    weights and the brain weights list contains all the brain weights.

    Parameters:
    name_list - a string representing the list of animal names
    body_list -  a string representing a list of the body weight of animals
    brain_list - a string representing a list of the brain weight of animals

    Returns: None
    '''
    file = open("BrainBodyWeightKilos.csv", 'r')
    for line in file:
        words = line.split(',')
        name_list.append(words[0].title())
        body_list.append(float(words[1]))
        brain_list.append(float(words[2]))
    file.close()
    return None

def write_converted_csv(file_out, name_list, body_list, brain_list):
    '''
    The function writes a new .csv file (with the given filename) in 
    the same format as the original “BrainBodyWeightKilos.csv” using 
    the values in the three lists, but all kilogram values and all gram 
    values should first be converted to pounds, and names should be in 
    title case. The conversion factor for converting from kilograms is
    2.205; from grams it is 0.0022.

    Parameters:
    file_out - a string representing the name of the file being written
    name_list - a string representing the list of the animal names
    body_list - a string representing a list of the body weight of the animals
    brain_list - a string representing a list of the brain weight of animals

    Returns: None
    '''
    output_file = open(file_out, 'w')
    for i in range(len(name_list)):
        k_pounds = round(float(body_list[i])*2.205, 2)
        g_pounds = round(float(brain_list[i])*0.0022, 2)
        output_file.write(name_list[i]+','+str(k_pounds)+','+str(g_pounds)+'\n')
    output_file.close()
    return None

#==========================================================
def main():
    '''
    When run, three empty lists for mammal names, body weights, and brain
    weights are populated. The user will be repeatedly be asked to enter an
    animal name or quit. If the name is not in the list of names, and the user
    would like to add it to the list, ask the user for the animal's body weight
    and brain weight and add all of these into the lists. If the user does not
    want to add the animal to the lists, continue. If the user entered an
    animal name that is already in the list, print the animal's weight data
    and then ask if the user wants to delete the animal's data and name from the lists.
    When the user quits, write out a file called "BrainBodyWeightPounds.csv" that
    contains all the data from the lists.
    '''

    #Create three empty lists
    mammal_lst = []
    names_lst = []
    brain_lst = []
    populate_lists(names_lst, mammal_lst, brain_lst)        #Populate the lists

    #Infinite Loop (Repeatedly ask)
    while True:
        print()
        animal = input('Enter animal name (or "q" to quit): ')
        #If the user wants to quit:
        if (animal == 'q'):
            write_converted_csv('BrainBodyWeightPounds.csv', names_lst, mammal_lst, brain_lst)
            return None

        animal_name = animal.title()    #Convert the user input into title case.

        #if the name from the user is already in the list:
        if animal_name in names_lst:
            #print the animal's data
            index = find_insert_position(animal_name, names_lst)
            body = mammal_lst[index]
            brain = brain_lst[index]
            print(animal_name+': body = '+str(body)+', brain = '+str(brain))
            del_line = 'Delete \"'+animal_name+'\"? (y|n) '
            del_answer = input(del_line)
            #User does NOT want to delete, so do nothing
            if (del_answer == 'n'):
                continue
            #User wants to delete, so delete animal's data from all three lists.
            if (del_answer == 'y'):
                names_lst.pop(index)
                mammal_lst.pop(index)
                brain_lst.pop(index)
        #Else: the user's input name is not in the list
        else:
            print('File does not contain \"'+animal_name+'\".')
            name_add = input('Add \"'+animal_name+'\" to file? (y|n) ')
            if name_add == 'n':     #User doesn't want to add, so do nothing
                continue
            if name_add == 'y':     #User wants to add, so add data into lists
                #Ask the user for the animal's data
                body_weight = input('Enter body weight for \"'+animal_name+'\" in kilograms: ')
                brain_weight = input('Enter brain weight for \"'+animal_name+'\" in grams: ')
                index = find_insert_position(animal_name, names_lst)
                #insert the animal's data into the lists
                names_lst.insert(index, animal_name)
                mammal_lst.insert(index, body_weight)
                brain_lst.insert(index, brain_weight)



if __name__ == '__main__':
    main()
