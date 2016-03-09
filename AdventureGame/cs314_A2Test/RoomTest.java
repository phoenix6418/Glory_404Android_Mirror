// author: Bolin Liu
// test methods in Room.java

package cs314_A2Test;
import static org.junit.Assert.*;

import org.junit.Test;

import cs314_A2.*;



public class RoomTest {
	
	// test roomEmpty()
	@Test
	public void testRoomEmpty() {
		Room r1 = new Room();
		assertTrue(r1.roomEmpty());
	}
	
	// test roomFull()
	// Modified by Bolin
	@Test
	public void testRoomFull() {
		Room r1 = new Room();
		Treasure t1 = new Treasure();
		Treasure t2 = new Treasure();
		r1.addItem(t1);
		assertFalse(r1.roomFull());
		r1.addItem(t2);
		assertTrue(r1.roomFull());
	}
	
	// test addItem(Item theItem)
	@Test
	public void testAddItem() {
		Room r1 = new Room();
		Treasure treasure = new Treasure();
		treasure.setDesc ("gold bars");
		r1.addItem(treasure);
		assertFalse(r1.roomEmpty());
	}
	
	// test removeItem (Item theItem)
	@Test
	public void testRemoveItem() {
		Room r1 = new Room();
		Treasure t1 = new Treasure();
		t1.setDesc("treasure");
		r1.addItem(t1);
		r1.removeItem(t1);
		assertTrue(r1.roomEmpty());
	}
	
	// test enter (Player p)
	//		getDesc()
	// Modified by Bolin
	@Test
	public void testEnterAndGetDesc() {
		Room r1 = new Room();
		r1.setDesc("r1");
		Item i1 = new Item();
		Item i2 = new Item();
		i1.setDesc("i1");
		i2.setDesc("i2");
		r1.addItem(i1);
		r1.addItem(i2);
		Player p = new Player();
		r1.enter(p);
		assertEquals(r1.getDesc() , p.getLoc().getDesc());
		
	}
	
	// test exit (int direction, Player p)
	//		setSide (String d)
	@Test
	public void testExitAndSetSide() {
		Room r1 = new Room();
		Room r2 = new Room();
		r1.setDesc("r1");
		r2.setDesc("r2");
		r1.setSide(1, r2);
		Player p = new Player();
		r1.enter(p);
		r1.exit(1, p);
		assertEquals(r2.getDesc(), p.getLoc().getDesc());
	}
	
	// test getRoomContents()
	@Test
	public void testGetRoomContents() {
		Room r1 = new Room();
		Treasure t1 = new Treasure();
		t1.setDesc("treasure1");
		r1.addItem(t1);
		assertEquals(r1.getRoomContents()[0].toString(), "treasure1");
	}

}
