package com.fuzzy.metro.chatter;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;

import com.fuzzy.metro.components.MyLabel;

public class MyListRenderer extends DefaultListCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private static final ImageIcon tipIcon = new ImageIcon ( CustomListRenderer.class.getResource ( "comment.png" ) );
    
    private ChatLabel renderer;

    /**
     * Custom renderer constructor.
     * We will use it to create actual renderer component instance.
     * We will also add a custom mouse listener to process close button.
     *
     * @param list our JList instance
     */
    public MyListRenderer (final JList<CustomData> list )
    {
        super();
        renderer = new ChatLabel ();
    }
    
    @Override
    public Component getListCellRendererComponent ( JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus )
    {
        renderer.setSelected ( isSelected );
        renderer.setData ( ( CustomData ) value );
        return renderer;
    }
    
	private static class ChatLabel extends MyLabel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private static final Color selectionColor = new Color(82, 158, 202);

		private boolean selected;
		private CustomData data;

		public ChatLabel() {
			super();
			setOpaque(false);
			setBorder(BorderFactory.createEmptyBorder(0, 36 + 5, 0, 40));
		}

		private void setSelected(boolean selected) {
			this.selected = selected;
			setForeground(selected ? Color.WHITE : Color.BLACK);
		}

		private void setData(CustomData data) {
			this.data = data;
			setText(data.getName());
		}

		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

			if (selected) {
				Area area = new Area(new Ellipse2D.Double(0, 0, 36, 36));
				area.add(new Area(new RoundRectangle2D.Double(18, 3, getWidth() - 18, 29, 6, 6)));
				g2d.setPaint(selectionColor);
				g2d.fill(area);

				g2d.setPaint(Color.WHITE);
				g2d.fill(new Ellipse2D.Double(2, 2, 32, 32));
			}
			
			g2d.setPaint(data.getCircleColor());
			g2d.fill(new Ellipse2D.Double(5, 5, 26, 26));
			g2d.drawImage(tipIcon.getImage(), 5 + 13 - tipIcon.getIconWidth() / 2, 5 + 13 - tipIcon.getIconHeight() / 2,
					null);

			/*if (selected) {
				g2d.drawImage(crossIcon.getImage(), getWidth() - 9 - 5 - crossIcon.getIconWidth() / 2,
						getHeight() / 2 - crossIcon.getIconHeight() / 2, null);
			} else if (data.getNewMessages() > 0) {
				g2d.setPaint(selectionColor);
				g2d.fill(new Ellipse2D.Double(getWidth() - 18 - 5, getHeight() / 2 - 9, 18, 18));

				final String text = "" + data.getNewMessages();
				final Font oldFont = g2d.getFont();
				g2d.setFont(oldFont.deriveFont(oldFont.getSize() - 1f));
				final FontMetrics fm = g2d.getFontMetrics();
				g2d.setPaint(Color.WHITE);
				g2d.drawString(text, getWidth() - 9 - 5 - fm.stringWidth(text) / 2,
						getHeight() / 2 + (fm.getAscent() - fm.getLeading() - fm.getDescent()) / 2);
				g2d.setFont(oldFont);
			}*/

			super.paintComponent(g);
		}

		@Override
		public Dimension getPreferredSize() {
			final Dimension ps = super.getPreferredSize();
			ps.height = 36;
			return ps;
		}
	}

}
