package com.example.facepamphlet;
/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import static com.example.facepamphlet.FacePamphletConstants.EMPTY_LABEL_TEXT;
import static com.example.facepamphlet.FacePamphletConstants.TEXT_FIELD_SIZE;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.example.facepamphlet.buttons.ActionButton;
import com.example.facepamphlet.buttons.AdministrationButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.AddButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.DeleteButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.FriendButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.LookupButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.PictureButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.StatusButton;
import com.example.facepamphlet.buttons.PrefillButton;
import com.example.facepamphlet.buttons.ResumeButton;
import com.example.facepamphlet.buttons.SaveButton;

import acm.program.Program;

/*
 * Refactored -- This class
 * Reason -- It was a huge mess of if/else statements
 * Main type of refactoring done -- 
 */

/*
 * Feature -- Added buttons for adding/viewing a resume, viewing the admin page, and pre-filling with some data
 *            Only like 6 lines of added code from the original refactor
 * Changed -- Didn't have to change any code from the original refactor
 */
public class FacePamphlet extends Program  {

	private static final long serialVersionUID = 133276188638963785L;	
	
	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	@Override
	public void init() {
		SharedData data = new SharedData();
		
		// All of our buttons
		ActionButton prefillButton = new PrefillButton(this, data);
		ActionButton addButton = new AddButton(this, data);
		ActionButton deleteButton = new DeleteButton(this, data);
		ActionButton lookupButton = new LookupButton(this, data);
		ActionButton statusButton = new StatusButton(this, data);
		ActionButton pictureButton = new PictureButton(this, data);
		ActionButton friendButton = new FriendButton(this, data);
		ActionButton administrationButton = new AdministrationButton(this, data);
		ActionButton resumeButton = new ResumeButton(this, data);
		ActionButton saveButton = new SaveButton(this, data);
		
		
		JTextField name = new JTextField(TEXT_FIELD_SIZE);
		JTextField status = new JTextField(TEXT_FIELD_SIZE);
		JTextField picture = new JTextField(TEXT_FIELD_SIZE);
		JTextField friend = new JTextField(TEXT_FIELD_SIZE);
		
		// Setup shared data
		FacePamphletCanvas canvas = new FacePamphletCanvas();
		
		data.setData("nameField", name);
		data.setData("statusField", status);
		data.setData("pictureField", picture);
		data.setData("friendField", friend);
		data.setData("database", new FacePamphletDatabase());
		data.setData("canvas", canvas);
		data.setData("program", this);
		
		// Add the buttons/fields/etc. to the program
		add(prefillButton.getButton(), prefillButton.getPlacement());
		add(saveButton.getButton(), saveButton.getPlacement());
		add(new JLabel("Name "), NORTH);
		add(name, NORTH);
		add(addButton.getButton(), addButton.getPlacement());
		add(deleteButton.getButton(), deleteButton.getPlacement());
		add(lookupButton.getButton(), lookupButton.getPlacement());
		add(status, WEST);
		add(statusButton.getButton(), statusButton.getPlacement());
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		add(picture, WEST);
		add(pictureButton.getButton(), pictureButton.getPlacement());
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		add(friend, WEST);
		add(friendButton.getButton(), friendButton.getPlacement());
		add(administrationButton.getButton(), administrationButton.getPlacement());
		add(resumeButton.getButton(), resumeButton.getPlacement());
		
		
		// Add action listeners to the program
		addActionListeners();
		
		status.addActionListener(statusButton);
		picture.addActionListener(pictureButton);
		friend.addActionListener(friendButton);
		
		add(canvas);
		this.setSize(1200,900);
    }
}
