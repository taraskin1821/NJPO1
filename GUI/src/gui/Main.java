package gui;

import gui.powitanie.Powitanie;
import gui.algorytmluhnapesel.AlgorytmLuhnaPesel;
import gui.kalkulator.Kalkulator;
import gui.uciekajacyprzycisk.UciekajacyPrzycisk;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        System.out.print("Wybierz program:\n\n1 - Powitanie\n2 - Kalkulator" +
                "\n3 - Uciekajacy przycisk\n4 - Algorytm Luhna (PESEL)\n\nWybór:");

        Scanner scanner = new Scanner(System.in);

        switch(scanner.nextInt()) {

            case 1:
                new Powitanie();
                break;

            case 2:
                new Kalkulator();
                break;

            case 3:
                new UciekajacyPrzycisk();
                break;

            case 4:
                new AlgorytmLuhnaPesel();
                break;

        }

    }

}
