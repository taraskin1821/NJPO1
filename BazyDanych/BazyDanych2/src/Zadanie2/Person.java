package Zadanie2;


import db.DBConnect;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Person {

    private static List<Person> list;

    private int id = 0;
    private String imie;
    private String nazwisko;
    private String ulica;
    private int numerDomu;
    private String miasto;
    private String numerTelefonu;

    public Person(int id, String imie, String nazwisko, String ulica, int numerDomu, String miasto, String numerTelefonu) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miasto = miasto;
        this.numerTelefonu = numerTelefonu;
    }

    public static void add(Person p) {

        String update = "INSERT INTO Ksiazka (ID, IMIE, NAZWISKO, ULICA, NRDOMU, MIASTO, NRTEL) " +
                "VALUES (" + p.id + ", '" + p.imie + "', '" + p.nazwisko + "', '" + p.ulica + "', " + p.numerDomu + ", '" + p.miasto + "', '" + p.numerTelefonu + "');";
        DBConnect.getInstance().executeUpdate(update);
    }

    public String toString() {

        return id + " " + nazwisko + " " + imie + ", " + ulica + " " + numerDomu + " " + miasto + ", " + numerTelefonu;

    }

    public static void sortowaniePoNazwisku() {

        Collections.sort(list, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int comparator = o1.nazwisko.toUpperCase().compareTo(o2.nazwisko.toUpperCase());
                if (comparator == 0)
                    comparator = o1.imie.toUpperCase().compareTo(o2.imie.toUpperCase());

                return comparator;
            }
        });
    }

    public static void sortujWedlugMiasta() {

        Collections.sort(list, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int comparator = o1.miasto.toUpperCase().compareTo(o2.miasto.toUpperCase());
                return comparator;
            }
        });
    }

    public static void removePerson(Person p) {

        String update = "DELETE FROM Ksiazka WHERE ID=" + p.id + ";";

        DBConnect.getInstance().executeUpdate(update);

        list.remove(p);
    }

    public static Person[] getAll() {

        String query = "SELECT * FROM Ksiazka;";

        ResultSet rs = DBConnect.getInstance().executeQuery(query);

        list = new ArrayList<>();

        try {
            while (rs.next()) {
                list.add(new Person(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (list.size() > 0) {

            Person[] ret = new Person[list.size()];
            for (int i = 0, size = list.size(); i < size; i++)
                ret[i] = list.get(i);
            return ret;
        } else
            return new Person[]{};
    }

}
