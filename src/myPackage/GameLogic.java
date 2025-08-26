package myPackage;

import javax.swing.JButton;

public class GameLogic {

    public static boolean checkWinner(JButton[][] buttons) {
        for (int i = 0; i < 3; i++) {
            if (equals(buttons[i][0], buttons[i][1], buttons[i][2]))
                return true;
            if (equals(buttons[0][i], buttons[1][i], buttons[2][i]))
                return true;
        }

        if (equals(buttons[0][0], buttons[1][1], buttons[2][2]))
            return true;
        if (equals(buttons[0][2], buttons[1][1], buttons[2][0]))
            return true;

        return false;
    }

    public static boolean isDraw(JButton[][] buttons) {
        for (JButton[] row : buttons)
            for (JButton btn : row)
                if (btn.getText().equals(""))
                    return false;
        return true;
    }

    public static void disableAll(JButton[][] buttons) {
        for (JButton[] row : buttons)
            for (JButton btn : row)
                btn.setEnabled(false);
    }

    private static boolean equals(JButton a, JButton b, JButton c) {
        return !a.getText().equals("") &&
                a.getText().equals(b.getText()) &&
                b.getText().equals(c.getText());
    }

    public static void makeAIMove(JButton[][] buttons) {
        // Simple AI: first empty button
        for (JButton[] row : buttons) {
            for (JButton btn : row) {
                if (btn.getText().equals("")) {
                    btn.setText("O");
                    return;
                }
            }
        }
    }
}
