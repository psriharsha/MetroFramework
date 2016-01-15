package com.fuzzy.metro.test;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import com.jidesoft.swing.JideBoxLayout;
import com.jidesoft.swing.StyledLabel;

public class StyledDemo extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StyledLabel sl = null;
	
	public StyledDemo(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(500, 500);
		addComponents(frame.getContentPane());
		frame.pack();
	}
	
	private void addComponents(Container contentPane) {
		// TODO Auto-generated method stub
		String text = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. ";
		sl =  new StyledLabel();
		sl.setText(text);
		sl.setLineWrap(true);
		sl.setPreferredSize(contentPane.getParent().getSize());
		//sl.setPreferredWidth(contentPane.getWidth());
		contentPane.setLayout(new BorderLayout());
		contentPane.add(sl,BorderLayout.CENTER);
	}

	public static void main(String args[]){
		new StyledDemo();
	}

}