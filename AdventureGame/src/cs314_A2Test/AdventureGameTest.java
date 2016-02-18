package cs314_A2Test;
import cs314_A2.*;
/**
Team: Glory404
Members: David Sahud, Xuehao(David) Hu, Bolin Liu, Kerry McKean.
**/
//Written by: David Sahud

import cs314_A2.*;
import static org.junit.Assert.*;

import org.junit.Test;
public class AdventureGameTest {
	//Written by: David Sahud
	@Test
	public void convertDirectionTest() {		
		AdventureGame game = new AdventureGame();
		assertEquals(game.convertDirection("w"),game.convertDirection("W"));
		assertEquals(3,game.convertDirection("W"));
		assertTrue(game.convertDirection("E") >= 0 && game.convertDirection("E") <= 5);
		assertTrue(game.convertDirection("z") < 0 || game.convertDirection("z") > 5);
	}

}
