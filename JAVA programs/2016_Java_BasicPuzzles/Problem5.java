/**
  * A class that implements the PuzzleSolution interface and finds the 
  * difference between the square of the sum and the sum of the squares
  * of the first 100 natural numbers. 
  */
  
public class Problem5 implements PuzzleSolution {
	
	/**
	  *	Main method that creates a new PuzzleSolution reference to
	  * a Problem5 object and prints the numerical solution for 
	  * problem 5. 
	  *
	  *	@param an unused String array of arguments
	  */
	
	public static void main(String[] args) {
		PuzzleSolution solution = new Problem5();
		System.out.printf("%s", solution.run());
	}
	
	/**
	  * A non-static member method that runs the code to find the
	  * solution for problem 5 and returns it to the calling method
	  * as a String.
	  *
	  * @return	a String representation of the numerical solution for
	  *			this problem. 
	  */
	
	public String run() {
		return Integer.toString(calcDifference());
	}
	
	/**
	  * Static method that finds the difference between the square of the
	  * sum and the sum of the squares.
	  *
	  * @return an integer that is the difference between the square of the
	  * 		sum and the sum of the squares.
	  */
	
	private static int calcDifference() {
		//Saves value returned by findSumOfSquares()
		int sumOfSquares = findSumOfSquares();
		
		//Saves value returned by findSquareOfSum()
		int squareOfSum = findSquareOfSum();
		
		//Saves difference between squareOfSum and sumOfSquares
		int difference = squareOfSum - sumOfSquares;
		
		return difference;
	}
	
	/**
	  * Static method that finds the sum of the squares of the first 
	  * hundred natural numbers
	  *
	  * @return an integer that is the sum of the squares of 1 through 100.
	  */
	
	private static int findSumOfSquares() {
		//Will save the sum of the squares
		int sumOfSquares = 0;
		
		//Uses a for loop to iterate through one to one hundred and add each
		//iteration's square value to the total sum.
		for(int x = 1; x <= 100; x++) {
			sumOfSquares += x * x;
		}
		
		return sumOfSquares; 
	}
	
	/**
	  * Static method that finds the square of the sum of the first hundred
	  * natural numbers.
	  *
	  * @return an integer that is the square of the sum of 1 - 100.
	  */
	
	private static int findSquareOfSum() {
		
		//Stores the square of the sum
		int squareOfSum = 0;
		
		//Iterates from 1 through 100 and adds the value to the sum
		for(int x = 1; x <= 100; x++) {
			squareOfSum += x;
		}
		
		//Squares the sum.
		squareOfSum *= squareOfSum;
		
		return squareOfSum;
	}
}