package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;

public class MyButton extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyButton(String text){
		this(text, Color.WHITE);
	}
	
	public MyButton(String text, Color color){
		super(text);
		setBackSettings(color);
		setBorder(BorderFactory.createEmptyBorder(5,15,5,15));
	}
	
	public MyButton(String text, Kind state){
		super(text);
		Font font = new MyFont().getFont();
		font = font.deriveFont(Font.PLAIN, 15);
		setFont(font);
		setForeground(state.getForeColor());
		setBackSettings(state.getStateColor());
		setBorder(BorderFactory.createEmptyBorder(5,25,5,25));
	}
	
	public void setBackSettings(Color color){
		setBackground(color);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

}