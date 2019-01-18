/**
  * A class that implements the PuzzleSolution interface and finds the
  * product of a * b * c, where a, b, and c represent a pythagorean triplet
  * whose sum is 1000. 
  */

public class Problem8 implements PuzzleSolution {
	
	/**
	  * A static field containing an integer whose value is the needed 
	  * sum of the pythagorean triplet. 
	  */
	
	private static final int SUM_VALUE = 1000;
	
	/**
	  *	Main method that creates a new PuzzleSolution reference to
	  * a Problem8 object and prints the numerical solution for 
	  * problem 8. 
	  *
	  *	@param an unused String array of arguments
	  */
	
	public static void main(String[] args) {
		PuzzleSolution solution = new Problem8();
		System.out.printf("%s", solution.run());
	}
	
	/**
	  * A non-static member method that runs the code to find the
	  * solution for problem 8 and returns it to the calling method
	  * as a String.
	  *
	  * @return	a String representation of the numerical solution for
	  *			this problem. 
	  */
	
	public String run() {
		return Integer.toString(pythTripleProd());
	}
	
	/**
	  * A static method that finds the product of a pythagorean triple
	  * whose sum is 1000. 
	  *
	  * @return the product of the triple
	  */
	
	private static int pythTripleProd() {
		//Saves the calculated product.
		int product = 0;
		
		//Used to stop loop iteration.
		boolean tripleFound = false;
		
		//Used for pythagorean triplet calculation.
		int c = 0;
		
		//One plus another square does not make a square, so it is an unnecessary
		//addition. 
		int a = 2;
		
		//The loop will continue until a triple that meets the conditions is found
		while(!tripleFound) {
			int b = 0;
			
			//B only needs to iterate until it is half of 1000 minus the value of a.
			//After that point, c would not be bigger than a and b both. 
			while(b < (SUM_VALUE - a) / 2 && !tripleFound) {
				
				//C is 1000 minus the values of a and b
				c = SUM_VALUE - a - b;
				
				//Will check if the proposed values are pythagorean triples 
				if (a*a + b*b == c*c) {
					tripleFound = true;
					product = a * b * c;
				}
				
				//B is incremented in case of another iteration
				b++;
			}
			//A is incremented, meaning less values are tested for B, and, therefore,
			//C in the next iteration. 
			a++;
		}
		
		return product; 
	}
}