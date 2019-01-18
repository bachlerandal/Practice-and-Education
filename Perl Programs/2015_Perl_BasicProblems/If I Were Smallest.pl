#!/usr/bin/perl

use Modern::Perl;

#DESC: If I was smallest would you be largest?


my ($userinput1, $userinput2, $userinput3, $userinput4, $userinput5, $userinput6, $largest, $smallest);

print("\nThis program takes six integers from the user, and \ndetermines which numbers 
are the largest and smallest, \nthen outputs the results to the screen as 
Largest:Smallest.\n"); 




print "Please enter the first number: ";

    chomp ($userinput1 = <>);

        $largest = $userinput1;

        $smallest = $userinput1; 



print "\nPlease enter the second number:\n ";

    chomp ($userinput2 = <>);

        if ($userinput2 > $largest)
            {
                $largest = $userinput2;
            }

        if ($userinput2 < $smallest)
            {
                $smallest = $userinput2
            }



print "\nPlease enter the third number:\n ";

    chomp ($userinput3 = <>);

        if ($userinput3 > $largest)
            {
                $largest = $userinput3;
            }

        if ($userinput3 < $smallest)
            {
                $smallest = $userinput3;
            }



print "\nPlease enter the fourth number:\n ";

    chomp ($userinput4 = <>);

        if ($userinput4 > $largest)
            {
                $largest = $userinput4;
            }

        if ($userinput4 < $smallest)
            {
                $smallest = $userinput4;
            }



print "\nPlease enter the fifth number:\n ";

    chomp ($userinput5 = <>);

        if ($userinput5 > $largest)
            {
                $largest = $userinput5;
            }

        if ($userinput5 < $smallest)
            {
                $smallest = $userinput5;
            }



print "\nPlease enter the sixth number:\n ";

    chomp ($userinput6 = <>);

        if ($userinput6 > $largest)
            {
                $largest = $userinput6;
            }

        if ($userinput6 < $smallest)
            {
                $smallest = $userinput6;
            }


print "\n\nThe Results are listed below as Largest:Smallest :\n\n$largest:$smallest
       \n\nThanks for Playing!\n\n";
