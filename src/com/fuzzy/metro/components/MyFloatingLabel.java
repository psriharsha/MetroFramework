package com.fuzzy.metro.components;

import javax.swing.JTextArea;

public class MyFloatingLabel extends JTextArea{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFloatingLabel(String text) {
        super(text);
        setBackground(null);
        setEditable(false);
        setBorder(null);
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(false);
    }

}