package myPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class singlePlayer extends ticTacToe{
	
	public singlePlayer(){
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(200, 163, 72));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(300, 300, 600, 600);
		

		forSingle();
		addBackButton();
	}
	
	public void forSingle(){
		JPanel gridPanel = new JPanel();
	      gridPanel.setLayout(new GridLayout(3, 3));
	      frame.setSize(600, 600);
	      
	      for(int i = 0; i<9; i++) {
	    	  JButton button = new JButton("");
	    	  
	    	  gridPanel.add(button);
	      }
	      frame.getContentPane().add(gridPanel, BorderLayout.CENTER);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
