package testy1;
public class RownanieKwadratowe {
    
    private final double a, b, c;
    private double delta;
    private double[] wyniki;
    
    public RownanieKwadratowe(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public double[] obliczPierwiastki(){
        double pierwDelta = Math.sqrt(delta);
        for (int i = 0; i < wyniki.length; i++) {
            wyniki[i] = (-b - pierwDelta) / (2 * a);
            pierwDelta = -pierwDelta;
        }
        return wyniki;
    }

    public String ObliczLiczbePierwiastkow(){
        String komunikat;
        delta = Math.pow(b, 2) - (4 * a * c);
        if(delta>0){
            komunikat = "Delta > 0, istnieją dwa pierwiastki równania";
            wyniki = new double[2];
        }  
        else if(delta<0){
            wyniki = new double[0];
            komunikat = "Delta < 0, brak pierwiastków równania.";
        }   
        else{
            komunikat = "Delta = 0, istnieje jeden pierwiastek równania";
            wyniki = new double[1];
        }
            return komunikat;
            
    }
}
