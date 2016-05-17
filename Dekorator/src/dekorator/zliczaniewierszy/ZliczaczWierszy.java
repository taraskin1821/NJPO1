package dekorator.zliczaniewierszy;

import dekorator.SprawdzaczZnakow;

import java.io.IOException;


public class ZliczaczWierszy {

    SprawdzaczZnakow SZ;

    public ZliczaczWierszy(SprawdzaczZnakow SZ) {

        this.SZ = SZ;
    }

    public int zlicz() throws IOException {

        int wiersze = 0;
        int c;
        int pc = -1;

        while ((c = SZ.wczytajZnak()) != -1) {

            if (c == 10) wiersze++;
            pc = c;
        }

        if (pc != 10) wiersze ++;

        return wiersze;
    }
}
