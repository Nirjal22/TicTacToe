package myPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class multiPlayer extends ticTacToe{
	
	public multiPlayer() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(155, 163, 72));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(300, 300, 600, 600);
		

		forMulti();
		addBackButton();
	}
	
	public void forMulti() {
		gridPanel = new JPanel();
		
	      gridPanel.setLayout(new GridLayout(3, 3));

	        for(int i = 0; i < 3; i++) {
	        	for(int j = 0;j<3;j++) {
	            button[i][j] = new JButton("");
	            button[i][j].setFont(new Font("Ink Free", Font.BOLD, 120));
	            button[i][j].setFocusable(false);
	            button[i][j].addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                	JButton button = (JButton)e.getSource();
	                    if (button.getText().equals("")) {
	                        if (player1_turn) {
	                            button.setForeground(new Color(255, 0, 0));
	                            button.setText("X");
	                            textField.setText("O's turn");
	                            player1_turn = false;
	                            
	                        } else {
	                            button.setForeground(new Color(0, 0, 255));
	                            button.setText("O");
	                            textField.setText("X's turn");
	                            player1_turn = true;
	                        }
	                        check();
	                    }
	                }
	        	});
	            gridPanel.add(button[i][j]);
	        }
	        }
	        frame.getContentPane().add(gridPanel, BorderLayout.CENTER);
	    }
	
	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}
