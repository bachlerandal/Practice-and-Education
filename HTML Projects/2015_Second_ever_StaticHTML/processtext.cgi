#!/usr/bin/perl

#Name        : Randal Bachle
#Class       : CIST 1300-002
#Assign#     : Assignment 15 Project Dynamic Page
#Due         : Dec 17th, 2015

#Honor Pledge:  On my honor as a student of the University of Nebraska at Omaha, I have neither given nor recieved unauthorized help on this homework assignment.

#NAME: Randal Bachle
#EMAIL: rabchle@unomaha.edu

#Partners: http://www.w3schools.com/ and the Computer Science Learning Center
#DESC: Project Dynamic Page

 

use Modern::Perl;
use CGI qw/:standard/;
use CGI::Carp qw/fatalsToBrowser/;
use Mail::Sendmail;		# required to use the Mail::Sendmail library

print header();
print start_html(-style=>'project.css');


my $mailTo      =	 'NerdAsylum402@yahoo.com';  	
my $mailFrom    =       param('mailFrom');	
my $subjectLine =       param('subjectLine');	
my $message     =       param('message');
my $rating	=	param('rating');	

if ($mailTo && $mailFrom && $subjectLine && $message && $rating)
{
	my %mail = ( To      => $mailTo,
             From    => $mailFrom,
             Subject => $subjectLine,
             Message => $message,			# must be a string, not an array
    	     Rating  => $rating,
             'Content-Type' => 'text/plain'		
            );

	if ( sendmail %mail )
	{
		print p("Successfully sent mail to $mailTo.  Thanks for hitting us up!");
	}

	else
	{
		print p("Error sending mail: $Mail::Sendmail::error");
	}

	print a({-href=>"javascript:history.back();"}, "Back to Talk To Us page");
}

else
{
	if (!$mailTo)
	{
		print p({-style=>"color: red;"}, "Please enter a destination email!");
	}

	if (!$mailFrom)
	{
		print p({-style=>"color: red;"}, "Please enter your email!");
	}
	
	if (!$subjectLine)
	{
		print p({-style=>"color: red;"}, "Please enter a subject!");
	}

	if (!$message)
	{
		print p({-style=>"color: red;"}, "Please enter a message!");
	}
	
	if (!$rating)
	{
       		print p({-style=>"color: red;"}, "Please give our site a rating!");
	}

	if($rating < 1 || $rating > 10)
	{
		print p({-style=>"color: red;"}, "Please give our site a rating between 1 and 10");
   	}

	print a({-href=>"javascript:history.back();"}, "Go back and fill in the fields"); 
}
	

print end_html();