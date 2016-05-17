package dekorator;

import dekorator.zachowaniadrogowe.ZachowaniaDrogowe;
import dekorator.zliczanieslow.ZliczanieSlow;
import dekorator.zliczaniewierszy.ZliczanieWierszy;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        System.out.println("Wybierz program: \n");
        System.out.println("1 - Zliczanie wierszy");
        System.out.println("2 - Zliczanie słów");
        System.out.println("3 - Zachowania drogowe");

        System.out.print("\nWybieram: ");

        Scanner s = new Scanner(System.in);
        try {

            switch (s.nextInt()) {

                case 1:
                    new ZliczanieWierszy().start();
                    break;

                case 2:
                    new ZliczanieSlow().start();
                    break;

                case 3:
                    new ZachowaniaDrogowe().start();
                    break;

                default:
                    System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
