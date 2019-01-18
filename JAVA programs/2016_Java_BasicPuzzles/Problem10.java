import java.util.StringTokenizer;

/**
  * A class that implements the PuzzleSolution interface and finds the
  * four adjacent numbers in the given 20 x 20 grid that have the largest
  * product. 
  */

public class Problem10 implements PuzzleSolution {
	
	/**
	  * A static instance variable containing the String representing the
	  * given 20 x 20 grid. 
	  */
	
	private static final String GRID = 
			( "08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08 "
			+ "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00 "
			+ "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65 "
			+ "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91 "
			+ "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80 "
			+ "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50 "
			+ "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70 "
			+ "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21 "
			+ "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72 "
			+ "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95 "
			+ "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92 "
			+ "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57 "
			+ "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58 "
			+ "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40 "
			+ "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66 "
			+ "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69 "
			+ "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36 "
			+ "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16 "
			+ "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54 "
			+ "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48");
	
	/**
	  * A static field containing the number of integers that need to be 
	  * multiplied, minus one to account for use of the starting integer.
	  */
	  
	private static final int NUM_DIGITS = 3;
	
	/**
	  * A static field containing an integer that represents the number of
	  * rows and columns in the grid. 
	  */
	
	private static final int NUM_ROWS_COLS = 20;
	
	/**
	  * A static 2D array that will hold the integer grid once it has been
	  * parsed in by the StringTokenizer. 
	  */
	
	private static int[][] intGrid = new int[NUM_ROWS_COLS][NUM_ROWS_COLS];
	
	/**
	  *	Main method that creates a new PuzzleSolution reference to
	  * a Problem10 object and prints the numerical solution for 
	  * problem 10. 
	  *
	  *	@param an unused String array of arguments
	  */
	
	public static void main(String[] args) {
		PuzzleSolution solution = new Problem10();
		System.out.printf("%s", solution.run());
	}
	
	/**
	  * A non-static member method that runs the code to find the
	  * solution for problem 10 and returns it to the calling method
	  * as a String.
	  *
	  * @return	a String representation of the numerical solution for
	  *			this problem. 
	  */
	
	public String run() {
		return Integer.toString(findLargestProduct());
	}
	
	/**
	  * A static method used to implement the makeGrid() and
	  * calcAllAcross() methods.
	  *
	  * @return the largest product of four adjacent numbers in the grid.
	  */
	
	private static int findLargestProduct() {
		makeGrid();		
		return calcAllAcross();
	}
	
	/**
	  * A static method used to fill the grid using the String GRID.
	  */
	
	private static void makeGrid() {
		//StringTokenizer used to transfer String into intGrid
		StringTokenizer strTkr = new StringTokenizer(GRID);
		
		//Double four loop fills the columns in an individual row before
		//moving onto the next in order to mimic the grid itself
		for(int row = 0; row < NUM_ROWS_COLS; row++) {
			for (int col = 0; col < NUM_ROWS_COLS; col++) {
				//To ensure that don't try to grab something from GRID 
				//when the code has reached the end. Merely a precaution.
				if (strTkr.hasMoreTokens()) {
					//Must parse integer from the String; since using tokens,
					//the next token will be the integer needed
					intGrid[row][col] = Integer.parseInt(strTkr.nextToken());
				}
			}
		}
	}
	
	/**
	  * A static method used to calculate the largest product of four adjacent
	  * numbers in the 2D array filled by GRID. 
	  *
	  * @return the largest product of four adjacent numbers
	  */
	
	private static int calcAllAcross() {
		//Holds the largest product found during processing
		int largestProduct = 0;
		
		//keeps track of the position going across the rows
		//(which column currently on)
		int posAcross;
		
		//keeps track of the position going up and down the columns
		//(which row currently on)
		int posVert;
		
		//double four loop iterates through the entire grid 
		for (int row = 0; row < NUM_ROWS_COLS; row++) {
			for (int col = 0; col < NUM_ROWS_COLS; col++) {
				//New variable to track the latest product found. Starts at 
				//one for correct multiplicative assignment.
				int product = 1;
				
				//The starting point of the multiplication going across
				//is set to the column currently at
				posAcross = col;
				
				//The starting point of the multiplication going up and down
				//is set to the row currently at
				posVert = row;
				
				//The while loop will test two conditions:
				//1) The position going across can't be greater than the starting point plus
				//   three (since the starting point is included in calculations)
				//2) The column the for loop  is on must be less than the 17. Because an array
				//   indexes 0 through 19 in this case, once the starting position is 17, 
				//   there are less than four numbers left from the starting position to the 
				//   end of the row. 
				//This loop only multiplies four numbers going across the row as long as the
				//conditions are met. 
				while(posAcross <= col + NUM_DIGITS && col < NUM_ROWS_COLS - NUM_DIGITS) {
					//The integer at the current position in the 2D array is multiplied 
					//by and saved into product. 
					product *= intGrid[row][posAcross];
					
					//The position going across is incremented.
					posAcross++;
				}
				
				//Comparison saves the calculated product as the largest if it is so.
				if (product > largestProduct) {
					largestProduct = product;
				}
				
				//The product is reset to one so that it can be filled anew. 
				product = 1;
				
				//This loop works much like the first, only going down columns:
				//1) The position going up an down can't be greater than the starting point
				//   plus three
				//2) The row the for loop is on must be less than
				//   17. Otherwise, there are less than 4 operands to use. 
				//This loop multiples four operands going down the column. 
				while(posVert <= row + NUM_DIGITS && row < NUM_ROWS_COLS - NUM_DIGITS) {
					product *= intGrid[posVert][col];
					
					//The position going down is incremented. 
					posVert++;
				}
				
				if(product > largestProduct) {
					largestProduct = product;
				}
				
				//Reset to store a new calculation
				product = 1;
				
				//Reset to original starting points for reuse in first diagonal calculation.
				posAcross = col; 
				posVert = row;
				
				//This loop calculates going from top left to bottom right. 
				//1) The position going down has to be at most the starting point plus three. 
				//2) The position going across has to be at most the start plus three.
				//3) The row on which the for loop is on has to be less than 17.
				//4) The column on which the for loop is on has to be less than 17.
				while(posVert <= row + NUM_DIGITS && posAcross <= col + NUM_DIGITS &&
				row < NUM_ROWS_COLS - NUM_DIGITS && col < NUM_ROWS_COLS - NUM_DIGITS) {
					product *= intGrid[posVert][posAcross];
					//The position across and down must both be incremented so that
					//the current integer is actually the one diagonal of the previous.
					posVert++;
					posAcross++;
				}
				
				if (product > largestProduct) {
					largestProduct = product;
				}
				
				//Reset all three again to original values for last loop.
				product = 1;
				posAcross = col; 
				posVert = row;
				
				//This loop calculates from top right to bottom left. 
				//1) The position going down has to be at most the start plus three.
				//2) The position going across can be no less than the starting point
				//   minus three (accounting for the fact that the value at the 
				//   position is also used)
				//3) The row on which the for loop is on has to be less than 17.
				//4) The column on which the for loop is on has to be at least 3
				//   (the first calculation will be made on positions 0 through 3)
				while(posVert <= row + NUM_DIGITS && posAcross >= col - NUM_DIGITS &&
				row < NUM_ROWS_COLS - NUM_DIGITS && col >= NUM_DIGITS) {
					product *= intGrid[posVert][posAcross];
					posVert++;
					
					//In this case, the position going across is decremented so that
					//the position travels downwards, but towards the "left" rather
					//than right.
					posAcross--;
				}
				
				if (product > largestProduct) {
					largestProduct = product;
				}
			}
		}
		
		return largestProduct;
	}
}