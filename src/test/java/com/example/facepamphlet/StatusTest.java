package com.example.facepamphlet;

import static org.junit.Assert.*;

import org.junit.Test;

public class StatusTest {

	FacePamphletProfile uut = new FacePamphletProfile("Louie");

	// Normally I would use a mocking framework but in the interest of not bloating this .rar file
	// I have omitted it and the test is really simple.
	@Test
	public void testSetAndGetStatus() {
		String status = "EATING TENNIS BALL";
		
		uut.setStatus(status);
		
		assertEquals(status, uut.getStatus());
	}
	
	@Test
	public void testPastStatuses(){
		String[] status = {"EATING TENNIS BALL",
				"WOOF WOOF WOOF",
				"UPS MAN",
				"DINNER!",
				"MUST CATCH TAIL"
		};
		
		// Cycle through all the statuses in order
		for( String s : status ){
			uut.setStatus(s);
		}
		
		// Assert that the current status is the last one in
		assertEquals(status[status.length-1], uut.getStatus());
		
		// Make sure our list has stuff in it (all but the last status)
		assertTrue( uut.getPastStatuses().size() == status.length - 1 );
		
		// Assert that, for all items in our queue, they match with the correct
		// status from our array
		int i = 0;
		while( !uut.getPastStatuses().isEmpty() ){
			assertEquals( uut.getPastStatuses().poll(), status[i++]);
		}
	}
}
