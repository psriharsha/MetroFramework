package com.fuzzy.metro.chatter;

import java.util.Date;

public class MessageData{
	private String sender, message;
	private Date sentAt;
	private MessageSender senderKind;
	public String getSender() {
		return sender;
	}
	public String getMessage() {
		return message;
	}
	public Date getSentAt() {
		return sentAt;
	}
	
	public MessageSender getSenderKind() {
		return senderKind;
	}
	public MessageData(String sender,String message, Date sentAt, MessageSender senderKind){
		this.sender = sender;
		this.message = message;
		this.sentAt = sentAt;
		this.senderKind = senderKind;
	}
	
	public enum MessageSender{
		SELF,
		COUNTER
	}
	
}