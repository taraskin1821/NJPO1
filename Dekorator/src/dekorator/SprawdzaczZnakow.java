package dekorator;

import java.io.*;
import java.nio.charset.Charset;


public class SprawdzaczZnakow {

    File plik;
    BufferedReader czytacz;
    boolean czyPracuje;
    int litera;

    public SprawdzaczZnakow(String filePath) throws IOException {

        plik = new File(filePath);

        czytacz = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(plik),
                        Charset.forName("UTF-8")));

        czyPracuje = true;
    }

    public int wczytajZnak() throws IOException {

        if (czyPracuje)
            litera = czytacz.read();

        if (litera == -1)
            czyPracuje = false;

        return litera;
    }



}
