package com.fuzzy.metro.components;

import java.awt.Rectangle;

import javax.swing.JTextArea;

public class MyFloatingLabel extends JTextArea{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String text = "";

	public MyFloatingLabel(String text) {
        super();
        this.text = text;
        setText(text);
        setBackground(null);
        setEditable(false);
        setBorder(null);
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(false);
        setVisible(true);
    }

	@Override
	public void repaint(Rectangle r) {
		// TODO Auto-generated method stub
		super.repaint(r);
		setText(text);
        setBackground(null);
        setEditable(false);
        setBorder(null);
        setLineWrap(true);
        setWrapStyleWord(true);
        setOpaque(false);
        setVisible(true);
	}

}