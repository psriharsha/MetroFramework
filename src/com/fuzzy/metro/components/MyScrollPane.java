package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class MyScrollPane extends JScrollPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyScrollPane(){
		super();
	}
	
	public MyScrollPane(Component component) {
		// TODO Auto-generated constructor stub
		super(component);
		setSize(getMaximumSize());
		getViewport().setBackground(Color.WHITE);
		setBorder(BorderFactory.createEmptyBorder());
	}

	@SuppressWarnings("unused")
	private void setScrollUI() {
		// TODO Auto-generated method stub
		setUI(new BasicScrollBarUI(){
			protected void configureScrollBarColors(){
				//LookAndFeel.installColors(scrollbar, "ScrollBar.background","ScrollBar.foreground");
				thumbHighlightColor = UIManager.getColor("ScrollBar.thumbHighlight");
				thumbLightShadowColor = UIManager.getColor("ScrollBar.thumbShadow");
				thumbDarkShadowColor = UIManager.getColor("ScrollBar.thumbDarkShadow");
				thumbColor = UIManager.getColor("ScrollBar.thumb");
				trackColor = UIManager.getColor("ScrollBar.track");
				trackHighlightColor = UIManager.getColor("ScrollBar.trackHighlight");
			}
		});
	}

}