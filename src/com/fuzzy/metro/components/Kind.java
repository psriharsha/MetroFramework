package com.fuzzy.metro.components;

import java.awt.Color;

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
		case 0: color = Color.LIGHT_GRAY;
				fore = Color.BLACK; break;
		case 1: color = Color.GREEN; break;
		case 2: color = Color.RED; break;
		case 3: color = Color.ORANGE; break;
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