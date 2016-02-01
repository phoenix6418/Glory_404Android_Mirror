package cs314_A1;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
				    
**/

// class Wall
/* The sides, floor, and ceiling of each room are walls by default.
 * Walls have no special properties, but they are impassable.
 */



public class Wall implements CaveSite {
	public void enter(Player p)
	{
		//You can't go through walls!
		System.out.println("Ouch! That hurts.");
	}

}

