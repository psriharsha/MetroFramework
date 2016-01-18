package com.fuzzy.metro.components;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

import com.fuzzy.metro.Singleton;
import com.jidesoft.plaf.basic.ThemePainter;
import com.jidesoft.swing.JideButton;

public class MyComboBoxUI extends BasicComboBoxUI{
	
	private JideButton arrowButton;
	
	protected JButton createArrowButton() {
		ImageIcon icon = createImageIcon("./cogs.png");
		arrowButton = new JideButton(icon);
		arrowButton.setOpaque(true);
		arrowButton.setBackground(Singleton.defaultColor);
		arrowButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Singleton.defaultColor));
		arrowButton.setBackgroundOfState(ThemePainter.STATE_PRESSED, Singleton.defaultColor);
		arrowButton.setBackgroundOfState(ThemePainter.STATE_ROLLOVER, Singleton.defaultColor);
        return arrowButton;
    }
	
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