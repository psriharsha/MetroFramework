package com.fuzzy.metro.components;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import com.fuzzy.metro.Singleton;
import com.jidesoft.plaf.basic.ThemePainter;
import com.jidesoft.swing.JideButton;

public class MyComboBoxUI extends BasicComboBoxUI{
	
	private JideButton arrowButton;
	
	protected JButton createArrowButton() {
		ImageIcon icon = MyIcon.createImageIcon("./cogs.png");
		arrowButton = new JideButton(icon);
		arrowButton.setOpaque(true);
		arrowButton.setBackground(Singleton.defaultColor);
		arrowButton.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Singleton.defaultColor));
		arrowButton.setBackgroundOfState(ThemePainter.STATE_PRESSED, Singleton.defaultColor);
		arrowButton.setBackgroundOfState(ThemePainter.STATE_ROLLOVER, Singleton.defaultColor);
        return arrowButton;
    }

	@Override
	protected ComboPopup createPopup() {
		// TODO Auto-generated method stub
		BasicComboPopup comboPopup = new BasicComboPopup(this.comboBox);
		comboPopup.setSize(new Dimension(5,5));
		return comboPopup;
	}

}