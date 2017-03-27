package com.example.facepamphlet.buttons;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import com.example.facepamphlet.ActionButton;
import com.example.facepamphlet.FacePamphletCanvas;
import com.example.facepamphlet.FacePamphletDatabase;
import com.example.facepamphlet.FacePamphletProfile;
import com.example.facepamphlet.SharedData;

import acm.program.Program;

public class AdministrationButton extends ActionButton {
	public AdministrationButton(Program program, SharedData data) {
		super(program, data);
	}
	@Override
	public String getText() {
		return "Administration Page";
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
		
		FacePamphletCanvas canvas = data.getData("canvas", FacePamphletCanvas.class);
		canvas.removeAll();
		if (this.button.getText().equals("Return to User Profile")) {
			this.button.setText("Administration Page");
			canvas.displayProfile(current);
		} else {
			this.button.setText("Return to User Profile");
			
			FacePamphletDatabase database = data.getData("database", FacePamphletDatabase.class);
			String profiles = "<html>";
			for (FacePamphletProfile profile : database.getProfiles()) {
				profiles += profile.toString() + "<br>";
			}
			profiles += "</html>";
			canvas.add(new JLabel(profiles));
		}
	}
}