package com.fuzzy.metro.listeners;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import com.fuzzy.metro.components.MyOptionPane;
import com.fuzzy.metro.components.MyTextField;

public class MyFocusListener implements FocusListener{
	
	public String placeholder = "";
	public MyTextField contextField = null;
	MyOptionPane messageBox;
	
	public MyFocusListener(MyTextField field,String placeholder){
		this.contextField = field;
		this.placeholder = placeholder;
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		if(contextField.getForeground().equals(new Color(216,225,228)) && (contextField.getText().equalsIgnoreCase(placeholder))){
			contextField.setForeground(Color.BLACK);
			contextField.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(contextField.getText().equalsIgnoreCase("")){
			contextField.setForeground(new Color(216,225,228));
			contextField.setText(placeholder);
		}
	}

}