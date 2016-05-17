package Zadanie2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class KsiazkaAdresowa extends JFrame implements ActionListener {
    private JPanel rootPanel;
    private JButton DodajButton;
    private JButton UsunButton;
    private JButton sortNazwButton;
    private JButton sortMiastButton;
    private JList listaAdresow;


    public KsiazkaAdresowa() {
        super("Ksiazka adresowa");

        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DodajButton.addActionListener(this);
        sortMiastButton.addActionListener(this);
        sortNazwButton.addActionListener(this);
        UsunButton.addActionListener(this);



        setVisible(true);

        try {
            listaAdresow.setListData(Person.getAll());
        } catch (Exception ex) {
            ex.printStackTrace();
            listaAdresow.setListData(new Person[] {});
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("DODAJ")) {
            new Adding().addWindowListener(new WindowListener() {
                @Override
                public void windowOpened(WindowEvent e) {

                }

                @Override
                public void windowClosing(WindowEvent e) {

                }

                @Override
                public void windowClosed(WindowEvent e) {
                    listaAdresow.setListData( Person.getAll() );
                }

                @Override
                public void windowIconified(WindowEvent e) {

                }

                @Override
                public void windowDeiconified(WindowEvent e) {

                }

                @Override
                public void windowActivated(WindowEvent e) {

                }

                @Override
                public void windowDeactivated(WindowEvent e) {

                }
            });
        } else if (e.getActionCommand().equals("usun")) {
            Person.removePerson( (Person) listaAdresow.getSelectedValue() );
        } else if (e.getActionCommand().equals("imie")) {
            Person.sortowaniePoNazwisku();
        } else if (e.getActionCommand().equals("miasto")) {
            Person.sortujWedlugMiasta();
        }

        try {
            listaAdresow.setListData(Person.getAll());
        } catch (Exception ex) {
            ex.printStackTrace();
            listaAdresow.setListData(new Person[] {});
        }
    }
}
