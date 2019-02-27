#!/usr/bin/env perl

#User Unix stats.  This program prints the user (username entered from command line) log in stats from Unix
# and computes the total time logged in via the "last" command.

##### Note ######
#Entries for the user when logged in via Mosh shells appear to produce more than one entry through the "last" command
#Entries from log ins via Putty/WinScp/etc only produce one entry

##########################################################################################################################
use Modern::Perl;

my $name1 = $ARGV[0];
if(!defined $name1){
print "\n\nNo username entered on the command line. Exiting...\n\n";
exit;
}

#print"\n $name\n";
my $name = substr($name1, 0, 7);
#print"\n $name\n";
#exit;

my@capture=`last`;

# BACKTICKS!  NOT SINGLE QUOTES!
# You would want to use something similar in your program
# process every line of output and print it out


#Still need to have the entered user via command line

#Prints our entry header for username entered on command line
print "\nHere is a listings of the log ins for $name1:\n\n";


#i is the variable to delineate the 1.) , 2.) , 3.) etc for each new line printed
my $i = 1;


#my %times;

#array to hold entries of matching strings from the time online (far right) column of 'last's summary
my @totalTime;

#array to hold entries that have the '(' and ')' and '+' trimmed from their strings
#my @totalTimeRemix;

#iterates through the captured input from the 'last' function
for my $line (@capture){
    #checks if $line has content that matches our $name
    if($line =~ /$name/){
        #following if/else statements check matches for the various forms of time online column
        if($line =~ /(\(\d\d:\d\d\))/){
        push @totalTime , $1;
        }
        elsif($line =~ /(\(\d\+\d\d:\d\d\))/ | $line =~ /(\(\d\d\+\d\d:\d\d\))/)
        {
        push @totalTime , $1;
        }
        print "$i.  $line";
        $i++;
}


}
#####################################################################################################################

#Section for handling total time online summary
print "\n\nHere is a summary of the time spent on the system for $name1:\n\n";
print "$name1\n";
$i--;
print "$i\n";

#Variables used for breaking down the user's total time online
my $hours = 0;
my $minutes = 0;
my $days = 0;

#Finds the matching portions of the @totalTime array and sums up the hours, days, min
foreach my $totalTime (@totalTime){
    if($totalTime =~ /(\()(\d\d):(\d\d)(\))/ ){
    $hours += $2;
    $minutes += $3;

}
    if($totalTime =~ /(\()(\d)\+(\d\d):(\d\d)(\))/ ){

    $days += $2;
    $hours += $3;
    $minutes += $4;
    }

    if($totalTime =~ /(\()(\d\d)\+(\d\d):(\d\d)(\))/ ){
    $days += $2;
    $hours += $3;
    $minutes += $4;
    }
}

#print "@totalTime totalTime here\n\n";
#print "\n\n @totalTimeRemix \n\n";
#print "\n\n $days";
#print "\n\n $hours";
#print "\n\n $minutes";

############################################################################################################################
#Section converting days, hours, min to a sum total of minutes
my $daysToMinutes = $days * 1440;
my $hoursToMinutes = $hours * 60;
my $sum = $daysToMinutes + $hoursToMinutes + $minutes;
#print "\n\n $sum";

#Section that formats the totality of the summed minutes into an acceptable format
$hours = int $sum / 60;
$minutes = $sum % 60;

#Ensures that both hours and minutes are displayed in HH:MM format
if($minutes < 10){
$minutes = sprintf("%02d", $minutes);
}
if($hours < 10){
$hours = sprintf("%02d", $hours);
}
print "$hours:$minutes \n\n";
