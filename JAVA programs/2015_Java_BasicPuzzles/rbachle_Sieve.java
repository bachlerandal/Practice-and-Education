// This program will calculate all Sexy Prime Pairs between 1 and 50000, then display them.  The program will then ask the user to input a lower and upper boundary.
// The program will then display all the Sexy Prime Pairs within the outlined boundary set by the user, calculate how many pairs there are, and then display the count of Sexy Prime Pairs
import java.util.Random;
import java.util.Scanner;


public class rbachle_Sieve
{
    public static void main ( String args[] )
    {
        final int HOWMANY = 50000; // The range of numbers
        boolean[] sieve = new boolean[HOWMANY+1]; // Boolean array of true/false
        int lower = 1, upper = HOWMANY; // Setting initial boundaries
        // the following method call will implement the Sieve algorithm
        processSieve( sieve );
        // the following method call will print all 1419 sexy pairs of primes
        showPrimes( sieve, lower, upper, HOWMANY );
        // the following method call gets the lower boundary for printing
        lower = getLower( HOWMANY );
        // the following method call gets the upper boundary for printing
        upper = getUpper( lower, HOWMANY );
        // the following method call prints sexy pairs in the new lower-upper range
        showPrimes( sieve, lower, upper, HOWMANY );
    }





/**
  *
  * Method processSieve will implement the Sieve of Eratosthenes algorithm on the array.
  * When the method is done, all elements in the Boolean array that are true are prime numbers
  * (i.e., the index of a true value in the array is a prime number) while all elements in the
  * array with a false value are not prime numbers.
  *
  * @param sieve[]  the boolean array to process
  * @return nothing, void
  */

    public static void processSieve(boolean[] sieve )
    {
        for(int i=0; i < sieve.length; i++)
        {
            sieve[i] = true;
        }	

        sieve[0] = false;
        sieve[1] = false;

        for (int i=2; i < sieve.length; i++)
        {
            for(int j=(i*2); j < sieve.length; j += i)
            {
                sieve[j] = false;
            }
        }

    }







/**
  *
  * Method getLower will simply ask the user to enter a number between 1 and the value of the
  * parameter that is sent in to it as an argument.
  *
  * @param HOWMANY  the largest value to allow
  * @return lower   an integer value, which is the lower boundary
  */

    public static int getLower(int HOWMANY)
    {
        Scanner in = new Scanner(System.in);
        int lower = 0;
        while(lower < 1 || lower > HOWMANY)
        {
            System.out.print("Please enter the lower boundary (between 1 and 50000): ");
            lower = in.nextInt();
        }
        return lower;

    }






/**
  *
  * Method getUpper will simply ask the user to enter a number between the first and second
  * arguments that are sent to it. The first parameter that it receives is a lower boundary
  * and the second parameter is the maximum value allowed.
  *
  * @param lower    the smallest value to allow
  * @param HOWMANY  the largest value to allow
  * @return upper   an integer value, which is the upper boundary
  */


    public static int getUpper(int lower, int HOWMANY)
    {
        Scanner input = new Scanner(System.in);
        int upper = 0;
        while(upper < lower || upper > HOWMANY)
        {
            System.out.printf("\nPlease enter the upper boundary between %d and 50000: ", lower);
            upper = input.nextInt();
        }
        return upper;
    }






/**
  *
  * Method showPrimes will display the sexy prime pairs in an array between a lower and an
  * upper boundary, provided as parameters to the method.
  *
  * @param sieve[]   the boolean array to process
  * @param lower     the bottom position of the range to display
  * @param upper     the top position of the range to display
  * @param HOWMANY   the largest value to allow when displaying ALL sexy prime pairs
  * @return none, void
  */


    public static void showPrimes(boolean[] sieve, int lower, int upper, int HOWMANY)
    {
        int pairs = 0;
        if(lower == 1 && upper == 50000)
        {
            for(int i = lower; i <=(upper-6); i++)
            {
                if(sieve[i] == true && sieve[i+6] == true)
                {
                    System.out.println( i + " and " + (i+6));
                }
            }
        }

        else 
        {
            for (int i = lower; i <= (upper-6); i++)
            {
                if(sieve[i] == true && sieve[i+6] == true)
                {
                    pairs ++;
                    System.out.println( i + " and " + (i+6));
                }
            }

            System.out.printf("\nThere were %d sexy prime pairs displayed\n\n", pairs);
        } 
    }
































    // implement method showPrimes here
    // implement method getLower here
    // implement method getUpper here
}
