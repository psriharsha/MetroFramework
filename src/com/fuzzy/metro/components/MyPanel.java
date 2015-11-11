package com.fuzzy.metro.components;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyPanel(){
		super();
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
}