package com.fuzzy.metro.chatter;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.DefaultListModel;
import javax.swing.JSplitPane;

import com.fuzzy.metro.components.MyFrame;
import com.fuzzy.metro.components.MyLabel;
import com.fuzzy.metro.components.MyList;
import com.fuzzy.metro.components.MyPanel;
import com.fuzzy.metro.components.MySplitPane;

public class ChatFrame extends MyFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ChatFrame(){
		super();
		setTitle("ChatFrame - Chatter");
		createLayout(getContentPane());
		setVisible(true);
		setMinWidth();
	}

	@Override
	public void createLayout(Container contentPane) {
		// TODO Auto-generated method stub
		listPanel = new MyPanel();
		addUsers();
		contentPanel = new MyPanel();
		contentPanel.add(new MyLabel("This is left over"));
		setLayout(new BorderLayout());
		splitPane = new MySplitPane(JSplitPane.HORIZONTAL_SPLIT, listPanel, contentPanel);
		splitPane.setOneTouchExpandable(false);
		contentPane.add(splitPane);
		splitPane.setDividerSize(2);
		splitPane.setOpaque(false);
	    //splitPane.setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Singleton.defaultColor	));
	}
	
	private void addUsers() {
		// TODO Auto-generated method stub
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		listModel.addElement("Sri Harsha");
		listModel.addElement("Sri Karthik");
		listModel.addElement("Sai Hema");
		colleagues = new MyList(listModel);
		listPanel.add(colleagues);
	}

	public static void main(String[] args){
		new ChatFrame();
	}
	
	MyPanel listPanel, contentPanel;
	MyList colleagues;
	MySplitPane splitPane;
}