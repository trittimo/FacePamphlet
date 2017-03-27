package com.example.facepamphlet;

import java.io.Serializable;

public class ResumeItem implements Serializable {
	public String dateStart;
	public String dateEnd;
	public String place;
	public String type;
	public ResumeItem(String place, String type, String start, String end) {
		this.place = place;
		this.dateStart = start;
		this.dateEnd = end;
		this.type = type;
	}
	
	@Override
	public String toString() {
		return dateStart + " - " + dateEnd + ": " + place;
	}
}
