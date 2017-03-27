package com.example.facepamphlet;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResumeItemTest {
	@Test
	public void testResumeItem() {
		ResumeItem item = new ResumeItem("Old-School-Cool", "school", "01/30/1996", "03/27/2014");
		assertEquals("01/30/1996 - 03/27/2014: Old-School-Cool", item.toString());
	}
}
