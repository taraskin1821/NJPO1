package kolekcje3;

import java.util.*;



public class TestLists {
    private ArrayList<Integer> list = new ArrayList<>();
    private LinkedList<Integer> linkedList = new LinkedList<>();
    private long czas1, czas2, czas3, wynik;
    public TestLists(){
        for(int i = 0; i < 2500000 ; i++){
            list.add(i);
            linkedList.add(i);
        }
        dodajNaPierwszaPozycje();
        dodajNaSrodkowaPozycje();
        dodajNaOstatniaPozycje();
        usunZPierwszejPozycji();
        usunZeSrodkowejPozycji();
        usunZOstatniejPozycji();
        ZwrocPierwszaPozycje();
        zwrocSrodkowaPozycje();
        zwrocOstatniaPozycje();
    }
  
    
    private void compareTimes(long czasPierwszejOperacji, long czasDrugiejOperacji){
        wynik = czasPierwszejOperacji - czasDrugiejOperacji;
        if(wynik > 1200)
            System.out.println("ArrayLista jest szybsza o:"
                    + " " + ((czasPierwszejOperacji - czasDrugiejOperacji)) + " nanosekund");
        else if(wynik < -1200)
            System.out.println("LinkedLista jest szybsza o:"
                    + " " + ((czasDrugiejOperacji - czasPierwszejOperacji)) + " nanosekund");
        else
            System.out.println("Obie operacje wykonały się z taką "
                    + "samą prędkością");
    }
    
     private void dodajNaPierwszaPozycje() {
        czas1 = System.nanoTime();
       list.add(0, 123);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.add(0, 123);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla dodawania elementu na początek listy: ");
       compareTimes(czas2, czas3);
     }

    private void dodajNaSrodkowaPozycje() {
        czas1 = System.nanoTime();
       list.add((list.size()/2), 200);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.add((linkedList.size()/2), 200);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla dodawania elementu na środek listy: ");
       compareTimes(czas2, czas3);
    }

    private void dodajNaOstatniaPozycje() {
        czas1 = System.nanoTime();
       list.add(300);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.add(300);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla dodawania elementu na koniec listy: ");
       compareTimes(czas2, czas3);
    }

    private void usunZPierwszejPozycji() {
       czas1 = System.nanoTime();
       list.remove(0);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.remove(0);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla usuwania elementu z początku listy: ");
       compareTimes(czas2, czas3);
    }

    private void usunZeSrodkowejPozycji() {
       czas1 = System.nanoTime();
       list.remove((Math.round(list.size()/2)));
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.remove(Math.round((linkedList.size()/2)));
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla usuwania elementu z środka listy: ");
       compareTimes(czas2, czas3);
    }

    private void usunZOstatniejPozycji() {
       czas1 = System.nanoTime();
       list.remove(list.size() - 1);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.remove(linkedList.size() - 1);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla usuwania elementu z końca listy: ");
       compareTimes(czas2, czas3);
    }

    private void ZwrocPierwszaPozycje() {
       czas1 = System.nanoTime();
       list.get(0);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.get(0);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla pobierania elementu z początku listy: ");
       compareTimes(czas2, czas3);
    }

    private void zwrocSrodkowaPozycje() {
       czas1 = System.nanoTime();
       list.get((Math.round(list.size()/2)));
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.get(Math.round((linkedList.size()/2)));
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla pobierania elementu z środka listy: ");
       compareTimes(czas2, czas3);
    }

    private void zwrocOstatniaPozycje() {
       czas1 = System.nanoTime();
       list.get(list.size() - 1);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.get(linkedList.size() - 1);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla pobierania elementu z końca listy: ");
       compareTimes(czas2, czas3);
    }
}
    
