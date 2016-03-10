package cs314_A2Test;

import static org.junit.Assert.*;

import org.junit.Test;

import cs314_A2.Door;
import cs314_A2.Key;
import cs314_A2.Player;
import cs314_A2.Room;

public class DoorTest {

	//enter a door from RIGHT outside room 
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
		
		assertEquals("Your key works! The door creaks open,"+'\n'+
				"and slams behind you after you pass through."+'\n'+
				""+'\n'+
				"inRoom"+'\n'+
				""+'\n'+
				"Room Contents: "+'\n'+
				"", str);
		}
	
	//enter a door from RIGHT outside room 
	// with wrong key
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
		assertEquals("You don't have the key for this door!"+'\n'+
				"Sorry."+'\n'+
				"", str);
	}
	
		//enter a door from outside 
		//and then enter outSide from inSide
		// with correct key
		@Test
		public void EnterDoorWithKeyFromInCaveSite() {
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
			
			String strin = door.enter(aPlayer);
			String strout = door.enter(aPlayer);
			
			assertEquals("Your key works! The door creaks open,"+'\n'+
					"and slams behind you after you pass through."+'\n'+
					""+'\n'+
					"inRoom"+'\n'+
					""+'\n'+
					"Room Contents: "+'\n'+
					"", strin);
			
			assertEquals("Your key works! The door creaks open,"+'\n'+
					"and slams behind you after you pass through."+'\n'+
					""+'\n'+
					"outRoom"+'\n'+
					""+'\n'+
					"Room Contents: "+'\n'+
					"", strout);
		}
		
		//enter a door from WRONG outside 
		// with correct key
		@Test
		public void EnterNoAccessRoom() {
			Room out;
			Room in;
			Room noAccess;
			Key key = new Key();
			Door door;
			Player aPlayer;
					
			out = new Room();
			in = new Room();
			noAccess = new Room();
			door = new Door(out,in,key);
			aPlayer = new Player();
					
			out.addItem(key);
			aPlayer.setRoom(noAccess);
					
			aPlayer.pickUp(key);
					
			aPlayer.setRoom(noAccess);
					
			in.setDesc("inRoom");
			out.setDesc("outRoom");
					
			String strin = door.enter(aPlayer);	
			
			assertEquals("Your key works! The door creaks open,"+'\n'+
					"and slams behind you after you pass through."+'\n'+
					""+'\n'+
					"", strin);
		}
	
}
