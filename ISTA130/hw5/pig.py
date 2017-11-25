'''
Author: Brian Loi
Date: October 12, 2017
Class: ISTA 130
Section Leader: Sebastion Andrews

Description:
This program simulates the game Pig Dice, in which two players take turns
rolling a six-sided dice. For each turn, a player can roll the dice as many
times as they want, and the dice adds to the number of points earned in that
turn. If a player rolls a 1, then they lose all their points for that turn.
The first player to get 50 or more points, wins the game.
'''

import random

def print_scores(name1, score1, name2, score2):
    '''
    This function prints the names and scores of the two players playing
    the game.

    Parameters:
    name1: a string that represents the name of player 1
    score1: an int that represents the score of player 1
    name2: a string that represents the name of player 2
    score2: an int that represents the score of player 2

    Returns: None
    '''
    print()
    print('--- SCORES\t'+name1+': '+ str(score1)+'\t'+name2+": "+str(score2)+" ---")
    return None

def check_for_winner(name, score):
    '''
    This function checks if a player has won the game. In order for a
    player to win the game, their score needs be 50 or more.

    Parameters:
    name: a string that represents a player's name
    score: an int that represents a player's score

    Returns:
    True if parameter score is >= 50
    False otherwise
    '''
    if (score >= 50):
        print('THE WINNER IS: '+name+'!!!!!')
        return True
    else:
        return False

def roll_again(name):
    '''
    This function asks the player(user) if they want to roll again. If the
    user inputs anything other than 'Y','y','N', or 'n', then it prints an
    error message and asks the user again.

    Parameters:
    name: a string that represents a player's name

    Returns:
    True if the user inputs 'Y' or 'y' 
    False if the user inputs 'N' or 'n'
    '''
    while True:
        answer = input('Roll again, '+name+'? (Y/N) ')
        if (answer == 'Y' or answer == 'y'):
            return True
        elif(answer == 'N' or answer == 'n'):
            return False
        else:
            print ('I don\'t understand: "'+answer+'". Please enter either "Y" or "N".')

def play_turn(name):
    '''
    This function generates a random number from 1-6 to simulate a dice roll
    and uses that number to add to the player's points. If a 1 is rolled, then
    no points are earned for the turn. The function continues until the player
    does not want to roll again, or rolls a 1. The function prints out the
    process, including which player's turn it is, what number was rolled, and
    how many total points have been accumulated for that turn.

    Parameters:
    name: a string that represents a player's name

    Returns: an int that represents the amount of points earned by a player
    '''
    print('---------- '+name+'\'s turn ----------')
    points = 0
    while True:
        rand_num = random.randint(1,6)
        print('\t<<< '+name+' rolls a '+str(rand_num)+' >>>')
        if (rand_num == 1):
            print('\t!!! PIG! No points earned, sorry '+name+' !!!')
            points = 0
            cont = input('(enter to continue)')
            break
        else:
            points = points + rand_num
            print('\tPoints: '+str(points))
            if (roll_again(name) == True):
                continue;
            else:
                break
    return points

#==========================================================
def main():
    '''
    When this file is run, the program will ask the user for a random seed
    value (that determines the random numbers being generated). Then a game
    of Pig Dice will begin and the names of the players will be asked from the
    user. The program will continue to run, as the players take turns rolling
    dice and adding those rolls to their score. Rolling a 1 will result in the
    end of a turn and losss of all points for the turn. After each roll, the
    user will be asked if they want to roll again. If not, those points will be
    saved into that player's total score. The program will end once one of the
    players has accumulated 50 or more total points.
    '''

    #Get and set the random seed value
    random.seed(int(input('Enter seed value: ')))
    print()
    print()
    print('Pig Dice')
    #Get and store the names of the players
    player1 = input('Enter name for player 1: ')
    player2 = input('Enter name for player 2: ')
    print('\tHello '+player1+' and '+player2+', welcome to Pig Dice!')
    #Set both players' scores to zero
    player1_score = 0
    player2_score = 0
    print_scores(player1, player1_score, player2, player2_score)

    #Infinite Loop
    while True:
        #Add the points from the player 1's turn to their total score
        player1_score = player1_score+play_turn(player1)    #Player 1's turn
        #Print the scores of the players after each turn
        print_scores(player1, player1_score, player2, player2_score)
        #If player 1 did not win yet:
        if (check_for_winner(player1, player1_score) == False):
            #Add the points from player 2's turn to their total score
            player2_score = player2_score+play_turn(player2)    #Player2's turn
            #Print the scores of the players after each turn
            print_scores(player1, player1_score, player2, player2_score)
            #If player 2 did not win yet:
            if (check_for_winner(player2, player2_score) == False):
                continue   #Continue the loop and go back to player 1's turn
            #Else: player 2 has won, so break from the infinite loop
            else:
                break
        #Else: player 1 has won, so break from the infinite loop
        else:
            break
    return None
   

if __name__ == '__main__':
    main()
