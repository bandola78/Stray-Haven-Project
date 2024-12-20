package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost/strayhaven";
        String user = "root";
        String password = "kAKrR_9n"; 

        return DriverManager.getConnection(url, user, password);
    }
}
