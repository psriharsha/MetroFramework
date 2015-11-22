package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JPasswordField;
import javax.swing.border.Border;

import com.fuzzy.metro.listeners.MyFocusListener;

public class MyPassword extends JPasswordField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyPassword(){
		super();
		setForeground(new Color(216,225,228));
		setOpaque(false);
		Font font = new MyFont().getFont();
		font = font.deriveFont(Font.PLAIN, 10);
		addFocusListener(new MyFocusListener(this, "Password1"));
		setSettingBorder();
	}
	
	private void setSettingBorder() {
		// TODO Auto-generated method stub
		Border padding = BorderFactory.createEmptyBorder(10, 15, 10, 15);
		Border outer = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216,225,228)));
		setBorder(BorderFactory.createCompoundBorder(outer, padding));
	}

}
