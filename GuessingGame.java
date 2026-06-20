import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessingGame extends JFrame implements ActionListener {

    JLabel messageLabel;
    JTextField inputField;
    JButton guessButton;

    int randomNumber;
    int attempts = 0;

    GuessingGame() {

        Random random = new Random();
        randomNumber = random.nextInt(100) + 1;

        setTitle("Guessing Number Game");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        messageLabel = new JLabel("Guess a number between 1 and 100");

        inputField = new JTextField(10);

        guessButton = new JButton("Submit Guess");
        guessButton.addActionListener(this);

        add(messageLabel);
        add(inputField);
        add(guessButton);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        try {

            int guess = Integer.parseInt(inputField.getText());

            attempts++;

            if (guess < randomNumber) {
                messageLabel.setText("Too low! Try again.");
            }

            else if (guess > randomNumber) {
                messageLabel.setText("Too high! Try again.");
            }

            else {
                messageLabel.setText(
                    "Correct! Attempts: " + attempts
                );

                JOptionPane.showMessageDialog(
                    this,
                    "You guessed the number in "
                    + attempts + " attempts!"
                );

                randomNumber = new Random().nextInt(100) + 1;
                attempts = 0;
            }

            inputField.setText("");

        } catch (NumberFormatException ex) {

            messageLabel.setText("Please enter a valid number.");

        }
    }

    public static void main(String[] args) {

        new GuessingGame();

    }
}