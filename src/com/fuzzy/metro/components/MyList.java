package com.fuzzy.metro.components;

import javax.swing.DefaultListModel;
import javax.swing.JList;

import com.fuzzy.metro.chatter.CustomData;

public class MyList extends JList<CustomData>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyList(DefaultListModel<CustomData> listModel) {
		// TODO Auto-generated constructor stub
		super(listModel);
	}

}