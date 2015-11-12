package com.fuzzy.metro.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dialog.ModalExclusionType;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

public class MyOptionPane extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyOptionPane(String message){
		this("", message);
	}
	
	public MyOptionPane(String title, String message){
		this(title, "", message);
	}
	
	public MyOptionPane(String title, String heading, String message){
		this(title, heading, message, Kind.DEFAULT);
	}
	
	public MyOptionPane(String title, String message, Kind kind){
		this(title, "", message, kind);
	}
	
	public MyOptionPane(String title, String heading, String message, Kind kind){
		//super(new JFrame(), true);
		super(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setLayout(new BorderLayout());
		setKind(kind);
		if(title != ""){
			setTitle(title);
		}
		if(heading != ""){
			headerPanel = new MyPanel();
			headerPanel.setBackground(Color.LIGHT_GRAY);
			headerPanel.add(new MyLabel(heading, com.fuzzy.metro.components.MyLabel.Type.HEAD));
			add(headerPanel, BorderLayout.NORTH);
		}
		contentPanel = new MyPanel();
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		contentPanel.add(new MyLabel(message), BorderLayout.CENTER);
		add(contentPanel, BorderLayout.LINE_END);
		setLocationRelativeTo(null);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		pack();
		setVisible(true);
	}
	
	MyPanel headerPanel, contentPanel, footerPanel;

	@Override
	public void createLayout(Container contentPane) {
		// TODO Auto-generated method stub
		
	}

}