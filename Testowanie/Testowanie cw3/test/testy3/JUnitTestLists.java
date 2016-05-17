package testy3;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class JUnitTestLists {
    
    public JUnitTestLists() {
    }
    @Test
    public void TestDodajNaPierwszaPozycje(){
        TestList test = new TestList();
        test.DodajNaPierwszaPozycje();
        assertEquals(3000001, test.lista.size());
        assertEquals(123, test.lista.get(0),0);
        assertEquals(3000001, test.linkedList.size());
        assertEquals(123, test.linkedList.get(0),0);
        }
    
    @Test
    public void TestDodajNaSrodkowaPozycje(){
        TestList test = new TestList();
        test.DodajNaSrodkowaPozycje();
        assertEquals(3000001, test.lista.size());
        assertEquals(200, test.lista.get(test.lista.size()/2),0);
        assertEquals(3000001, test.linkedList.size());
        assertEquals(200, test.lista.get(test.linkedList.size()/2),0);
        }
    
    @Test
    public void TestDodajNaOstatniaPozycje(){
        TestList test = new TestList();
        test.DodajNaOstatniaPozycje();
        assertEquals(3000001, test.lista.size());
        assertEquals(300, test.lista.get(test.lista.size() - 1),0);
        assertEquals(3000001, test.linkedList.size());
        assertEquals(300, test.lista.get(test.linkedList.size() - 1),0);
        }
    
    @Test
    public void TestUsunZPierwszejPozycji(){
        TestList test = new TestList();
        test.UsunZPierwszejPozycji();
        assertEquals(2999999, test.lista.size());
        assertEquals(1, test.lista.get(0),0);
        assertEquals(2999999, test.linkedList.size());
        assertEquals(1, test.linkedList.get(0),0);
        }
    
    @Test
    public void TestUsunZeSrodkowejPozycji(){
        TestList test = new TestList();
        test.UsunZeSrodkowejPozycji();
        assertEquals(2999999, test.lista.size());
        assertEquals(1499999, test.lista.get(test.lista.size()/2),0);
        assertEquals(2999999, test.linkedList.size());
        assertEquals(1499999, test.linkedList.get(test.lista.size()/2),0);
        }
    
    @Test
    public void TestUsunZOstatniejPozycji(){
        TestList test = new TestList();
        test.UsunZOstatniejPozycji();
        assertEquals(2999999, test.lista.size());
        assertEquals(2999998, test.lista.get(test.lista.size() - 1),0);
        assertEquals(2999999, test.linkedList.size());
        assertEquals(2999998, test.linkedList.get(test.lista.size() - 1),0);
        }
    
    @Test
    public void TestZwrocPierwszaPozycje(){
        TestList test = new TestList();
        int[] testResults = test.ZwrocPierwszaPozycje();
        assertEquals(3000000, test.lista.size());
        assertEquals(0, testResults[0]);
        assertEquals(3000000, test.linkedList.size());
        assertEquals(0, testResults[1]);
        }
    
    @Test
    public void TestZwrocSrodkowaPozycje(){
        TestList test = new TestList();
        int[] testResults = test.ZwrocSrodkowaPozycje();
        assertEquals(3000000, test.lista.size());
        assertEquals(1500000, testResults[0]);
        assertEquals(3000000, test.linkedList.size());
        assertEquals(1500000, testResults[1]);
        }
    
    @Test
    public void TestZwrocOstatniaPozycje(){
        TestList test = new TestList();
        int[] testResults = test.ZwrocOstatniaPozycje();
        assertEquals(3000000, test.lista.size());
        assertEquals(2999999, testResults[0]);
        assertEquals(3000000, test.linkedList.size());
        assertEquals(2999999, testResults[1]);
        }
    
    @Test
    public void testCompareTimesTime1IsBigger(){
        long op1time = 123456;
        long op2time = 123;
        TestList test = new TestList();
        assertEquals("ArrayLista jest szybsza o: " + ((op1time - op2time)) + " nanosekund", test.compareTimes(op1time, op2time));
        
        }
    
    @Test
    public void testCompareTimesTime2IsBigger(){
        long op1time = 123;
        long op2time = 123456;
        TestList test = new TestList();
        assertEquals("LinkedLista jest szybsza o: " + ((op2time - op1time)) + " nanosekund", test.compareTimes(op1time, op2time));
        
        }
    
    @Test
    public void testCompareTimesTimesEqual(){
        long op1time = 7500;
        long op2time = 7100;
        TestList test = new TestList();
        assertEquals("Obie operacje wykonały się z taką samą prędkością", test.compareTimes(op1time, op2time));
        
        }
    
}


