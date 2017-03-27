package com.example.facepamphlet.buttons;

import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.example.facepamphlet.FacePamphletProfile;
import com.example.facepamphlet.ResumeItem;
import com.example.facepamphlet.SharedData;

import acm.program.Program;

public class AddResumeItemButton extends ActionButton {

	public AddResumeItemButton(Program program, SharedData data) {
		super(program, data);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FacePamphletProfile current = data.getData("currentProfile", FacePamphletProfile.class);
		if (current == null || data.getData("startField", JTextField.class) == null) {
			return;
		}
		
		JTextField start = data.getData("startField", JTextField.class);
		JTextField end = data.getData("endField", JTextField.class);
		JTextField place = data.getData("placeField", JTextField.class);
		JComboBox<String> type = data.getData("typeField", JComboBox.class);
		String selected = type.getSelectedItem().toString();
		
		current.addResumeItem(new ResumeItem(place.getText(), selected, start.getText(), end.getText()));
		ActionButton resume = data.getData("resumeButton", ActionButton.class);
		resume.getButton().setText("Work and Education");
		resume.actionPerformed(e);
	}

	@Override
	public String getText() {
		return "Add New Entry";
	}

	@Override
	public String getPlacement() {
		return Program.EAST;
	}

}
