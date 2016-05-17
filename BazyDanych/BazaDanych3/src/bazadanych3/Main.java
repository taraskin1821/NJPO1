package bazadanych3;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;



public class Main {

    public static void main(String[] args) {
        long start,end, javaTime, mysqlTime;
        ArrayList<BigInteger> biArrayList;
        StringBuffer sb = new StringBuffer("INSERT INTO liczby VALUES ");
        Random random = new Random();
       
        DataBaseConnect.getInstance();
        DataBaseConnect.dbConnection.updateDB("CREATE TABLE liczby ( id BIGINT(8)  PRIMARY KEY NOT NULL, data BIGINT(8) NOT NULL) ENGINE =  MyISAM;");
        for (int i = 1; i < 2000000; i++)
            sb.append(("("+i+", "+random.nextInt(2000000000)+"), "));
        sb.append("(2000000, ").append(random.nextInt(2000000000)).append(");");
        DataBaseConnect.dbConnection.updateDB(sb.toString());
         DataBaseConnect.getInstance();
         start = System.nanoTime();
         biArrayList = DataBaseConnect.dbConnection.getCollection("Select * from liczby;");
         end = System.nanoTime();
         javaTime = (end - start)/1000000000;
         System.out.println("Sortowanie za pomocą Javy trwało: " + javaTime + " sekund");
         biArrayList.sort(null);

        start = System.nanoTime();
        DataBaseConnect.dbConnection.updateDB("ALTER TABLE liczby ORDER BY data ASC ");
        end = System.nanoTime();
        mysqlTime = (end - start)/1000000000;
        System.out.println("Sortowanie za pomocą silnika bazodanowego trwało: " + mysqlTime + " sekund");
        
        if(javaTime < mysqlTime)
            System.out.println("Sortowanie za pomocą javy jest szybsze o: " + (mysqlTime - javaTime) + " sekund");
        else
            System.out.println("Sortowanie za pomocą silnika MySql jest szybsze o: " + (javaTime - mysqlTime) + " sekund");

    }
    
}
