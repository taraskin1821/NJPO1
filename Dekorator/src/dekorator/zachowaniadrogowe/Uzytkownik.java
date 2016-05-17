package dekorator.zachowaniadrogowe;

import java.util.Random;


public class Uzytkownik extends UzytkownikDrogi {

    public Uzytkownik() {

        x = new Random().nextInt(20)+1;
        y = new Random().nextInt(10)+1;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getType() {
        return "";
    }

    @Override
    public char getMark() {
        return '?';
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    public void przemiescUzytkownika() {
    }

    @Override
    public void wykonajKrok(int predkosc) {

        boolean czyKoniec = false;

        while (!czyKoniec) {

            int kierunek = new Random().nextInt(4); //0-polnoc 1-wschod 2-poludnie 3-zachod

            switch (kierunek) {

                case 0:
                    if ((getY() - predkosc) > 0) {
                        y -= predkosc;
                        czyKoniec = true;
                    }
                    break;

                case 1:
                    if ((getX() + predkosc) < 21) {
                        x += predkosc;
                        czyKoniec = true;
                    }
                    break;

                case 2:
                    if ((getY() + predkosc) < 11) {
                        y += predkosc;
                        czyKoniec = true;
                    }
                    break;

                case 3:
                    if ((getX() - predkosc) > 0) {
                        x -= predkosc;
                        czyKoniec = true;
                    }
                    break;

            }

        }

    }


    @Override
    public boolean equals(Object obj) {

        UzytkownikDrogi uzytkownik = (UzytkownikDrogi) obj;
        if ( (uzytkownik.getX() == x) && (uzytkownik.getY() == y) )
            return true;
        else return false;
    }
}
