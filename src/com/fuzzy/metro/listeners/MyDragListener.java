package com.fuzzy.metro.listeners;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.fuzzy.metro.components.MyFrame;

public class MyDragListener implements MouseListener, MouseMotionListener{
	
	public int locX, locY;
	public MyFrame contextFrame;
	
	public MyDragListener(MyFrame frame){
		contextFrame = frame;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		contextFrame.setLocation(new Point(contextFrame.getLocation().x + e.getX() - locX, contextFrame.getLocation().y + e.getY() - locY));
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		locX = e.getX();
		locY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}