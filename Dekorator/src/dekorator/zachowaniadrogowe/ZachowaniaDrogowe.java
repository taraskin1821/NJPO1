package dekorator.zachowaniadrogowe;

import dekorator.zachowaniadrogowe.comparators.UzytkownikDrogiXComp;
import dekorator.zachowaniadrogowe.comparators.UzytkownikDrogiYComp;
import dekorator.zachowaniadrogowe.dekoratory.Pieszy;
import dekorator.zachowaniadrogowe.dekoratory.Rowerzysta;
import dekorator.zachowaniadrogowe.dekoratory.Kierowca;

import java.util.ArrayList;


public class ZachowaniaDrogowe {

    ArrayList<UzytkownikDrogi> uzytkownicy;


    public void start() {

        uzytkownicy = new ArrayList<UzytkownikDrogi>();

        uzytkownicy.add(new Pieszy(new Uzytkownik()));
        uzytkownicy.add(new Rowerzysta(new Uzytkownik()));
        uzytkownicy.add(new Kierowca(new Uzytkownik()));
        uzytkownicy.add(new Pieszy(new Uzytkownik()));
        uzytkownicy.add(new Rowerzysta(new Uzytkownik()));
        uzytkownicy.add(new Kierowca(new Uzytkownik()));
        uzytkownicy.add(new Pieszy(new Uzytkownik()));
        uzytkownicy.add(new Rowerzysta(new Uzytkownik()));
        uzytkownicy.add(new Kierowca(new Uzytkownik()));



        uzytkownicy.sort(new UzytkownikDrogiXComp());
        uzytkownicy.sort(new UzytkownikDrogiYComp());

        int licznik = 0;

        while (!sprawdzCzyZaistnialWypadek()) {

            rysujSiatke();
            przemiescUzytkownikow();

            System.out.println(licznik++);

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }

    public boolean sprawdzCzyZaistnialWypadek() {

        for (int i = 0; i < uzytkownicy.size(); i++) {

            for (int j = i+1; j < uzytkownicy.size(); j++) {

                UzytkownikDrogi u1 = uzytkownicy.get(i);
                UzytkownikDrogi u2 = uzytkownicy.get(j);

                if ( (u1.getY() == u2.getY()) && (u1.getX() == u2.getX()) ) {

                    System.out.print("Wykryto kolizje na współrzędnych: " + u1.getX() + "-" + u1.getY());
                    return true;
                }

            }
        }
        return false;
    }

    public void rysujSiatke() {

        System.out.println("######################");

        for (int i = 1; i < 11; i++) {

            System.out.print("#");
            ArrayList<UzytkownikDrogi> temp = new ArrayList<UzytkownikDrogi>();

            for (UzytkownikDrogi uzytkownik : uzytkownicy) {
                if (uzytkownik.getY() == i)
                    temp.add(uzytkownik);
            }


            int wypelnione = 0;

            for (UzytkownikDrogi uzytkownik : temp) {

                for (int j = wypelnione; j < uzytkownik.getX() - 1; j++) {
                    wypelnione++;
                    System.out.print(" ");
                }
                wypelnione++;
                System.out.print(uzytkownik.getMark());
            }

            for (int j = 0; j < 20 - wypelnione; j++)
                System.out.print(" ");
                 System.out.println("#"+i);
        }

        System.out.println("######################");

    }

    public void przemiescUzytkownikow() {

        for (UzytkownikDrogi uzytkownik : uzytkownicy)
            uzytkownik.przemiescUzytkownika();

        uzytkownicy.sort(new UzytkownikDrogiXComp());
        uzytkownicy.sort(new UzytkownikDrogiYComp());

    }


}
