package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

import com.jidesoft.swing.StyledLabel;

public class MyStyledLabel extends StyledLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static enum Type{
		TITLE,
		HEAD,
		ITALIC,
		BOLD,
		GEN;
		
		public Font getFont(){
			Font font = new MyFont().getFont();
			font = font.deriveFont(Font.PLAIN, 13);
			switch(this){
			case TITLE: font = font.deriveFont(Font.BOLD, 14); break;
			case BOLD: font = font.deriveFont(Font.BOLD, 14); break;
			case HEAD: font = font.deriveFont(Font.PLAIN, 20); break;
			case ITALIC: font = font.deriveFont(Font.ITALIC, 12); break;
			case GEN: 
			}
			return font;
		}
		
		public Border getBorder(){
			Border border = BorderFactory.createEmptyBorder();
			switch(this){
			case TITLE: border = BorderFactory.createEmptyBorder(5,15,5,5); break;
			case BOLD: border = BorderFactory.createEmptyBorder(5,5,5,5); break;
			case HEAD: border = BorderFactory.createEmptyBorder(5,5,5,5); break;
			case ITALIC: border = BorderFactory.createEmptyBorder(5,5,5,5); break;
			case GEN: border = BorderFactory.createEmptyBorder(1,1,1,1); break;
			}
			return border;
		}
		
	}
	
	public MyStyledLabel(String text){
		this(text, Type.GEN);
	}
	
	public MyStyledLabel(String text, Type type){
		this(text, type, Kind.DARK);
	}
	
	public MyStyledLabel(String text,Type type, Kind state){
		super(text);
		setFont(type.getFont());
		if(type != Type.TITLE){
			setForeground(Color.BLACK);
		}else{
			setForeground(Color.WHITE);
		}
		setBorder(type.getBorder());
	}
	
	public void setState(Kind state){
		setForeground(state.getStateColor());
	}
	
	public void setLabelBorder(Border border){
		setBorder(border);
	}

}