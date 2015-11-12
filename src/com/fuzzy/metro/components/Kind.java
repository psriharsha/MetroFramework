package com.fuzzy.metro.components;

import java.awt.Color;

import com.fuzzy.metro.Singleton;

public enum Kind {
	DEFAULT(0),
	SUCCESS(1),
	DANGER(2),
	WARNING(3),
	INFO(4),
	DARK(5),
	;
	
	private final Color color;
	private Color fore;
	
	private Kind(int type){
		fore = Color.WHITE;
		switch(type){
		case 0: color = Singleton.defaultColor; break;
		case 1: color = new Color(29,166,52); break;
		case 2: color = new Color(250,23,23); break;
		case 3: color = new Color(231,140,10); break;
		case 4: color = Color.BLUE; break;
		case 5: color = Color.BLACK; fore = Color.WHITE; break;
		default: color = Color.LIGHT_GRAY;
		}
	}
	
	public Color getStateColor(){
		return color;
	}
	
	public Color getForeColor(){
		return fore;
	}
	
}