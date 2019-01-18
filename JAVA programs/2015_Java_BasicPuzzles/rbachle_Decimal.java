// Program converts Octal numbers to decimals

import java.util.Scanner;

class rbachle_Decimal

{

    public static void main(String args[])

    {
        int oct;
	Scanner sc = new Scanner ( System.in );
	System.out.print ("Enter up to an 8-digit octal number and I'll convert it: ");
	oct = sc.nextInt(); 

while (oct >= 10000000 || oct <= 0)
{
        System.out.println ("Invalid, try again:");
        oct = sc.nextInt();
}

System.out.printf("Your octal number %d is %d in decimal.\n", oct, convert(oct));

}

    

public static int convert ( int oct )
{
int number=oct;
   int remain=0;
   int count=0;
   int decimal=0;
   while(number>0)
    {
       remain=number%10;
       decimal=(int)(decimal+remain*Math.pow(8,count));
       count++;
      number=number/10;
    }
return decimal;
}
}

