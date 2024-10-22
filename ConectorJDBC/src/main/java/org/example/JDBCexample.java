package org.example;

import java.sql.*;

public class JDBCexample {
    // Change these values according to your database configuration
    static final String DB_URL = "jdbc:mariadb://localhost:3306/instituto"; // Change 'mi_base_de_datos' to your database name
    static final String USER = "root";  // Database user
    static final String PASS = "";      // Database password

    public static void ejercic(String[] args) {
        // Establish the database connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connected to ddbb");
            // Create a statement object

            Statement stmt = conn.createStatement();

            // Check sql to select all students

            String sql = "SELECT nia, nombre, edad FROM alumno";

            //Execute the query

            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set

            while(rs.next()) {
                // Retrieve by column name
                int nia = rs.getInt("nia");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");

                // Display values
                System.out.println("NIA: " + nia + ", Nombre: " + nombre + ", Edad: " + edad);

            }

            // Close the result set, statement and connection

            rs.close();
            stmt.close();

        } catch (SQLException e) {
            System.err.println("Error connecting to ddbb: " + e.getMessage());
        }
    }
}

