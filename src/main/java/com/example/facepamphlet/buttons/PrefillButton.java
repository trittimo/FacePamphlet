package com.example.facepamphlet.buttons;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.example.facepamphlet.FacePamphletCanvas;
import com.example.facepamphlet.FacePamphletDatabase;
import com.example.facepamphlet.FacePamphletProfile;
import com.example.facepamphlet.SharedData;

import acm.program.Program;

public class PrefillButton extends ActionButton {
	private boolean prefilled = false;
	
	public PrefillButton(Program program, SharedData data) {
		super(program, data);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (prefilled) {
			return;
		}
		Path path = Paths.get("save.txt");
		Path current = Paths.get("current.txt");
		if (!path.toFile().exists() || !current.toFile().exists()) {
			System.out.println("Unable to load save file!");
			return;
		}
		try {
			FileInputStream fin = new FileInputStream(path.toFile());
			ObjectInputStream in = new ObjectInputStream(fin);
			FacePamphletDatabase database = (FacePamphletDatabase) in.readObject();
			fin.close();
			in.close();
			
			fin = new FileInputStream(current.toFile());
			in = new ObjectInputStream(fin);
			FacePamphletProfile c = (FacePamphletProfile) in.readObject();
			fin.close();
			in.close();
			data.setData("database", database);
			data.setData("currentProfile", c);
			data.getData("canvas", FacePamphletCanvas.class).displayProfile(c);
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	@Override
	public String getText() {
		return "Prefill Application";
	}

	@Override
	public String getPlacement() {
		return Program.NORTH;
	}

}
