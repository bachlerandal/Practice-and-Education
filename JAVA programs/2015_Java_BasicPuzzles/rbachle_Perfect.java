// Program prompts the user to enter how many values they would like to have evaluated, then returns
// if each value is a Perfect number. If a value is perfect, the program will then list all of its factors.

import java.util.Scanner;

class rbachle_Perfect

{
    public static void main(String args[])
    {
        Scanner in = new Scanner (System.in);
        int userValue;
        boolean isItPerfect;
        int howMany;

        System.out.print("\nHow many numbers would you like to test?: ");
        howMany = in.nextInt();
        while ( howMany <= 0 )
        {
            System.out.print("\nInvalid value input - Enter a positive value: ");
            howMany = in.nextInt();
        }
        for(int i = 1; i <= howMany; i++)
        { 

            System.out.print("\nPlease enter a possible perfect number: ");
            userValue = in.nextInt();

            if( testPerfect (userValue))
            {
                isItPerfect = true;
            }
            else
            {
                isItPerfect = false;
            }

            printFactors(isItPerfect, userValue);
        }
    }


    /**
     *printFactors: Takes the true or false boolean value recieved from method testPerfect  and prints result. If true,
     *the method will print the original userValue and then list all of its factors.  If false, the method will print Not Perfect
     *
     * @param userValue		the original value entered by the user
     */

    public static void printFactors(boolean isItPerfect, int userValue)
    {    
        if (testPerfect(userValue))
        {
            System.out.printf("\n%d : ", userValue);

            for(int i=1 ; i <= userValue; i++)
            {
                if(userValue%i == 0) 
                {
                    System.out.printf(" %d ", i);
                }
            }


        }
        else
        {
            System.out.printf("\n%d : Not Perfect\n", userValue);

        }
    }


    /**
     *testPerfect: Evaluates the userValue entered by the user and determines if it is a Perfect number
     * @param temporary		value that continues to build up with the additions of the count value i when the userValue is divisible by i.
     *				Once the count value of i has reached its ceiling, if temporary = userValue, then userValue is a Perfect Number
     */

    public static boolean testPerfect(int userValue)
    { 

        int temporary = 0;

        for(int i = 1 ; i <= userValue/2 ;i++)
        {
            if(userValue%i == 0)
            {
                temporary += i;
            }
        }
        if(userValue == 0)
        {
            return false;
        }

        else if(temporary == userValue)
        {
            return true;
        } 

        else 
        {
            return false;
        }
    }

}
