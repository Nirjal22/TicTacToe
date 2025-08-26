package myPackage;

import javax.swing.*;
import java.awt.*;

public class GameBoard {
    JFrame frame;
    JButton[][] buttons = new JButton[3][3];
    boolean player1Turn = true;
    boolean singlePlayer;

    public GameBoard(boolean isSinglePlayer) {
        this.singlePlayer = isSinglePlayer;

        frame = new JFrame(isSinglePlayer ? "Single Player" : "Multiplayer");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 3));
        JTextField status = new JTextField("Tic Tac Toe");
        status.setEditable(false);
        status.setHorizontalAlignment(JTextField.CENTER);
        status.setFont(new Font("Arial", Font.BOLD, 20));

        frame.add(status, BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton btn = new JButton("");
                btn.setFont(new Font("Arial", Font.BOLD, 40));
                int x = i, y = j;

                btn.addActionListener(e -> {
                    if (!btn.getText().equals(""))
                        return;

                    btn.setText(player1Turn ? "X" : "O");
                    if (GameLogic.checkWinner(buttons)) {
                        status.setText((player1Turn ? "X" : "O") + " Wins!");
                        GameLogic.disableAll(buttons);
                    } else if (GameLogic.isDraw(buttons)) {
                        status.setText("Draw!");
                    } else {
                        player1Turn = !player1Turn;
                        if (singlePlayer && !player1Turn) {
                            GameLogic.makeAIMove(buttons);
                            if (GameLogic.checkWinner(buttons)) {
                                status.setText("O Wins!");
                                GameLogic.disableAll(buttons);
                            } else if (GameLogic.isDraw(buttons)) {
                                status.setText("Draw!");
                            }
                            player1Turn = true;
                        }
                    }
                });

                buttons[i][j] = btn;
                panel.add(btn);
            }
        }

        JButton backBtn = new JButton("Back");
        backBtn.addActionListener(e -> {
            frame.dispose();
            new MainMenu().show();
        });

        frame.add(backBtn, BorderLayout.SOUTH);
    }

    public void show() {
        frame.setVisible(true);
    }
}
