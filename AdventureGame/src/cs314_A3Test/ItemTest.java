package cs314_A3Test;

//Author: Kerry McKean
//Tests the methods in Item.java
/**
 Team: Glory404
 Members: David Sahud, Xuehao(David) Hu, Bolin Liu, Kerry McKean.
 **/
import cs314_A3.*;
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