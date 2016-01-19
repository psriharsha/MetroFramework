package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

import com.fuzzy.metro.Singleton;

public class MyComboBox extends JComboBox<String>{
	
	private int direction;
	private Boolean hasPlaceholder;
	private List<String> items;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyComboBox(){
		this(SwingConstants.LEFT);
	}
	
	public MyComboBox(int direction){
		this(direction, false);
	}
	
	public MyComboBox(int direction, Boolean hasPlaceholder){
		this.direction = direction;
		this.hasPlaceholder = hasPlaceholder;
		items = new ArrayList<String>();
		setInterface();
	}
	
	@SuppressWarnings("unchecked")
	private void setInterface(){
		setOpaque(false);
		Font font = (new MyFont()).getFont();
		font = font.deriveFont(Font.BOLD, 12);
		setFont(font);
		setBackground(Singleton.defaultColor);
		setForeground(Color.WHITE);
		setAlignmentX(direction);
		setBorder(BorderFactory.createEmptyBorder());
		setUI(new MyComboBoxUI());
		setRenderer(new ComboBoxRenderer());
		setModel(new MyComboBoxModel());
	}
	
	private class ComboBoxRenderer extends BasicComboBoxRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@SuppressWarnings("rawtypes")
		@Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			// TODO Auto-generated method stub
			setText(value.toString());
			setBackground(Singleton.defaultColor);
			setForeground(Color.WHITE);
			setHorizontalAlignment(direction);
			setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
			if(isSelected) setBackground(Singleton.defaultColor);
			if(cellHasFocus) setBackground(Singleton.defaultColor);
			list.setSelectionBackground(Singleton.defaultColor);
			list.setSelectionForeground(Color.WHITE);
			//list.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
			return this;
		}
		
	}
	
	private class MyComboBoxModel extends DefaultComboBoxModel<String>{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private static final String NOT_SELECTABLE_OPTION = "Settings";
		private Boolean selectionAllowed = hasPlaceholder;

		@Override
		public void setSelectedItem(Object object) {
			// TODO Auto-generated method stub
			if (object.toString() != NOT_SELECTABLE_OPTION) {
		          super.setSelectedItem(object);
		        } else if (selectionAllowed) {
		          // Allow this just once
		          selectionAllowed = false;
		          super.setSelectedItem(object);
		        }
		}

		@Override
		public void addElement(String anObject) {
			// TODO Auto-generated method stub
			super.addElement(anObject);
			items.add(anObject.toString());
		}
		
	}
	
	

}