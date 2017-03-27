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
import javax.swing.*;

import com.example.facepamphlet.FacePamphletButtons.AddButton;
import com.example.facepamphlet.FacePamphletButtons.AdministrationButton;
import com.example.facepamphlet.FacePamphletButtons.DeleteButton;
import com.example.facepamphlet.FacePamphletButtons.FriendButton;
import com.example.facepamphlet.FacePamphletButtons.LookupButton;
import com.example.facepamphlet.FacePamphletButtons.PictureButton;
import com.example.facepamphlet.FacePamphletButtons.ResumeButton;
import com.example.facepamphlet.FacePamphletButtons.StatusButton;

public class FacePamphlet extends Program  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 133276188638963785L;
	
	//creates a new database and a new canvas
	private FacePamphletDatabase profileInfo = new FacePamphletDatabase();
	private FacePamphletCanvas canvas = new FacePamphletCanvas();
	
	//keeps track of the current profile
	private FacePamphletProfile currentProfile = null;
	
	
	/**
	 * This method has the responsibility for initializing the 
	 * interactors in the application, and taking care of any other 
	 * initialization that needs to be performed.
	 */
	@Override
	public void init() {
		SharedData data = new SharedData();
		
		ActionButton addButton = new AddButton(this, data);
		ActionButton deleteButton = new DeleteButton(this, data);
		ActionButton lookupButton = new LookupButton(this, data);
		ActionButton statusButton = new StatusButton(this, data);
		ActionButton pictureButton = new PictureButton(this, data);
		ActionButton friendButton = new FriendButton(this, data);
		ActionButton administrationButton = new AdministrationButton(this, data);
		ActionButton resumeButton = new ResumeButton(this, data);
		
		add(new JLabel("Name "), NORTH); 
		
		JTextField name = new JTextField(TEXT_FIELD_SIZE);
		add(name, NORTH);
		
		data.setData("nameField", name);
		
		add(addButton.getButton(), addButton.getPlacement());
		
		add(deleteButton.getButton(), deleteButton.getPlacement());
		
		add(lookupButton.getButton(), lookupButton.getPlacement());
		
		JTextField status = new JTextField(TEXT_FIELD_SIZE);
		add(status, WEST);
		
		data.setData("statusField", status);
		
		add(statusButton.getButton(), statusButton.getPlacement());
		
		add(new JLabel(EMPTY_LABEL_TEXT), WEST);
		
		JTextField picture = new JTextField(TEXT_FIELD_SIZE);
		add(picture, WEST);
		
		data.setData("pictureField", picture);
		
		add(pictureButton.getButton(), pictureButton.getPlacement());
		
		add(new JLabel(EMPTY_LABEL_TEXT), WEST); //space holder
		
		JTextField friend = new JTextField(TEXT_FIELD_SIZE);
		add(friend, WEST);
		
		data.setData("friendField", picture);
		
		add(friendButton.getButton(), friendButton.getPlacement());
		
//		add(new JButton("Administration Page"), Program.NORTH);
//		add(new JButton("Education and Work History"), Program.NORTH);
		
		//Action listeners
		addActionListeners();
		
		status.addActionListener(statusButton);
		picture.addActionListener(pictureButton);
		friend.addActionListener(friendButton);
		
		add(this.canvas);
		this.setSize(1200,900);
    }
	
    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    @Override
	public void actionPerformed(ActionEvent e) {
//		
//    	
//    	String enteredName = this.name.getText();
//    	
//    	//Add button is clicked
//    	if(e.getActionCommand().equals("Add") && !this.name.getText().equals("")) {
//    		//if the entered name does not exist in the database, a profile is created
//    		if(this.profileInfo.containsProfile(enteredName) == false) {
//    			FacePamphletProfile profile = new FacePamphletProfile(enteredName);
//    			this.profileInfo.addProfile(profile);
//    			this.canvas.displayProfile(profile);
//    			this.canvas.showMessage("New profile created");
//    			this.currentProfile = profile;
//    		}
//    		//if the entered name is already an existing profile, displays the profile
//    		//and tells the user that the profile already exists
//    		else{
//    			FacePamphletProfile profile = this.profileInfo.getProfile(enteredName);
//    			this.canvas.displayProfile(profile);
//    			this.canvas.showMessage("A profile with name " + enteredName + " already exists.");
//    			this.currentProfile = profile;
//    		}
//    	}
//    	
//    	//Delete button is clicked
//    	else if (e.getActionCommand().equals("Delete") && !this.name.getText().equals("")){
//    		//clears the canvas and sets the current profile to null
//    		this.canvas.removeAll();
//    		this.currentProfile = null;
//    		//if the entered name exists as a profile, the profile is deleted
//    		if(this.profileInfo.containsProfile(enteredName) == true) {
//    			this.profileInfo.deleteProfile(enteredName);
//    			this.canvas.showMessage("Profile of " + enteredName + " deleted");
//    		}
//    		//if the entered name is not an actual profile, tells the user 
//    		//that the profile does not exist
//    		else{
//    			this.canvas.showMessage("A profile with name " + enteredName + " does not exist.");
//    		}
//    	}
//    	
//    	//Lookup button is clicked
//    	else if (e.getActionCommand().equals("Lookup") && !this.name.getText().equals("")){
//    		this.canvas.removeAll(); //clears everything off the canvas
//    		//if the entered name exists in the database, displays the profile
//    		if(this.profileInfo.containsProfile(enteredName) == true) {
//    			FacePamphletProfile profile = this.profileInfo.getProfile(enteredName);
//    			this.canvas.displayProfile(profile);
//    			this.canvas.showMessage("Displaying " + enteredName);
//    			this.currentProfile = profile;
//    		}
//    		//if the entered name does not exists, tells the user it doesn't exist
//    		//and sets current profile to null
//    		else{
//    			this.canvas.showMessage("A profile with name " + enteredName + " does not exist.");
//    			this.currentProfile = null;
//    		}
//    	}
//    	
//    	//Change Status is clicked or user clicked enter after entering a status in the text field
//    	else if (e.getActionCommand().equals("Change Status") || e.getSource() == this.status && !this.status.getText().equals("")){
//    		String statusMessage = this.status.getText();
//    		if(this.currentProfile != null) {
//    			FacePamphletProfile profile = this.profileInfo.getProfile(this.currentProfile.getName());
//    			profile.setStatus(profile.getName() + " is " + statusMessage);
//    			this.canvas.displayProfile(profile);
//    			this.canvas.showMessage("Status updated to " + statusMessage);
//    		}
//    		else{
//    			this.canvas.showMessage("Please select a profile to change status");
//    		}
//    	}
//    	
//    	//Change Picture is clicked or user clicked enter after entering picture name into the text field
//    	else if (e.getActionCommand().equals("Change Picture") || e.getSource() == this.picture && !this.picture.getText().equals("")){
//    		String filename = this.picture.getText();
//    		if(this.currentProfile != null) {
//    			FacePamphletProfile profile = this.profileInfo.getProfile(this.currentProfile.getName());
//    			GImage image = null;
//    			try {
//    				image = new GImage(filename);
//    				profile.setImage(image);
//    			} catch (ErrorException ex) {
//    				image = null;
//    			}
//    			this.canvas.displayProfile(profile);
//    			if(image == null) {
//    				this.canvas.showMessage("Unable to open image file: " + filename);
//    			}
//    			else{
//    				this.canvas.showMessage("Picture updated");
//    			}
//    		}
//    		else{
//    			println("Please select a profile to change picture");
//    		}
//    	}
//    	
//    	//Add Friend is clicked or user clicked enter after entering a friends name into the text field
//    	else if (e.getActionCommand().equals("Add Friend") || e.getSource() == this.friend && !this.friend.getText().equals("")){
//    		String friendName = this.friend.getText();
//    		//checks to see if there is a current profile
//    		if(this.currentProfile != null) {
//    			FacePamphletProfile profile = this.profileInfo.getProfile(this.currentProfile.getName());
//    			//checks to see if the name entered is the users name. The user can't friend him/herself. 
//    			if(profile.getName().equals(friendName)) {
//    				this.canvas.showMessage("You cannot friend yourself");
//    			}
//    			//checks to see if the friend exists in the database
//    			else if(this.profileInfo.containsProfile(friendName)) {
//    				FacePamphletProfile friendProfile = this.profileInfo.getProfile(friendName);
//    				//checks to see if the user is already friends with the friend name entered
//    				
//    				//if the user and the friend entered are not friends, makes them friends
//    				if(profile.addFriend(friendName) == true) {
//    					profile.addFriend(friendName);
//    					friendProfile.addFriend(enteredName);
//    					this.canvas.displayProfile(profile);
//    					this.canvas.showMessage(friendName + " added as a friend.");
//    				}
//    				//if the user is already friends with the friend name entered, displays this message
//    				else {
//    					this.canvas.showMessage(profile.getName() + " already has " + friendName + " as a friend.");
//    				}
//    			}
//    			//if the friend does not exist in the database, displays this message
//    			else{
//    				this.canvas.showMessage(friendName + " does not exist.");
//    			}
//    		}	
//    		//if there is not current profile, asks user to select a profile
//    		else{
//    			this.canvas.showMessage("Please select a profile to add friend");
//    		}
//    	} else if (e.getActionCommand().equals("Administration Page")){
//    		this.canvas.showMessage("Hello world");
//    		//checks to see if there is a current profile
////    		if(this.currentProfile != null) {
////    			FacePamphletProfile profile = this.profileInfo.getProfile(this.currentProfile.getName());
////    			//checks to see if the name entered is the users name. The user can't friend him/herself. 
////    			if(profile.getName().equals(friendName)) {
////    				this.canvas.showMessage("You cannot friend yourself");
////    			}
////    			//checks to see if the friend exists in the database
////    			else if(this.profileInfo.containsProfile(friendName)) {
////    				FacePamphletProfile friendProfile = this.profileInfo.getProfile(friendName);
////    				//checks to see if the user is already friends with the friend name entered
////    				
////    				//if the user and the friend entered are not friends, makes them friends
////    				if(profile.addFriend(friendName) == true) {
////    					profile.addFriend(friendName);
////    					friendProfile.addFriend(enteredName);
////    					this.canvas.displayProfile(profile);
////    					this.canvas.showMessage(friendName + " added as a friend.");
////    				}
////    				//if the user is already friends with the friend name entered, displays this message
////    				else {
////    					this.canvas.showMessage(profile.getName() + " already has " + friendName + " as a friend.");
////    				}
////    			}
////    			//if the friend does not exist in the database, displays this message
////    			else{
////    				this.canvas.showMessage(friendName + " does not exist.");
////    			}
////    		}	
////    		//if there is not current profile, asks user to select a profile
////    		else{
////    			this.canvas.showMessage("Please select a profile to add friend");
////    		}
//    	}	
    }
}
