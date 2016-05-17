

package testy3;

import java.util.*;




public class TestList {
    ArrayList<Integer> lista = new ArrayList<>();
    LinkedList<Integer> linkedList = new LinkedList<>();
    long czas1, czas2, czas3, wynik;
    public TestList(){
        for(int i = 0; i < 3000000 ; i++){
            lista.add(i);
            linkedList.add(i);
        }   
    }

    public String compareTimes(long op1time, long op2time){
        if((op1time - op2time) > 1200)
            return "ArrayLista jest szybsza o: " + ((op1time - op2time)) + " nanosekund";
        else if((op1time - op2time) < -1200)
            return "LinkedLista jest szybsza o: " + ((op2time - op1time)) + " nanosekund";
        else
            return "Obie operacje wykonały się z taką samą prędkością";
    }

    public void DodajNaPierwszaPozycje() {
        czas1 = System.nanoTime();
       lista.add(0, 123);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.add(0, 123);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla dodawania elementu na początek listy: ");
       System.out.println(compareTimes(czas2, czas3));
    }

    public void DodajNaSrodkowaPozycje() {
        czas1 = System.nanoTime();
       lista.add((lista.size()/2), 200);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.add((linkedList.size()/2), 200);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla dodawania elementu na środek listy: ");
       System.out.println(compareTimes(czas2, czas3));
    }

    public void DodajNaOstatniaPozycje() {
        czas1 = System.nanoTime();
       lista.add(300);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.add(300);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla dodawania elementu na koniec listy: ");
       System.out.println(compareTimes(czas2, czas3));
    }

    public void UsunZPierwszejPozycji() {
       czas1 = System.nanoTime();
       lista.remove(0);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.remove(0);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla usuwania elementu z początku listy: ");
       System.out.println(compareTimes(czas2, czas3));
    }

    public void UsunZeSrodkowejPozycji() {
       czas1 = System.nanoTime();
       lista.remove((Math.round(lista.size()/2)));
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.remove(Math.round((linkedList.size()/2)));
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla usuwania elementu z środka listy: ");
       System.out.println(compareTimes(czas2, czas3));
    }

    public void UsunZOstatniejPozycji() {
       czas1 = System.nanoTime();
       lista.remove(lista.size() - 1);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       linkedList.remove(linkedList.size() - 1);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla usuwania elementu z końca listy: ");
       System.out.println(compareTimes(czas2, czas3));
    }

    public int[] ZwrocPierwszaPozycje() {
       int[] results = new int[2];
       czas1 = System.nanoTime();
       results[0] = lista.get(0);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       results[1] = linkedList.get(0);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla pobierania elementu z początku listy: ");
       System.out.println(compareTimes(czas2, czas3));
       return results;
    }

    public int[] ZwrocSrodkowaPozycje() {
        int[] results = new int[2];
       czas1 = System.nanoTime();
       results[0] = lista.get((Math.round(lista.size()/2)));
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       results[1] = linkedList.get(Math.round((linkedList.size()/2)));
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla pobierania elementu z środka listy: ");
       System.out.println(compareTimes(czas2, czas3));
       return results;
    }

    public int[] ZwrocOstatniaPozycje() {
        int[] results = new int[2];
       czas1 = System.nanoTime();
       results[0] = lista.get(lista.size() - 1);
       czas2 = System.nanoTime() - czas1;
       czas1 = System.nanoTime();
       results[1] = linkedList.get(linkedList.size() - 1);
       czas3 = System.nanoTime() - czas1;
       System.out.print("Dla pobierania elementu z końca listy: ");
       System.out.println(compareTimes(czas2, czas3));
       return results;
    }
    
}
