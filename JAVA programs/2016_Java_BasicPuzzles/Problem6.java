/**
  * A class that implements the PuzzleSolution interface and finds the 
  * thirteen adjacent digits in the given 1000-digit stored in NUMBER that
  * have the greatest product. 
  */

public class Problem6 implements PuzzleSolution {
	
	/**
	  * A static field holding a String representing the 1000-digit number
	  * used in this problem. 
	  */
	
	private static final String NUMBER = 
	("73167176531330624919225119674426574742355349194934"
	+ "96983520312774506326239578318016984801869478851843" 
	+ "85861560789112949495459501737958331952853208805511"
	+ "12540698747158523863050715693290963295227443043557"
	+ "66896648950445244523161731856403098711121722383113"
	+ "62229893423380308135336276614282806444486645238749"
	+ "30358907296290491560440772390713810515859307960866"
	+ "70172427121883998797908792274921901699720888093776"
	+ "65727333001053367881220235421809751254540594752243"
	+ "52584907711670556013604839586446706324415722155397"
	+ "53697817977846174064955149290862569321978468622482"
	+ "83972241375657056057490261407972968652414535100474"
	+ "82166370484403199890008895243450658541227588666881"
	+ "16427171479924442928230863465674813919123162824586"
	+ "17866458359124566529476545682848912883142607690042"
	+ "24219022671055626321111109370544217506941658960408"
	+ "07198403850962455444362981230987879927244284909188"
	+ "84580156166097919133875499200524063689912560717606"
	+ "05886116467109405077541002256983155200055935729725"
	+ "71636269561882670428252483600823257530420752963450");
	
	/**
	  * A static field holding an integer whose value is used to 
	  * determine the number of iterations needed to process the
	  * correct number of variables. Accounts for the fact that the
	  * starting value of the iteration with be used in calculation.
	  */
	  
	private static final int DIGIT_NUM = 12;
	
	/**
	  *	Main method that creates a new PuzzleSolution reference to
	  * a Problem6 object and prints the numerical solution for 
	  * problem 6. 
	  *
	  *	@param an unused String array of arguments
	  */
	
	public static void main(String[] args) {
		PuzzleSolution solution = new Problem6();
		System.out.printf("%s", solution.run());
	}
	
	/**
	  * A non-static member method that runs the code to find the
	  * solution for problem 6 and returns it to the calling method
	  * as a String.
	  *
	  * @return	a String representation of the numerical solution for
	  *			this problem. 
	  */
	
	public String run() {
		//The method passes along 0 because want to start at position 0
		//of the String NUMBER.
		return Long.toString(findLargestProduct(0));
	}
	
	/**
	  * Static method that finds the largest product of thirteen adjacent
	  * digits in the field NUMBER.
	  *
	  * @param an integer that represents the position in the String NUMBER
	  * @return an integer that is the difference between the square of the
	  * 		sum and the sum of the squares.
	  */
	
	private static long findLargestProduct(int position) {
		//calculatedHere starts at 1 so as to be able use multiplication 
		//assignment without error
		long calculatedHere = 1;
		
		//keeps track of the value returned by the recursive method
		long returnedByRecursion = 0;
		
		//Base Case: Reaches the end of the string. Determined by calculating
		//whether or not the position is the same as the length of the NUMBER
		//String minus the one less than the number of digits to calculate. 
		if (position == NUMBER.length() - DIGIT_NUM) {
			return 1; 
		}
		
		//Recursive Case: Does not reach the end of the string.
		else { 
			//Will calculate thirteen digits starting with the digit at position
			//and ending with the digit at position + 12
			for(int pos = position; pos <= position + DIGIT_NUM; pos++) { 
				//Takes the digit at the current position in the NUMBER string
				//and parses it into an integer
				int currentDigit = Integer.parseInt(NUMBER.substring(pos, pos + 1));

				//Takes the digit parsed and does multiplication assignment one
				//calculatedHere using it. 
				calculatedHere *= currentDigit;
			}
			
			//Calls this method using the next digit in the String as the starting
			//point
			returnedByRecursion = findLargestProduct(position + 1);
		}
		
		//Compares the value returned by recursion and the value calculated in 
		//the current method call. Returns the largest. 
		if(returnedByRecursion >= calculatedHere) {
			return returnedByRecursion;
		}
		
		else {
			return calculatedHere;
		}
	}
}