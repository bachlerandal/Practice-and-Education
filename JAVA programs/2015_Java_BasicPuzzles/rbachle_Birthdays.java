// Program generates a random Julian Calender birthday 18975 times.  It then prints out the frequency of each date
// and determines the most popular birthday and the least popular birthday date

import java.util.Random;

class rbachle_Birthdays

{



    /**
     *@param ROLLS			The amount of total times the program will randomly generate a value within the 1-365 range
     *@param OPTIONS			The designated range that ROLLS values may fall under. 1-365
     *@param birthdays[]		The array that all randomly generated birthdays from ROLLS within the range OPTIONS will be stored
     */



    public static void main(String args[])
    {

        Random randomNumbers = new Random();
        final int ROLLS = 18975;
        final int OPTIONS = 365;
        int birthdays[] = new int [ OPTIONS + 1];



        /**
         *For loop executes the generation of random numbers 18975 (ROLLS) times within the range of 1-365 (OPTIONS)
         */ 



        for (int roll = 1; roll <= ROLLS; roll ++)
        {
            int date = 1 + randomNumbers.nextInt ( OPTIONS );
            birthdays[ date ] ++;
        }



        /**
         *For loop prints out all of the days of the Julian Calender (1-365) in a columnar fashion and lists how many birthdays (generated from the first loops random numbers)
         *fall on each date
         */



        for (int x = 1; x < birthdays.length; x ++)
        {
            System.out.printf("Day %4d : %2d people\n", x, birthdays[x]);
        }




        /**
         *@param max	the highest value recorded regarding how many birthdays have fallen on any particluar Julian date.  i.e Date with most birthdays
         *@param min	the lowest value recorded regarding how many birthdays have fallen on any particula Julian date. i.e Date with least birthdays
         *For loop determines the value for int max after comparing it to all values within the birthdays[] array
         */



        int max = birthdays[1];
        int min = birthdays[1];

        for (int counter = 1; counter < birthdays.length; counter ++)
        {
            if (birthdays[counter] > max)
            {
                max = birthdays[counter];
            }
        }
        System.out.printf("The following days have %d people:\n", max);




        /**
         *For loop identifies and then prints all Julian dates that have the int max value of birthdays
         */


        for (int i = 1; i < birthdays.length; i++)
        {
            if (birthdays[i] == max)
            {
                System.out.printf(" %d ", i);
            } 
        }



        /**
         *For loop determines the value for int min after comparing it to all values within the birthdays[] array
         */

        for (int counter2 = 1; counter2 < birthdays.length; counter2 ++)
        {
            if (birthdays[counter2] < min)
            {
                min = birthdays[counter2];
            }
        }
        System.out.printf("\nThe following days have %d people;\n", min);



        /**
         *For loop identifies and then prints all Julian dates that have the int min value of birthdays
         */

        for (int j = 1; j < birthdays.length; j++)
        {
            if (birthdays[j] == min)
            {
                System.out.printf(" %d ", j);
            }
        }
        System.out.println("\n");





    }
}
