package dekorator.zachowaniadrogowe.dekoratory;

import dekorator.zachowaniadrogowe.UzytkownikDrogi;


public class Pieszy extends TypeDecorator {

    public Pieszy(UzytkownikDrogi user) {
        super(user);
    }

    @Override
    public String getType() {
        return "I'm a pedestrian!";
    }

    @Override
    public char getMark() {
        return 'P';
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public void przemiescUzytkownika() {
        super.wykonajKrok(getSpeed());
    }
}
