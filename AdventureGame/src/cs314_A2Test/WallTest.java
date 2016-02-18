package cs314_A2Test;

//Author: Kerry McKean

import cs314_A2.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class WallTest {

	@Test
	public void enterTest(){
		Player guy = new Player();
		Room troom = new Room();
		guy.setRoom(troom);
		assertTrue(troom.enter(guy)=="Ouch! That hurts.");
		assertTrue(guy.getLoc() == troom);
	}
}

