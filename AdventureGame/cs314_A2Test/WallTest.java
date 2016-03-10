package cs314_A2Test;

//Author: Kerry McKean
//Tests the method in Wall.java

import cs314_A2.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class WallTest {

	@Test
	public void enterTest(){
		Player guy = new Player();
		Wall theWall = new Wall();
		assertTrue(theWall.enter(guy).equals("Ouch! That hurts."));
	}
}

