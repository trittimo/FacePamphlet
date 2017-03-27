package com.example.facepamphlet;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import acm.program.Program;

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
			return null;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		@Override
		public void onInteract() {
			
		}
		@Override
		public void onBeforeAdd() {
			
			
		}
		@Override
		public void onAfterAdd() {
			
			
		}
	}
	public static class DeleteButton extends ActionButton {
		public DeleteButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return null;
		}
		@Override
		public String getPlacement() {
			return null;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		@Override
		public void onInteract() {
			
		}
		@Override
		public void onBeforeAdd() {
			
			
		}
		@Override
		public void onAfterAdd() {
			
			
		}
	}
	
	public static class LookupButton extends ActionButton {
		public LookupButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return null;
		}
		@Override
		public String getPlacement() {
			return null;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		@Override
		public void onInteract() {
			
		}
		@Override
		public void onBeforeAdd() {
			
			
		}
		@Override
		public void onAfterAdd() {
			
			
		}
	}
	
	public static class StatusButton extends ActionButton {
		public StatusButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return null;
		}
		@Override
		public String getPlacement() {
			return null;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		@Override
		public void onInteract() {
			
		}
		@Override
		public void onBeforeAdd() {
			
			
		}
		@Override
		public void onAfterAdd() {
			
			
		}
	}
	public static class PictureButton extends ActionButton {
		public PictureButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return null;
		}
		@Override
		public String getPlacement() {
			return null;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		@Override
		public void onInteract() {
			
		}
		@Override
		public void onBeforeAdd() {
			
			
		}
		@Override
		public void onAfterAdd() {
			
			
		}
	}
	public static class FriendButton extends ActionButton {
		public FriendButton(Program program, SharedData data) {
			super(program, data);
		}
		@Override
		public String getText() {
			return null;
		}
		@Override
		public String getPlacement() {
			return "Add Friend";
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
		@Override
		public void onInteract() {
			
		}
		@Override
		public void onBeforeAdd() {
			
			
		}
		@Override
		public void onAfterAdd() {
			
			
		}
	}
	public static class AdministrationButton extends ActionButton {
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
			
		}
		@Override
		public void onInteract() {
			
		}
		@Override
		public void onBeforeAdd() {
			
			
		}
		@Override
		public void onAfterAdd() {
			
			
		}
	}
	public static class ResumeButton extends ActionButton {
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
		@Override
		public void onInteract() {
			
		}
		@Override
		public void onBeforeAdd() {
			
		}
		@Override
		public void onAfterAdd() {
			
		}
	}

}
