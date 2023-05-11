package by.teachmeskills.hw_12052023.paymentsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
    private static final String dbURL = "jdbc:mysql://localhost:3306/tmsdb";
    private static final String dbUSERNAME = "root";
    private static final String dbPassword = "2007659";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, dbUSERNAME, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
