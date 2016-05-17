package dekorator.zliczanieslow;

import dekorator.SprawdzaczZnakow;

import java.io.IOException;


public class ZliczaczSlow {

    SprawdzaczZnakow sprawdzacz;

    public ZliczaczSlow(SprawdzaczZnakow sprawdzacz) {

        this.sprawdzacz = sprawdzacz;
    }

    public int zlicz() throws IOException {

        int slowa = 0;

        int znak;
        int znak2 = -1;

        while ((znak = sprawdzacz.wczytajZnak()) != -1) {

            if (znak == 10 || znak == 9 || znak == 32) {

                if (znak2 != 10 && znak2 != 9 && znak2 != 32) {
                    slowa++;
                }
            }
            znak2 = znak;

        }

        if (znak2 != 10 && znak2 != 9 && znak2 != 32) {
            slowa++;
        }

        return slowa;
    }


}
