package cs314_A2;

import static org.junit.Assert.*;

import org.junit.Test;

public class xhAdventureGameModelFacadeTest {

	/**
	 * tests for methods:
	 *  go up, down, north, south, west, east
	 * */
	@Test
	public void testRoomWithWallsAllAround() {
		AdventureGameModelFacade model = new AdventureGameModelFacade();
		
		//make a room with wals in all directions
		Room room_wallsAround = new Room();
		model.getPlayer().setRoom(room_wallsAround);
		model.goDown();
		assertEquals(model.getViewText(),"Ouch! That hurts.");
		model.goUp();
		assertEquals(model.getViewText(),"Ouch! That hurts.");
		model.goEast();
		assertEquals(model.getViewText(),"Ouch! That hurts.");
		model.goWest();
		assertEquals(model.getViewText(),"Ouch! That hurts.");
		model.goNorth();
		assertEquals(model.getViewText(),"Ouch! That hurts.");
		model.goSouth();
		assertEquals(model.getViewText(),"Ouch! That hurts.");
	}
}
