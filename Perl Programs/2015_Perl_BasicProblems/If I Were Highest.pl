#!/usr/bin/perl
use Modern::Perl;


#DESC: If I were the highest.....now with arrays!


my (@numbers, $entry, $howmany, $total, @numbersasc, @numbersdsc, $largest, $smallest, $last_entry);

$howmany = 0;





print "\nPlease enter a number or -1 to end:\n";
chomp ($entry = <> );
push (@numbers, $entry);
$smallest = $entry;
$largest = $entry;




while ( $entry != -1 ) 
	{
    		$total += $entry;

    		$howmany ++;

    		print "\nPlease enter a number or -1 to end:\n";

    		chomp ($entry = <> );

    		push (@numbers, $entry) if $entry >= 0;

    		$smallest = $entry if $entry < $smallest && $entry >= 0;

    		$largest = $entry if $entry > $largest;
	}




(@numbersasc = sort {$a <=> $b} @numbers);


(@numbersdsc = sort {$b <=> $a} @numbers);




if ( $howmany == 0)
	{
    		print "\nNo numbers to process\n\n";
	}




else
	{
		$" = ", ";

		print "\n\n\nHere are the numbers you entered:\n";

		print "@numbers\n";

		print "\nHere are the numbers you entered in ascending order:\n@numbersasc \n";

		print "\nHere are the numbers you entered in descending order:\n@numbersdsc \n";

		print "\nYour largest and smallest values are displayed below as 'Largest : Smallest' :\n$largest : $smallest \n\n ";
	}
