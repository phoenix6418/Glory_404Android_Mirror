package cs314_A2;
/**
 Team: Glory404
 Members: David Sahud, Xuehao(David) Hu, Bolin Liu, Kerry McKean.
 **/

/**  Adventure Game  Program Code
     Copyright (c) 1999 James M. Bieman

     To compile: javac AdventureGame.java
     To run:     java AdventureGame

     The main routine is AdventureGame.main
     
     Update August 2010: refactored Vector contents into ArrayList<Item> contents.
      This gets rid of the use of obsolete Vector and makes it type safe.
				    
		
	 Update Feb 1, 2016:  Removed unused vector and enumeration imports to get rid
	  of warnings.  Also added comments to describe the function of less obvious methods,
	  specifically Room(), setSide(), enter(), exit(), and getDesc().  (Kerry McKean)
**/

// class Room


import java.util.ArrayList;
import java.util.ListIterator;

public class Room implements CaveSite {

  private String description;

  private CaveSite[] side = new CaveSite[6];

  private ArrayList<Item> contents = new ArrayList<Item>();

  //Default constructor is a cube with only walls
  Room() {
    side[0] = new Wall();		//North
    side[1] = new Wall();		//South
    side[2] = new Wall();		//East
    side[3] = new Wall();		//West
    side[4] = new Wall();		//Up
    side[5] = new Wall();		//Down
    }

  public void setDesc(String d){
    description = d;
    }

  //For creating doors and connecting rooms
  public void setSide(int direction, CaveSite m){
   side[direction] = m;
   }

  public void addItem(Item theItem){
   contents.add(theItem); 
   }

  public void removeItem(Item theItem){
   contents.remove(theItem);
   }

  public boolean roomEmpty(){
	 return contents.isEmpty();
  }

  public Item[] getRoomContents(){
   Item[] contentsArray = new Item[contents.size()];
   contentsArray = contents.toArray(contentsArray);
   return contentsArray;
  }

  //Used to enter into this particular room.
  //Required to implement CaveSite.
  public String enter(Player p) {
   return p.setLoc(this); 
  }

  //Used to go to a different CaveSite from this room.
  //Works even if side[direction] is a wall. 
  public void exit(int direction, Player p){
   side[direction].enter(p);
   }

  /* Returns a string of the following form:
   * "<Description of room>
   * 
   * Room Contents: <Description of item1> <Description of item2> ... <Description of final item>
   * "
   */
  public String getDesc(){
   ListIterator<Item> roomContents = contents.listIterator(); 
   String contentString = "";
   while(roomContents.hasNext())
	contentString = 
	contentString + (roomContents.next()).getDesc() + " ";

   return description + '\n' + '\n' +
   "Room Contents: " + contentString + '\n';
   }

}

