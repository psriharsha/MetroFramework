package com.fuzzy.metro.listeners;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.fuzzy.metro.components.MyPanel;
import com.fuzzy.metro.components.MyTabHead;
import com.fuzzy.metro.components.MyTabHead.State;

public class MyTabListener implements MouseListener{
	
	MyTabHead tabHead;
	MyPanel panel;
	public static List<MyTabHead> tabHeads = new ArrayList<MyTabHead>();
	
	public MyTabListener(MyTabHead tabHead, MyPanel panel){
		tabHeads.add(tabHead);
		this.tabHead = tabHead;
		this.panel = panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		CardLayout cl = (CardLayout)(panel.getLayout());
        cl.show(panel, tabHead.getText());
        Iterator<MyTabHead> heads = tabHeads.iterator();
		while(heads.hasNext()){
			MyTabHead tab = heads.next();
			tab.setState(State.INACTIVE);
		}
		tabHead.setState(State.ACTIVE);
		//.setState(Kind.ACTIVE);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}