package watki.Silnia;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Silnia extends JFrame implements ActionListener {
    private JPanel rootPanel;
    private JTextField liczba;
    private JButton licz;
    private JButton PRZERWIJButton;
    private JTextArea textArea1;

    Thread[] threads;

    public Silnia() {
        super("Oblicz Silnie");
        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        licz.addActionListener(this);
        PRZERWIJButton.addActionListener(this);
        textArea1.setText("");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("licz")) {
            oblicz();
        } else if (e.getActionCommand().equals("przerwij")) {
            przerwij();
        }

    }



    private void przerwij() {

        try {
            threads[0].interrupt();
            threads[1].interrupt();

            Thread.sleep(500);
        } catch (Exception e) {

        }

        textArea1.setText("PRZERWANO");
    }

    private void oblicz() {

        int liczba = 0;

        try {
            liczba = Integer.parseInt(this.liczba.getText().trim());
        } catch (Exception e) {
            textArea1.setText("");
            return;
        }

        threads = new Thread[2];

        Iteracyjnie iter = new Iteracyjnie(liczba);
        Rekurencyjnie reku = new Rekurencyjnie(liczba);



        threads[0] = new Thread(iter);
        threads[1] = new Thread(reku);
        threads[0].start();
        threads[1].start();


    }


    public class Iteracyjnie implements Runnable {

        int liczba;

        public Iteracyjnie(int liczba) {
            this.liczba = liczba;
        }

        @Override
        public void run() {

            long result = 1;
            long time = System.nanoTime();

            for (int i = 1; i<=liczba; i++) {
                result = result * i;
            }

            time = System.nanoTime() - time;

            uaktualnij("Iteracyjnie: " + result + " w czasie: " + time + " nanosekund.");
        }
    }

    public class Rekurencyjnie implements Runnable {

        int liczba;

        public Rekurencyjnie(int liczba) {
            this.liczba = liczba;
        }

        @Override
        public void run() {

            long result;
            long time = System.nanoTime();

            result = liczaj(liczba);

            time = System.nanoTime() - time;

            uaktualnij("Rekurencyjnie: " + result + " w czasie: " + time + " nanosekund.");

        }

        public long liczaj(long liczba) {

            if (liczba == 1) return 1;

            return liczba * liczaj(liczba-1);

        }
    }





    public void uaktualnij(String s) {
        textArea1.append("\n" + s);
    }

}
