package kolekcje2;

import java.util.*;


public class Person {

    private static List<Person> list;

    private String imie;
    private String nazwisko;
    private String ulica;
    private int numerDomu;
    private String miasto;
    private String numerTelefonu;

    public Person(String imie, String nazwisko, String ulica, int numerDomu, String miasto, String numerTelefonu){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ulica = ulica;
        this.numerDomu = numerDomu;
        this.miasto = miasto;
        this.numerTelefonu = numerTelefonu;
        if(list == null) list = new ArrayList<Person>();
        list.add(this);
    }

    public String toString(){

        return nazwisko + " " + imie + ", " + ulica + " " + numerDomu + " " + miasto + ", " + numerTelefonu;

    }

    public static void sortBySurname(){

        Collections.sort(list, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int cmp = o1.nazwisko.toUpperCase().compareTo(o2.nazwisko.toUpperCase());
                if(cmp == 0)
                    cmp = o1.imie.toUpperCase().compareTo(o2.imie.toUpperCase());

                return cmp;
            }
        });
    }

    public static void sortujWedlugMiasta(){

        Collections.sort(list, new Comparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int cmp = o1.miasto.toUpperCase().compareTo(o2.miasto.toUpperCase());
                return cmp;
            }
        });
    }

    public static void usunOsobe(Person person){
        list.remove(person);
    }

    public static Person[] PobierzWszystkich(){

        if (list.size() > 0) {

            Person[] ret = new Person[list.size()];
            for (int i = 0, size = list.size(); i < size; i++)
                ret[i] = list.get(i);
            return ret;
        } else
            return null;
    }

}
