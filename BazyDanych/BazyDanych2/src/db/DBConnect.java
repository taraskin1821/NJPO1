package db;

import java.sql.*;


public class DBConnect {

    private static DBConnect instance;
    Connection connection = null;
    Statement statement = null;

    public static DBConnect getInstance() {
        if (instance == null)
            instance = new DBConnect();
        return instance;
    }

    private DBConnect() {

    }

    public void connect() {

        if (connection != null) return;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:ksiazka.db");

            statement = connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int executeUpdate(String update) {

        if (connection == null)
            return -1;

        try {
            return statement.executeUpdate(update);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ResultSet executeQuery(String query) {

        if (connection == null) return null;

        try {
            return statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
