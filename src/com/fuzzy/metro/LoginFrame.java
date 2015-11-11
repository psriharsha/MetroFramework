package com.fuzzy.metro;

import java.awt.Container;

import com.fuzzy.metro.components.MyFrame;
import com.fuzzy.metro.components.MyPanel;

public class LoginFrame extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	LoginFrame(){
		super();
		createLayout(getContentPane());
		setVisible(true);
	}
	
	@Override
	public void createLayout(Container contentPane) {
		// TODO Auto-generated method stub
		formPanel = new MyPanel();
		infoPanel = new MyPanel();
	}
	
	public static void main(String[] args){
		/*FirstFrame firstFrame = */
		new LoginFrame();
	}
	
	MyPanel formPanel, infoPanel;
	
}