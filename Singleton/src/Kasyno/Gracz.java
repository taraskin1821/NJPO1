package Kasyno;


public class Gracz {

    private static Gracz instance;

    private double pieniadze;

    public static Gracz getInstance() {

        if (instance == null)
            return instance = new Gracz();
        else
            return instance;
    }

    private Gracz() {
        pieniadze = 100;
    }

    public double getPieniadze() {
        return pieniadze;
    }

    public void dodajPieniadze(double value) {

        pieniadze = pieniadze + value;
        Kasa.getInstance().addMoney(-value);
    }
}
