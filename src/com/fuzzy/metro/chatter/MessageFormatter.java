package com.fuzzy.metro.chatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.SwingConstants;

import com.fuzzy.metro.Singleton;
import com.fuzzy.metro.chatter.MessageData.MessageSender;
import com.fuzzy.metro.components.MyPanel;
import com.fuzzy.metro.components.MyStyledLabel;
import com.fuzzy.metro.components.MyStyledLabel.Type;
import com.jidesoft.swing.JideBoxLayout;

public class MessageFormatter extends MyPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageData msgData;
	private MyPanel msgHeader, msgContent;
	private MyStyledLabel sender, sentAt;
	private MyStyledLabel message;
	
	public MessageFormatter(MessageData msgData){
		this.msgData = msgData;
		createMessagePanel();
	}
	
	private void createMessagePanel(){
		int senderPos, sentAtPos;
		msgHeader = new MyPanel(false);
		msgHeader.setLayout(new GridLayout(1,2));
		if(msgData.getSenderKind() == MessageSender.COUNTER){
			senderPos = SwingConstants.LEFT;
			sentAtPos = SwingConstants.RIGHT;
			sender = new MyStyledLabel(msgData.getSender(),Type.BOLD);
			sender.setHorizontalAlignment(senderPos);
			msgHeader.add(sender);
			sentAt = new MyStyledLabel(msgData.getSentAt().toString(), Type.ITALIC);
			sentAt.setHorizontalAlignment(sentAtPos);
			msgHeader.add(sentAt);
			sender.setForeground(Singleton.counterColor);
		}else{
			senderPos = SwingConstants.RIGHT;
			sentAtPos = SwingConstants.LEFT;
			sentAt = new MyStyledLabel(msgData.getSentAt().toString(), Type.ITALIC);
			sentAt.setHorizontalAlignment(sentAtPos);
			msgHeader.add(sentAt);
			sender = new MyStyledLabel(msgData.getSender(),Type.BOLD);
			sender.setHorizontalAlignment(senderPos);
			msgHeader.add(sender);
			sender.setForeground(Singleton.selfColor);
		}
		JideBoxLayout jbl = new JideBoxLayout(this,JideBoxLayout.Y_AXIS);
		setLayout(jbl);
		add(msgHeader, JideBoxLayout.FIX);
		message = new MyStyledLabel(msgData.getMessage());
		//message = 
		message.setBackground(Color.GRAY);
		message.setLineWrap(true);
		message.setSize(200,message.getPreferredSize().height);
		msgContent= new MyPanel(false);
		msgContent.setLayout(new BorderLayout());
		msgContent.add(message,BorderLayout.CENTER);
		add(msgContent, JideBoxLayout.FIX);
		setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Singleton.defaultColor));
	}
	
}