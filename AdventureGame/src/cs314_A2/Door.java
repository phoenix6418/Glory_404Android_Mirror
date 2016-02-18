package cs314_A2;
/**
 Team: Glory404
 Members: David Sahud, Xuehao(David) Hu, Bolin Liu, Kerry McKean.
 **/

import BreezySwing.GBDialog;

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
				    
**/

// class Door

public class Door implements CaveSite {
  /** In this implementation doors are always locked.
      A player must have the correct key to get through
      a door.  Doors automatically lock after a player
      passes through. */

  private Key myKey;

  /** The door's location. */
  private CaveSite outSite;
  private CaveSite inSite;
  

  /** We can construct a door at the site. */
  Door(CaveSite out, CaveSite in, Key k){
    outSite = out;
    inSite = in;
    myKey = k;
  }

 /** A player will need the correct key to enter. */
 public String enter(Player p){
 if (p.haveItem(myKey)) {
	String message = "";
    message += "Your key works! The door creaks open,\n";
    message += "and slams behind you after you pass through.\n\n";
    if (p.getLoc() == outSite){
    	message += inSite.enter(p);
    }
    else if (p.getLoc() == inSite){
    	message += outSite.enter(p);
    }
    return message;
 }
 else {
	 String message = "";
	 message += "You don't have the key for this door!\n";
     message += "Sorry.\n";
     return message;
      }
 }

}

