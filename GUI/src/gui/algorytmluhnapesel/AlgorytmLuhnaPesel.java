package gui.algorytmluhnapesel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;


public class AlgorytmLuhnaPesel extends JFrame {


    private JTextField jTextField;
    private JButton jButton;
    private JLabel jLabel;
    private JPanel jPanel;

    public AlgorytmLuhnaPesel() {
        super("Sprawdzanie poprawnosci PESEL");
        setContentPane(jPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (sprawdzNumer(jTextField.getText())) {
                    jLabel.setText("Wprowadzony PESEL jest poprawny");
                    dopiszDoPliku(jTextField.getText());
                    jTextField.setText("");
                }

                else
                    jLabel.setText("Wprowadzony PESEL jest fałszywy");


            }
        });

        setVisible(true);
    }



    boolean sprawdzNumer(String digits) {
        try {

            int[] pesel = new int[digits.length()];
            for (int i = 0; i < pesel.length; i++) {
                pesel[i] = Integer.parseInt(digits.substring(i, i + 1));
            }

            int suma = pesel[0] +
                    pesel[1] * 3 +
                    pesel[2] * 7 +
                    pesel[3] * 9 +
                    pesel[4] +
                    pesel[5] * 3 +
                    pesel[6] * 7 +
                    pesel[7] * 9 +
                    pesel[8] +
                    pesel[9] * 3;

            suma = suma % 10;

            if (suma == pesel[10]) return true;
            else return (10 - suma) == pesel[10];

        } catch (Exception e) {
            return false;
        }

    }


    public void dopiszDoPliku(String pesel) {

        File file = new File("poprawene_numery_PESEL.doc");

        try {
            if (!file.exists())
                file.createNewFile();

            PrintWriter out =new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            out.append(pesel+"\n");
            out.close();

        } catch (Exception e) {
        }


    }

}
