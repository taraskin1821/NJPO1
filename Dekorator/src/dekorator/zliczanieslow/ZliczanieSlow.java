package dekorator.zliczanieslow;

import dekorator.SprawdzaczZnakow;
import dekorator.zliczaniewierszy.ZliczaczWierszy;

import java.util.Scanner;


public class ZliczanieSlow {

    public void start() throws Exception{

        System.out.print("Podaj ścieżkę do pliku tekstowego: ");

        Scanner scanner = new Scanner(System.in);

        String sciezka = scanner.nextLine();
        System.out.println(sciezka);

        System.out.println("Ilosc wierszy: " + new ZliczaczSlow(new SprawdzaczZnakow(sciezka)).zlicz());
    }

}
