/**
  * A class that implements the PuzzleSolution interface and finds the
  * sum of all even fibonacci sequence terms less than four million. 
  */

public class Problem1 implements PuzzleSolution {
	
	/**
	  * A final int variable that delineates the maximum valued
	  * of a term of the fibonacci sequence. 
	  */
	
	private static final int MAX = 4000000;
	
	/**
	  *	Main method that creates a new PuzzleSolution reference to
	  * a Problem1 object and prints the numerical solution for 
	  * problem 1. 
	  * 
	  * @param an unsed String array of arguments
	  */
	
	public static void main(String[] args) {
		PuzzleSolution solution = new Problem1();
		System.out.printf("%s", solution.run());
	}
	
	/**
	  * A non-static member method that runs the code to find the
	  * solution for problem 1 and returns it to the calling method
	  * as a String.
	  *
	  * @return	a String representation of the numerical solution for
	  *			this problem. 
	  */
	
	public String run() {
		return Integer.toString(fibonacciCalc());
	}
	
	/**
	  *	A static method that calculates the solution of this problem
	  * by finding the terms of the fibonacci sequence up to four
	  * million and adding the even terms together.
	  *
	  *	@return a integer variable containing the sum of the even
	  *			terms of the fibonacci sequence less than four million.
	  */
	
	private static int fibonacciCalc() {
		
		//The fibonacci number term currently processing
		int currentFibNum = 0;
		
		//The fibonacci number term that was previously processed
		int prevFibNum = 0;
		
		//A temporary variable used during processing.
		int temp = 0;
		
		//The sum of the even terms less than four million
		int sum = 0;
		
		//The do while will ensure that the first two terms of the
		//fibonacci sequence process, and then processing continues
		//in a loop until maximum term is reached or surpassed. 
		do {
			
			//This ensures that the first term of the fibonacci sequence
			//is processed. 
			if (currentFibNum == 0) {
				currentFibNum += 1;
			}
			
			//This processes the fibonacci sequence calculation
			else {
				//Saves the current fibonacci number during processing
				temp = currentFibNum;
				
				//Does the calculation for the next term
				currentFibNum = prevFibNum + currentFibNum;
				
				//Saves the temporary term as the previously processed term
				prevFibNum = temp;
				
				//The currently processed fibonacci number is added only
				//when even
				if (isEven(currentFibNum)) {
					sum += currentFibNum;
				}
			}	
		} 
		while (currentFibNum <= MAX);
		
		return sum;
	}
	
	/**
	  *	A static method that determines whether or not the number passed
	  * is an even number. 
	  *
	  * @param a integer number to be tested
	  *	@return a boolean determining whether or not the passed parameter is
	  *			even
	  */
	
	private static boolean isEven(int num) {
		//Will return false by defualt unless changed by the code
		boolean toReturn = false;
		
		if (num % 2 == 0) {
			toReturn = true;
		}
		
		return toReturn;
	}
}