package com.example.facepamphlet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.sun.istack.internal.NotNull;

import acm.program.Program;
import acmx.export.javax.swing.JButton;

public abstract class ActionButton implements ActionListener {
	
	protected JButton button;
	protected Program program;
	protected SharedData data;
	
	public ActionButton(Program program, SharedData data) {
		this.program = program;
		this.data = data;
		this.button = new JButton(getText()); 
	}
	
	public JButton getButton() {
		return this.button;
	}
	
	@Override
	public abstract void actionPerformed(ActionEvent e);
	
	/**
	 * Called immediately prior to adding the button to the canvas
	 */
	public abstract void onBeforeAdd();
	
	
	/**
	 * Called immediately after adding the button to the canvas
	 */
	public abstract void onAfterAdd();
	
	/**
	 * Gets the text on the button
	 * @return String of the text on the button
	 */
	public abstract @NotNull String getText();
	
	/**
	 * Gets the placement on the canvas
	 * @return integer constant from JButton representing placement on canvas
	 */
	public abstract @NotNull String getPlacement();
	
	/**
	 * This method will be called automatically when the FacePamphlet
	 * app detects an interaction with this button
	 */
	public abstract void onInteract();
}
