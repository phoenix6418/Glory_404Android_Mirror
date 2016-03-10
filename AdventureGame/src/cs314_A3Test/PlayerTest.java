package cs314_A3Test;
import cs314_A3.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
Team: Glory404
Members: David Sahud, Xuehao(David) Hu, Bolin Liu, Kerry McKean.
**/

// Black Box Tests: 8
// White Box Tests: 4

// Defects Found:
//		- dropTest().
//		 Should print error message when drop item that the player does not have
// 		 or number inputs out of index (other than 1 and 2).

//		- showMyThings().
//		 Should give player a picture when the player does not have anything.
 

//Written by: David Sahud
public class PlayerTest {

	// Written by: David Sahud
	// Comments added by Bolin Liu
	// White Box
	// Setup room with description. Test if the look() 
	// matches the expected room description
	@Test
	public void lookTest(){
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
		guy.setRoom(troom);
		assertTrue(troom.getDesc().equals(guy.look()));
	}
	
	// Written by: David Sahud
	// Comments added by Bolin Liu
	// Black Box
	// Setup room with items, pickUp items
	// and check if the player if carrying the item.
	@Test
	public void pickupTest(){
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
	    Treasure theTreasure = new Treasure();
	    theTreasure.setDesc("A bag filled with gold bars.");
	    troom.addItem(theTreasure);
	    Treasure anotherTes = new Treasure();
	    anotherTes.setDesc("A bag filled with bronze bars.");
	    troom.addItem(anotherTes);
		guy.setRoom(troom);
		
		
		
		guy.pickUp(theTreasure);
	    assertTrue(guy.haveItem(theTreasure) == true);	
	    assertTrue(guy.numItemsCarried() == 1);		
	}
	
	
	// Written by: David Sahud
	// Comments added by Bolin Liu
	// Black Box
	// Test if a player's hands are full
	// when the player has one and two items.
	@Test
	public void handsFullTest(){
		
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
	    Treasure theTreasure = new Treasure();
	    theTreasure.setDesc("A bag filled with gold bars.");
	    troom.addItem(theTreasure);
	    Treasure anotherTes = new Treasure();
	    anotherTes.setDesc("A bag filled with bronze bars.");
	    troom.addItem(anotherTes);
		guy.setRoom(troom);
		
		assertTrue(guy.handsFull() == false);
		
		
		guy.pickUp(theTreasure);
		assertTrue(guy.handsFull() == false);
		
		//now player should have 2 items, and can't get another.
		guy.pickUp(anotherTes);
	    assertTrue(guy.handsFull() == true);	
	}
	//Written by: David Sahud
	// Commented by Bolin Liu
	// Black Box
	// Setup a room with 2 items.
	// Test if the player has items before picking up.
	// Test if the player has items after picking up.
	// Test if the player has the item after drop.
	@Test
	public void haveItemTest(){
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
	    Treasure theTreasure = new Treasure();
	    theTreasure.setDesc("A bag filled with gold bars.");
	    troom.addItem(theTreasure);
	    Treasure anotherTes = new Treasure();
	    anotherTes.setDesc("A bag filled with bronze bars.");
	    troom.addItem(anotherTes);
		guy.setRoom(troom);
		
		
		assertTrue(guy.haveItem(theTreasure) == false);
	    assertTrue(guy.haveItem(anotherTes) == false);	

		guy.pickUp(theTreasure);
		assertTrue(guy.haveItem(theTreasure) == true);
		guy.pickUp(anotherTes);
	    assertTrue(guy.haveItem(theTreasure) == true);	
	    assertTrue(guy.haveItem(anotherTes) == true);	
	    
	    guy.drop(1);
	    assertTrue(guy.haveItem(anotherTes) == true);
	    assertTrue(guy.haveItem(theTreasure) == false);	    
	}
	//Written by: David Sahud
	// Commented by Bolin Liu
	// Black Box
	// Test if the player can drop something that the player doesnt have
	// Test if the player can drop the item that the player has.
	// Defects: An error message should show up when tries to drop null.
	@Test
	public void dropTest(){
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
	    Treasure theTreasure = new Treasure();
	    theTreasure.setDesc("A bag filled with gold bars.");
	    troom.addItem(theTreasure);
	    guy.setLoc(troom);
	    guy.pickUp(theTreasure);
	    guy.drop(2);
	    assertTrue(guy.numItemsCarried() == 1);
	    
	    guy.drop(1);
	    assertTrue(guy.numItemsCarried() == 0);
	    
	}
	// Written by: David Sahud
	// Modified and Commented by Bolin Liu
	// Black Box
	// Test number of items carried by player whenever
	// the player pickup or drop an item. Check if the number
	// matches the expected number of items.
	@Test 
	public void numitemsCarriedTest(){
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
	    Treasure theTreasure = new Treasure();
	    theTreasure.setDesc("A bag filled with gold bars.");
	    troom.addItem(theTreasure);
	    
	    Item i = new Item();
	    i.setDesc("Item i");
	    troom.addItem(i);
	    
	    guy.setLoc(troom);
	    assertTrue(guy.numItemsCarried() == 0);

	    guy.pickUp(theTreasure);
	    guy.drop(2);
	    assertTrue(guy.numItemsCarried() == 1);
	    guy.pickUp(i);
	    assertTrue(guy.numItemsCarried() == 2);
	    guy.drop(3);
	    assertTrue(guy.numItemsCarried() == 2);
	    guy.drop(0);
	    assertTrue(guy.numItemsCarried() == 2);
	    
	    guy.drop(2);
	    assertTrue(guy.numItemsCarried() == 1);
	    guy.drop(1);
	    assertTrue(guy.numItemsCarried() == 0);
	//numItemsCarried	
	}
	
	// Written by: David Sahud
	// Commented by Bolin Liu
	// Black Box
	// Test if the player has items before picking up an item.
	// Test if the player has items after picking up an item.
	// Test if the player has items after dropping an item.
	@Test
	public void emptyTest(){
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
	    Treasure theTreasure = new Treasure();
	    theTreasure.setDesc("A bag filled with gold bars.");
	    troom.addItem(theTreasure);
		guy.setRoom(troom);
		
		assertTrue(guy.handsEmpty() == true);
		
		
		guy.pickUp(theTreasure);
		assertTrue(guy.handsEmpty() == false);
		
		guy.drop(1);
	    assertTrue(guy.handsEmpty() == true);	
	}
	
	//Written by: David Sahud
	// Commented by Bolin Liu
	// White box
	// Set up Room and see if room description matches the expected description.
	@Test
	public void setRoomTest(){
		Player guy = new Player();
		Room troom = new Room();
		Room room2 = new Room();
		guy.setRoom(troom);
		assertTrue(guy.getLoc() == troom);
		assertFalse(guy.getLoc() == room2);
	}
	
	//Written by: David Sahud
	// Commented by Bolin Liu
	// White Box
	// Put player in a room and see if the room description matches the expected description.
	@Test
	public void setLocTest(){
		Player guy = new Player();
		Room troom = new Room();
		Room room2 = new Room();
		guy.setLoc(troom);
		assertTrue(guy.getLoc() == troom);
		assertFalse(guy.getLoc() == room2);
	}
	
	// Written by: David Sahud
	// Commented by Bolin Liu
	// Black Box
	// Check if the items showed matches the items that the player has.
	// Defects: Should let the player know when the player does not have anything.
	@Test
	public void showMyThingsTest(){
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
	    Treasure theTreasure = new Treasure();
	    theTreasure.setDesc("A bag filled with gold bars.");
	    troom.addItem(theTreasure);
		guy.setRoom(troom);
		assertTrue(guy.showMyThings().equals(""));
		guy.pickUp(theTreasure);
		assertTrue(guy.showMyThings().equals("1: A bag filled with gold bars. "));
	}
	//showMyThings
	
	
	// Written by: Bolin Liu
	// White Box
	// check if the array stores the exact item that the player is holding.
	@Test
	public void myThingsTest () {
		Player guy = new Player();
		Room troom = new Room();
		Item i = new Item();
	    i.setDesc("Item i");
	    Item i2 = new Item();
	    i2.setDesc("Item i2");
	    troom.addItem(i);
	    troom.addItem(i2);
	    guy.setLoc(troom);
	    guy.pickUp(i);
	    guy.pickUp(i2);
		Item items[] = guy.myThings();
		assertEquals(items[0].getDesc(), "Item i");
		assertEquals(items[1].getDesc(), "Item i2");
	}
	
	// Written by: Bolin Liu
	// Black Box
	// set up 2 adjacent rooms. See if the player can go from one to another.
	@Test
	public void goTest () {
		Player p = new Player();
		Room r1 = new Room();
		r1.setDesc("r1");
		Room r2 = new Room();
		r2.setDesc("r2");
		r1.setSide(2, r2);
		Item i = new Item();
		i.setDesc("i");
		
		r2.addItem(i);
		
		p.setLoc(r1);
		p.go(2);
		Item items[] = p.getLoc().getRoomContents();
		assertEquals(items[0].getDesc(), "i");
		
	}
	

}
