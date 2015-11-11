package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class MyTextField extends JTextField{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyTextField(int cols){
		super(cols);
		setOpaque(false);
		Font font = new MyFont().getFont();
		font = font.deriveFont(Font.PLAIN, 10);
		setSettingBorder();
	}

	private void setSettingBorder() {
		// TODO Auto-generated method stub
		Border padding = BorderFactory.createEmptyBorder(10, 15, 10, 15);
		Border outer = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY));
		setBorder(BorderFactory.createCompoundBorder(outer, padding));
	}

}