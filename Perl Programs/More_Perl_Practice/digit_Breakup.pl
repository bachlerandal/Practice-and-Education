#!/usr/bin/env perl

# Digit Breakup Program. Takes input from user (int between 10000 and 99999 only) and seperates
# the digits by three spaces when printing the number back out to the screen.

##############################################################################################################

use Modern::Perl;

#Asks user for five digit number
print "Enter a five-digit number:";

#Takes users entered number and assigns it to variable numberInput
chomp(my $numberInput = <>);

#prints out the user's value normally
print "\n\n";
print $numberInput;

###############################################################################################################

#Checks to ensure the entered value is within the acceptable number range
if($numberInput <= 10000)
{
    print "\n\n";
    print 'ERROR: Your number must be in the range 10000 and 99999.';
    print "\n\n";
}
elsif($numberInput>=99999)
{
    print "\n\n";
    print 'ERROR: Your number must be in the range 10000 and 99999.';
    print "\n\n";
}


###############################################################################################################

#If the number is within the acceptable range, prints out each digit of the number with 3 spaces between them
else
{
    #formatting space
    print "\n\n";
    #ten-thousandths place
    print int($numberInput/10000);
    print "   ";
    #thousandths place
    print int($numberInput/1000)%10;
    print "   ";
    #hundredths place
    print int($numberInput/100)%10;
    print "   ";
    #tenths place
    print int($numberInput/10)%10;
    print "   ";
    #under tens place
    print int($numberInput%10);
    print "\n\n";
}
