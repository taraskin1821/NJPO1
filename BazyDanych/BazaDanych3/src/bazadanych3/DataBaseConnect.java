package bazadanych3;

import com.mysql.jdbc.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



    class DataBaseConnect {

        Statement statement;
        String DB_URL = "jdbc:mysql://localhost:3306/liczbyNJPO";
        String USER = "uzytkownik";
        String PASS = "banan";
        private Connection connect;
        public static DataBaseConnect dbConnection;

        public synchronized static DataBaseConnect getInstance() {
                if (dbConnection == null)
                    dbConnection = new DataBaseConnect();
            return dbConnection;
        }

        private DataBaseConnect(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                connect = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            }
            catch (ClassNotFoundException e) {
                System.out.println("Wystąpił błąd sterownika" + e.getMessage());
            }
            catch (SQLException e) {
                System.out.println("Wystąpił błąd w wprowadzonym zapytaniu " + e.getMessage());
            }
        }

        public void updateDB(String query) {
            try{
                statement = (Statement) connect.createStatement();
                statement.executeUpdate(query);
        }
            catch (SQLException exc) {
                System.out.println("Wystąpił błąd w zapytaniu do bazy: " + exc.getMessage());
        }

        }

        public ArrayList getCollection(String query){
            ArrayList<Integer> lista = new ArrayList<>();
            try{
              PreparedStatement prStatement =(PreparedStatement) connect.prepareStatement(query);
              ResultSet result = prStatement.executeQuery();

              while(result.next()){
                  lista.add(result.getInt(2));
              }

            }
            catch (SQLException exc){
                System.out.println("Błąd w zapytaniu do bazy: " + exc.getMessage());
            }
            finally{
                return lista;
            }

        }
}
