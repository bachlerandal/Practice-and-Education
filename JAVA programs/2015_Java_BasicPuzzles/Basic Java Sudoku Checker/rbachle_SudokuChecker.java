// Program is used by rbachle_SudokuCheckerTest.java to provide methods for use.  Methods ask the user to input values for a 2D array that will be a Sudoku to be checked
// The program then displays the Sudoku, then verifies that the 2D array qualifies as a Sudoku by comparing rows, columns, and regions and ensuring they add up to 10
// The program then responds to the user, telling them is the Sudoku they entered is valid

import java.util.Scanner;
public class rbachle_SudokuChecker
{
    private int[][] grid = new int[4][4];
    // put private data members here
    public rbachle_SudokuChecker()
    { 




        System.out.println("Welcome to the Sudoku Checker v1.0!");
        System.out.println("\nThis program checks simple, small, 4x4 Sudoku grids for correctness. Each column, row and 2x2 regioncontains the numbers 1 through 4 only once.");
        System.out.println("\nTo check your Sudoku, enter your board one row at a time, with each digit separated by a space. Hit ENTER at the end of a row.\n");
    }




/* Method getGrid asks the user to enter values that are used to fill the 2D array 'grid' using a for loop
*/
    public void getGrid()
    {
        Scanner in = new Scanner(System.in);
        for ( int i=0; i<4; i++)
        {
            System.out.printf("Enter Row %d: ", i+1);
            grid[i][0] = in.nextInt();
            grid[i][1] = in.nextInt();
            grid[i][2] = in.nextInt();
            grid[i][3] = in.nextInt();
        }
    }




/* Method displayGrid uses a for loop to display the 2D array 'grid' in a 4x4 format
*/
    public void displayGrid()
    {

        System.out.println("This is the grid as I see it now");

        for(int j = 0; j<4; j++)
        {
            for(int k = 0; k<4; k++)
            {
                System.out.printf("%5d", grid[j][k]);
            }
            System.out.println();
        }
    }





/*Method checkGrid uses if statements to verify that the 2D array 'grid' is actually a valid Sudoku
// boolean Sudo is the value that changes if an invalid portion of the 2D array 'grid' is discovered
*/

    public void checkGrid()
    {
        System.out.println("Thankyou. Now Checking....");

        boolean Sudo = true;

        if((grid[0][0] + grid[0][1] + grid[1][0] + grid[1][1]) == 10)
        {
            System.out.println("Reg-1: Good");
        }
        if((grid[0][0] + grid[0][1] + grid[1][0] + grid[1][1]) != 10)
        {
            Sudo = false;
            System.out.println("Reg-1: Bad");
        }


        if((grid[0][2] + grid[0][3] + grid[1][2] + grid[1][3]) == 10)
        {
            System.out.println("Reg-2: Good");
        }
        if((grid[0][2] + grid[0][3] + grid[1][2] + grid[1][3]) != 10)
        {
            Sudo = false;
            System.out.println("Reg-2: Bad");
        }


        if((grid[2][0] + grid[2][1] + grid[3][0] + grid[3][1]) == 10)
        {
            System.out.println("Reg-3: Good");
        }
        if((grid[2][0] + grid[2][1] + grid[3][0] + grid[3][1]) != 10)
        {
            Sudo = false;
            System.out.println("Reg-3: Bad");
        }


        if((grid[2][2] + grid[2][3] + grid[3][2] + grid[3][3]) == 10)
        {
            System.out.println("Reg-4: Good");
        }
        if((grid[2][2] + grid[2][3] + grid[3][2] + grid[3][3]) != 10)
        {
            Sudo = false;
            System.out.println("Reg-4: Bad");
        }


        for( int i=0; i<4; i++ )
        {
            if((grid[i][0] + grid[i][1] + grid[i][2] + grid[i][3]) == 10)
            {
                System.out.printf("\nRow-%d: Good", i+1);
            }
            else
            {
                System.out.printf("\nRow-%d: Bad", i+1);
                Sudo = false;
            }
        }
        System.out.println(" ");
        for( int j=0; j<4; j++)
        {
            if((grid[0][j] + grid[1][j] + grid[2][j] + grid[3][j]) == 10)
            {
                System.out.printf("\nCol-%d: Good", j+1);
            }
            else
            {
                System.out.printf("\nCol-%d: Bad", j+1);
                Sudo = false;
            }
        }

        if(Sudo == true)
        {
            System.out.println("\n\nSudo: VALID");
        }
        if(Sudo == false)
        {
            System.out.println("\n\nSudo: INVALID");
        }
    }
}
