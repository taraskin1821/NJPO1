package bazadanych1;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;



public class DataBaseConnect {
    Connection connect;
    Statement statement;
    String DB_URL = "jdbc:mysql://localhost:3306/pracownicy";
    String USER = "uzytkownik";
    String PASS = "banan";

    public DataBaseConnect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connect = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
        }
         catch (ClassNotFoundException e) {
            System.out.println("Wystąpił błąd strownika" + e.getMessage());
        }
        catch (SQLException e) {
            System.out.println("Wystąpił błąd w wprowadzonym zapytaniu " + e.getMessage());
        }
    }
    public void PobierzInfo(String query){
        try{
          ResultSet result = wykonajPolecenie(query);

          while(result.next()){
              System.out.println("ID: " +result.getInt(1));
              System.out.println("Imię: " +result.getString(2));
              System.out.println("Nazwisko: " + result.getString(3));
              System.out.println("Zawód: " + result.getString(4));
              System.out.println("adres e-mail: " +result.getString(5));
          }

        }
        catch (SQLException exc){
            System.out.println("Błąd w query: " + exc.getMessage());
        }

    }
    

    
    private static DataBaseConnect connection;
    public synchronized static DataBaseConnect getInstance() {
            if (connection == null)
                connection = new DataBaseConnect();
        return connection;
    }

    void zaktualizujDB(String query) {
        try{
            statement = (Statement) connect.createStatement();
            statement.executeUpdate(query);
            System.out.println("Baza danych została zaktualizowana");
	} 
        catch (SQLException exc) {
            System.out.println("Błąd w zapytaniu do bazy: " + exc.getMessage());
	}

    }

    public ResultSet wykonajPolecenie(String query) throws SQLException {
        statement = (Statement) connect.createStatement();
        return statement.executeQuery(query);

    }
    
    
}
