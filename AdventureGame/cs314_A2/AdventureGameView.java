package cs314_A2;
/**
Team: Glory404
Members: David Sahud, Xuehao(David) Hu, Bolin Liu, Kerry McKean.
**/
import javax.swing.*;


import BreezySwing.*;

public class AdventureGameView extends GBFrame{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

// Window objects --------------------------------------
   JLabel welcomeLabel =
     addLabel("Welcome to the Adventure Game " + 
              "(inspired by an old game called the Colossal Cave Adventure)." +
            " Java implementation Copyright (c) 1999-2012 by James M. Bieman",
	    1,1,5,1);
   
   JLabel viewLable = addLabel ("Your View: ",2,1,1,1);
   JTextArea viewArea = addTextArea("Start",3,1,4,3); 

   JLabel carryingLable = addLabel ("You are carying: ",6,1,1,1);
   JTextArea carryingArea = addTextArea("Nothing",7,1,4,3); 

JLabel separator1 = addLabel
   ("-----------------------------------------------------------------"
	 , 10,1,4,1);


   JLabel choiceLabel    = addLabel
      ("Choose a direction, pick-up, or drop an item" ,11,1,5,1);

   JButton grabButton = addButton ("Grab an item", 12, 5,1,1);
   JButton dropButton = addButton ("Drop an item", 13, 5,1,1);
   
   JButton northButton = addButton ("North", 12,2,1,1);
   JButton southButton = addButton ("South", 14,2,1,1);
   JButton eastButton = addButton ("East",   13,3,1,1);
   JButton westButton = addButton ("West",   13,1,1,1);
   JButton upButton = addButton ("Up", 12,3,1,1);
   JButton downButton = addButton ("Down", 14,3,1,1);

   AdventureGameModelFacade model;
   
   // Constructor-----------------------------------------------

   public AdventureGameView(){
      setTitle ("Adventure Game");
      model = new AdventureGameModelFacade();

      viewArea.setEditable (false);
      carryingArea.setEditable (false);
      displayCurrentInfo();
   } 
   
   
   // buttonClicked method--------------------------------------

   public void buttonClicked (JButton buttonObj){
      if (buttonObj == upButton)
         model.goUp();

      else if (buttonObj == downButton)
	 model.goDown();

      else if (buttonObj == northButton)
	 model.goNorth();

      else if (buttonObj == southButton)
	 model.goSouth();

      else if (buttonObj == eastButton)
	 model.goEast();

      else if (buttonObj == westButton)
	 model.goWest();

      else if (buttonObj == grabButton)
	 grab();

      else if (buttonObj == dropButton)
	 drop();

      displayCurrentInfo();
  }
      
   
   // Private methods-------------------------------------------

   private void displayCurrentInfo(){
	 viewArea.setText(model.getView());
	 carryingArea.setText(model.getItems());
	 }

    // Left as an exercise. 
   private void grab() {
      //  Set up a dialog to talk to the model and
      //  determine what items to pick up.
		GBDialog msg = new GBDialog(null);
			   
			   if (model.handsFull()){
		         msg.messageBox("Your hands are full.");
			   }
			   else if ((model.getLoc()).roomEmpty())
		         msg.messageBox("The room is empty.");
			   else {
		         Item[] items = model.getLoc().getRoomContents();
				   Item choice = (Item) JOptionPane.showInputDialog(null,"Choose item that you want to pick up",
				                       "PICK",
				                       JOptionPane.PLAIN_MESSAGE,
				                       null,
				                       items,
				                       items[0].toString());
		
				   //If a string was returned, say so.
				   if ((choice != null) && (choice.toString().length() > 0)) {
				       //setLabel("Green eggs and... " + s + "!");
		            model.getLoc().removeItem(choice);
		            model.pickUp(choice);
		            displayCurrentInfo();
		
				      return;
				   }
			   }
   }

    // Left as an exercise. 
    private void drop() {
	     //  Set up a dialog to talk to the model and

         //  determine what items to pick up.
    	GBDialog msg = new GBDialog (null);
        if (model.handsEmpty ()) {
           msg.messageBox ("You have nothing to drop.");
        } else if (model.roomIsFull()) {
            msg.messageBox ("Room is full."); 
    	} else {
           Item[] drop = model.myThings();
           Item choice = (Item) JOptionPane.showInputDialog(null,"Choose item that you want to drop",
  		                       "DROP",
  		                       JOptionPane.PLAIN_MESSAGE,
  		                       null,
  		                       drop,
  		                       drop[0].toString());
     		//if ((choice != null) && (choice.toString().length() > 0)) {
           if (choice.toString().equals(drop[0].toString())) {
              model.drop(1);
              displayCurrentInfo();
              return;
     		} else {
              model.drop(2);
              displayCurrentInfo();
              return;
           }
        }
   }

   public static void main (String[] args){
      JFrame view = new AdventureGameView();
      view.setSize (800, 600); /* was 400, 250  */             
      view.setVisible(true);    
   }                    
}
