package com.fuzzy.metro;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;

import com.fuzzy.metro.components.MyButton;
import com.fuzzy.metro.components.MyFrame;
import com.fuzzy.metro.components.MyLabel;
import com.fuzzy.metro.components.MyPanel;
import com.fuzzy.metro.components.MyTabHead;
import com.fuzzy.metro.components.MyTabHead.State;
import com.fuzzy.metro.components.MyTextField;

public class FirstFrame extends MyFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	FirstFrame() {
		// TODO Auto-generated constructor stub
		super();
		createLayout(getContentPane());
		setTitle("Demo Frame - Metro UI");
		setStatus(com.fuzzy.metro.components.State.DANGER);
		setResizable(true);
		setVisible(true);
		setMinWidth();
	}
	
	@Override
	public void createLayout(Container contentPane) {
		// TODO Auto-generated method stub
		contentPane.setLayout(new BorderLayout(2,1));
		tabContent = new MyPanel();
		List<String> tabHeaders = new ArrayList<String>();
		tabHeaders.add(FORM);
		tabHeaders.add(BUTTON);
		tabHeaders.add(LABEL);
		tabControl = new MyPanel();
		tabControl.setLayout(new BoxLayout(tabControl, BoxLayout.X_AXIS));
		tabHeads = new ArrayList<MyTabHead>();
		for (String head : tabHeaders) {
			tabHeads.add(new MyTabHead(head, tabContent, MyTabHead.State.INACTIVE));
		}
		Iterator<MyTabHead> heads = tabHeads.iterator();
		while(heads.hasNext()){
			MyTabHead tab = heads.next();
			tabControl.add(tab);
		}
		tabHeads.get(0).setState(State.ACTIVE);
		tabForm = new MyPanel();
		tabForm.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		tabForm.add(new MyLabel("Text Field"), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		tabForm.add(new MyTextField(15), gbc);
		tabButton = new MyPanel();
		tabButton.add(new MyButton( "SUCCESS", com.fuzzy.metro.components.State.SUCCESS));
		tabButton.add(new MyButton( "DANGER", com.fuzzy.metro.components.State.DANGER));
		tabButton.add(new MyButton( "WARNING", com.fuzzy.metro.components.State.WARNING));
		tabButton.add(new MyButton( "INFO", com.fuzzy.metro.components.State.INFO));
		tabButton.add(new MyButton( "DARK", com.fuzzy.metro.components.State.DARK));
		tabButton.add(new MyButton( "DEFAULT", com.fuzzy.metro.components.State.DEFAULT));
		tabContent.setLayout(new CardLayout());
		tabContent.add(tabForm, FORM);
		tabContent.add(tabButton, BUTTON);
		tabContent.setSize(new Dimension(300,300));
		contentPane.add(tabControl, BorderLayout.PAGE_START);
		contentPane.add(tabContent, BorderLayout.PAGE_END);
		setVisible(true);
		pack();
	}

	public static void main(String[] args){
		/*FirstFrame firstFrame = */
		new FirstFrame();
	}
	
	MyButton test1,test2,test3,test4,test5;
	final static String FORM = "Form";
	final static String BUTTON = "Button";
	final static String LABEL = "Label";
	MyPanel tabControl, tabContent;
	MyPanel tabForm, tabButton, tabLabel;
	List<MyTabHead> tabHeads;	
}
