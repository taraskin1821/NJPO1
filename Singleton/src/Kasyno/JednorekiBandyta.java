package Kasyno;

import java.util.Random;
import java.util.Scanner;


public class JednorekiBandyta {


    public void start() throws Exception {

        System.out.println("Mój stan konta: " + Gracz.getInstance().getPieniadze());
        System.out.println("Kasa: " + Kasa.getInstance().getHajs());

        Scanner s = new Scanner(System.in);

        System.out.print("1 - Nowa gra\n2 - Powrót do menu\n ");

        switch (s.nextInt()) {

            case 1:
                graj();
                break;

            case 2:
                Main.wyborGier();
                break;
        }
    }

    private void graj() throws Exception {

        System.out.println("losowanie...\n\n");
        losuj();

    }


    private void losuj() throws Exception {

        Random r = new Random();
        int[] results = new int[3];

        for (int i = 0; i < 3; i++)
            System.out.print((results[i] = r.nextInt(2)) + " ");


        if (results[0] == results[1] && results[1] == results[2]) {
            System.out.println("\n\nWygrałeś :)");
            Gracz.getInstance().dodajPieniadze(10);
        } else {
            System.out.println("\n\nPrzegrałeś ;C");
            Gracz.getInstance().dodajPieniadze(-2);
        }
        start();



    }

}



