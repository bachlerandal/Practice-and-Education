#!/usr/bin/env perl

# Palindrom program: Takes user 7-character input and prints out if the input is a palindrome or not

use Modern::Perl;

#######################################################################################################################################

#Asks user to enter 7 character phrase and prints out what was entered
print "Enter in a 7 character phrase: "; 
chomp(my $enteredString=<>);
say length $enteredString;


#Splits the entered String into an array of characters
my @stringToArray = split('', $enteredString);


#######################################################################################################################################


#Checks that the entered string is 7 characters in length
if(length $enteredString == 7)
{
    #checks that the first and last, 2nd and 6th, and 3rd and 5th characters of the array are the same. If so, prints "PALINDROME!" 
    if($stringToArray[0] eq $stringToArray[6] and $stringToArray[1] eq $stringToArray[5] and $stringToArray[2] eq $stringToArray[4]){
        print "PALINDROME!\n\n";
    }
    #If the values in the array are not equal in such a way to be a Palindrome, prints "NOT"
    else{
        print "NOT\n\n";
    }
}
#If the length of the entered String is not 7 characters, prints an error message
else{
    print "ERROR: That is not a 7-character input. \n\n";
}
