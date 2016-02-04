package cs314_A1;
/**
 Team: Glory404
 Members: David Sahud, Xuehao(David) Hu, Bolin Liu, Kerry McKean.
 **/

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
				    

				    **/

// interface CaveSite
/*
 Used as each side of the room.
 This allows players to move between rooms through the doors that link the CaveSites
 */
public interface CaveSite{
  void enter(Player p);
}

