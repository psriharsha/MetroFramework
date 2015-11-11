package com.fuzzy.metro.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.fuzzy.metro.listeners.MyWindowListener;

public abstract class MyFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT = 0;
	public static final int SUCCESS = 1;
	public static final int DANGER = 2;
	public static final int WARNING = 3;
	public static final int INFO = 4;
	public boolean isResizable = true;
	
	
	public MyFrame(){
		this(true);		
	}
	
	public MyFrame(boolean defaults){
		isResizable = defaults;
		getContentPane().setBackground(Color.WHITE);
		/*try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		if(isResizable){
			makeTheFrameResizable();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setShape(new java.awt.geom.RoundRectangle2D.Double(0,0,getWidth(),getHeight(),5,5));
        setLocationRelativeTo(null);
		createMenu();
		addComponentListener(new MyWindowListener());
	}
	
	private void makeTheFrameResizable() {
		// TODO Auto-generated method stub
		MyComponentResizer resizer = new MyComponentResizer();
		resizer.setSnapSize(new Dimension(5,5));
		resizer.registerComponent(this);
	}

	private void createMenu() {
		// TODO Auto-generated method stub
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setLayout(new BorderLayout());
		menuPanel = new JPanel();
		menuPanel.setOpaque(false);
		min = new MyButton("_");
		plus = new MyButton("+");
		close = new MyButton("x");
		min.setFocusPainted(false);
		plus.setFocusPainted(false);
		close.setFocusPainted(false);
		min.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				setState(ICONIFIED);
			}			
		});
		plus.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(plus.getText() == "+")
					plus.setText("-");
				else
					plus.setText("+");
				maximise();
			}
		});
		close.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		menuPanel.add(min);
		menuPanel.add(plus);
		menuPanel.add(close);
		menuBar.add(menuPanel, BorderLayout.EAST);
		menuBar.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent event) {
				// TODO Auto-generated method stub
				locX = event.getX();
				locY = event.getY();
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionListener(){

			@Override
			public void mouseDragged(MouseEvent event) {
				// TODO Auto-generated method stub
				setLocation(new Point(getLocation().x + event.getX() - locX, getLocation().y + event.getY() - locY));
			}

			@Override
			public void mouseMoved(MouseEvent event) {
				// TODO Auto-generated method stub
				
			}
		});
		title = new MyLabel("Metro UI".toUpperCase(), MyLabel.Type.TITLE);
		menuBar.add(title, BorderLayout.WEST);
		setJMenuBar(menuBar);
		setStatus(State.DANGER);
		setMinWidth();
		getRootPane().setBorder(BorderFactory.createMatteBorder(0, 1, 1, 1, Color.LIGHT_GRAY));
	}	

	protected void setMinWidth() {
		// TODO Auto-generated method stub
		int w = title.getPreferredSize().width + menuPanel.getPreferredSize().width;
		setMinimumSize(new Dimension(w,150));
	}

	public void setStatus(State state){
		//menuBar.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, state.getStateColor()));
		menuBar.setBackground(state.getStateColor());
	}
	
	public void setTitle(String windowHead){
		title.setText(windowHead.toUpperCase());
	}
	
	private void maximise(){
		GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
		   
	    // Get the screen devices
	    GraphicsDevice[] g=env.getScreenDevices();
	   
	    // I only have one, the first one
	    // If current window is full screen, set fullscreen window to null
	    // else set the current screen
	    g[0].setFullScreenWindow(g[0].getFullScreenWindow()==this?null:this);
	}

	public abstract void createLayout(Container contentPane);
	
	int locX, locY;
	JMenuBar menuBar;
	JPanel menuPanel;
	MyButton min,plus,close;
	MyLabel title;
}