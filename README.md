DogGame in Scala
=========================

This is a project created by Marc Baldishwilie and Shohrukh Koyirov. It is a basic scala project as used in the
class Software Engineering at the University of Applied Science HTWG Konstanz<br><br>

DogGame instructions
=========================



DOG -  Rules of the game <br><br>

Aim
____________________ 
The team me mb ers (2 x 2) sit opposite. The object of the game  is to move own men 
from home to the target area as fast as possible. They are moved in an anticlockwise 
direction along the course according to the value of the cards. The winning team is 
the one who has first placed all its 8 me n in the target area. Once a player has set 
its 4 men in the target area, he continues by supporting his partner. He moves his partners me
n according to the values of his own cards. <br><br>

Procedure
____________________
The  cards are distributed by the same person during the whole game.
At the start of the game  each player obtains 6 cards.<br>
At each round’s start the partners exchange one card, swapped face down. 
Thereafter the obtained card joins the visible ones in hand. This feature enables the 
partners to provide each other strategically important cards.<br>
One player after the other, going anticlockwise around the table, lays down a single 
card, visible to all, and moves his man according to the card’s value (see p. 3:Card
Values).<br>
If a player’s set of cards doesn’t permit to start or move, he’s out of the current 
round and must lay down his remaining cards. A round is finished once all cards are 
laid down.<br>
At each subsequent round another player starts (anticlockwise change).
In the second round 5 cards are distributed, in the third 4, and so on, down to 2 
cards. There after the next round starts again with 6 cards, etc. (6, 5, 4, 3, 2, 6, 5, 
4,...).<br><br>

Start
____________________
A man can be moved from home to the starting-point either with an ace, a king or a 
joker (see p.1: Illustration). This point is the start and the end of the course , and 
where the men can enter the target area. When a man is moved from home to the starting
-point, he is protected, i.e. it can neither be exchanged (see p.3: JACK), returned home
 or passed (passage blocked, for own men, too).<br><br> 

Returning home
____________________ 
If a man arrives at a position occupied by another, the latter must return home. This 
also applies to own men.If one or more men are passed at the same time by another man 
moved by a 7 or a fraction thereof, these ones must return home. A man on a foreign starting
-point must return home, if another player’s man is set to start.Men on the own starting
-point and in the target area cannot be returned home.<br><br>

Passing
____________________
...is always permitted, except in target area or if a man is on its own starting-point.<br><br>

Compelled to move
____________________
The players are compelled to move their men the complete number of steps determinated by the card value, particularly to place the last man in the target area. If the card’s value exceeds the number of necessary steps, another lap of the course must be started to retry the entry.As a possible consequence additional laps must be turned.<br>
Exception: If the last man of a player e.g. needs 5 point to finish, but the corresponding card is lacking, he can use a 7 (if at hand) and apply the remaining 2 points for one of his partner’s men.
<br><br>

Target area
____________________
In order to enter the target area the starting-point must be hit twice and the direction must be 
anticlockwise. E.g. a man positioned 2 steps after the starting-point can be moved 4 steps backward, but not straight into the target area. The entry might follow with the next card. Within the target area passing men is prohibited.<br><br>

Card Values
______________

ACE
______
	<p>1 step forward or</p><br>
	<p>11 steps forward or</p><br>
	<p>move one man from home to starting-point</p><br><br>

KING
______
	<p>13 steps forward or</p><br>
	<p>move one man from home to starting-point</p><br><br>

QUEEN
______
	<p>12 steps forward</p><br><br>

JACK
______
	<p>exchange 2 men, one of which must be your own.</p><br>
	<p>A man positioned for the first time at the start, at home or in the</p> <br>
	<p>target area, may not be exchanged.</p><br><br>

10 
______
	<p>10 steps forward</p><br><br>

9
______
	<p>9 steps forward</p><br><br>

8
______
	<p>8 steps forward</p><br><br>

7 
______
	<p>7 steps forward</p><br>
	<p>The 7 steps can be partitioned to a random number to use on own</p><br> 
	<p>men (e.g.: 5 + 2, 3 + 2 + 2).</p><br>
	<p>A 7 step advance or a fraction thereof returns all the men he passes,</p><br> 
	<p>including his own, home.</p>

6
______
	<p>6 steps forward</p<br><br>

5
______
	<p>5 steps forward</p><br><br>

4
______
	<p>4 steps forward or backward</p><br><br>

3
______
	<p>3 steps forward</p><br><br>

2
______
	<p>2 steps forward</p><br><br>

JOKER
_______
	<p>The joker can take any of the card values mentioned above.</p><br><br>

