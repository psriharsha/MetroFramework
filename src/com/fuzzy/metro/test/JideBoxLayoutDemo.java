package com.fuzzy.metro.test;

import com.jidesoft.plaf.LookAndFeelFactory;
import com.jidesoft.swing.JideBoxLayout;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Demoed Component: {@link JideBoxLayout} <br> Required jar files: jide-common.jar <br> Required L&F: any L&F
 */
public class JideBoxLayoutDemo{
    private static final long serialVersionUID = 8694420413636800414L;

    public String getName() {
        return "JideBoxLayout Demo";
    }


    public Component getDemoPanel() {
        // create a panel with JideBoxLayout
        JPanel panel = new JPanel();
        JideBoxLayout jbl = new JideBoxLayout(panel, 0, 6);
        jbl.setAxis(JideBoxLayout.Y_AXIS);
        panel.setLayout(jbl);

        JButton button = new JButton("FIX (w:120)");
        button.setPreferredSize(new Dimension(120, 200));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        panel.add(button, JideBoxLayout.FIX);

        button = new JButton("FLEX (w:120)");
        button.setPreferredSize(new Dimension(120, 200));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        panel.add(button, JideBoxLayout.FLEXIBLE);

        button = new JButton("FLEX (w:240)");
        button.setPreferredSize(new Dimension(240, 200));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        panel.add(button, JideBoxLayout.FLEXIBLE);

        button = new JButton("VARY (w:120)");
        button.setPreferredSize(new Dimension(120, 200));
        button.setMinimumSize(new Dimension(0, 0));
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        panel.add(button, JideBoxLayout.VARY);

        panel.setBorder(new TitledBorder("Resize the panel to see the child components resizing behavior"));

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                LookAndFeelFactory.installDefaultLookAndFeelAndExtension();
                JideBoxLayoutDemo jd = new JideBoxLayoutDemo();
                JFrame f = new JFrame("Test");
                f.getContentPane().add(jd.getDemoPanel());
                f.setVisible(true);
                f.setSize(500, 500);
            }
        });
    }
}