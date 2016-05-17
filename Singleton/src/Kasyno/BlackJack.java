package Kasyno;

import java.util.*;


public class BlackJack {

    static String[] karty = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    Map<String, Integer> cardsCount;
    ArrayList<String> twojeKarty = new ArrayList<>();
    ArrayList<String> kartyKasyna = new ArrayList<>();

    public void initialize() {

        cardsCount = new HashMap<String, Integer>();

        cardsCount.put("2", 0);
        cardsCount.put("3", 0);
        cardsCount.put("4", 0);
        cardsCount.put("5", 0);
        cardsCount.put("6", 0);
        cardsCount.put("7", 0);
        cardsCount.put("8", 0);
        cardsCount.put("9", 0);
        cardsCount.put("10", 0);
        cardsCount.put("J", 0);
        cardsCount.put("Q", 0);
        cardsCount.put("K", 0);
        cardsCount.put("A", 0);

        twojeKarty.clear();
        kartyKasyna.clear();

    }


    public void start() {

        System.out.println("\n\n\n\n");
        System.out.println("Mój stan konta: " + Gracz.getInstance().getPieniadze());
        System.out.println("Kasa: " + Kasa.getInstance().getHajs());

        Scanner s = new Scanner(System.in);

        System.out.print("1 - Nowa gra\n2 - Powrót do menu\n ");

        switch (s.nextInt()) {

            case 1:
                initialize();
                zacznijNowaGre();
                break;

            case 2:
                Main.wyborGier();
                break;
        }
    }

    public void zacznijNowaGre() {

        twojeKarty.add(0, losujKarte());
        twojeKarty.add(1, losujKarte());

        kartyKasyna.add(0, losujKarte());
        kartyKasyna.add(1, losujKarte());

        zagrajRunde();
    }

    private void zagrajRunde() {

        System.out.println("\n\n\nTwoje karty: " + wypiszWylosowaneKarty(twojeKarty, false));
        System.out.println("Karty krupiera: " + wypiszWylosowaneKarty(kartyKasyna, true));

        if (sumaPkt(twojeKarty) > 20) zakonczGre();

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n1 - Dobierz karte\n2 - Pass\n ");

        switch (scanner.nextInt()) {

            case 1:
                dobierzKarte();
                break;

            case 2:
                zakonczGre();
                break;
        }

    }

    public void dobierzKarte() {

        twojeKarty.add(losujKarte());
        zagrajRunde();

    }


    public int sumaPkt(ArrayList<String> list) {

        int wynik = 0;
        int aces = 0;

        for (int i = 0; i < list.size(); i++) {

            if (list.get(i).equals("A")) {
                aces++;
            }
        }

        for (String string : list) {

            if (string.equals("K") || string.equals("Q") || string.equals("J"))
                wynik += 10;
            else if (string.equals("A"));
            else
                wynik += new Integer(string);
        }

        while (aces > 0) {
            if ((wynik + 11) > 21)
                wynik++;
             else
                wynik += 11;

            aces--;
        }
        return wynik;

    }

    public void zakonczGre() {

        while (sumaPkt(kartyKasyna) < 17)
            kartyKasyna.add(losujKarte());

        System.out.println("\n\n\n\n\n\n" + "WYNIK:");
        System.out.println("\n\n\nTwoje karty: " + wypiszWylosowaneKarty(twojeKarty, false));
        System.out.println("Karty krupiera: " + wypiszWylosowaneKarty(kartyKasyna, false));

        if ((sumaPkt(kartyKasyna) < 22 && (sumaPkt(kartyKasyna) > sumaPkt(twojeKarty))) || sumaPkt(twojeKarty) > 21) {
            System.out.println("\n\nPrzegrałeś ;C");
            Gracz.getInstance().dodajPieniadze(-2);
        } else if ((sumaPkt(kartyKasyna) == sumaPkt(twojeKarty)) && sumaPkt(twojeKarty) < 22) {
            System.out.println("\n\nRemis");
        } else {
            System.out.println("\n\nWygrałeś :)");
            Gracz.getInstance().dodajPieniadze(10);
        }
        start();


    }

    public String losujKarte() {

        Random random = new Random();

        while (true) {

            int i = random.nextInt(13);
            String s = karty[i];
            int j = cardsCount.get(s);

            if (j < 4) {
                j++;
                cardsCount.put(s, j);
                return s;
            }

        }

    }

    public String wypiszWylosowaneKarty(ArrayList<String> lista, boolean isCasino) {

        if (isCasino) {
            return lista.get(0) + " " + "X";
        } else {
            String result = "";
            for (String s : lista)
                result += s + " ";
            return result;
        }

    }
}
