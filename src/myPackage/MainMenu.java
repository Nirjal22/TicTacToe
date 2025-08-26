package myPackage;

import javax.swing.*;
import java.awt.*;

public class MainMenu {
    JFrame frame;

    public MainMenu() {
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JTextField title = new JTextField("Tic Tac Toe");
        title.setBounds(0, 0, 600, 80);
        title.setEditable(false);
        title.setHorizontalAlignment(JTextField.CENTER);
        title.setFont(new Font("Ink Free", Font.BOLD, 30));
        frame.add(title);

        JButton singleBtn = new JButton("Single Player");
        singleBtn.setBounds(220, 200, 160, 40);
        singleBtn.addActionListener(e -> {
            frame.dispose();
            new GameBoard(true).show(); // true = singlePlayer
        });

        JButton multiBtn = new JButton("Multi Player");
        multiBtn.setBounds(220, 260, 160, 40);
        multiBtn.addActionListener(e -> {
            frame.dispose();
            new GameBoard(false).show(); // false = multiplayer
        });

        frame.add(singleBtn);
        frame.add(multiBtn);
    }

    public void show() {
        frame.setVisible(true);
    }
}
