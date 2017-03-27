package com.example.facepamphlet.buttons;

import java.awt.event.ActionEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.example.facepamphlet.FacePamphletDatabase;
import com.example.facepamphlet.FacePamphletProfile;
import com.example.facepamphlet.SharedData;

import acm.program.Program;

public class SaveButton extends ActionButton {

	public SaveButton(Program program, SharedData data) {
		super(program, data);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Path path = Paths.get("save.txt");
		Path current = Paths.get("current.txt");
		try {
			FileOutputStream fout = new FileOutputStream(path.toFile());
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(data.getData("database", FacePamphletDatabase.class));
			fout.close();
			out.close();
			fout = new FileOutputStream(current.toFile());
			out = new ObjectOutputStream(fout);
			out.writeObject(data.getData("currentProfile", FacePamphletProfile.class));
			fout.close();
			out.close();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	@Override
	public String getText() {
		return "Save";
	}

	@Override
	public String getPlacement() {
		return Program.NORTH;
	}

}
