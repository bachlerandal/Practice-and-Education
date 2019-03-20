
##############################################################################################################################################################################################

use Modern::Perl;
use Mail::Sendmail;

my $var1;
my $var2;
my $var3;
my $var4;
my $var5;
my $var6;
my $var7;
my $var8;
my $var9;
my $var10;
my $var11;
my $var12;
my $var13;
my $var14;



my $mailTo = shift;

if(!defined $mailTo){
print "\n\nNo email entered on the command line. Exiting...\n\n";
exit;
}

my $mailFrom = 'rbachle@unomaha.edu';

my $subjectLine = "Weekend Box Office Report";

my $pageToGrab = "http://boxofficemojo.com/weekend/chart/";

my $command = "/usr/bin/lynx -dump -width=300 $pageToGrab";

# my $message = "<pre>Data Scraped from $pageToGrab\n\nData for the weekend of February 22-24, 2019\n
#                    </pre>";

my $allData = `$command`;

my $regex = '(\d+)\s+(\d+|N)\s+(\[\d+\])(\w.*)\s+(\[\d+\])(\w.*?)\s+(\$.*?)\s+(\D\d.*?|\D)\s+(\d+.*?)\s+(\D\d.*?|\D)\s+(\$\d.*?)\s+(\$\d.*?)\s+(\$\d.*?|\D)\s+(\d+)';


my @emailMessage;

my $Debuts;
my @DebutArray;
#my $smallestDebut;
my $biggestGain;


##############################################################################################################################################################################################

my $preMessage =  sprintf "Data Scraped from $pageToGrab \nData for the week of February 22-24, 2019\n\n%-4s %-4s %-65s %-25s %-25s", '#', '#', 'Movie Title', 'Weekend', "Cume\n\n";
push @emailMessage, $preMessage;

my $movieInfoLine;
while( $allData =~ /$regex/g){

    if($14 == 1){
        $Debuts = sprintf "%s %s", $4, "( $1 )";
        push @DebutArray, $Debuts;
    }

    if($1 == 42 ){
        $movieInfoLine = sprintf "%-4s %-4s %-67s %-25s %-25s", $1, $2, $4, $7, $12;
    }else
    { $movieInfoLine = sprintf "%-4s %-4s %-65s %-25s %-25s", $1, $2, $4, $7, $12;
    }
    # my $movieInfoLine = sprintf "%-3s %-4s %-60s %-20s %-20s", $1, $2, $4, $7, $12;
    push @emailMessage, $movieInfoLine;

##############################################################################################################################################################################################

    #Testing garbage when I was trying to format the email in a different way

    #  push @emailMessage, "\n";
    # push @emailMessage,$1;
    #	push @emailMessage,$2; 
    #   	push @emailMessage,$4;
    #  if(length($7) < 8){
    #      push @emailMessage, $7, "\t";
    #  }else{
    #       push @emailMessage, $7;
    #  }
    #     push @emailMessage, $12;	

##############################################################################################################################################################################################
}


my $longString = join "\n", @emailMessage;
my $beginning = "<pre>";
my $end = "</pre>";
$longString = $longString . "\n\n" . "Biggest Debut: " .  $DebutArray[0] . "\n" . "Weakest Debut: " . pop @DebutArray;
#print "$longString\n\n";
#print "Biggest Debut: ";
#print $DebutArray[0];
#print "\nWeakest Debut: ";
#print pop @DebutArray;

my $biggestLoss;
my $biggestGainValue = 0;
my $biggestLossValue = 0;
#my @biggestGainArray;

##############################################################################################################################################################################################
while( $allData =~ /$regex/g){
    $var1 = $1;
    $var2 = $2;
    $var4 = $4;
    $var8 = $8;
    $var14 = $14;
    if($var14 != 1){
    if($var8 =~ /\+/ ){
        $var8 =~ s/\D//g;
        if($var8 > $biggestGainValue){
            $biggestGainValue = $var8;
        $biggestGain = sprintf "%s %s %s %s", $var4,"(",($var2 - $var1)," places )";
        }
    }
    if($var8 =~ /\-/ ){
        $var8 =~ s/\D//g;
            if($var8 > $biggestLossValue){
                $biggestLossValue = $var8;
             $biggestLoss = sprintf "%s %s %s %s", $var4,"(",($var1-$var2)," places )";
             }
    
    }
}

}


##############################################################################################################################################################################################
$longString = $longString . "\nBiggest Gain: " . $biggestGain;
$longString = $longString . "\nBiggest Loss: " . $biggestLoss;
print $longString;
$longString = $beginning . $longString .  $end;
#print @biggestGainArray;
#print $longString;


##############################################################################################################################################################################################

my %mail = ( 	To   	    	=>	$mailTo,
    From 	    	=>	$mailFrom,
    Subject	    	=>	$subjectLine,
    Message	    	=>	$longString,
    'Content-Type'	=>	'text/html; charset="utf-8"'
);

if(sendmail %mail){
    print "\n\nSuccessfully sent mail to $mailTo. Check your inbox!\n";

}else{
    print "\n\nError sending mail: $Mail::Sendmail::error \n";

}


