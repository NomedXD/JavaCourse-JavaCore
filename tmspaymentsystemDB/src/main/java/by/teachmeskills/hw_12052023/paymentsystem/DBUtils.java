package by.teachmeskills.hw_12052023.paymentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/tmsdb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "2007659";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
