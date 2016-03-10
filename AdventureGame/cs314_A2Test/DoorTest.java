package cs314_A2Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs314_A2.Door;
import cs314_A2.Key;
import cs314_A2.Player;
import cs314_A2.Room;

public class DoorTest {

	//enter a door from outside 
	// with correct key
	@Test
	public void EnterDoorWithKey() {
		Room out;
		Room in;
		Key key = new Key();
		Door door;
		Player aPlayer;
		
		out = new Room();
		in = new Room();
		door = new Door(out,in,key);
		aPlayer = new Player();
		
		out.addItem(key);
		aPlayer.setRoom(out);
		
		aPlayer.pickUp(key);
		
		in.setDesc("inRoom");
		out.setDesc("outRoom");
		
		String str = door.enter(aPlayer);
		System.out.println(str);
	}
	//enter a door from outside 
	// with wrong
	@Test
	public void EnterDoorWrongKey() {
		Room out;
		Room in;
		Key key = new Key();
		Key key2 = new Key();
		Door door;
		Player aPlayer;
	
		out = new Room();
		in = new Room();
		door = new Door(out,in,key);
		aPlayer = new Player();
		
		out.addItem(key);
		out.addItem(key2);
		aPlayer.setRoom(out);
		aPlayer.pickUp(key2);
		
		in.setDesc("inRoom");
		out.setDesc("outRoom");
		
		String str = door.enter(aPlayer);
		System.out.println(str);
	}
	
	
}
