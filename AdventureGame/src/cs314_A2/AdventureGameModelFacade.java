package cs314_A2;

import cs314_A1.*;

public class AdventureGameModelFacade {

	// some private fields to reference current location,
	// its description, what I'm carrying, etc.
	//
	// These methods and fields are left as exercises.
	private Player thePlayer = new Player();
	
	AdventureGameModelFacade() { // we initialize
		
  	}

	/**
	 * Based ont the adventureGame.java
	 * move up:    4
	 * move down:  5
	 * move north: 0
	 * move south: 1
	 * move east:  2
	 * move west:  3
	 * */
  	public void goUp(){
  		thePlayer.go(4); 
  	}

  	public void goDown(){
  		thePlayer.go(5);
  	}

  	public void goNorth(){
  		thePlayer.go(0);
  	}
      
  	public void goSouth(){
  		thePlayer.go(1);
  	}

  	public void goEast(){
  		thePlayer.go(2);
  	}
      
  	public void goWest(){
  		thePlayer.go(3);
  	}

  	// You need to finish these getView and getItems methods.
  public String getView(){ 
	  return("My view");
  	}

  	public String getItems(){
  		return("My items");
  	}

 // Surely you will need other methods to deal with
 // picking up and dropping things.

}
