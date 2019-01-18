// Program calls the methods from rbachle_SudokuChecker.java to run.  A 2D array 'grid' is first displayed with all 0s
// The getGrid method then asks the user to input values for the 2D array
// The displayGrid is called again to now display the 2D array with all entered values from the user
// Metod checkGrid then validates the users input values to decide if the 2D array is, in fact, a valid Sudoku


public class rbachle_SudokuCheckerTest
{
 public static void main ( String args[] )
 {
 rbachle_SudokuChecker sudChecker = new rbachle_SudokuChecker();
 sudChecker.displayGrid(); // this should display a 4x4 grid of all 0s
 sudChecker.getGrid();
 sudChecker.displayGrid(); // this should display your 4x4 grid that you just entered
 sudChecker.checkGrid();
 }
}

