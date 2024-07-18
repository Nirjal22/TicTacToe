package myPackage;

import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ticTacToe {

	public JFrame frame;
	public JTextField textField;
	public boolean player1_turn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticTacToe window = new ticTacToe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ticTacToe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 163, 72));
		frame.setBounds(300, 300, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
				
		textField = new JTextField();
		textField.setBounds(0, 0, 600, 78);
		textField.setEditable(false);
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free", Font.BOLD,24));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText("Tic Tac Toe");
		textField.setOpaque(true);
		frame.getContentPane().add(textField, BorderLayout.NORTH);

		JButton btnMultiPlayer = new JButton("Multi Player");
		btnMultiPlayer.setBounds(230, 300, 158, 25);
		frame.getContentPane().add(btnMultiPlayer, BorderLayout.CENTER);
		btnMultiPlayer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				multiPlayer multiplayer = new multiPlayer();
				multiplayer.setVisible(true);
				
			}
		});
		
		JButton btnSinglePlayer = new JButton("Single Player");
		btnSinglePlayer.setBounds(230, 250, 158, 25);
		frame.getContentPane().add(btnSinglePlayer,BorderLayout.CENTER);
		btnSinglePlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				singlePlayer singleplayer = new singlePlayer();
				singleplayer.setVisible(true);
				
			}
		});
	}
	
	public void addBackButton() {
		JButton goBack = new JButton("Back");
//		goBack.setBounds(0, 0, 158, 25);
		frame.getContentPane().add(goBack, BorderLayout.SOUTH);
		goBack.setVisible(true);
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ticTacToe().main(new String[0]); //opens the main menu again
			}
		});
	}
}
