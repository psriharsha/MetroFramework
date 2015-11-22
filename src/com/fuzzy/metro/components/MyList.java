package com.fuzzy.metro.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import com.fuzzy.metro.chatter.Colleague;

public class MyList extends JList<String>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MyList(DefaultListModel<String> listModel) {
		// TODO Auto-generated constructor stub
		super(listModel);
		//setCellRenderer((ListCellRenderer<? super Colleague>) new ListRenderer(this));
	}
	
	private static class CustomLabel extends JLabel
    {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private static final Color selectionColor = new Color ( 82, 158, 202 );

        private boolean selected;
        private Colleague data;

        public CustomLabel ()
        {
            super ();
            setOpaque ( false );
            setBorder ( BorderFactory.createEmptyBorder ( 0, 36 + 5, 0, 40 ) );
        }

        private void setSelected ( boolean selected )
        {
            this.selected = selected;
            setForeground ( selected ? Color.WHITE : Color.BLACK );
        }

        private void setData ( Colleague data )
        {
            this.data = data;
            setText ( data.getUsername () );
        }

        @Override
        protected void paintComponent ( Graphics g )
        {
            

            super.paintComponent ( g );
        }

        @Override
        public Dimension getPreferredSize ()
        {
            final Dimension ps = super.getPreferredSize ();
            ps.height = 36;
            return ps;
        }
    }

}