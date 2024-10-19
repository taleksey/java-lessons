package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/java_lessons";
    private static final String DRIVER_URL = "com.mysql.cj.jdbc.Driver";
    private static final Properties DB_PROPERTIES = new Properties();

    static {
        DB_PROPERTIES.put("user", "");
        DB_PROPERTIES.put("password", "");
        try {
            Class.forName(DRIVER_URL);
        } catch (ClassNotFoundException e) {
            try {
                throw new Exception("Can't load JDBC driver", e);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static Connection getConnection() throws SQLException {
        // Ensure the driver class is loaded
        return DriverManager.getConnection(DB_URL, DB_PROPERTIES);
    }

}
