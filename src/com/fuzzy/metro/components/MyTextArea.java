package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import com.fuzzy.metro.listeners.MyFocusListener;

public class MyTextArea extends JTextArea{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String placeholder = "";
	
	public MyTextArea(String placeholder){
		this(30, placeholder);
	}
	
	public MyTextArea(int cols, String placeholder){
		super();
		setPlaceHolder(placeholder);
		setSettings();
	}

	private void setSettings() {
		// TODO Auto-generated method stub
		/*setLineWrap(true);
		setWrapStyleWord(true);*/
	}

	private void setPlaceHolder(String placeholder) {
		// TODO Auto-generated method stub
		setText(placeholder);
		this.setPlaceholder(placeholder);
		setForeground(new Color(216,225,228));
		setOpaque(false);
		Font font = new MyFont().getFont();
		font = font.deriveFont(Font.PLAIN, 10);
		addFocusListener(new MyFocusListener(this, placeholder));
		setSettingBorder();
	}

	private void setSettingBorder() {
		// TODO Auto-generated method stub
		Border padding = BorderFactory.createEmptyBorder(10, 15, 10, 15);
		Border outer = BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(216,225,228)));
		setBorder(BorderFactory.createCompoundBorder(outer, padding));
	}

	public String getPlaceholder() {
		return placeholder;
	}

	public void setPlaceholder(String placeholder) {
		this.placeholder = placeholder;
	}
	
	public void setColumns(int columns){
		setColumns(columns);
	}

}