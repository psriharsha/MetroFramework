package com.fuzzy.metro;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.BoxLayout;

import com.fuzzy.metro.components.Kind;
import com.fuzzy.metro.components.MyButton;
import com.fuzzy.metro.components.MyFrame;
import com.fuzzy.metro.components.MyLabel;
import com.fuzzy.metro.components.MyOptionPane;
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
		//setKind(com.fuzzy.metro.components.Kind.DANGER);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		tabHeaders.add(OTHER);
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
		gbc.anchor = GridBagConstraints.WEST;
		tabForm.add(new MyLabel("Text Field", MyLabel.Type.GEN, Kind.INFO), gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		tabForm.add(new MyTextField(15), gbc);
		tabButton = new MyPanel();
		tabButton.add(new MyButton( "Success", Kind.SUCCESS));
		tabButton.add(new MyButton( "Danger", Kind.DANGER));
		tabButton.add(new MyButton( "Warning", Kind.WARNING));
		tabButton.add(new MyButton( "Info", Kind.INFO));
		tabButton.add(new MyButton( "Dark", Kind.DARK));
		tabButton.add(new MyButton( "Default", Kind.DEFAULT));
		tabOther = new MyPanel();
		defaultUp = new MyButton("Default Message Box", Kind.DEFAULT);
		defaultUp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyOptionPane("Message Box", "This is how the info message look like!!", Kind.DEFAULT);
			}
			
		});
		tabOther.add(defaultUp);
		infoUp = new MyButton("Info Message Box", Kind.INFO);
		infoUp.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new MyOptionPane("Message Box", "This is how the info message look like!!", Kind.INFO);
			}
			
		});
		tabOther.add(infoUp);
		tabContent.setLayout(new CardLayout());
		tabContent.add(tabForm, FORM);
		tabContent.add(tabButton, BUTTON);
		tabContent.add(tabOther, OTHER);
		tabContent.setSize(new Dimension(300,300));
		contentPane.add(tabControl, BorderLayout.PAGE_START);
		contentPane.add(tabContent, BorderLayout.LINE_START);
		setVisible(true);
		pack();
	}

	public static void main(String[] args){
		/*FirstFrame firstFrame = */
		new FirstFrame();
	}
	
	MyButton infoUp, defaultUp;
	final static String FORM = "Form";
	final static String BUTTON = "Button";
	final static String OTHER = "Other";
	MyPanel tabControl, tabContent;
	MyPanel tabForm, tabButton, tabOther;
	List<MyTabHead> tabHeads;	
}
