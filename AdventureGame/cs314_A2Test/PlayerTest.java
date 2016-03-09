package cs314_A2Test;
import cs314_A2.*;
import static org.junit.Assert.*;
import org.junit.Test;
/**
Team: Glory404
Members: David Sahud, Xuehao(David) Hu, Bolin Liu, Kerry McKean.
**/
//Written by: David Sahud
public class PlayerTest {

	//Written by: David Sahud
	@Test
	public void lookTest(){
		Player guy = new Player();
		Room troom = new Room();
		troom.setDesc("This room is very dark. You can just barely see (test).");
		guy.setRoom(troom);
		assertTrue(troom.getDesc().equals(guy.look()));
	}
	//Written by: David Sahud
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
	//Written by: David Sahud
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
	//Written by: David Sahud
	// Modified by Bolin Liu
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
	//Written by: David Sahud
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
	@Test
	public void setLocTest(){
		Player guy = new Player();
		Room troom = new Room();
		Room room2 = new Room();
		guy.setLoc(troom);
		assertTrue(guy.getLoc() == troom);
		assertFalse(guy.getLoc() == room2);
	}
	//Written by: David Sahud
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
	
	
	
	

}
