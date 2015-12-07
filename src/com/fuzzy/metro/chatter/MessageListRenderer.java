package com.fuzzy.metro.chatter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.border.Border;

import com.fuzzy.metro.components.Kind;
import com.fuzzy.metro.components.MyFloatingLabel;
import com.fuzzy.metro.components.MyFont;
import com.fuzzy.metro.components.MyLabel;
import com.fuzzy.metro.components.MyLabel.Type;
import com.fuzzy.metro.components.MyPanel;
import com.fuzzy.metro.components.MyScrollPane;
import com.fuzzy.metro.components.WrapLayout;

public class MessageListRenderer extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private MessagePanel renderer = null;
	
	public MessageListRenderer(JList<MessageData> data){
		renderer = new MessagePanel();
	}
	
	@Override
	public Component getListCellRendererComponent(JList<?> arg0, Object msgData, int arg2, boolean arg3, boolean arg4) {
		// TODO Auto-generated method stub
		renderer.completeLayout((MessageData) msgData);
		return renderer;
	}



	private static class MessagePanel extends MyPanel{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private MyPanel top, content, wrapper;
		private MyScrollPane scroller;
		public MyFloatingLabel msgContent;
		
		public MessagePanel(){
			super();
			Border padding = BorderFactory.createEmptyBorder(2, 2, 2, 2);
			Border line = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(216,225,228));
			setBorder(BorderFactory.createCompoundBorder(line, padding));
			setLayout(new BoxLayout( this, BoxLayout.Y_AXIS));
		}
		
		private void completeLayout(MessageData msgData){
			MyFont newFont = new MyFont();
			MyLabel name = new MyLabel(msgData.getSender(),Type.BOLD);
			name.setFont(newFont.getFont().deriveFont(Font.BOLD, 14));
			name.setAlignmentX(LEFT_ALIGNMENT);
			SimpleDateFormat ft = 
				      new SimpleDateFormat ("dd/MMM/yyyy hh:mm:ss");
			MyLabel sent = new MyLabel(ft.format(msgData.getSentAt()), Type.ITALIC);
			sent.setFont(newFont.getFont().deriveFont(Font.ITALIC, 9));
			sent.setAlignmentX(RIGHT_ALIGNMENT);
			sent.setState(Kind.INFO);
			top = new MyPanel();
			top.setLayout(new BorderLayout());
			top.add(name, BorderLayout.LINE_START);
			top.add(new MyLabel(""), BorderLayout.CENTER);
			top.add(sent, BorderLayout.LINE_END);
			content = new MyPanel();
			content.setLayout(new BorderLayout());
			msgContent = new MyFloatingLabel(msgData.getMessage());
			/*scroller = new MyScrollPane(msgContent);
			scroller.setSize(getMaximumSize());*/
			msgContent.scrollRectToVisible(getBounds());
			content.add(msgContent, BorderLayout.CENTER);
			if(getComponentCount() == 0){
				/*wrapper = new MyPanel();
				wrapper.setLayout(new BorderLayout());
				wrapper.add(top, BorderLayout.NORTH);
				wrapper.add(content, BorderLayout.CENTER);*/
				add(top, BorderLayout.NORTH);
				add(content, BorderLayout.CENTER);
			}
		}

		/*@Override
		public Dimension getPreferredSize() {
			// TODO Auto-generated method stub
			System.out.println(msgContent.getMinimumSize().height);
			return new Dimension((int)getSize().getWidth(),(int)msgContent.getMinimumSize().height);
		}*/
		
	}

}