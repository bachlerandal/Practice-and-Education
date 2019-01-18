import java.util.LinkedList;
import java.util.ListIterator;

/**
  * A class that implements the PuzzleSolution interface and finds the sum
  * of all primes less than two million. 
  */

public class Problem9 implements PuzzleSolution {
	
	/**
	  * A static integer field with 
	  * the maximum value of the primes used in the program. 
	  */
	
	private static final int MAX = 2000000;
	
	/**
	  * A static LinkedList that will save all found primes less than the MAX.
	  */
	
	//The values of primes themselves won't go above two million, therefore notDivisible
	//requiring the use of longs.
	private static LinkedList<Integer> primes = new LinkedList<Integer>();
	
	/**
	  *	Main method that creates a new PuzzleSolution reference to
	  * a Problem9 object and prints the numerical solution for 
	  * problem 9. 
	  *
	  *	@param an unused String array of arguments
	  */
	
	public static void main(String[] args) {
		PuzzleSolution solution = new Problem9();
		System.out.printf("%s", solution.run());
	}
	
	/**
	  * A non-static member method that runs the code to find the
	  * solution for problem 9 and returns it to the calling method
	  * as a String.
	  *
	  * @return	a String representation of the numerical solution for
	  *			this problem. 
	  */
	
	public String run() {
		return Long.toString(calcSum());
	}
	
	/**
	  * A static method that calculates the sum of all primes
	  * less than two million. 
	  *
	  * @return a long integer that is the sum of all primes < 2 mil
	  */
	
	private static long calcSum() {
		//The sum exceeds the limits of the integer type. 
		long sum = 0;
		
		//Two is the first positive prime number, so x starts at 2.
		for(int x = 2; x < MAX; x++) {
			//The number is added to the sum only if it is prime.
			if(isPrime(x)) {
				sum += x;
			}
		}
		
		return sum;
	}
	
	/**
	  * A static method that determines if the passed number is a prime number
	  * by dividing the candidate by all previously found primes. 
	  *
	  * @param a long integer that contains the number to be tested for divisibility
	  * @return a boolean containing true if the candidate is prime and false 
	  *			otherwise
	  */
	
	private static boolean isPrime(int candidate) {
		//Starts as true so that it is only changed once during processing if
		//the number turns out to be composite
		boolean notDivisible = true;
		
		//Used to avoid O(N^2) time in element access of LinkedLists
		ListIterator<Integer> itr = primes.listIterator();

		/*The loop will continue while it meets the following conditions for the
		  following reasons:
		  1) There IS a next element. Otherwise, an exception will be thrown.
		  2) An element has not yet been determined divisible, which would
		     disqualify it from candidacy since we are only dividing currentMultiple
		  	 by prime numbers.
		  3) The element at the next position isn't greater than the square root of
		     the candidate, at which point the loop repeats backwards.
		*/
		
		while(itr.hasNext() && notDivisible && primes.get(itr.nextIndex()) <= Math.sqrt(candidate)) {
			if(candidate % itr.next() == 0) {
				notDivisible = false;
			}
		}
		
		//If the candidate is 2, the list is empty because 2 is the smallest prime
		//and it needs to be saved. 
		if (candidate == 2) {
			primes.add(candidate);
		}
		
		//A check for an empty list isn't needed here -- the list
		//must've been filled at this point. To be added to the list, 
		//though, it must be indivisible by any of the saved primes. This
		//also checks to ensure that duplicate primes are not saved to the list.
		else if (notDivisible && primes.peekLast() != candidate) {
			primes.add(candidate);
		}

		return notDivisible;
	}
}