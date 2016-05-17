package gui.uciekajacyprzycisk;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;


public class UciekajacyPrzycisk extends JFrame implements MouseMotionListener {
    private JPanel jPanel;
    private JButton jButton;


    private int pointerX, pointerY;

    public UciekajacyPrzycisk() {
        super("Uciekajacy Przycisk");
        setContentPane(jPanel);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseMotionListener(this);
        setVisible(true);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {

        Point point = MouseInfo.getPointerInfo().getLocation();
        pointerX = point.x - this.getLocationOnScreen().x;
        pointerY = point.y - this.getLocationOnScreen().y;

        if (pointerX > jButton.getLocation().x && pointerX < (jButton.getLocation().x+50))
            zmienPozycjePrzycisku();
         else if (pointerY > jButton.getLocation().y && pointerY < (jButton.getLocation().y+50))
            zmienPozycjePrzycisku();
    }




    public void zmienPozycjePrzycisku() {
        jButton.setLocation(new Random().nextInt(451), new Random().nextInt(451));
    }
}
