package cs314_A2;
/**
Team: Glory404
Members: David Sahud, Xuehao(David) Hu, Bolin Liu, Kerry McKean.
**/
public class AdventureGameModelFacade {
	
	private Player thePlayer;
	private Adventure theCave;
	private String viewText;
	

  public AdventureGameModelFacade() { // we initialize
	  thePlayer = new Player();
	  theCave = new Adventure();
	  thePlayer.setRoom(theCave.createAdventure());
	  viewText = thePlayer.getLoc().getDesc();
  }

  public void goUp(){

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

  public Player getPlayer(){
	  return this.thePlayer;
  }
  
  public String getView(){ 
     return viewText;
     }

  public String getItems(){
     return(thePlayer.showMyThings());
  }
<<<<<<< HEAD
=======
  
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

>>>>>>> 679cc09b735416ab568e648d71fb59fe7225f993

<<<<<<< HEAD
  public String getViewText(){
	  return viewText;
  }
 // Surely you will need other methods to deal with
 // picking up and dropping things.
=======
>>>>>>> 804508df6e5dded111c57c948afb1bfc6c91286d

 
}

