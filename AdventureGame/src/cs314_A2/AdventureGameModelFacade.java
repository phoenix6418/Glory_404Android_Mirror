package cs314_A2;

public class AdventureGameModelFacade {

 // some private fields to reference current location,
 // its description, what I'm carrying, etc.
 //
 // These methods and fields are left as exercises.

  AdventureGameModelFacade() { // we initialize
  }
  
    //make new startQuest? ‹need to interact with interact with startQuest()
    //get rid of wihle loop, just have it as an object that gets called.
    
    
    //where most of the refactoring is needed...
    //new game button?
    //get description, messageBox(String msg)
    //drop item, re got items for list...?
  public void goUp(){
      //Player.go(2)
  }

  public void goDown(){
      //Player.go(5)
    }

  public void goNorth(){
      //0
    }
      
  public void goSouth(){
      //1
    }

  public void goEast(){
      //2
    }
      
  public void goWest(){
      //3
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