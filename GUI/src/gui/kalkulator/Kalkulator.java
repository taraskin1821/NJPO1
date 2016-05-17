package gui.kalkulator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Kalkulator extends JFrame {

    private JTextField pierwszaLiczbaTextField;
    private JTextField drugaLiczbaTextField;
    private JPanel jPanel;
    private JRadioButton odejmnijRadioButton;
    private JRadioButton dodajRadioButton;
    private JRadioButton pomnozRadioButton;
    private JRadioButton podzielRadioButton;
    private JButton obliczJButton;
    private JLabel wynikLabel;

    public Kalkulator() {
        super("Kalkulator");
        setContentPane(jPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final ButtonGroup opcje = new ButtonGroup();

        opcje.add(odejmnijRadioButton);
        opcje.add(dodajRadioButton);
        opcje.add(pomnozRadioButton);
        opcje.add(podzielRadioButton);

        dodajRadioButton.setSelected(true);


        obliczJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double a = Double.parseDouble(pierwszaLiczbaTextField.getText());
                double b = Double.parseDouble(drugaLiczbaTextField.getText());

                if (odejmnijRadioButton.isSelected()) {
                    wynikLabel.setText((a-b) + "");
                } else if (dodajRadioButton.isSelected()) {
                    wynikLabel.setText((a+b) + "");
                } else if (pomnozRadioButton.isSelected()) {
                    wynikLabel.setText((a*b) + "");
                } else if (podzielRadioButton.isSelected()) {
                    wynikLabel.setText((a/b) + "");
                }
            }
        });

        setVisible(true);
    }


}
