/**
  * A class that implements the PuzzleSolution interface and finds the 
  * smallest positive number that is evenly divisible by all of the numbers
  * from 1 through 20. 
  */

public class Problem4 implements PuzzleSolution {
	
	/**
	  * A static field that indicates the starting number for testing 
	  * divisibility by 1 through 20. 
	  */
	
	//Because 2520 is the smallest number divisible by 1 through 10, no
	//number smaller than it will by divisible by 1 through 20. 
	private static final int START_POINT = 2520;
	
	/**
	  * A static field that indicates the gap between the tested number and
	  * the new number.
	  */
	  
	//Because 2520 is divisible by 20 (obvious by sight or tesitng), every
	//other number divisible by 20 will be the sum of 2520 and some multiple
	//of 20.
	private static final int GAP_NUM = 20;
	
	/**
	  *	Main method that creates a new PuzzleSolution reference to
	  * a Problem4 object and prints the numerical solution for 
	  * problem 4. 
	  *
	  *	@param an unused String array of arguments
	  */
	
	public static void main(String[] args) {
		PuzzleSolution solution = new Problem4();
		System.out.printf("%s", solution.run());
	}
	
	/**
	  * A non-static member method that runs the code to find the
	  * solution for problem 4 and returns it to the calling method
	  * as a String.
	  *
	  * @return	a String representation of the numerical solution for
	  *			this problem. 
	  */
	
	public String run() {
		return Integer.toString(testDivisibility());
	}
	
	/**
	  * Static method that finds the divisibility from 1 through 20 of all 
	  * numbers from the starting point to the first number found 
	  * (in gaps of 20).
	  *
	  * @return an integer that is the smallest number divisible by 1 to 20
	  */
	
	private static int testDivisibility() {
		//Keeps track of the number being tested
		int testing = START_POINT;
		
		//Will loop through until the number being tested is divisible by
		//all necessary numbers. Will increment the tested number by 20.
		while(!isDivisible(testing)){
			testing += GAP_NUM;
		}
		
		return testing;
	}
	
	/**
	  * Static method that finds the divisibility of the number passed.
	  *
	  * @param the integer number being tested
	  * @return true if the number is divisible by 1-20; false otherwise
	  */
	
	private static boolean isDivisible(int testing){
		//Defaults to true. Will only be changed to false if proven to 
		//be indivisible by one of the tested numbers.
		boolean divisible = true;
		
		//Twenty is covered in the increment from the previous test number.
		int divideBy = 19;
		
		//Will test from 11 through 19. 1 through 10 are all factors 
		//of one or more numbers in 11 through 20. The loop continues
		//as long as no number has been found that is not a factor of the
		//tested number.
		while(divideBy > 10 && divisible) {
			
			//Will only decrement as long as the tested number remains 
			//divisible by everything tested so far.
			if (testing % divideBy != 0) {
				divisible = false;
			}
	
			else {
				divideBy--;
			}
		}
		
		return divisible;
	}
}