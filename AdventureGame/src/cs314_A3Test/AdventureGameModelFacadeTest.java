package cs314_A3Test;

import static org.junit.Assert.*;

import org.junit.Test;
import cs314_A2.AdventureGameModelFacade;

public class AdventureGameModelFacadeTest {

	@Test
	public void getViewTest() {
		AdventureGameModelFacade facadeTest = new AdventureGameModelFacade();

		String expectedStr="You are standing outside, on the edge of a cliff;"+'\n'+
							" A creek runs alongside the cliff."+'\n'+
							"a cave opens straight down (outside)."+'\n'+
							""+'\n'+"Room Contents: "+'\n'+
							"";	
		assertTrue(facadeTest.getView().equals(expectedStr));
	}
	
}
