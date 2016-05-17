package dekorator.zachowaniadrogowe.comparators;

import dekorator.zachowaniadrogowe.UzytkownikDrogi;

import java.util.Comparator;


public class UzytkownikDrogiXComp implements Comparator<UzytkownikDrogi> {

    @Override
    public int compare(UzytkownikDrogi o1, UzytkownikDrogi o2) {
        return o1.getX() - o2.getX();
    }
}
