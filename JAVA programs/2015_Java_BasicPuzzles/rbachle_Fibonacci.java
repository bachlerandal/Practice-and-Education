// Program converts a user enter integer into a fibonacci number

import java.util.Scanner;

class rbachle_Fibonacci

{
    public static void main(String args[])
    {
        Scanner in = new Scanner (System.in);
        int original;
        do
        {
            System.out.print("Which Fibonacci number would you like?: ");
            original = in.nextInt();
        }while( original < 0 || original > 70);

        System.out.printf("\nFibonacci #%d is %.0f\n", original, fibcalc(original));
    }




    /**
     *fibcalc: Determine the fibonacci number associated with the original input using a for loop

     * @param num       initial starting value for the fibonacci sequence
     * @param num2      second starting value for the fibonacci sequence
     * @param fibnum    the finum fibonacci value after the method sequence is completed
     */

    public static double fibcalc(int original)
    {

        double num = 0;
        double num2 = 1;
        double fibnum=0;

        for(int i=2; i <= original; i++)
        {

            fibnum = num + num2;    
            num = num2;
            num2 = fibnum;

        }
        if(original == 1)
        {
            fibnum = 1;
        }
        return fibnum;
    } // end method fibcalc



}
