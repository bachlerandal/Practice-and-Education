// Program uses methods to compute basic mathmatical operations and returns them to the user after completion


import java.util.Scanner;

class rbachle_Mathstuff

{

    public static void main(String args[])

    {
        Scanner in = new Scanner ( System.in );
        System.out.println("Please enter the length of a side of your square: ");
        double a = in.nextDouble();
        System.out.printf("\nArea of your square is: %.3f\n", square(a) );
   
        System.out.println("Please enter the length of a side of your cube: ");
        double b = in.nextDouble();
        System.out.printf("\nVolume of your cube is: %.3f\n", cube(b) );
   
        System.out.println("Please enter the radius of your circle: ");
        double c = in.nextDouble();
        System.out.printf("\nArea of your circle is: %.3f\n", circle(c) );   
   
        System.out.println("Please enter the length of a side of your cube: ");
        double d = in.nextDouble();
        System.out.printf("\nSurface area of your cube is: %.3f\n", surface(d) );   
   
        System.out.println("Please enter two numbers seperated by spaces: ");
        double e = in.nextDouble();
        double f = in.nextDouble();
        double g = large ( e , f );
        System.out.printf("\nLarger of the first two numbers is: %.3f\n", g );

        System.out.println("Please enter two numbers seperated by spaces again: ");
        double h = in.nextDouble();
        double i = in.nextDouble();
        double j = small ( h , i );
        System.out.printf("\nSmaller of the second two numbers is: %.3f\n", j );
    }




    public static double square ( double a ) {
        double result = (double) ( Math.pow ( a , 2 ) );
        return result;
    }

   public static double cube ( double b ) {
       double result = (double) ( Math.pow ( b , 3 ) );
       return result;
   } 

   public static double circle ( double c ) {
       double result = (double) (Math.PI * Math.pow( c , 2 ) );
       return result;
   }

   public static double surface ( double d ) {
       double result = (double) (6 * Math.pow( d , 2 ) );
       return result;
   } 

   public static double large (double e , double f ) {
       double result;
       if ( e > f )
       {
           result = e;
       }
       else
       {
           result = f;
       }
       return result;
   }

   public static double small (double h , double i ) {
       double result;
       if ( h < i )
       {
           result = h;
       }
       else
       {
           result = i;
       }
       return result;
   }





}
