package com.fuzzy.metro.components;

import javax.swing.ImageIcon;

public class MyIcon{
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = MyComboBoxUI.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

}