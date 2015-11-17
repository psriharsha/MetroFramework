package com.fuzzy.metro.components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import com.fuzzy.metro.Singleton;
import com.fuzzy.metro.listeners.MyDragListener;
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
				if(getDefaultCloseOperation() == EXIT_ON_CLOSE)
					System.exit(0);
				else if(getDefaultCloseOperation() == DISPOSE_ON_CLOSE)
					dispose();
			}
		});
		menuPanel.add(min);
		menuPanel.add(plus);
		menuPanel.add(close);
		menuBar.add(menuPanel, BorderLayout.EAST);
		MyDragListener dragListener = new MyDragListener(this);
		menuBar.addMouseListener(dragListener);
		menuBar.addMouseMotionListener(dragListener);
		title = new MyLabel(Singleton.projectTitle.toUpperCase(), MyLabel.Type.TITLE);
		menuBar.add(title, BorderLayout.WEST);
		setJMenuBar(menuBar);
		setKind(Kind.DEFAULT);
		setMinWidth();
		getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Singleton.defaultColor));
	}	

	protected void setMinWidth() {
		// TODO Auto-generated method stub
		int w = title.getPreferredSize().width + menuPanel.getPreferredSize().width;
		setMinimumSize(new Dimension(w,100));
	}

	public void setKind(Kind state){
		//menuBar.setBorder(BorderFactory.createMatteBorder(5, 0, 0, 0, state.getStateColor()));
		menuBar.setBackground(state.getStateColor());
		getRootPane().setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, state.getStateColor()));
	}
	
	public void setTitle(String windowHead){
		title.setText(windowHead.toUpperCase());
	}
	
	private void maximise(){
		/*GraphicsEnvironment env=GraphicsEnvironment.getLocalGraphicsEnvironment();
		   
	    // Get the screen devices
	    GraphicsDevice[] g=env.getScreenDevices();
	   
	    // I only have one, the first one
	    // If current window is full screen, set fullscreen window to null
	    // else set the current screen
	    g[0].setFullScreenWindow(g[0].getFullScreenWindow()==this?null:this);*/
		int winState = getExtendedState();
		if(winState == NORMAL){
			winState = MAXIMIZED_BOTH;
		}else{
			winState = NORMAL;
		}
		setExtendedState(winState);
	}

	public abstract void createLayout(Container contentPane);
	
	int locX, locY;
	JMenuBar menuBar;
	JPanel menuPanel;
	MyButton min,plus,close;
	MyLabel title;
}