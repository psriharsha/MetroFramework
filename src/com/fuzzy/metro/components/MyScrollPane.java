package com.fuzzy.metro.components;

import javax.swing.JScrollPane;

public class MyScrollPane extends JScrollPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyScrollPane(){
		super();
	}
	
	public MyScrollPane(Kind kind){
		setBackground(kind.getStateColor());
	}

}