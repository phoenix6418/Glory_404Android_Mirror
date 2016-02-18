package cs314_A2;

public class AdventureGameModelFacade {
	
	private Player thePlayer;
	private Adventure theCave;
	private String viewText;
	

  AdventureGameModelFacade() { // we initialize
	  thePlayer = new Player();
	  theCave = new Adventure();
	  thePlayer.setRoom(theCave.createAdventure());
	  viewText = thePlayer.getLoc().getDesc();
  }

  public void goUp(){

=======
    //make new startQuest? ‹need to interact with interact with startQuest()
    //get rid of wihle loop, just have it as an object that gets called.
    
    
    //where most of the refactoring is needed...
    //new game button?
    //get description, messageBox(String msg)
    //drop item, re got items for list...?
  public void goUp(){
>>>>>>> e3af08480aeac66e4c03d5cba28dd3f6da1b68e0
      viewText = thePlayer.go(4);
  }

  public void goDown(){
      viewText = thePlayer.go(5);
    }

  public void goNorth(){
      viewText = thePlayer.go(0);
    }
      
  public void goSouth(){
      viewText = thePlayer.go(1);
    }

  public void goEast(){
      viewText = thePlayer.go(2);
    }
      
  public void goWest(){
      viewText = thePlayer.go(3);
    }

  
  public String getView(){ 
     return viewText;
     }

  public String getItems(){
     return(thePlayer.showMyThings());
  }
  
	public boolean handsFull() {	return thePlayer.handsFull(); }
	
	public boolean handsEmpty() { return thePlayer.handsEmpty();}
	
	public Room getLoc() { return thePlayer.getLoc(); }
 
	public void pickUp(Item choice){
		thePlayer.pickUp(choice);
		viewText = thePlayer.look();		//Updates room description to show items in room
	}
 
	public void drop (int toDrop) {
		thePlayer.drop (toDrop);
		viewText = thePlayer.look();		//Updates room description to show items in room
	}

	public Item[] myThings () { return thePlayer.myThings(); }

<<<<<<< HEAD
}
=======

 // Surely you will need other methods to deal with
 // picking up and dropping things.

}
>>>>>>> e3af08480aeac66e4c03d5cba28dd3f6da1b68e0
