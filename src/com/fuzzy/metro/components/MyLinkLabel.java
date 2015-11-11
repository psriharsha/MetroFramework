package com.fuzzy.metro.components;

import java.awt.Color;

import javax.swing.JLabel;

import com.fuzzy.metro.listeners.LinkListener;

public class MyLinkLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	MyLinkLabel(String text, String link){
		super(text);
		this.addMouseListener(new LinkListener(link));
		setForeground(Color.BLUE);
	}

}