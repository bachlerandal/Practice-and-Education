import java.util.LinkedList;
import java.util.ListIterator;

/**
  * A class that implements the PuzzleSolution interface and finds the
  * largest prime factor of 600851475143. 
  */

public class Problem2 implements PuzzleSolution {

	/**
	  * A static instance variable containing a long integer that represents
	  * the number whose prime factorization will be found. 
	  */
	
	private static final long PROB_NUM = 600851475143L;
	
	/**
	  * A static LinkedList containing long integers that will hold the
	  * prime numbers that have already been found.
	  */
	
	private static LinkedList<Long> primes = new LinkedList<Long>();
	
	/**
	  *	Main method that creates a new PuzzleSolution reference to
	  * a Problem2 object and prints the numerical solution for 
	  * problem 2. 
	  *
	  *	@param an unused String array of arguments
	  */
	
	public static void main(String[] args) {
		PuzzleSolution solution = new Problem2();
		System.out.printf("%s", solution.run());
	}
	
	/**
	  * A non-static member method that runs the code to find the
	  * solution for problem 2 and returns it to the calling method
	  * as a String.
	  *
	  * @return	a String representation of the numerical solution for
	  *			this problem. 
	  */
	
	public String run() {
		return Long.toString(findLargest());
	}
	
	/**
	  * A static method that finds the largest prime factor of PROB_NUM
	  * and returns it as a long integer to the calling method.
	  *
	  * @return a long integer containing the largest prime factor of
	  *			PROB_NUM
	  */
	
	private static long findLargest() {
		//This variable initially contains PROB_NUM, but will contain smaller
		//non-prime factors of PROB_NUM that need to be further factored out
		//during processing. 
		long currentMultiple = PROB_NUM;
		
		//This variable keeps track of the current candidate number for a prime
		//factor of the currentMultiple. 
		long candidate = 2;
		
		//This loop will only continue so long as the candidate number isn't 
		//greater than the square root of the currentMultiple. The loop would
		//repeat itself backwards (as in, 2 divides into 8, and, "backwards", 4
		//divides into 8)
		while(Math.sqrt(currentMultiple) >= candidate) {
			
			//In order to ensure we are finding the prime factorization, must 
			//test the number to ensure it is prime. In order to ensure it is
			//a factor, that candidate must evenly divide into the current multiple.
			if (isPrime(candidate) && currentMultiple % candidate == 0) {	
			
				//The new currentMultiple is simply what remains once the current
				//is divided by the candidate.
				currentMultiple = currentMultiple / candidate;
			}
			
			//The candidate goes up one when it doesn't meet the conditions.
			else {
				candidate++;
			}
		}
		
		//Once the while loop has finished, the remaining multiple should be the
		//the largest prime factor of PROB_NUM (no candidate would've met the 
		//conditions)
		return currentMultiple;
		
	}
	
	/**
	  * A static method that determines if the passed number is a prime number
	  * by dividing the candidate by all previously found primes. 
	  *
	  * @param a long integer that contains the number to be tested for divisibility
	  * @return a boolean containing true if the candidate is prime and false 
	  *			otherwise
	  */
	
	private static boolean isPrime(long candidate) {
		//Starts as true so that it is only changed once during processing if
		//the number turns out to be composite
		boolean notDivisible = true;
		
		//Used to avoid O(N^2) time in element access of LinkedLists
		ListIterator<Long> itr = primes.listIterator();

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