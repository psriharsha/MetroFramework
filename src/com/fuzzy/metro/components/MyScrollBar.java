package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;

public class MyScrollBar extends JScrollBar{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyScrollBar(){
		setUI(new MyScrollBarUI(this));
		setBackground(Color.WHITE);
		if(getOrientation() == VERTICAL){
			setPreferredSize(new Dimension(14,0));
		}else{
			setPreferredSize(new Dimension(0,14));
		}
	}
	
	

}