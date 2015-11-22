package com.fuzzy.metro.components;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class MyPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyPanel(){
		this(true);
	}

	public MyPanel(boolean setBorder) {
		// TODO Auto-generated constructor stub
		super();
		setOpaque(false);
		if(setBorder){
			setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		}else	{
			setBorder(BorderFactory.createEmptyBorder());
		}
	}
}