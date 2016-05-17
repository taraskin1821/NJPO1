package testy2;
import org.junit.Test;



public class JUnitTestGenerujISortuj {
    long start,koniec;
    
    @Test
    public void TestGeneratorNumbers(){
        GenerujISortuj GASN = new GenerujISortuj();
        start = System.nanoTime();
        GASN.Generuj();
        koniec = System.nanoTime();
        System.out.println("Czas wygenerowania wszystkich liczb wynosi " + (koniec - start)/1000000 + " ms");
    }
    
    @Test
    public void TestSortNumbers() throws Exception {
        GenerujISortuj gis = new GenerujISortuj();
        gis.Generuj();
        start = System.nanoTime();
        gis.Sortuj();
        koniec = System.nanoTime();
        System.out.println("Czas posortowania liczb wynosi " + (koniec - start)/1000000 + " ms");
    }
}
