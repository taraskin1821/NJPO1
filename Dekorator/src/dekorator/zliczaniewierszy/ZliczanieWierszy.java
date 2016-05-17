package dekorator.zliczaniewierszy;

import dekorator.SprawdzaczZnakow;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;


public class ZliczanieWierszy {



    public void start() throws Exception{

        System.out.print("Podaj ścieżkę do pliku: ");

        Scanner s = new Scanner(System.in);

        String sciezka = s.nextLine();
        System.out.println(sciezka);

        System.out.println("Ilosc wierszy: " + new ZliczaczWierszy(new SprawdzaczZnakow(sciezka)).zlicz());
    }




}
