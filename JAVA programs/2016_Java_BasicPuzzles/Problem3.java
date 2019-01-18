/**
  * A class that implements the PuzzleSolution interface and finds the
  * largest palindrome made from the product of two three-digit numbers.
  */

public class Problem3 implements PuzzleSolution {
	
	/**
	  *	Main method that creates a new PuzzleSolution reference to
	  * a Problem3 object and prints the numerical solution for 
	  * problem 3. 
	  *
	  *	@param an unused String array of arguments
	  */
	
	public static void main(String[] args) {
		PuzzleSolution solution = new Problem3();
		System.out.printf("%s", solution.run());
	}
	
	/**
	  * A non-static member method that runs the code to find the
	  * solution for problem 3 and returns it to the calling method
	  * as a String.
	  *
	  * @return	a String representation of the numerical solution for
	  *			this problem. 
	  */
	
	public String run() {
		return Integer.toString(findPalindrome());
	}
	
	/**
	  * A static method that finds the largest palindrome of the product
	  * of two three-digit numbers.
	  *
	  * @return an integer containing the largest palindrome
	  */
	
	private static int findPalindrome() {
		//Will hold the largest found palindrome during processing
		int palindrome = 0;
		
		//Loops through integer variables x and y. To find the largest palindrome,
		//the x loop will internally loop from 0 to x in decreasing order. 
		//Meanwhile, it will loop from 999 to 0, ensuring that every
		//possible product is considered. 
		for (int x = 999; x > 0; x--) {
			for (int y = x; y > 0; y--) {
				
				//Only saves into palindrome when is palindrome and the new 
				//palindrome is larger than the currently saved palindrome
				if(isPalindrome(Integer.toString(x * y)) && x * y > palindrome){
					palindrome = x * y;
				}
			}
		}
		
		return palindrome;
	}
	
	/**
	  * A static method that determines whether or not the String passed
	  * is palindromic.
	  *
	  * @param a String representation of the candidate number.
	  * @return true if the String is palindromic; false otherwise
	  */
	
	private static boolean isPalindrome(String toTest) {
		//Starts as false so that true is only returned when changed by code
		boolean toReturn = false;
		
		//String to which the characters will be addded
		String newString = "";
		
		//Goes through all characters in the String and saves them into 
		//the new String
		for(int atChar = toTest.length() - 1; atChar >= 0; atChar--) {
			newString += toTest.charAt(atChar);
		}
		
		//Changes the boolean to true if the two Strings are equal to each other
		if (toTest.equals(newString)){
			toReturn = true;
		}
		
		return toReturn;
	}
}