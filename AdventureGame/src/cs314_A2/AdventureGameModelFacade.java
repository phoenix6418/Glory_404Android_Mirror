package cs314_A2;

public class AdventureGameModelFacade {
	
	Player thePlayer;
	Adventure theCave;
	

  AdventureGameModelFacade() { // we initialize
	  thePlayer = new Player();
	  theCave = new Adventure();
	  thePlayer.setRoom(theCave.createAdventure());
	  
  }
  
    //make new startQuest? ‹need to interact with interact with startQuest()
    //get rid of wihle loop, just have it as an object that gets called.
    
    
    //where most of the refactoring is needed...
    //new game button?
    //get description, messageBox(String msg)
    //drop item, re got items for list...?
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

  
  public String getView(){ 
     return thePlayer.getLoc().getDesc();
     }

  public String getItems(){
     return(thePlayer.showMyThings());
  }

 // Surely you will need other methods to deal with
 // picking up and dropping things.

}