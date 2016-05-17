import stronaWWW.HTMLInterface;

import java.util.Random;


public class Main {

    public static void main(String[] args) {

        String[] podstrony = {"Galeria", "Informacje", "Kontakty", "Aktualnosci"};

        HTMLInterface stronka = FabrykaStron.getStrona(podstrony[new Random().nextInt(4)]);
        stronka.generuj();

    }

}
