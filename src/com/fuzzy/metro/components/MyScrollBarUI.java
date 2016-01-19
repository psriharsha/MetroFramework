package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;

import com.fuzzy.metro.Singleton;
import com.jidesoft.plaf.basic.ThemePainter;
import com.jidesoft.swing.JideButton;

public class MyScrollBarUI extends BasicScrollBarUI{
	
	private JideButton increaseButton, decreaseButton;
	private MyScrollBar scrollBar;

	@Override
	protected ArrowButtonListener createArrowButtonListener() {
		// TODO Auto-generated method stub
		return super.createArrowButtonListener();
	}

	@Override
	protected JButton createDecreaseButton(int orientation) {
		// TODO Auto-generated method stub
		return decreaseButton;
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		// TODO Auto-generated method stub
		return increaseButton;
	}
	
	 @Override
     protected void paintThumb(final java.awt.Graphics g, final javax.swing.JComponent c, final java.awt.Rectangle thumbBounds) {
        if (thumbBounds.isEmpty() || !this.scrollbar.isEnabled()) {
           return;
        }
        g.translate(thumbBounds.x, thumbBounds.y);
        g.setColor(Singleton.defaultColor);
        g.drawRect(2, 0, 12, thumbRect.height);
        g.setColor(Singleton.defaultColor);
        g.fillRect(2, 0, 12, thumbRect.height);
        g.setColor(Singleton.defaultColor);
        g.setColor(Singleton.defaultColor);
        g.translate(-thumbBounds.x, -thumbBounds.y);
         
     }
	 
	 @Override
	 protected void paintTrack(final java.awt.Graphics g, final javax.swing.JComponent c, final java.awt.Rectangle thumbBounds){
		 g.setColor(Color.WHITE);
		 g.drawRect(0, 0, 12, scrollBar.getHeight());
		 g.fillRect(0, 0, 12, scrollBar.getHeight());
	 }

	public MyScrollBarUI(MyScrollBar scrollBar){
		ImageIcon increaseIcon = MyIcon.createImageIcon("./down.png");
		ImageIcon decreaseIcon = MyIcon.createImageIcon("./up.png");
		increaseButton = createJideButton(increaseIcon);
		decreaseButton = createJideButton(decreaseIcon);
		this.scrollBar = scrollBar;
	}
	
	public JideButton createJideButton(ImageIcon icon){
		JideButton button = new JideButton(icon);
		button.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
		button.setBackgroundOfState(ThemePainter.STATE_PRESSED, Color.WHITE);
		button.setBackgroundOfState(ThemePainter.STATE_ROLLOVER, Color.WHITE);
		return button;
	}
	
}