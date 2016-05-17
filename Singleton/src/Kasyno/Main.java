package Kasyno;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        wyborGier();
    }

    public static void wyborGier() {

        System.out.print("Wybierz tryb gry: \n\n1 - Jednoręki bandyta\n" +
                "2 - Gra w  BlackJacka\n3 - Wyjście\n\nWybór: ");

        Scanner s = new Scanner(System.in);

        try {

            switch (s.nextInt()) {

                case 1:
                    new JednorekiBandyta().start();
                    break;

                case 2:
                    new BlackJack().start();
                    break;

                default:
                    System.exit(0);
            }
        } catch (Exception e) {
            System.exit(0);
        }
    }
}
