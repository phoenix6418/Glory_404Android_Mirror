package cs314_A2Test;

//Author: Kerry McKean
//Tests the methods in Item.java

import cs314_A2.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ItemTest {

	@Test
	public void descriptionTest(){
		Item theItem = new Item();
		assertTrue(theItem.getDesc() == null);
		theItem.setDesc("This item is the sword of testing.");
		assertTrue(theItem.getDesc() == theItem.toString());
		assertTrue(theItem.toString() == "This item is the sword of testing.");
	}
}