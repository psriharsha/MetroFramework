package com.fuzzy.metro.chatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JSplitPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

import com.fuzzy.metro.Singleton;
import com.fuzzy.metro.chatter.MessageData.MessageSender;
import com.fuzzy.metro.components.Kind;
import com.fuzzy.metro.components.MyButton;
import com.fuzzy.metro.components.MyFrame;
import com.fuzzy.metro.components.MyLabel;
import com.fuzzy.metro.components.MyList;
import com.fuzzy.metro.components.MyPanel;
import com.fuzzy.metro.components.MyScrollPane;
import com.fuzzy.metro.components.MySplitPane;
import com.fuzzy.metro.components.MyTextArea;
import com.fuzzy.metro.components.MyTextField;
import com.jidesoft.swing.JideBoxLayout;

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
		setSize(600,400);
	}

	@Override
	public void createLayout(Container contentPane) {
		// TODO Auto-generated method stub
		listPanel = new MyPanel();
		addUsers();
		contentPanel = new MyPanel(false);
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
		listModel.addElement ( new CustomData ( new Color ( 135, 163, 14 ), 1, "Sri Karthik" ) );
		listModel.addElement ( new CustomData ( new Color ( 135, 163, 14 ), 0, "Sai Hema" ) );
		listModel.addElement ( new CustomData ( new Color ( 135, 163, 14 ), 3, "Colin McLauchlan" ) );
		listModel.addElement ( new CustomData ( new Color ( 209, 52, 23 ), 0, "Josef" ) );
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
		msgs.add(new MessageData("Sri Harsha","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",new Date(), MessageSender.SELF));
		msgs.add(new MessageData("Sri Harsha","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",new Date(), MessageSender.SELF));
		msgs.add(new MessageData("Sri Karthik","Lorem Ipsum is simply dummy text of the printing and typesetting industry.  Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",new Date(), MessageSender.COUNTER));
		msgs.add(new MessageData("Sri Harsha","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",new Date(), MessageSender.SELF));
		msgs.add(new MessageData("Sri Karthik","Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",new Date(), MessageSender.COUNTER));
		messageFormatterList = new ArrayList<MessageFormatter>();
		msgDetailPanel = new MyPanel(false);
		msgDetailPanel.setLayout(new JideBoxLayout(msgDetailPanel, JideBoxLayout.Y_AXIS));
		for(MessageData msg: msgs){
			MessageFormatter formatter = new MessageFormatter(msg);
			formatter.setPreferredSize(new Dimension(msgDetailPanel.getSize().width,100));
			messageFormatterList.add(formatter);
			msgDetailPanel.add(formatter, JideBoxLayout.FLEXIBLE);
		}
		scrollMessage = new MyScrollPane(msgDetailPanel);
		scrollMessage.setLayout(new ScrollPaneLayout());

		messagePanel.setLayout(new GridLayout());
		messagePanel.add(scrollMessage);
		
		sendPanel = new MyPanel(false);
		sendPanel.setLayout(new BoxLayout( sendPanel, BoxLayout.X_AXIS));
		sendText = new MyTextField("Text to send");
		sendPanel.add(sendText);
		sendButton = new MyButton("Send", Kind.SUCCESS);
		sendButton.setSize(50,20);
		sendButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				newMessage(new MessageData("Sai Hema","Lorem Ipsum is simply dummy text of the printing and typesetting industry.  Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum is simply dummy text of the printing and typesetting industry.",new Date(), MessageSender.COUNTER));
			}
			
		});
		sendPanel.add(sendButton);
		infoPanel = new MyPanel();
		infoPanel.setLayout(new GridLayout(1,2));
		counterName = new MyLabel("Sri Karthik",com.fuzzy.metro.components.MyLabel.Type.TITLE);
		counterName.setForeground(Singleton.counterColor);
		
		contentPanel.setLayout(new BorderLayout());
		contentPanel.add(messagePanel, BorderLayout.CENTER);
		contentPanel.add(sendPanel, BorderLayout.SOUTH);
	}
	
	public void newMessage(MessageData msg){
		MessageFormatter formatter = new MessageFormatter(msg);
		formatter.setPreferredSize(new Dimension(msgDetailPanel.getSize().width,100));
		messageFormatterList.add(formatter);
		msgDetailPanel.add(formatter, JideBoxLayout.FLEXIBLE);
		//formatter.revalidate();
		scrollMessage.revalidate();
	}

	public static void main(String[] args){
		new ChatFrame();
	}
	
	MyPanel listPanel, contentPanel, sendPanel, messagePanel, msgDetailPanel, infoPanel;
	MyList colleagues;
	MySplitPane splitPane;
	MyScrollPane scrollList, scrollMessage;
	MyTextField sendText;
	MyButton sendButton;
	MyTextArea messageArea;
	MyLabel counterName;
	List<MessageFormatter> messageFormatterList;
}