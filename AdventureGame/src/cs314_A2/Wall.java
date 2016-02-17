package cs314_A2;

import BreezySwing.GBDialog;

/**
 Team: Glory404
 Members: David Sahud, Xuehao(David) Hu, Bolin Liu, Kerry McKean.
 **/

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
     
     Feb 1, 2016 Update:  Added Class description comment.  (Kerry McKean)
				    
**/

/* The sides, floor, and ceiling of each room are walls by default.
 * Walls have no special properties, but they are impassable.
 * Therefore, wall.enter(player) doesn't change player's location.
 */



public class Wall implements CaveSite {
	public void enter(Player p)
	{
		//You can't go through walls!
		GBDialog popup = new GBDialog(null);
		popup.messageBox("Ouch! That hurts.");
	}

}

