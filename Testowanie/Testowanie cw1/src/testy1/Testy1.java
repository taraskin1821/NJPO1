package testy1;

import java.util.Scanner;



public class Testy1 {


    public static void main(String[] args) {
        double wyniki[];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wprowadź wspolczynnik a");
        double a = scanner.nextInt();
        System.out.println("Wprowadź wspolczynnik b");
        double b = scanner.nextInt();
        System.out.println("Wprowadź wspolczynnik c");
        double c = scanner.nextInt();
        RownanieKwadratowe noweRownanie = new RownanieKwadratowe(a, b, c);
        System.out.println(noweRownanie.ObliczLiczbePierwiastkow());
        wyniki = noweRownanie.obliczPierwiastki();
        for (int i = 0; i < wyniki.length; i++) {
            System.out.println("Perwiastek numer: "+(i+1)+" wynosi: " + wyniki[i]);
        }
    }
    
}
