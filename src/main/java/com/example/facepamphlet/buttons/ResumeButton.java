package com.example.facepamphlet.buttons;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.example.facepamphlet.FacePamphletCanvas;
import com.example.facepamphlet.FacePamphletProfile;
import com.example.facepamphlet.ResumeItem;
import com.example.facepamphlet.SharedData;
import static com.example.facepamphlet.FacePamphletConstants.*;

import acm.graphics.GLabel;
import acm.program.Program;

public class ResumeButton extends ActionButton {
	private ActionButton addItemButton;
	
	public ResumeButton(Program program, SharedData data) {
		super(program, data);
		this.addItemButton = new AddResumeItemButton(program, data);
	}
	@Override
	public String getText() {
		return "Work and Education";
	}
	@Override
	public String getPlacement() {
		return Program.NORTH;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		FacePamphletProfile current = data.getData("currentProfile", FacePamphletProfile.class);
		if (current == null) {
			return;
		}
		
		JTextField startField = new JTextField("Start date (mm/dd/yyyy)");
		JTextField endField = new JTextField("End date (mm/dd/yyyy)");
		JComboBox typeField = new JComboBox(new String[] {"work", "school"});
		JTextField placeField = new JTextField("Place of employment/school");
		data.setData("startField", startField);
		data.setData("endField", endField);
		data.setData("placeField", placeField);
		data.setData("typeField", typeField);
		data.setData("resumeButton", this);
		
		FacePamphletCanvas canvas = data.getData("canvas", FacePamphletCanvas.class);
		canvas.removeAll();
		if (this.button.getText().equals("Return to Profile Page")) {
			this.button.setText("Work and Education");
			canvas.displayProfile(data.getData("currentProfile", FacePamphletProfile.class));
		} else {
			this.button.setText("Return to Profile Page");
			
			String resume = "<html>";
			resume += "<b>Work Resume</b><br>";
			for (ResumeItem item : current.getResumeByType("work")) {
				resume += item.toString() + "<br>";
			}
			
			resume += "<br><br><br>";
			
			resume += "<b>School Resume</b><br>";
			for (ResumeItem item : current.getResumeByType("school")) {
				resume += item.toString() + "<br>";
			}
			resume += "</html>";
			canvas.add(new JLabel(resume), LEFT_MARGIN, TOP_MARGIN);
			canvas.add(startField, canvas.getWidth()/2, TOP_MARGIN);
			canvas.add(endField, canvas.getWidth()/2, TOP_MARGIN + 30);
			canvas.add(typeField, canvas.getWidth()/2, TOP_MARGIN + 60);
			canvas.add(placeField, canvas.getWidth()/2, TOP_MARGIN + 90);
			canvas.add(addItemButton.getButton(), canvas.getWidth()/2, TOP_MARGIN + 120);
		}
	}
}
