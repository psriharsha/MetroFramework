package com.fuzzy.metro.chatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.fuzzy.metro.components.MyLabel;
import com.fuzzy.metro.components.MyLabel.Type;
import com.fuzzy.metro.components.MyPanel;
import com.jidesoft.swing.JideBorderLayout;
import com.jidesoft.swing.JideBoxLayout;

public class MessageFormatter extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MessageData msgData;
	private MyPanel msgHeader, msgContent;
	private MyLabel sender, sentAt;
	private JTextArea message;
	
	public MessageFormatter(MessageData msgData){
		this.msgData = msgData;
		createMessagePanel();
	}
	
	private void createMessagePanel(){
		msgHeader = new MyPanel();
		msgHeader.setLayout(new GridLayout(1,2));
		sender = new MyLabel(msgData.getSender(),Type.BOLD);
		sender.setHorizontalAlignment(SwingConstants.LEFT);
		msgHeader.add(sender);
		sentAt = new MyLabel(msgData.getSentAt().toString(), Type.ITALIC);
		sentAt.setHorizontalAlignment(SwingConstants.RIGHT);
		msgHeader.add(sentAt);
		JideBoxLayout jbl = new JideBoxLayout(this,JideBoxLayout.Y_AXIS);
		setLayout(jbl);
		add(msgHeader, JideBoxLayout.FIX);
		//message = StyledLabelBuilder.createStyledLabel(msgData.getMessage());
		message = new JTextArea(){

			@Override
			public boolean getLineWrap() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean getWrapStyleWord() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public boolean isEditable() {
				// TODO Auto-generated method stub
				return false;
			}
			
			
		};
		message.setBackground(null);
		message.setText(msgData.getMessage());
		msgContent= new MyPanel();
		msgContent.setLayout(new JideBorderLayout());
		msgContent.add(message,JideBorderLayout.CENTER);
		add(msgContent, JideBoxLayout.FIX);
	}
	
}