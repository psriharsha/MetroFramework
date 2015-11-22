package com.fuzzy.metro.components;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JSplitPane;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;

public class MySplitPane extends JSplitPane{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MySplitPane(){
		super();
		defineUI();
	}

	private void defineUI() {
		// TODO Auto-generated method stub

		setUI(new BasicSplitPaneUI(){
			public BasicSplitPaneDivider createDefaultDivider() {
                return new BasicSplitPaneDivider(this) {
                    /**
					 * 
					 */
					private static final long serialVersionUID = 1L;

					public void setBorder(Border b) {
						super.setBorder(BorderFactory.createMatteBorder(0, 3, 3, 3,Color.LIGHT_GRAY));
                    }
                };
            }
		});
	}

	public MySplitPane(int horizontalSplit, MyPanel listPanel, MyPanel contentPanel) {
		// TODO Auto-generated constructor stub
		super(horizontalSplit, listPanel, contentPanel);
	}

}