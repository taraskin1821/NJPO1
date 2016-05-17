import stronaWWW.*;


public class FabrykaStron {

    public static HTMLInterface getStrona(String criteria) {

        if (criteria.equals("Galeria"))
            return new Galeria();
        else if (criteria.equals("Informacje"))
            return new Informacje();
        else if (criteria.equals("Kontakty"))
            return new Kontakty();
        else if (criteria.equals("Aktualnosci"))
            return new Aktualnosci();

        return null;

    }

}
