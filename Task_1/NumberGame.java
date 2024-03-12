import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NumberGame extends JFrame {
    private int targetNumber;
    private int attemptsLeft;
    private JTextField guessField;
    private JLabel feedbackLabel;
    
    public NumberGame() {
        setTitle("Number Guessing Game");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        targetNumber = generateRandomNumber();
        attemptsLeft = 5; // Limiting attempts to 5

        JLabel titleLabel = new JLabel("Guess the Number (1-100)");
        add(titleLabel);

        guessField = new JTextField();
        add(guessField);

        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(new GuessListener());
        add(guessButton);

        feedbackLabel = new JLabel("Attempts left: " + attemptsLeft);
        add(feedbackLabel);

        setVisible(true);
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    private class GuessListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int guess = Integer.parseInt(guessField.getText());
            if (guess == targetNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations! You guessed it right!");
                targetNumber = generateRandomNumber();
                attemptsLeft = 5;
            } else if (guess < targetNumber) {
                JOptionPane.showMessageDialog(null, "Too low! Try again.");
                attemptsLeft--;
            } else {
                JOptionPane.showMessageDialog(null, "Too high! Try again.");
                attemptsLeft--;
            }

            if (attemptsLeft == 0) {
                JOptionPane.showMessageDialog(null, "You've used all your attempts. The number was: " + targetNumber);
                targetNumber = generateRandomNumber();
                attemptsLeft = 5;
            }

            feedbackLabel.setText("Attempts left: " + attemptsLeft);
            guessField.setText("");
        }
    }

    public static void main(String[] args) {
        new NumberGame();
    }
}
