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
 
 
   
 **/

//class Player
public class Player {
    
    //myLoc is the Room the player is in
    private Room myLoc;
    
    //Player can hold up to 2 items
    private Item[] myThings = new Item[2];
    //itemCount keeps track of number of items in myThings
    private int itemCount = 0;
    
    //set myLoc
    public void setRoom(Room r){
        myLoc = r;
    }
    
    //Returns the contents of the room
    public String look() {
        return myLoc.getDesc();
    }
    
    //move a direction to an adjacent room, if wall the room will not change
    public String go(int direction){
        return myLoc.exit(direction,this);
    }
    
    //Item can only be added to myThings if the count does not exceed 2
    public void pickUp(Item i){
        if (itemCount < 2) {
            myThings[itemCount] = i;
            itemCount++;
            myLoc.removeItem(i);
        }
    }
    
    //check if item is in myThings
    public boolean haveItem(Item itemToFind){
        for (int n = 0; n < itemCount ; n++)
            if (myThings[n] == itemToFind) return true;
        return false;
    }
    
    //remove item from myThings and shift
    public void drop(int itemNum){
        if (itemNum > 0 & itemNum <= itemCount){
            switch(itemNum){
                case 1: { myLoc.addItem(myThings[0]);
                    myThings[0]=myThings[1];
                    itemCount--;
                    break;
                }
                case 2: { myLoc.addItem(myThings[1]);
                    itemCount--;
                    break;
                }
            }
        }
    }
    
    //set the myLoc
    public void setLoc(Room r){
    	myLoc = r;
    }
    
    //get myLoc
    public Room getLoc(){return myLoc;}
    
    //Returns player's items
    public String showMyThings(){
        String outString = "";
        for (int n = 0; n < itemCount ; n++)
            outString = outString + Integer.toString(n+1) + ": "
            + myThings[n].getDesc() + " ";
        return outString;
    }
    
    //check if carrying max amount of items
    public boolean handsFull(){return itemCount==2;}
    
    //check if carrying 0 items
    public boolean handsEmpty(){return itemCount==0;}
    
    //returns itemsCount
    public int numItemsCarried(){return itemCount;}
    
}

