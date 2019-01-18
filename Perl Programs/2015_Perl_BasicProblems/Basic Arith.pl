#!/usr/bin/perl

use Modern::Perl;


print "Enter three numbers and see how they do MATHZZZZ!  Enter the first number now!: ";

chomp (my $number1 = <>);


print "Enter your second number now: ";

chomp (my $number2 = <>);


print "Enter your third number now: ";

chomp (my $number3 = <>);

my $answer1 = $number1 + $number2 + $number3;
my $answer2 = $number1 * $number2 * $number3;
my $answer3 = $number1 / $number3;
my $answer4 = $number3 % $number2;
my $answer5 = $number2 - $number3;
my $answer6 = ($number1 * $number2) / ($number3 + $number1);

print "\n\nADD:$answer1 \n\n";
print "MUL:$answer2 \n\n";
print "DIV:$answer3 \n\n";
print "MOD:$answer4 \n\n";
print "SUB:$answer5 \n\n";
print "EQT:$answer6 \n\n\n";


