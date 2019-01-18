// Program prompts the user to enter the integer values for a 4x4 square.  The program then checks to see if the values entered
// make up a "Magic Square" that has all rows, coulumns, and diagonals equaling the value of 34 using every integer only once

import java.util.Scanner;
import java.util.Random;

public class rbachle_Magic
{
    public static void main(String args[])
    {

        Scanner in = new Scanner (System.in);
 
        int[][] theSquare = new int[4][4];

        System.out.println("The magic value for your square is 34, which means that every row, column, and diagonal of your square"
                + " must add up to that number.\n");

        for ( int i=0; i<4; i++)
        {
            System.out.printf("Please enter the 4 values for row %d, seperated by spaces: ", i);
            theSquare[i][0] = in.nextInt();
            theSquare[i][1] = in.nextInt();
            theSquare[i][2] = in.nextInt();
            theSquare[i][3] = in.nextInt();
        }

        for(int j = 0; j<4; j++)
        {
            for(int k = 0; k<4; k++)
            {
                System.out.printf("%5d", theSquare[j][k]);
            }
            System.out.println();
        }
        System.out.println("\nChecking Square for problems\n");

    
        boolean magic = true;
        if(checkDiagonals(theSquare) == false)
                {
                    magic = false;
                }

        if(checkRows(theSquare) == false)
        {
            magic = false;
        }
        if(checkColumns(theSquare) == false)
        {
            magic = false;
        }
        if(checkRange(theSquare) == false)
        {
            magic = false;
        }
        if(magic == false)
        {
            System.out.print("\nMAGIC: NO\n");
        }
        
        if(magic == true) 
        {
            System.out.println("\nMAGIC: YES");
        }
    }


/**
  *Method checkRows will run through a loop that adds up all positions of the 2D array theSquare by row
  *If the value of the row is 34, the boolean value rowsValid remains true
  *If the value of the row is not 34, the boolean value rowsValid is set to false
  *@param theSquare  the 2Dimensional array that is fed into the checkRows method
  *@return rowsValid the boolean value that is returned to the main method by the checkRows method
  */

    public static boolean checkRows( int theSquare[] [] )
    {
        System.out.print("\nROWS: ");
        boolean rowsValid = true;
        for( int i = 0; i<4; i++)
        {
            if(theSquare[i][0] + theSquare[i][1] + theSquare[i][2] + theSquare[i][3] != 34)
            {	
                rowsValid = false;
                System.out.printf(" %d ", i);
            }	
        }
        if(rowsValid == true)
        {
            System.out.print("VALID");
        }
        return rowsValid;
    }


/**
  *Method checkColums will run through a loop that adds up all positions of the 2D array theSquare by column
  *If the value of the column is 34, the boolean value columnsValid remains true
  *If the value of the column is not 34, the boolean value columnsValid is set to false
  *@param theSquare the 2Dimensional array that is fed into the checkColumns method
  *@return columnsValid the boolean value that is returned to the main method by the checkColumns method
  */

    public static boolean checkColumns( int theSquare[] [] )
    {
        System.out.print("\nCOLS: ");
        boolean columnsValid = true;
        for( int i = 0; i<4; i++)
        {
            if(theSquare[0][i] + theSquare[1][i] + theSquare[2][i] + theSquare[3][i] != 34)
            {
                columnsValid = false;
                System.out.printf(" %d ", i);
            }
        }
        if(columnsValid == true)
        {
            System.out.print("VALID");
        }
        return columnsValid;
    }


/**
  *Method checkDiagonals will run through a loop that adds up the positions of the 2 potential diagonals of the 2D array theSquare
  *If the value of the diagonal is 34, the boolean value diagonalsValid remains true
  *If the value of the diagonal is not 34, the boolean value diagonalsValid is set to false
  *@param theSquare the 2Dimensional array that is fed into the checkDiagonals method
  *@return diagonalsValid the boolean value that is returned to the main method by the checkDiagonals method
  */

    public static boolean checkDiagonals( int theSquare[] [])
    {
        System.out.print("\nDIAG: ");
        boolean diagonalsValid = true;
        if(theSquare[0][0] + theSquare[1][1] + theSquare[2][2] + theSquare[3][3] != 34)
        {
            diagonalsValid = false;
            System.out.printf(" 0 ");
        }
        if(theSquare[0][3] + theSquare[1][2] + theSquare[2][1] + theSquare[3][0] != 34)
        {
            diagonalsValid = false;
            System.out.printf(" 1 ");
        }

        if(diagonalsValid == true)
        {
            System.out.print("VALID");
        }
        return diagonalsValid;
    }

/**
  *Method checkRange will compare all values of the 2D array theSquare to each other to identify if any integer is repeated throughout the array
  *If a value IS repeated, the boolean value rangeValid will be set to false
  *If a value is outside of the acceptable range of values (1-16), then the boolean value rangeValid will be set to false
  *@param theSquare the 2Dimesnional array that is fed into checkRange method
  *@return rangeValid is the boolean value that is returned to the main method by the checkRange method
  */

    public static boolean checkRange( int theSquare[] [])
    {
        boolean rangeValid = true;
        System.out.print("\nRANG: ");

        for(int j = 0; j<4; j++)
        {
            for(int k = 0; k<4; k++)
            {
                if(theSquare[j][k] < 1 || theSquare[j][k] > 16)
                {
                    rangeValid = false;
                    System.out.printf(" %d ", theSquare[j][k]);
                }
                for(int x = 0; x<4; x++)
                {
                    for(int y = 0; y<4; y++)
                    {
                        if(j != x || k != y)
                        { 
                            if(theSquare[j][k] == theSquare[x][y])
                            {
                                rangeValid = false;
                                System.out.printf(" %d ", theSquare[j][k]);
                            }
                        }
                    }
                }
            }
        }




        if(rangeValid == true)
        {
            System.out.print("VALID");
        }
        return rangeValid;
    }

}
