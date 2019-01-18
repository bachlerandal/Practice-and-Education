#!/usr/bin/perl
use Modern::Perl;


#DESC: Number Guessing Game



my ($guess, $answer, $counter);
$counter = 1;
$answer = (int rand 100) + 1;
$guess = 0;



print "\n\nPlease guess the number (between 1 and 100) I am thinking of.\nYou will have 8 tries.\nAfter every attempt, I will tell you if you are too high, too low, or correct."; 



while ($counter <= 8 && $guess != $answer)
{
print "\n\nYour guess #$counter: ";
chomp ( $guess = <> );



if ( $guess < 1 || $guess > 100 )
{
print "\n$guess is not between 1 and 100. LTP NOOB!";
}

elsif ( $guess < $answer )
{
print "\n$guess is too low.";
$counter++;
}


elsif ( $guess > $answer )
{
print "\n$guess is too high.";
$counter++;
}

}



if ($guess == $answer )
{
print "\nYou got it right!\n";
print "\nIt only took you $counter tries!\n\n";
}



else
{
print "\n\nYou lose! You were only allotted 8 guesses.  Sorry!\n";
print "\nThe Answer was : $answer\n\n";
}
