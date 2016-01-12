
Tennis Scoring Android App
==================================


1.	Layout of views – used the basketball layout as a starting point
a.	Added in three text views for the different sets(will incorporate more sets or an option to select 3 or 5 sets later on)
b.	Have two buttons for incrementing both players’ points

2.	Need menu to edit name of players…(Work on this later)
3.	Separate layout for tablet(work on this later) or addition explanation for points(probably will go for this extension)
4.	Separate activity for choosing number of sets(Work on this later)
5.	Display message when the match is won 
6.	Started working on the scoring mechanism
a.	Added a method for scoring games
•	Added a set tracker
•	Haven’t incorporated tie break handling yet
a.	Handle it in pointScoring method
b.	Added a method for scoring points

i.	Display of points handled separately for both players
ii.	Used conditional statements for handling of deuce, advantage and other point situations 
7.	Scoring works well INCLUDING TIEBREAKS (bug tiebreak when equal at 6-6- corrected)
	*3 hours on Sunday
8.	Included toast when a player wins a match
9.	Edited the layout – still not completed	
	*40 minutes on Monday

10.	Working on match stats
11.	Incorporated all the buttons in main activity
12.	Yet to work on displaying match stats.
13.	When changed to landscape current state is destroyed
	*Bug display previous set when rotated
	*Need 4 instance variables and if statements for display
	*3 hours on Tuesday and Wednesday
14.	ALL working now
15.	It includes a match stats tracker as well
16.	TIPS on how to use: When button:- FORCED ERROR, UNFORCED ERROR and DOUBLE FAULT are clicked it scores the point for the other player, while the winner and ace buttons score point for the current player. There is also a match stats button when clicked will open an activity which displays certain match stats
17.	TOTAL 6-hours
