package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MyScrollPane extends JScrollPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyScrollPane(){
		super();
		setUserInterface();
	}
	
	public MyScrollPane(Component component) {
		// TODO Auto-generated constructor stub
		super(component);
		setSize(getMaximumSize());
		getViewport().setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder());
		setUserInterface();
	}

	private void setUserInterface() {
		// TODO Auto-generated method stub
		setHorizontalScrollBar(new MyScrollBar());
		setVerticalScrollBar(new MyScrollBar());
	}

}