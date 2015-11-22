package com.fuzzy.metro.chatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import com.fuzzy.metro.components.Kind;
import com.fuzzy.metro.components.MyButton;
import com.fuzzy.metro.components.MyFrame;
import com.fuzzy.metro.components.MyLabel;
import com.fuzzy.metro.components.MyPanel;
import com.fuzzy.metro.components.MyPassword;
import com.fuzzy.metro.components.MyTextField;

public class LoginFrame extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	LoginFrame(){
		super(false);
		setTitle("Login - Chatter");
		createLayout(getContentPane());
		setVisible(true);
		setMinWidth();
	}
	
	@Override
	public void createLayout(Container contentPane) {
		// TODO Auto-generated method stub
		setLayout(new GridBagLayout());
		infoPanel = new MyPanel();
		formPanel = new MyPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		formPanel = new MyPanel();
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
		MyLabel logHead = new MyLabel("Login to Chat !!".toUpperCase(), com.fuzzy.metro.components.MyLabel.Type.HEAD);
		logHead.setAlignmentX(Component.CENTER_ALIGNMENT);
		formPanel.add(logHead, BorderLayout.CENTER);
		MyPanel loginPanel = new MyPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		error = new MyLabel("",com.fuzzy.metro.components.MyLabel.Type.GEN,Kind.DANGER);
		error.setForeground(Color.RED);
		loginPanel.add(error);
		username = new MyTextField(20, "Username");
		loginPanel.add(username);
		password = new MyPassword();
		password.setText("password1");
		password.setColumns(20);
		loginPanel.add(password);
		login = new MyButton("Login", Kind.SUCCESS);
		login.setAlignmentX(Component.CENTER_ALIGNMENT);
		login.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginPanel.add(Box.createVerticalStrut(10));
		login.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new ChatFrame();
			}
			
		});
		loginPanel.add(login);
		loginPanel.setSize(getMinimumSize());
		formPanel.add(loginPanel);
		contentPane.add(formPanel, gbc);
		gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		infoPanel.setLayout(new GridBagLayout());
        infoPanel.add(new JLabel(new ImageIcon(getClass().getResource("logo.png"))));
		contentPane.add(infoPanel, gbc);
		setVisible(true);
		pack();
	}
	
	public static void main(String[] args){
		/*FirstFrame firstFrame = */
		new LoginFrame();
	}
	
	public void paintComponent(Graphics g) {
	    g.drawImage(logo, 0, 0, null);
	  }

	
	MyPanel formPanel, infoPanel;
	Image logo;
	MyTextField username;
	MyPassword password;
	MyButton login;
	MyLabel error;
}