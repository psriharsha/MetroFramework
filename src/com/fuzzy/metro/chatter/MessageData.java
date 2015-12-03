package com.fuzzy.metro.chatter;

import java.util.Date;

public class MessageData{
	String sender, message;
	Date sentAt;
	public String getSender() {
		return sender;
	}
	public String getMessage() {
		return message;
	}
	public Date getSentAt() {
		return sentAt;
	}
	
	public MessageData(String sender,String message, Date sentAt){
		this.sender = sender;
		this.message = message;
		this.sentAt = sentAt;
	}
	
}