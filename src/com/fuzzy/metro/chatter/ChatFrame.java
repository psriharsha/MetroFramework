package com.fuzzy.metro.chatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

import com.fuzzy.metro.components.Kind;
import com.fuzzy.metro.components.MyButton;
import com.fuzzy.metro.components.MyFrame;
import com.fuzzy.metro.components.MyList;
import com.fuzzy.metro.components.MyPanel;
import com.fuzzy.metro.components.MyScrollPane;
import com.fuzzy.metro.components.MySplitPane;
import com.fuzzy.metro.components.MyTextArea;
import com.fuzzy.metro.components.MyTextField;

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
		setSize(new Dimension(500,500));
		pack();
	}

	@Override
	public void createLayout(Container contentPane) {
		// TODO Auto-generated method stub
		listPanel = new MyPanel();
		addUsers();
		contentPanel = new MyPanel();
		addContent();
		setLayout(new BorderLayout());
		splitPane = new MySplitPane(JSplitPane.HORIZONTAL_SPLIT, listPanel, contentPanel);
		splitPane.setOneTouchExpandable(false);
		contentPane.add(splitPane);
		splitPane.setDividerSize(2);
		splitPane.setOpaque(false);
	}
	
	private void addUsers() {
		// TODO Auto-generated method stub
		DefaultListModel<CustomData> listModel = new DefaultListModel<CustomData>();
		listModel.addElement ( new CustomData ( new Color ( 135, 163, 14 ), 1, "Anna Williams" ) );
		listModel.addElement ( new CustomData ( new Color ( 135, 163, 14 ), 0, "Lucy Frank" ) );
		listModel.addElement ( new CustomData ( new Color ( 135, 163, 14 ), 3, "Mikle Garin" ) );
		listModel.addElement ( new CustomData ( new Color ( 209, 52, 23 ), 0, "Joe Fritz" ) );
		colleagues = new MyList(listModel);
		colleagues.setCellRenderer(new MyListRenderer(colleagues));
		scrollList = new MyScrollPane(colleagues);
		scrollList.setBorder(BorderFactory.createEmptyBorder());
		scrollList.setOpaque(true);
		scrollList.setBackground(Color.RED);
		scrollList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		listPanel.setLayout(new GridLayout(1, 1));
		listPanel.setBorder(BorderFactory.createEmptyBorder());
		listPanel.add(scrollList);
		int width = (int) (getSize().getWidth()/1.75);
		int height = this.getSize().height;
		listPanel.setMinimumSize(new Dimension(width, height));
	}
	
	private void addContent(){
		messagePanel = new MyPanel(false);
		/*messageArea = new MyTextArea("");
		messageArea.setEditable(false);
		scrollMessage = new MyScrollPane(messageArea);*/
		List<MessageData> msgs = new ArrayList<MessageData>();
		msgs.add(new MessageData("Sri Harsha","This is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a message",new Date()));
		msgs.add(new MessageData("Sri Harsha","This is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a message",new Date()));
		msgs.add(new MessageData("Sri Harsha","This is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a message",new Date()));
		msgs.add(new MessageData("Sri Harsha","This is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a message",new Date()));
		msgs.add(new MessageData("Sri Harsha","This is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a message",new Date()));
		msgs.add(new MessageData("Sri Harsha","This is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a message",new Date()));
		msgs.add(new MessageData("Sri Harsha","This is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a message",new Date()));
		msgs.add(new MessageData("Sri Harsha","This is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a message",new Date()));
		msgs.add(new MessageData("Sri Harsha","This is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a message",new Date()));
		msgs.add(new MessageData("Sri Harsha","This is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a messageThis is a message",new Date()));
		/*JList<MessageData> msgsList = new JList<MessageData>(msgs);
		//msgsList.setCellRenderer(new MessageListRenderer(msgsList));
		msgsList.ensureIndexIsVisible(1);
		//messageArea.add(msgsList, BorderLayout.CENTER);*/	
		msgDetailPanel = new MyPanel();
		msgDetailPanel.setLayout(new BoxLayout(msgDetailPanel,BoxLayout.Y_AXIS));
		for(MessageData msg: msgs){
			msgDetailPanel.add(new MessageFormatter(msg));
		}
		scrollMessage = new MyScrollPane(msgDetailPanel);
		scrollMessage.setLayout(new ScrollPaneLayout());
		//scrollMessage.setSize(getMaximumSize());
		messagePanel.setLayout(new GridLayout());
		messagePanel.add(scrollMessage);
		
		sendPanel = new MyPanel(false);
		sendPanel.setLayout(new BoxLayout( sendPanel, BoxLayout.X_AXIS));
		sendText = new MyTextField("Text to send");
		sendPanel.add(sendText);
		sendButton = new MyButton("Send", Kind.SUCCESS);
		sendButton.setSize(50,20);
		sendPanel.add(sendButton);
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(messagePanel, BorderLayout.CENTER);
		contentPanel.add(sendPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args){
		new ChatFrame();
	}
	
	MyPanel listPanel, contentPanel, sendPanel, messagePanel, msgDetailPanel;
	MyList colleagues;
	MySplitPane splitPane;
	MyScrollPane scrollList, scrollMessage;
	MyTextField sendText;
	MyButton sendButton;
	MyTextArea messageArea;
}