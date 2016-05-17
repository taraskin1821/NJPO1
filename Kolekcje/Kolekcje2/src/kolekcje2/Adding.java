package kolekcje2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Adding extends JFrame implements ActionListener {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton DODAJButton;
    private JPanel rootPanel;

    public Adding() {

        super("Dodaj kontakt");

        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        DODAJButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("DODAJ")) {

            int housenumber;

            try {
                housenumber = Integer.parseInt(textField4.getText().trim());
                Integer.parseInt(textField4.getText().trim());
            } catch (NumberFormatException e1) {
                housenumber = 0;
            }


            new Person(textField1.getText(), textField2.getText(), textField3.getText(), housenumber, textField6.getText(), textField5.getText());

            dispose();
        }


    }
}
