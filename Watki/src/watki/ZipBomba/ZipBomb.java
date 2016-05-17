package watki.ZipBomba;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ZipBomb extends JFrame implements ActionListener {
    private JPanel rootPanel;
    private JButton uruchomButton;


    public ZipBomb() {
        super("Zip bomba");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        uruchomButton.addActionListener(this);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("uruchom Zip-Bombe")) {
            uruchomBombe();
        }

    }

    public void uruchomBombe() {

        Thread[] watki = new Thread[10];

        for (int i = 0; i < watki.length; i++) {

            watki[i] = new Thread(new ZipBombThread(i));
            watki[i].start();

        }

    }
}
