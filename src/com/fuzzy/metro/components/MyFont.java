package com.fuzzy.metro.components;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;

public class MyFont{

	public Font getFont(){
		Font font = null;
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, getClass().getResource("Lora-Regular.ttf").openStream());
		} catch (FontFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Didn't manage to open it");
			font = Font.getFont("Arial");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Didn't get it at all!!");
			font = Font.getFont("Arial");
		}
		return font;
	}

}
