package Kasyno;


public class Kasa {

    private static Kasa instance;

    private double hajs;

    public static Kasa getInstance() {

        if (instance == null)
            return instance = new Kasa();
        else
            return instance;
    }

    private Kasa() {
        hajs = 9001.00;
    }

    public double getHajs() {
        return hajs;
    }

    public double addMoney(double wartosc) {

        return hajs = hajs + wartosc;
    }
}
