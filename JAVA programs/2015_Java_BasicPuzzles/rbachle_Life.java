// Program generates a grid of points that grow or disappear depending on how many points are neighboring them.  If a point has 
// exactly three live neighbors, it becomes a live cell in the next generation.  If a living cell has two or three live neighbors, it 
// stays alive in the next generation.  If a cell has less than two live neighbors or more than three live neighbors, it dies.
// The user gets to choose either a Queen Bee shuttle formation, a glider patter formation, or a random formation of starting points.



import java.util.Scanner;
import java.util.Random;

public class rbachle_Life 
{

    // the size of the grid (GRIDSIZE x GRIDSIZE)
    final private static int GRIDSIZE = 18;

    /********************************************************************************/
    public static void main ( String args[] )
    {
        boolean[][] board = new boolean[GRIDSIZE][GRIDSIZE];
        char choice;
        int x = 1;
        Scanner sc = new Scanner ( System.in );

        do
        {
            System.out.print ( "Start with a (r)andom board, the (q)ueen bee shuttle or the (g)lider pattern? ");
            choice = sc.next().charAt(0);
        } while ( choice != 'r' && choice != 'q' && choice != 'g' );

        clearGrid (board);
        setup(board,choice);

        do
        {
            System.out.printf ("Viewing generation #%d:\n\n", x++);
            displayGrid(board);
            genNextGrid(board);
            System.out.print ("\n(q)uit or any other key + ENTER to continue: ");
            choice = sc.next().charAt(0);
        } while ( choice != 'q' );

    }

    /********************************************************************************/
    public static void setup (boolean[][] board, char which )
    {
        Random randomNumbers = new Random();

        clearGrid(board);

        if ( which == 'q' )
        {
            // Set up the Queen Bee Shuttle pattern
            board[5][1] = true;board[5][2] = true;board[6][3] = true;board[7][4] = true; 
            board[8][4] = true;board[9][4] = true;board[10][3] = true;board[11][2] = true;
            board[11][1] = true;        
        }
        else if ( which == 'g' )
        {
            // Set up a Glider
            board [17][0] = true; board[16][1] = true; board[15][1] = true;
            board[16][2] = true;
            board [17][2] = true;
        }
        else
        {
            // set up random
            for (int row = 0; row < board.length; row++ )
            {
                for (int col = 0; col < board[row].length; col++ )
                {
                    if ( randomNumbers.nextInt() % 2 == 0 )
                        board[row][col] = true;
                }
            }
        }

    }

    /********************************************************************************/
    public static void displayGrid (boolean[][] board)
    {
        // Start printing the top row of numbers
        System.out.print ("   ");
        for (int x = 1; x <= board.length; x++)
        {
            if ((x / 10) != 0)
                System.out.printf ( "%d", x / 10 );
            else
                System.out.print ( " " );
        }

        System.out.println();
        System.out.print( "   " );

        for (int x = 1; x <= board.length; x++)
        {
            System.out.printf ( "%d", x % 10 );
        }
        System.out.println();

        for (int r = 0; r < board.length; r++)
        {
            System.out.printf ( "%d", r+1 );
            if (r + 1 < 10)
                System.out.print ( "  " );
            else
                System.out.print ( " " );
            for (int c = 0; c < board.length; c++)
            {
                if (board[r][c] == true)
                    System.out.print ( "*" );
                else
                    System.out.print ( " " );
            }
            System.out.println();
        }
    }


    /*******************************************************************************/

    // put the three methods you must write here and make sure to document
    // them!

  /**
  *Method clearGrid sets all of the Board[][] values to false in order to prepare for the next generated grid iteration.
  *@param board   the 2Dimensional array that is fed into the clearGrid method
  */

    public static void clearGrid ( boolean[][] board )
    {
	for(int i=0; i<18; i++)
	{
		for(int j=0; j<18; j++)
		{
			board[i][j] = false;
		}
	}
    }


  /*******************************************************************************/ 


 /**
  *Method genNextGrid generates a temporary 2D array called 'newBoard' that holds the boolean values 
  *of the original 2D array 'board' while each position in the grid is being checked for survival, growth, or death into the next iteration
  *After the check has been complete, the values in 'newBoard' are copied into the old array 'board' to be printed and used in the next round
  *@param board   the 2Dimensional array that is fed into the clearGrid method
  */

    public static void genNextGrid ( boolean[][] board )
    {
	boolean[][] newBoard = new boolean[board.length][board[0].length];
	for(int i=0; i < board.length; i++)
	{
		for(int j=0; j <board[i].length; j++)
		{
			
			if(board[i][j] == false && countNeighbors(board, i, j) == 3)
			{
				newBoard[i][j] = true;
			}
			
			if(countNeighbors(board, i, j) < 2 || countNeighbors(board, i, j) > 3)
			{
				newBoard[i][j] = false;
			}
			
			if(board[i][j] == true && countNeighbors(board, i, j) == 2 || countNeighbors(board, i, j) == 3)
			{
			  newBoard[i][j] = true;
			}
		}
	}
    for(int k=0; k < board.length; k++)
    {
        for(int l=0; l < board[k].length; l++)
        {
            board[k][l] = newBoard[k][l];
        }
    }
    }


  /*******************************************************************************/ 


 /**
  *Method countNeighbors checks all positions in the 2D array 'board' and counts how many neighbors they have.  This count will be
  *returned for further use in the genNextGrid method, determining if a cell lives or dies through the next iteration.
  *The value returned is between 0 and 8 
  *@param board   the 2Dimensional array that is fed into the clearGrid method
  */

    public static int countNeighbors ( final boolean[][] board, final int row, final int col )
    {
	int count = 0;
	
	for(int i = row - 1; i <= row + 1; i++)
	{
		if(i >= 0 && i < board.length)
		{
			for(int j = col - 1; j <= col + 1; j++)
			{
				if(j >= 0 && j < board[i].length)
				{
					if (i != row || j != col)
					{
						if(board[i][j] == true)
						{
							count++;
						}
					}
				}
			}
		}
	}
	return count;	
    }
}
