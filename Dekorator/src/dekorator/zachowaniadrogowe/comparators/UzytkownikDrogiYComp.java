package dekorator.zachowaniadrogowe.comparators;

import dekorator.zachowaniadrogowe.UzytkownikDrogi;

import java.util.Comparator;


public class UzytkownikDrogiYComp implements Comparator<UzytkownikDrogi> {

    @Override
    public int compare(UzytkownikDrogi o1, UzytkownikDrogi o2) {
        return o1.getY() - o2.getY();
    }

}
