import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Password Generator");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel label = new JLabel("Password Length:");
        label.setBounds(20, 20, 120, 25);
        frame.add(label);

        JTextField lengthField = new JTextField();
        lengthField.setBounds(150, 20, 150, 25);
        frame.add(lengthField);

        JButton generateButton = new JButton("Generate");
        generateButton.setBounds(100, 60, 120, 30);
        frame.add(generateButton);

        JTextField resultField = new JTextField();
        resultField.setBounds(20, 110, 280, 25);
        resultField.setEditable(false);
        frame.add(resultField);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int length = Integer.parseInt(lengthField.getText());
                    resultField.setText(generatePassword(length));
                } catch (NumberFormatException ex) {
                    resultField.setText("Enter a valid number");
                }
            }
        });

        frame.setVisible(true);
    }

    private static String generatePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return password.toString();
    }
}