#!/usr/bin/env perl


#Oscar Nomination Ballot. Asks the user to enter their votes for varying Oscar awards. The program then...
#...shows the user their final ballot after they have entered all of their votes.


use Modern::Perl;

##################################################################################################


#Best Picture Section
say "\n\n Welcome to the 91st Academy Awards!\n";
say "\n==============================================================================\n";
say" The nominees for the Best Picture are: \n ";



#Creates array that holds all valid bestPicture choices
my @bestPicture = ('Black Panther', 'BlacKkKlansman', 'Bohemian Rhapsody', 'The Favorite',
			'Green Book', 'Roma', 'A Star Is Born', 'Vice', 'Write In');



#Prints out every valid bestPicture choice
foreach my $i (0..$#bestPicture){
	print "     ","[",$i + 1,"] ", "$bestPicture[$i] \n"; 
}



#Creates variable (outside of acceptable bounds) that is used for users choice of bestPicture
my $bestPicChoice = 0;


#Asks the user to enter their choice for bestPicture. Will only accept choices within the presented range
do{
print "\n Please enter your choice for Best Picture now: \n";
chomp ($bestPicChoice = <>);
if( $bestPicChoice <= 0 || $bestPicChoice > 9){
print "\n I'm sorry, but $bestPicChoice is not a valid option.\n"
}
}while($bestPicChoice <= 0 || $bestPicChoice > 9);



#If the user chooses WriteIn as their choice, asks for the user to enter their WriteIn choice
if($bestPicChoice == 9){
print "\n Please enter your write-in candidate: \n";
chomp(my $writeIn = <>);
$bestPicture[$bestPicChoice - 1] = $writeIn;
}


#Prints out the users selection for bestPicture
print "\n Thank you for selecting ", $bestPicture[$bestPicChoice - 1]," as Best Picture\n";



##################################################################################################


#Lead Actress Section
say "\n==============================================================================\n";
say" The nominees for Lead Actress are: \n ";



#Creates array that holds all valid leadActress choices
my @leadActress = ('Yalitza Aparicio, "Roma"', 'Glenn Close, "The Wife"', 
			'Olivia Colman, "The Favourite"', 'Lady Gaga, "A Star Is Born"',
			'Melissa McCarthy, "Can You Ever Forgive Me?"', 'Write In');



#Prints out every valid leadActress choice
foreach my $i (0..$#leadActress){
	print "     ","[",$i + 1,"] ", "$leadActress[$i] \n"; 
}



#Creates variable (outside of acceptable bounds) that is used for users choice of leadActress
my $leadActressChoice = 0;



#Asks the user to enter their choice for leadActress. Will only accept choices within the presented range
do{
print "\n Please enter your choice for Lead Actress now: \n";
chomp ($leadActressChoice = <>);
if($leadActressChoice <= 0 || $leadActressChoice > 6){
print"\n I'm sorry, but $leadActressChoice is not a valid option.\n"
}
}while($leadActressChoice <= 0 || $leadActressChoice > 6);




#If the user chooses WriteIn as their choice, asks for the user to enter their WriteIn choice
if($leadActressChoice == 6){
print "\n Please enter your write-in candidate: \n";
chomp(my $writeIn = <>);
$leadActress[$leadActressChoice - 1] = $writeIn;
}



#Prints out the users selection for leadActress
print "\n Thank you for selecting ", $leadActress[$leadActressChoice - 1]," as Lead Actress\n";


##################################################################################################

#Animated Feature Section
say "\n==============================================================================\n";
say" The nominees for Animated Feature are: \n ";



#Creates array that holds all valid Animated Feature choices
my @animFeature = ('"Incredibles 2", Brad Bird', '"Isle of Dogs", Wes Anderson', 
			'"Mirai", Mamoru Hosoda', '"Ralph Breaks the Internet", Rich Moore, Phil Johnston',
			'Spider-Man: Into the Spider-Verse", Bob Persichetti, Peter Ramsey, Rodney Rothman', 'Write In');



#Prints out every valid choice
foreach my $i (0..$#animFeature){
	print "     ","[",$i + 1,"] ", "$animFeature[$i] \n"; 
}



#Creates variable (outside of acceptable bounds) that is used for users choice
my $animFeatureChoice = 0;



#Asks the user to enter their choice. Will only accept choices within the presented range
do{
print "\n Please enter your choice for Animated Feature now: \n";
chomp ($animFeatureChoice = <>);
if($animFeatureChoice <= 0 || $animFeatureChoice > 6){
print"\n I'm sorry, but $animFeatureChoice is not a valid option.\n"
}
}while($animFeatureChoice <= 0 || $animFeatureChoice > 6);




#If the user chooses WriteIn as their choice, asks for the user to enter their WriteIn choice
if($animFeatureChoice == 6){
print "\n Please enter your write-in candidate: \n";
chomp(my $writeIn = <>);
$animFeature[$animFeatureChoice - 1] = $writeIn;
}



#Prints out the users selection
print "\n Thank you for selecting ", $animFeature[$animFeatureChoice - 1]," as Animated Feature\n";



##################################################################################################



#Best Original Score Section
say "\n==============================================================================\n";
say" The nominees for Original Score are: \n ";



#Creates array that holds all valid choices
my @originalScore = ('"BlacKkKlansman", Terence Blanchard', '"Black Panther", Ludwig Goransson', 
			'"If Beale Street Could Talk", Nicholas Britell','"Isle of Dogs", Alexandre Desplat',
			 '"Mary Poppins Returns", Marc Shaiman, Scott Wittman', ' Write In');



#Prints out every valid choice
foreach my $i (0..$#originalScore){
	print "     ","[",$i + 1,"] ", "$originalScore[$i] \n"; 
}



#Creates variable (outside of acceptable bounds) that is used for users choice
my $origScoreChoice = 0;



#Asks the user to enter their choice. Will only accept choices within the presented range
do{
print "\n Please enter your choice for Original Score now: \n";
chomp ($origScoreChoice = <>);
if($origScoreChoice <= 0 || $origScoreChoice > 6){
print"\n I'm sorry, but $origScoreChoice is not a valid option.\n"
}
}while($origScoreChoice <= 0 || $origScoreChoice > 6);




#If the user chooses WriteIn as their choice, asks for the user to enter their WriteIn choice
if($origScoreChoice == 6){
print "\n Please enter your write-in candidate: \n";
chomp(my $writeIn = <>);
$originalScore[$origScoreChoice - 1] = $writeIn;
}



#Prints out the users selection
print "\n Thank you for selecting ", $originalScore[$origScoreChoice - 1]," as Original Score\n";



##################################################################################################

#Costume Design Section
say "\n==============================================================================\n";
say" The nominees for Costume Design are: \n ";



#Creates array that holds all valid choices
my @costumeDesign = ('"The Ballad of Buster Scruggs", Mary Zophres', '"Black Panther", Ruth E. Carter', 
			'"The Favourite", Sandy Powell','"Mary Poppins Returns", Sandy Powell',
			 '"Mary Queen of Scots", Alexandra Byrne', ' Write In');



#Prints out every valid choice
foreach my $i (0..$#costumeDesign){
	print "     ","[",$i + 1,"] ", "$costumeDesign[$i] \n"; 
}



#Creates variable (outside of acceptable bounds) that is used for users choice
my $costumeDesignChoice = 0;



#Asks the user to enter their choice. Will only accept choices within the presented range
do{
print "\n Please enter your choice for Costume Design now: \n";
chomp ($costumeDesignChoice = <>);
if($costumeDesignChoice <= 0 || $costumeDesignChoice > 6){
print"\n I'm sorry, but $costumeDesignChoice is not a valid option.\n"
}
}while($costumeDesignChoice <= 0 || $costumeDesignChoice > 6);



#If the user chooses WriteIn as their choice, asks for the user to enter their WriteIn choice
if($costumeDesignChoice == 6){
print "\n Please enter your write-in candidate: \n";
chomp(my $writeIn = <>);
$costumeDesign[$costumeDesignChoice - 1] = $writeIn;
}



#Prints out the users selection
print "\n Thank you for selecting ", $costumeDesign[$costumeDesignChoice - 1]," as Costume Design\n";



##################################################################################################

#Visual Effects Section
say "\n==============================================================================\n";
say " The nominees for Visual Effects are: \n ";



#Creates array that holds all valid choices
my @visualEffects = ('"Avengers: Infinity War"', '"Christopher Robin"', 
			'"First Man"','"Ready Player One"', '"Solo: A Star Wars Story"', ' Write In');



#Prints out every valid choice
foreach my $i (0..$#visualEffects){
	print "     ","[",$i + 1,"] ", "$visualEffects[$i] \n"; 
}



#Creates variable (outside of acceptable bounds) that is used for users choice
my $visualEffectsChoice = 0;



#Asks the user to enter their choice. Will only accept choices within the presented range
do{
print "\n Please enter your choice for Visual Effects now: \n";
chomp ($visualEffectsChoice = <>);
if($visualEffectsChoice <= 0 || $visualEffectsChoice > 6){
print"\n I'm sorry, but $visualEffectsChoice is not a valid option.\n"
}
}while($visualEffectsChoice <= 0 || $visualEffectsChoice > 6);



#If the user chooses WriteIn as their choice, asks for the user to enter their WriteIn choice
if($visualEffectsChoice == 6){
print "\n Please enter your write-in candidate: \n";
chomp(my $writeIn = <>);
$visualEffects[$visualEffectsChoice - 1] = $writeIn;
}


#Prints out the users selection
print "\n Thank you for selecting ", $visualEffects[$visualEffectsChoice - 1]," as Visual Effects\n";


##################################################################################################

#MakeUp and Hair Section
say "\n==============================================================================\n";
say" The nominees for MakeUp and Hair are: \n ";



#Creates array that holds all valid choices
my @makeUp = ('"Border"', '"Mary Queen of Scots"','"Vice"', ' Write In');



#Prints out every valid choice
foreach my $i (0..$#makeUp){
	print "     ","[",$i + 1,"] ", "$makeUp[$i] \n"; 
}



#Creates variable (outside of acceptable bounds) that is used for users choice
my $makeUpChoice = 0;




#Asks the user to enter their choice. Will only accept choices within the presented range
do{
print "\n Please enter your choice for MakeUp and Hair now: \n";
chomp ($makeUpChoice = <>);
if($makeUpChoice <= 0 || $makeUpChoice > 4){
print"\n I'm sorry, but $makeUpChoice is not a valid option.\n"
}
}while($makeUpChoice <= 0 || $makeUpChoice > 4);




#If the user chooses WriteIn as their choice, asks for the user to enter their WriteIn choice
if($makeUpChoice == 4){
print "\n Please enter your write-in candidate: \n";
chomp(my $writeIn = <>);
$makeUp[$makeUpChoice - 1] = $writeIn;
}



#Prints out the users selection
print "\n Thank you for selecting ", $makeUp[$makeUpChoice - 1]," as MakeUp and Hair\n";

##################################################################################################

#Ballot Finalization Section
say "\n==============================================================================\n";
say "\n Thank you for voting. Here is a summary of your votes:\n";




#The following statements print out the user's previous choices, in order to complete their ballot
print "\n Best Picture: \n";
print "      ", $bestPicture[$bestPicChoice - 1];

print "\n Lead Actress: \n";
print "      ", $leadActress[$leadActressChoice - 1];

print "\n Animated Feature: \n";
print "      ", $animFeature[$animFeatureChoice - 1];

print "\n Original Score: \n";
print "      ", $originalScore[$origScoreChoice - 1];

print "\n Costume Design: \n";
print "      ", $costumeDesign[$costumeDesignChoice - 1];

print "\n Visual Effects: \n";
print "      ", $visualEffects[$visualEffectsChoice - 1];

print "\n Makeup and Hair: \n";
print "      ", $makeUp[$makeUpChoice - 1], "\n\n";











