package com.example.facepamphlet;
/* 
 * File: FacePamphlet.java
 * -----------------------
 * When it is finished, this program will implement a basic social network
 * management system.
 */

import static com.example.facepamphlet.FacePamphletConstants.*;

import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import java.util.HashMap;

import javax.swing.*;

import com.example.facepamphlet.buttons.*;
import com.example.facepamphlet.buttons.FacePamphletButtons.AddButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.DeleteButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.FriendButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.LookupButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.PictureButton;
import com.example.facepamphlet.buttons.FacePamphletButtons.StatusButton;

public class FacePamphlet extends Program  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 133276188638963785L;
	
	private FacePamphletCanvas canvas = new FacePamphletCanvas();
	
	//keeps track of the current profile
	private FacePamphletProfile currentProfile = null;
	
	private HashMap<JButton, ActionButton> buttonMap = new HashMap<>();
	
	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	@Override
	public void init() {
		SharedData data = new SharedData();
		
		// All of our buttons
		ActionButton addButton = new AddButton(this, data);
		ActionButton deleteButton = new DeleteButton(this, data);
		ActionButton lookupButton = new LookupButton(this, data);
		ActionButton statusButton = new StatusButton(this, data);
		ActionButton pictureButton = new PictureButton(this, data);
		ActionButton friendButton = new FriendButton(this, data);
		ActionButton administrationButton = new AdministrationButton(this, data);
		ActionButton resumeButton = new ResumeButton(this, data);
		
		buttonMap.put(addButton.getButton(), addButton);
		buttonMap.put(deleteButton.getButton(), deleteButton);
		buttonMap.put(lookupButton.getButton(), lookupButton);
		buttonMap.put(statusButton.getButton(), statusButton);
		buttonMap.put(pictureButton.getButton(), pictureButton);
		buttonMap.put(friendButton.getButton(), friendButton);
		buttonMap.put(administrationButton.getButton(), administrationButton);
		buttonMap.put(resumeButton.getButton(), resumeButton);
		
		
		JTextField name = new JTextField(TEXT_FIELD_SIZE);
		JTextField status = new JTextField(TEXT_FIELD_SIZE);
		JTextField picture = new JTextField(TEXT_FIELD_SIZE);
		JTextField friend = new JTextField(TEXT_FIELD_SIZE);
		
		// Setup shared data
		data.setData("nameField", name);
		data.setData("statusField", status);
		data.setData("pictureField", picture);
		data.setData("friendField", friend);
		data.setData("database", new FacePamphletDatabase());
		data.setData("canvas", this.canvas);
		data.setData("program", this);
		
		// Add the buttons/fields/etc. to the program
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
		
		add(this.canvas);
		this.setSize(1200,900);
    }
	
    @Override
	public void actionPerformed(ActionEvent e) {
    	if (buttonMap.containsKey(e.getSource())) {
    		buttonMap.get(e.getSource()).actionPerformed(e);
    	} else {
    		System.out.println("There is no button associated with the action");
    	}
    }
}
