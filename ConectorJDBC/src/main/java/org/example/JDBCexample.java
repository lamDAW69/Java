package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCexample {
    // Change these values according to your database configuration
    static final String DB_URL = "jdbc:mariadb://localhost:3306/instituto"; // Change 'mi_base_de_datos' to your database name
    static final String USER = "root";  // Database user
    static final String PASS = "";      // Database password

    public static void main(String[] args) {
        // Establish the database connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            if (conn != null) {
                System.out.println("connection successful");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to ddbb: " + e.getMessage());
        }
    }
}
