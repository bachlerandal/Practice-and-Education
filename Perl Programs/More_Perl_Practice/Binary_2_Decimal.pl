#!/usr/bin/env perl


#Binary to Decimal number converter


use Modern::Perl;

#Input an integer containing only the digits 0 and 1 (binary).
#Then print out decimal equivalent.
#DO NOT need to check the input string for validity. Assume all data is valid.
#Assume all data entered will be between 1 and 30 characters in length.

############################################################################################################

#Asks user for binary number with more than 1 and less than 30 digits. Then splits that number into an array
print "\n\nPlease enter a binary number up to 30 digits: \n\n";
chomp (my $binaryNumber = <>);

my @binaryArray = split('', $binaryNumber);

#print @binaryArray, "\n\n";


############################################################################################################

#Iterates through the positions within the newly formed array and applies the algorithm to convert binary
# to decimal form, and sums up all the values to get the true decimal form of the binary number
#Then prints the newly calculated decimal number to screen
my $decimalNumber = 0;

foreach my $i (0..$#binaryArray){

    $decimalNumber += $binaryArray[(length ($binaryNumber) -1) - $i] * (2**$i);
}

say "\n\n $binaryNumber is $decimalNumber in decimal form \n\n";

