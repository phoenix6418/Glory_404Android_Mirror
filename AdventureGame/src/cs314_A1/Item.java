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
				    
/* Update1: Date: 2/1/2016 by Bolin Liu
 * 			Add comments explaining what Item class,
 *			setDesc() and getDesc() are doing.
 */

// class Item
// object that locates in room.

public class Item {

  private String description;

  // set description for item
  public void setDesc(String d){
      description = d;
  }

  // get description for item
  public String getDesc(){
	     return description;
  }

}

