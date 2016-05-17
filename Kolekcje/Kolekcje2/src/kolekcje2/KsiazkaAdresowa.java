package kolekcje2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;


public class KsiazkaAdresowa extends JFrame implements ActionListener {
    private JPanel rootPanel;
    private JButton dodajButton;
    private JButton UsunButton;
    private JButton sortNazwiskaButton;
    private JButton sortMiastButton;
    private JList listaAdresow;


    public KsiazkaAdresowa() {
        super("'Le addressen booken");

        setContentPane(rootPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dodajButton.addActionListener(this);
        sortMiastButton.addActionListener(this);
        sortNazwiskaButton.addActionListener(this);
        UsunButton.addActionListener(this);



        setVisible(true);
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
                    listaAdresow.setListData( Person.PobierzWszystkich() );
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
        } else if (e.getActionCommand().equals("USUN")) {
            Person.usunOsobe( (Person) listaAdresow.getSelectedValue() );
        } else if (e.getActionCommand().equals("NAME")) {
            Person.sortBySurname();
        } else if (e.getActionCommand().equals("CITY")) {
            Person.sortujWedlugMiasta();
        }

        try {
            listaAdresow.setListData(Person.PobierzWszystkich());
        } catch (Exception ex) {
            ex.printStackTrace();
            listaAdresow.setListData(new Person[] {});
        }
    }
}
