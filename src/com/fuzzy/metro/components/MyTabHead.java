package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

import com.fuzzy.metro.listeners.MyTabListener;

public class MyTabHead extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	MyPanel panel;
	public static enum State{
		ACTIVE,
		INACTIVE
	};
	
	public MyTabHead(String title){
		this(title,null, State.INACTIVE);
	}
	
	public MyTabHead(String title, MyPanel panel,State state){
		super(title);
		this.panel = panel;
		setState(state);
		setOpaque(false);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(new MyTabListener(this, panel));
	}
	
	public void setState(State state){
		Color fore = Color.LIGHT_GRAY;
		switch(state){
		case ACTIVE: fore = Color.BLACK;
				Border padding = BorderFactory.createEmptyBorder(10, 15, 10, 15);
				Border divider = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLUE);
				setBorder(BorderFactory.createCompoundBorder(divider, padding));
			break;
		case INACTIVE: fore = Color.LIGHT_GRAY;
				Border padding1 = BorderFactory.createEmptyBorder(10, 15, 10, 15);
				Border divider1 = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.WHITE);
				setBorder(BorderFactory.createCompoundBorder(divider1, padding1));
		break;
		default: fore = Color.LIGHT_GRAY;
		}
		setForeground(fore);
		Font font = new MyFont().getFont();
		font = font.deriveFont(Font.BOLD, 12);
		setFont(font);
	}

}