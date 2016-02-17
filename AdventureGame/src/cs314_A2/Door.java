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
  
  //Popup box for displaying messages
  private GBDialog popup;

  /** We can construct a door at the site. */
  Door(CaveSite out, CaveSite in, Key k){
    outSite = out;
    inSite = in;
    myKey = k;
    popup = new GBDialog(null);
  }

 /** A player will need the correct key to enter. */
 public void enter(Player p){
 if (p.haveItem(myKey)) {
    popup.messageBox("Your key works! The door creaks open,");
    popup.messageBox("and slams behind you after you pass through.");
    if (p.getLoc() == outSite) inSite.enter(p);
    else if (p.getLoc() == inSite) outSite.enter(p); 
 }
 else {popup.messageBox("You don't have the key for this door!");
       popup.messageBox("Sorry.");
      }
 }

}

