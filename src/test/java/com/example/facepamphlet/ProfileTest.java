package com.example.facepamphlet;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProfileTest {
	@Test
	public void testResumeItems() {
		FacePamphletProfile profile = new FacePamphletProfile("Mike");
		profile.addResumeItem(new ResumeItem("Old-School-Cool", "school", "01/30/1996", "03/27/2014"));
		profile.addResumeItem(new ResumeItem("Rose-Hulman", "school", "01/30/2015", "03/27/2017"));
		profile.addResumeItem(new ResumeItem("JobPlace1", "work", "01/30/1996", "03/27/2014"));
		profile.addResumeItem(new ResumeItem("JobPlace2", "work", "01/30/1996", "03/27/2014"));
		
		assertEquals("[01/30/1996 - 03/27/2014: Old-School-Cool, 01/30/2015 - 03/27/2017: Rose-Hulman]", profile.getResumeByType("school").toString());
		assertEquals("[01/30/1996 - 03/27/2014: JobPlace1, 01/30/1996 - 03/27/2014: JobPlace2]", profile.getResumeByType("work").toString());
	}
}
