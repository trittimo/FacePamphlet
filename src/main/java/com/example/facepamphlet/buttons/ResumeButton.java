package com.example.facepamphlet.buttons;

import java.awt.event.ActionEvent;

import com.example.facepamphlet.ActionButton;
import com.example.facepamphlet.SharedData;

import acm.program.Program;

public class ResumeButton extends ActionButton {
	
	public ResumeButton(Program program, SharedData data) {
		super(program, data);
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
		
	}
}
