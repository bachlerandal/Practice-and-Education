/**
  * A class that implements the PuzzleSolution interface and finds the
  * 10001st prime number. 
  */

public class Problem7 implements PuzzleSolution {
	
	/**
	  * A static field that saves previously calculated prime numbers. 
	  */
	 
	//10001 elements long in order to save space and increase efficiency
	private static int[] primes = new int[10001];
	
	/**
	  *	Main method that creates a new PuzzleSolution reference to
	  * a Problem7 object and prints the numerical solution for 
	  * problem 7. 
	  *
	  *	@param an unused String array of arguments
	  */
	
	public static void main(String[] args) {
		PuzzleSolution solution = new Problem7();
		System.out.printf("%s", solution.run());
	}
	
	/**
	  * A non-static member method that runs the code to find the
	  * solution for problem 7 and returns it to the calling method
	  * as a String.
	  *
	  * @return	a String representation of the numerical solution for
	  *			this problem. 
	  */
	
	public String run() {
		return Integer.toString(findPrime());
	}
	
	/**
	  * Static method that finds the `10001st prime. 
	  *
	  * @return the 10001st prime as an integer
	  */
	
	private static int findPrime() {
		//2 is the first prime number
		primes[0] = 2;
		
		//candidate will be incremented by one and tested for divisibility
		int candidate = 3;
		
		//This loop fills each position in the array
		for(int pos = 1; pos < primes.length; pos++) {
			//The candidate will continue incrementing by two until it is prime
			//An increment by one from three would end up with an even number, 
			//which can be skipped.
			while(!isPrime(candidate)) {
				candidate += 2;
			}
			
			//When a prime candidate is found, it is saved to the primes array
			//and the candidate is incremented by two. 
			primes[pos] = candidate;
			candidate += 2;
		}
		
		//Once the array is filled, the array at position 10000 (element number 10001)
		//is returned to the calling method.
		return primes[10000];
	}
	
	/**
	  * Static method that determines whether or not the passed number is a
	  * prime number by dividing the candidate by all previously found primes.
	  *
	  * @param an integer containing the number to be tested.
	  * @return true if the number is a prime number; false otherwise.
	  */
	
	private static boolean isPrime(int candidate) {
		//Defaults as true because assuming the given number is prime. 
		boolean notDivisible = true;
		
		//Will keep track of where in the array the position is. 
		int pos = 0;
		
		//While the number at the position in the primes array is not greater
		//than the sqrt of the candidate, the number has still be determined
		//indivisible, and the position is not greater than the length of the 
		//array, this loop will continue. 
		while(primes[pos] <= Math.sqrt(candidate) && notDivisible && pos < primes.length) {
			//The candidate can be divided by one of the primes
			if (candidate % primes[pos] == 0) {
				notDivisible = false;
			}
			
			//The position is increased and the loop continues. 
			else {
				pos++;
			}
		}
		
		return notDivisible;
	}
}