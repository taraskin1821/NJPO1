package bazadanych1;

import java.sql.SQLException;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) throws SQLException {
        String query = "";
        DataBaseConnect dbc = new DataBaseConnect();
        Scanner scanner = new Scanner(System.in);
        dbc.PobierzInfo("select * from employees");
       
       System.out.println("Nacisnij 0 aby przejsc do wprowadzania zmian w DB");
       if(scanner.nextInt() == 0){
           System.out.println("Wprowadź komendę");
           scanner.nextLine();
           query = scanner.nextLine();
           dbc.zaktualizujDB(query);
           
       }
       
    }
    
}
