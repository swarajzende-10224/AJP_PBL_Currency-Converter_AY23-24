package SamplePKG;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class CurrencyConverter implements ActionListener {
    JFrame frame;
    JLabel label;
    JTextField inputField, outputField;
    JButton resetButton, inrToUsdButton, inrToPoundsButton, usdToInrButton, usdToPoundsButton, poundsToInrButton, poundsToUsdButton;

    CurrencyConverter() {
        frame = new JFrame("Currency Converter");
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLayout(null);

        label = new JLabel("Currency Converter");
        label.setBounds(100, 10, 200, 20);

        inputField = new JTextField();
        inputField.setBounds(20, 100, 100, 20);

        inrToUsdButton = new JButton("INR To USD");
        inrToUsdButton.setBounds(20, 130, 150, 50);

        inrToPoundsButton = new JButton("INR To POUNDS");
        inrToPoundsButton.setBounds(20, 200, 150, 50);

        usdToInrButton = new JButton("USD To INR");
        usdToInrButton.setBounds(20, 270, 150, 50);

        usdToPoundsButton = new JButton("USD To POUNDS");
        usdToPoundsButton.setBounds(250, 130, 150, 50);

        poundsToInrButton = new JButton("POUNDS To INR");
        poundsToInrButton.setBounds(250, 200, 150, 50);

        poundsToUsdButton = new JButton("POUNDS To USD");
        poundsToUsdButton.setBounds(250, 270, 150, 50);

        outputField = new JTextField();
        outputField.setBounds(20, 340, 150, 20);

        resetButton = new JButton("RESET");
        resetButton.setBounds(20, 370, 100, 50);

        frame.add(label);
        frame.add(inputField);
        frame.add(outputField);
        frame.add(resetButton);
        frame.add(inrToUsdButton);
        frame.add(inrToPoundsButton);
        frame.add(usdToInrButton);
        frame.add(usdToPoundsButton);
        frame.add(poundsToInrButton);
        frame.add(poundsToUsdButton);

        resetButton.addActionListener(this);
        inrToUsdButton.addActionListener(this);
        inrToPoundsButton.addActionListener(this);
        usdToInrButton.addActionListener(this);
        usdToPoundsButton.addActionListener(this);
        poundsToInrButton.addActionListener(this);
        poundsToUsdButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == resetButton) {
            inputField.setText("");
            outputField.setText("");
        } else {
            try {
                double amount = Double.parseDouble(inputField.getText());
                double result = 0;
                if (source == inrToUsdButton) {
                    result = amount / 84; // 1 INR = 0.0119 USD
                } else if (source == inrToPoundsButton) {
                    result = amount * 0.0094; // 1 INR = 0.0094 Pounds
                } else if (source == usdToInrButton) {
                    result = amount * 84; // 1 USD = 84 INR
                } else if (source == usdToPoundsButton) {
                    result = amount * 0.78; // 1 USD = 0.78 Pounds
                } else if (source == poundsToInrButton) {
                    result = amount / 0.0094; // 1 Pound = 106.38 INR
                } else if (source == poundsToUsdButton) {
                    result = amount / 1.28; // 1 Pound = 0.78 USD
                }
                outputField.setText(Double.toString(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid input! Please enter a valid number.");
            }
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
