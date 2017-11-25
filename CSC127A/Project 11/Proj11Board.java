/*Proj11Board.java
 *
 * CSc 127A Fall 15, Project 11
 *
 * Author: Brian Loi
 * SL Name: Tori Brenner
 *
 * ---
 *
 *This is a class used to support the Proj11 program. It determines whether or not
 * tiles are able to shift in any direction and collapse in any direction. It also
 * draws the board and adds a random number tile after each turn. 
 * 
 */

import java.util.Random;

public class Proj11Board
{
    //Private Variable:
    private int[][] board;
    
    //Ints initialized to check if the board is full
    private int maxTiles;
    private int numberOfTiles;
    
    //The number on the tile
    private int tileNumber;
    
    private int newTileNumber;
    //Int used to determine whether a 2 or 4 is added
    private int randomIntForNewTile;
    
    //Generates random numbers between 0 and 3
    private Random randX;
    private Random randY;
    
    //Used to store the new tiles coordinates into
    private int newTileX;
    private int newTileY;
    
    //Initializes checkers to check when shifts and collapse are false
    private int shiftChecker;
    private int collapseChecker;
    
    //Initializes a string for tile numbers to be converted to for stdDraw
    private String tileNumString;
    
//!!!CONSTRUCTOR METHOD!!!///
    
    public Proj11Board()
    {
        board = new int[4][4];
        for (int j = 0; j<board.length; j++)
        {
            for (int i = 0; i<board[0].length; i++)
            {   
                board[i][j] = 0;
            }
        }
        
        maxTiles = 16;
        numberOfTiles = 0;
        randX = new Random(4);
        newTileNumber = 2;
        shiftChecker = 0;
        collapseChecker = 0;
        tileNumString="";
    }   
    
    
    
    
    /////////////////////////////////
    
    public void draw()
    {
        
        //Sets scale and clears the draw
        StdDraw.show(0);
        StdDraw.setScale(-1,4);
        StdDraw.clear();
        
        //Iterates through the 2D Array
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 0; j<board[0].length; j++)
            {
                if (board[i][j] != 0)
                {
                //Converts the tile number into a string
                tileNumString = ""+ board[i][j];
                //Draws the numbers onto the tiles. **The "3-i" is the only way 
                //I can find to draw the array correctly
                StdDraw.text(j,3-i,tileNumString);
                
                //Re-initializes String to nothing 
                tileNumString = "";
                }
                
                //System.out.printf("%d ", board[i][j]);
               
                //Draws the grid
                StdDraw.square(i,j,.5);
            }
            //System.out.println();
        }
        
    }
    

    public void addOne()
    {   
        //Re-initializes the new tile number being added to be a 2
        newTileNumber = 2;
        numberOfTiles = 0;
        
        //Iterates through the whole board
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 0; j<board[0].length; j++)
            {
                //If all the tiles are not 0, meaning the board is full, add one
                //to numberOfTiles for each tile
                if ((board[i][j] != 0))
                {
                    numberOfTiles++;
                }
            }
        }
        
        //If the number of filled Tiles is equal to the limit of tiles, return
        if (numberOfTiles == maxTiles)
        {
            System.out.println("GAME OVER");
            return;
        }
        
        //Stores a random number from 0 to 3
        randomIntForNewTile = randX.nextInt(4);
        
        //Stores a random number from 0 to 4 to store into the new tile coordinates
        newTileX = randX.nextInt(4);
        newTileY = randX.nextInt(4);
        
        //While the new tile number is taken, get new random numbers
        while (board[newTileX][newTileY] !=0)
        {
            newTileX = randX.nextInt(4);
            newTileY = randX.nextInt(4);
        }
        
        //Makes the probability of a new tile being 4 25%
        if (randomIntForNewTile == 0)
        {
            newTileNumber = 4;
        }
        //System.out.println("X: " + newTileX);
        //System.out.println("Y: " + newTileY);
        board[newTileX][newTileY] = newTileNumber;

        }
    
    ///////////////////////////////////////
    
    public boolean shiftUp()
    {
        //Sets checker to 0
        shiftChecker = 0;
        
        //Iterates over the whole grid 3 times so that tiles shift 3 times
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 0; i<board.length-1; i++)
            {
                if (board[i][j] == 0 && (board[i+1][j] != 0))
                {
                    board[i][j] = board[i+1][j];
                    board[i+1][j] = 0;
                    shiftChecker++;
                }
            }
        }
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 0; i<board.length-1; i++)
            {
                if (board[i][j] == 0  && (board[i+1][j] != 0))
                {
                    board[i][j] = board[i+1][j];
                    board[i+1][j] = 0;
                    shiftChecker++;
                }
            }
        }
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 0; i<board.length-1; i++)
            {
                if (board[i][j] == 0  && (board[i+1][j] != 0))
                {
                    board[i][j] = board[i+1][j];
                    board[i+1][j] = 0;
                    shiftChecker++;
                }
            }
        }
        
        if (shiftChecker == 0)
        {
            return false;
        }
        
        return true;
    }
    
    public boolean collapseUp()
    {
        //Sets checker to 0
        collapseChecker = 0;
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 0; i<board.length-1; i++)
            {
                if (board[i][j] == board[i+1][j] && (board[i+1][j] != 0))
                {
                    board[i][j] = 2*board[i+1][j];
                    board[i+1][j] = 0;
                    collapseChecker++;
                }
            }
        }
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 0; i<board.length-1; i++)
            {
                if (board[i][j] == board[i+1][j] && (board[i+1][j] != 0))
                {
                    board[i][j] = 2*board[i+1][j];
                    board[i+1][j] = 0;
                    collapseChecker++;
                }
            }
        }
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 0; i<board.length-1; i++)
            {
                if (board[i][j] == board[i+1][j] && (board[i+1][j] != 0))
                {
                    board[i][j] = 2*board[i+1][j];
                    board[i+1][j] = 0;
                    collapseChecker++;
                }
            }
        }
        
        if (collapseChecker == 0)
        {
            return false;
        }
        
        return true;
    }
    
    
    //////////////////////////////////////////
    
    
    public boolean shiftDown()
    {
        //Sets checker to 0
        shiftChecker = 0;
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 3; i>=1; i--)
            {
                if (board[i][j] == 0 && (board[i-1][j] != 0))
                {
                    board[i][j] = board[i-1][j];
                    board[i-1][j] = 0;
                    shiftChecker++;
                }
            }
        }
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 3; i>=1; i--)
            {
                if (board[i][j] == 0 && (board[i-1][j] != 0))
                {
                    board[i][j] = board[i-1][j];
                    board[i-1][j] = 0;
                    shiftChecker++;
                }
            }
        }
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 3; i>=1; i--)
            {
                if (board[i][j] == 0 && (board[i-1][j] != 0))
                {
                    board[i][j] = board[i-1][j];
                    board[i-1][j] = 0;
                    shiftChecker++;
                }
            }
        }
        
        if (shiftChecker == 0)
        {
            return false;
        }
        
        return true;
    }
    
    public boolean collapseDown()
    {
        //Sets checker to 0
        collapseChecker = 0;
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 3; i>=1; i--)
            {
                if (board[i][j] == board[i-1][j] && (board[i-1][j] != 0)) 
                {
                    board[i][j] = 2*board[i-1][j];
                    board[i-1][j] = 0;
                    collapseChecker++;
                }
            }
        }
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 3; i>=1; i--)
            {
                if (board[i][j] == board[i-1][j] && (board[i-1][j] != 0)) 
                {
                    board[i][j] = 2*board[i-1][j];
                    board[i-1][j] = 0;
                    collapseChecker++;
                }
            }
        }
        
        for (int j = 0; j<board[0].length; j++)
        {
            for (int i = 3; i>=1; i--)
            {
                if (board[i][j] == board[i-1][j] && (board[i-1][j] != 0)) 
                {
                    board[i][j] = 2*board[i-1][j];
                    board[i-1][j] = 0;
                    collapseChecker++;
                }
            }
        }
        
        if (collapseChecker == 0)
        {
            return false;
        }
        
        return true;
    }
    
    //////////////////////////////////////////
    
    public boolean shiftLeft()
    {
        //Sets checker to 0
        shiftChecker = 0;
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 0; j<board.length-1; j++)
            {
                if (board[i][j] == 0 && (board[i][j+1] != 0))
                {
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = 0;
                    shiftChecker++;
                }
            }
        }
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 0; j<board.length-1; j++)
            {
                if (board[i][j] == 0 && (board[i][j+1] != 0))
                {
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = 0;
                    shiftChecker++;
                }
            }
        }
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 0; j<board.length-1; j++)
            {
                if (board[i][j] == 0 && (board[i][j+1] != 0))
                {
                    board[i][j] = board[i][j+1];
                    board[i][j+1] = 0;
                    shiftChecker++;
                }
            }
        }
        
        if (shiftChecker == 0)
        {
            return false;
        }
        
        return true;
    }
    
    
    public boolean collapseLeft()
    {
        //Sets checker to 0
        collapseChecker = 0;
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 0; j<board[0].length-1; j++)
            {
                if (board[i][j] == board[i][j+1] && (board[i][j+1] != 0))
                {
                    board[i][j] = 2*board[i][j+1];
                    board[i][j+1] = 0;
                    collapseChecker++;
                }
            }
        }
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 0; j<board[0].length-1; j++)
            {
                if (board[i][j] == board[i][j+1] && (board[i][j+1] != 0))
                {
                    board[i][j] = 2*board[i][j+1];
                    board[i][j+1] = 0;
                    collapseChecker++;
                }
            }
        }
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 0; j<board[0].length-1; j++)
            {
                if (board[i][j] == board[i][j+1] && (board[i][j+1] != 0))
                {
                    board[i][j] = 2*board[i][j+1];
                    board[i][j+1] = 0;
                    collapseChecker++;
                }
            }
        }
        
        if (collapseChecker == 0)
        {
            return false;
        }
        
        return true;
    }
    
    ///////////////////////
    
    public boolean shiftRight()
    {  
        //Sets checker to 0
        shiftChecker = 0;
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 3; j>=1; j--)
            {
                if (board[i][j] == 0 && (board[i][j-1] != 0))
                {
                    board[i][j] = board[i][j-1];
                    board[i][j-1] = 0;
                    shiftChecker++;
                }
            }
        }
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 3; j>=1; j--)
            {
                if (board[i][j] == 0 && (board[i][j-1] != 0))
                {
                    board[i][j] = board[i][j-1];
                    board[i][j-1] = 0;
                    shiftChecker++;
                }
            }
        }
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 3; j>=1; j--)
            {
                if (board[i][j] == 0 && (board[i][j-1] != 0))
                {
                    board[i][j] = board[i][j-1];
                    board[i][j-1] = 0;
                    shiftChecker++;
                }
            }
        }
        
        if (shiftChecker == 0)
        {
            return false;
        }
        
        return true;
    }
    
    public boolean collapseRight()
    {
        //Sets checker to 0
        collapseChecker = 0;
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 3; j>=1; j--)
            {
                if (board[i][j] == board[i][j-1] && (board[i][j-1] != 0))
                {
                    board[i][j] = 2*board[i][j-1];
                    board[i][j-1] = 0;
                    collapseChecker++;
                }
            }
        }
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 3; j>=1; j--)
            {
                if (board[i][j] == board[i][j-1] && (board[i][j-1] != 0))
                {
                    board[i][j] = 2*board[i][j-1];
                    board[i][j-1] = 0;
                    collapseChecker++;
                }
            }
        }
        
        for (int i = 0; i<board.length; i++)
        {
            for (int j = 3; j>=1; j--)
            {
                if (board[i][j] == board[i][j-1] && (board[i][j-1] != 0))
                {
                    board[i][j] = 2*board[i][j-1];
                    board[i][j-1] = 0;
                    collapseChecker++;
                }
            }
        }
        
        if (collapseChecker == 0)
        {
            return false;
        }
        
        return true;
    }
    
    
    
    }