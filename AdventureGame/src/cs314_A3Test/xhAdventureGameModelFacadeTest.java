package cs314_A3Test; 

import cs314_A3.*;
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
	
	@Test
	public void testRoomWithWallsAndEntranceToOtherRooms() {
		AdventureGameModelFacade model = new AdventureGameModelFacade();
		
		//make a room with wals in all directions
		Room room_main = new Room();
		
		Room room_north = new Room();
		room_north.setDesc("north");
		
		Room room_south = new Room();
		room_south.setDesc("south");
		
		Room room_west = new Room();
		room_west.setDesc("west");
		
		Room room_east = new Room();
		room_east.setDesc("east");
		
		Room room_up = new Room();
		room_up.setDesc("up");
		
		Room room_down = new Room();
		room_down.setDesc("down");
		
		room_main.setSide(0, room_north);
		room_main.setSide(1, room_south);
		room_main.setSide(2, room_east);
		room_main.setSide(3, room_west);
		room_main.setSide(4, room_up);
		room_main.setSide(5, room_down);
		
		model.getPlayer().setRoom(room_main);
		model.goDown();
		assertEquals(model.getViewText().split("\\s+")[0],"down");
		
		model.getPlayer().setRoom(room_main);
		model.goUp();
		assertEquals(model.getViewText().split("\\s+")[0],"up");
		
		model.getPlayer().setRoom(room_main);
		model.goEast();
		assertEquals(model.getViewText().split("\\s+")[0],"east");
		
		model.getPlayer().setRoom(room_main);
		model.goWest();
		assertEquals(model.getViewText().split("\\s+")[0],"west");
		
		model.getPlayer().setRoom(room_main);
		model.goNorth();
		assertEquals(model.getViewText().split("\\s+")[0],"north");
		
		model.getPlayer().setRoom(room_main);
		model.goSouth();
		assertEquals(model.getViewText().split("\\s+")[0],"south");
		
	}
}
