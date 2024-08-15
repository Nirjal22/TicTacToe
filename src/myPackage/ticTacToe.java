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
	public boolean player1_turn = true;
	public JButton[][] button = new JButton[3][3];
	public JPanel gridPanel;
	
	
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
	
    public void check() {
    	for (int i = 0; i < 3; i++) {
            if (button[i][0].getText().equals(button[i][1].getText()) &&
                button[i][1].getText().equals(button[i][2].getText()) &&
                !button[i][0].getText().equals("")) {
                showWinner(button[i][0].getText());
                return;
            }
        }
        
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (button[0][i].getText().equals(button[1][i].getText()) &&
                button[1][i].getText().equals(button[2][i].getText()) &&
                !button[0][i].getText().equals("")) {
                showWinner(button[0][i].getText());
                return;
            }
        }
        
        // Check diagonals
        if (button[0][0].getText().equals(button[1][1].getText()) &&
            button[1][1].getText().equals(button[2][2].getText()) &&
            !button[0][0].getText().equals("")) {
            showWinner(button[0][0].getText());
            return;
        }
        
        if (button[0][2].getText().equals(button[1][1].getText()) &&
            button[1][1].getText().equals(button[2][0].getText()) &&
            !button[0][2].getText().equals("")) {
            showWinner(button[0][2].getText());
            return;
        }
        
        // Check for draw
        boolean draw = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (button[i][j].getText().equals("")) {
                    draw = false;
                    break;
                }
            }
        }
        if (draw) {
            textField.setText("Draw");
        }
    }
    
    private void showWinner(String winner) {
    	textField.setText(winner + " wins");
        disableButtons();
    }
    
    private void disableButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                button[i][j].setEnabled(false);
            }
        }
    }
    }
