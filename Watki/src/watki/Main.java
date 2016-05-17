package watki;

import watki.Silnia.Silnia;
import watki.ZipBomba.ZipBomb;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        System.out.println("Wybierz program: \n1 - Obliczanie silni" +
                " \n2 - Zip bomba");

        System.out.print("Wybór: ");
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextInt()) {

            case 1:
                new Silnia();
                break;

            case 2:
                new ZipBomb();
                break;

        }
    }


}
