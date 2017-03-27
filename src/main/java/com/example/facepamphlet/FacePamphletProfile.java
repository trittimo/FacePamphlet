package com.example.facepamphlet;
/*
 * File: FacePamphletProfile.java
 * ------------------------------
 * This class keeps track of all the information for one profile
 * in the FacePamphlet social network.  Each profile contains a
 * name, an image (which may not always be set), a status (what 
 * the person is currently doing, which may not always be set),
 * and a list of friends.
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

import com.google.common.collect.EvictingQueue;

import acm.graphics.GImage;

public class FacePamphletProfile implements Serializable {
	
	/* Private instance variables*/
	private String Name = "";
	private GImage Image = null;
	private String Status = "No current status";
	private boolean statusSet = false;
	
	// Evicting queue of size 1000.  FIFO built-in.
	private Queue<String> pastStatuses = EvictingQueue.create(1000);
	private List<String> friends = new ArrayList<String>();
	private List<ResumeItem> resume = new ArrayList<>();
	
	/** 
	 * Constructor
	 * This method takes care of any initialization needed for
	 * the profile.
	 */
	public FacePamphletProfile(String name) {
		this.Name = name;
	}

	/** This method returns the name associated with the profile. */ 
	public String getName() {
		return this.Name;
	}

	/** 
	 * This method returns the image associated with the profile.  
	 * If there is no image associated with the profile, the method
	 * returns null. */ 
	public GImage getImage() {
		if(this.Image == null) {
			return null;
		}
		else{
			return this.Image;
		}
	}

	/** This method sets the image associated with the profile. */ 
	public void setImage(GImage image) {
		this.Image = image;
	}
	
	/** 
	 * This method returns the status associated with the profile.
	 * If there is no status associated with the profile, the method
	 * returns the empty string ("").
	 */ 
	public String getStatus() {
		return this.Status;
	}
	
	/** This method sets the status associated with the profile. */ 
	public void setStatus(String status) {
		if(statusSet){
			this.pastStatuses.add(this.Status);
		} else {
			statusSet = true;
		}
		this.Status = status;
	}
	
	public Queue<String> getPastStatuses(){
		return this.pastStatuses;
	}

	/** 
	 * This method adds the named friend to this profile's list of 
	 * friends.  It returns true if the friend's name was not already
	 * in the list of friends for this profile (and the name is added 
	 * to the list).  The method returns false if the given friend name
	 * was already in the list of friends for this profile (in which 
	 * case, the given friend name is not added to the list of friends 
	 * a second time.)
	 */
	public boolean addFriend(String friend) {
		if(this.friends.contains(friend)) {
			return false;
		}
		else{
			this.friends.add(friend);
			return true;
		}
	}

	/** 
	 * This method removes the named friend from this profile's list
	 * of friends.  It returns true if the friend's name was in the 
	 * list of friends for this profile (and the name was removed from
	 * the list).  The method returns false if the given friend name 
	 * was not in the list of friends for this profile (in which case,
	 * the given friend name could not be removed.)
	 */
	public boolean removeFriend(String friend) {
		if(this.friends.contains(friend)) {
			this.friends.remove(this.friends.indexOf(friend));
			return true;
		}
		else{
			return false;
		}
	}

	/** 
	 * This method returns an iterator over the list of friends 
	 * associated with the profile.
	 */ 
	public Iterator<String> getFriends() {
		return this.friends.iterator();
	}
	
	public void addResumeItem(ResumeItem item) {
		this.resume.add(item);
	}
	
	public List<ResumeItem> getResumeByType(String type) {
		List<ResumeItem> list = new ArrayList<ResumeItem>();
		for (ResumeItem item : this.resume) {
			if (item.type.equals(type)) {
				list.add(item);
			}
		}
		return list;
		
	}
	
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.writeObject(friends);
		stream.writeObject(Name);
		stream.writeObject(Status);
		stream.writeBoolean(statusSet);
		stream.writeObject(pastStatuses);
		stream.writeObject(friends);
		stream.writeObject(resume);
	}
	
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		friends = (List<String>) stream.readObject();
		Name = (String) stream.readObject();
		Status = (String) stream.readObject();
		statusSet = stream.readBoolean();
		pastStatuses = (Queue<String>) stream.readObject();
		friends = (List<String>) stream.readObject();
		resume = (List<ResumeItem>) stream.readObject();
	}
	
	/** 
	 * This method returns a string representation of the profile.  
	 * This string is of the form: "name (status): list of friends", 
	 * where name and status are set accordingly and the list of 
	 * friends is a comma separated list of the names of all of the 
	 * friends in this profile.
	 * 
	 * For example, in a profile with name "Alice" whose status is 
	 * "coding" and who has friends Don, Chelsea, and Bob, this method 
	 * would return the string: "Alice (coding): Don, Chelsea, Bob"
	 */ 
	@Override
	public String toString() {
		String profile = this.Name + " (" + this.Status + "): ";
		Iterator<String>it = this.friends.iterator();
		while(it.hasNext()) {
			profile += it.next() + ", ";
		}
		return profile;
	}
	
}
