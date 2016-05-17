package dekorator.zachowaniadrogowe.dekoratory;

import dekorator.zachowaniadrogowe.UzytkownikDrogi;


public class Kierowca extends TypeDecorator {

    public Kierowca(UzytkownikDrogi user) {
        super(user);
    }

    @Override
    public String getType() {
        return "Jestem kierowca!";
    }

    @Override
    public char getMark() {
        return 'K';
    }

    @Override
    public int getSpeed() {
        return 3;
    }

    @Override
    public void przemiescUzytkownika() {
        super.wykonajKrok(getSpeed());
    }
}
