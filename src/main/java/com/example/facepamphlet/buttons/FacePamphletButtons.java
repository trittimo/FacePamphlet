package com.example.facepamphlet.buttons;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import com.example.facepamphlet.FacePamphletCanvas;
import com.example.facepamphlet.FacePamphletDatabase;
import com.example.facepamphlet.FacePamphletProfile;
import com.example.facepamphlet.SharedData;

import acm.graphics.GImage;
import acm.program.Program;
import acm.util.ErrorException;

/**
 * A container class for the buttons in this application
 * Easier than making a class for each button, but this
 * is just convenience.
 */
public class FacePamphletButtons {
	public static class AddButton extends ActionButton {
		public AddButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return "Add";
		}
		@Override
		public String getPlacement() {
			return Program.NORTH;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			FacePamphletDatabase profileInfo = data.getData("database", FacePamphletDatabase.class);
			String enteredName = data.getData("nameField", JTextField.class).getText();
			FacePamphletCanvas canvas = data.getData("canvas", FacePamphletCanvas.class);
			//if the entered name does not exist in the database, a profile is created
    		if(profileInfo.containsProfile(enteredName) == false) {
    			FacePamphletProfile profile = new FacePamphletProfile(enteredName);
    			profileInfo.addProfile(profile);
    			canvas.displayProfile(profile);
    			canvas.showMessage("New profile created");
    			data.setData("currentProfile", profile);
    		}
    		//if the entered name is already an existing profile, displays the profile
    		//and tells the user that the profile already exists
    		else{
    			FacePamphletProfile profile = profileInfo.getProfile(enteredName);
    			canvas.displayProfile(profile);
    			canvas.showMessage("A profile with name " + enteredName + " already exists.");
    			data.setData("currentProfile", profile);
    		}
		}
	}
	public static class DeleteButton extends ActionButton {
		public DeleteButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return "Delete";
		}
		@Override
		public String getPlacement() {
			return Program.NORTH;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			FacePamphletDatabase profileInfo = data.getData("database", FacePamphletDatabase.class);
			String enteredName = data.getData("nameField", JTextField.class).getText();
			FacePamphletCanvas canvas = data.getData("canvas", FacePamphletCanvas.class);
			//clears the canvas and sets the current profile to null
    		canvas.removeAll();
    		data.removeData("currentProfile");
    		//if the entered name exists as a profile, the profile is deleted
    		if(profileInfo.containsProfile(enteredName) == true) {
    			profileInfo.deleteProfile(enteredName);
    			canvas.showMessage("Profile of " + enteredName + " deleted");
    		}
    		//if the entered name is not an actual profile, tells the user 
    		//that the profile does not exist
    		else{
    			canvas.showMessage("A profile with name " + enteredName + " does not exist.");
    		}
		}
	}
	
	public static class LookupButton extends ActionButton {
		public LookupButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return "Lookup";
		}
		@Override
		public String getPlacement() {
			return Program.NORTH;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			FacePamphletDatabase profileInfo = data.getData("database", FacePamphletDatabase.class);
			String enteredName = data.getData("nameField", JTextField.class).getText();
			FacePamphletCanvas canvas = data.getData("canvas", FacePamphletCanvas.class);
			canvas.removeAll(); //clears everything off the canvas
    		//if the entered name exists in the database, displays the profile
    		if (profileInfo.containsProfile(enteredName) == true) {
    			FacePamphletProfile profile = profileInfo.getProfile(enteredName);
    			canvas.displayProfile(profile);
    			canvas.showMessage("Displaying " + enteredName);
    			data.setData("currentProfile", profile);
    		}
    		//if the entered name does not exists, tells the user it doesn't exist
    		//and sets current profile to null
    		else {
    			canvas.showMessage("A profile with name " + enteredName + " does not exist.");
    			data.removeData("currentProfile");
    		}
		}
	}
	
	public static class StatusButton extends ActionButton {
		public StatusButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return "Change Status";
		}
		@Override
		public String getPlacement() {
			return Program.WEST;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			FacePamphletDatabase profileInfo = data.getData("database", FacePamphletDatabase.class);
			FacePamphletCanvas canvas = data.getData("canvas", FacePamphletCanvas.class);
			JTextField status = data.getData("statusField", JTextField.class);
			FacePamphletProfile currentProfile = data.getData("currentProfile", FacePamphletProfile.class);
			String statusMessage = status.getText();
    		if(currentProfile != null) {
    			FacePamphletProfile profile = profileInfo.getProfile(currentProfile.getName());
    			profile.setStatus(profile.getName() + " is " + statusMessage);
    			canvas.displayProfile(profile);
    			canvas.showMessage("Status updated to " + statusMessage);
    		}
    		else{
    			canvas.showMessage("Please select a profile to change status");
    		}
		}
	}
	public static class PictureButton extends ActionButton {
		public PictureButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return "Change Picture";
		}
		@Override
		public String getPlacement() {
			return Program.WEST;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			FacePamphletDatabase profileInfo = data.getData("database", FacePamphletDatabase.class);
			FacePamphletCanvas canvas = data.getData("canvas", FacePamphletCanvas.class);
			JTextField picture = data.getData("pictureField", JTextField.class);
			FacePamphletProfile currentProfile = data.getData("currentProfile", FacePamphletProfile.class);
			String filename = picture.getText();
    		if(currentProfile != null) {
    			FacePamphletProfile profile = profileInfo.getProfile(currentProfile.getName());
    			GImage image = null;
    			try {
    				image = new GImage(filename);
    				profile.setImage(image);
    			} catch (ErrorException ex) {
    				image = null;
    			}
    			canvas.displayProfile(profile);
    			if(image == null) {
    				canvas.showMessage("Unable to open image file: " + filename);
    			}
    			else{
    				canvas.showMessage("Picture updated");
    			}
    		}
    		else{
    			canvas.showMessage("Please select a profile to change picture");
    		}
		}
	}
	public static class FriendButton extends ActionButton {
		public FriendButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return "Add Friend";
		}
		@Override
		public String getPlacement() {
			return Program.WEST;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			FacePamphletDatabase profileInfo = data.getData("database", FacePamphletDatabase.class);
			FacePamphletCanvas canvas = data.getData("canvas", FacePamphletCanvas.class);
			JTextField friend = data.getData("friendField", JTextField.class);
			FacePamphletProfile currentProfile = data.getData("currentProfile", FacePamphletProfile.class);
			String enteredName = data.getData("nameField", JTextField.class).getText();
			String friendName = friend.getText();
			System.out.println("name = " + friendName);
    		//checks to see if there is a current profile
    		if(currentProfile != null) {
    			FacePamphletProfile profile = profileInfo.getProfile(currentProfile.getName());
    			//checks to see if the name entered is the users name. The user can't friend him/herself. 
    			if(profile.getName().equals(friendName)) {
    				canvas.showMessage("You cannot friend yourself");
    			}
    			//checks to see if the friend exists in the database
    			else if (profileInfo.containsProfile(friendName)) {
    				FacePamphletProfile friendProfile = profileInfo.getProfile(friendName);
    				//checks to see if the user is already friends with the friend name entered
    				
    				//if the user and the friend entered are not friends, makes them friends
    				if (profile.addFriend(friendName) == true) {
    					profile.addFriend(friendName);
    					friendProfile.addFriend(enteredName);
    					canvas.displayProfile(profile);
    					canvas.showMessage(friendName + " added as a friend.");
    				}
    				//if the user is already friends with the friend name entered, displays this message
    				else {
    					canvas.showMessage(profile.getName() + " already has " + friendName + " as a friend.");
    				}
    			}
    			//if the friend does not exist in the database, displays this message
    			else{
    				canvas.showMessage(friendName + " does not exist.");
    			}
    		}	
    		//if there is not current profile, asks user to select a profile
    		else{
    			canvas.showMessage("Please select a profile to add friend");
    		}
		}
	}
}
