package cs314_A2Test;

import cs314_A2.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class PlayerTest {

	@Test
	public void lookTest(){
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
		guy.setRoom(troom);
		assertTrue(troom.getDesc().equals(guy.look()));
	}
	
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
	
	@Test 
	public void numitemsCarriedTest(){
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
	    Treasure theTreasure = new Treasure();
	    theTreasure.setDesc("A bag filled with gold bars.");
	    troom.addItem(theTreasure);
	    guy.setLoc(troom);
	    assertTrue(guy.numItemsCarried() == 0);

	    guy.pickUp(theTreasure);
	    guy.drop(2);
	    assertTrue(guy.numItemsCarried() == 1);
	    
	    guy.drop(1);
	    assertTrue(guy.numItemsCarried() == 0);
	//numItemsCarried	
	}
	
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
	
	@Test
	public void setRoomTest(){
		Player guy = new Player();
		Room troom = new Room();
		Room room2 = new Room();
		guy.setRoom(troom);
		assertTrue(guy.getLoc() == troom);
		assertFalse(guy.getLoc() == room2);
	}
	
	@Test
	public void setLocTest(){
		Player guy = new Player();
		Room troom = new Room();
		Room room2 = new Room();
		guy.setLoc(troom);
		assertTrue(guy.getLoc() == troom);
		assertFalse(guy.getLoc() == room2);
	}
	
	//go
	/*
	wall
	room 
	door have key
	door don't have key
	*/
	//showMyThings
	
	
	
	

}
