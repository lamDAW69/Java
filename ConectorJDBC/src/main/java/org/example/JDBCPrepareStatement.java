package org.example;

import java.sql.*;

public class JDBCPrepareStatement {

    // Change these values according to your database configuration
    static final String DB_URL = "jdbc:mariadb://localhost:3306/instituto"; // Change 'mi_base_de_datos' to your database name
    static final String USER = "root";  // Database user
    static final String PASS = "";      // Database password


    public static void example2(Connection conn) throws SQLException {

        //This is a prepared statement
        PreparedStatement st = conn.prepareStatement("SELECT * FROM alumno WHERE nia = ?");

        st.setInt(1, 10032);

        ResultSet rs = st.executeQuery();

        while(rs.next()) {
            int nia = rs.getInt("nia");
            String nombre = rs.getString("nombre");
            int edad = rs.getInt("edad");

            System.out.println("NIA: " + nia + ", Nombre: " + nombre + ", Edad: " + edad);
        }


    }

    public static void example3(Connection conn) throws  SQLException {
        PreparedStatement st = conn.prepareStatement("INSERT INTO alumno (nia, nombre, edad) VALUES (?, ?, ?)");

        st.setInt(1, 10088);
        st.setString(2, "Danielk");
        st.setInt(3, 23);

        int rowsAffectted = st.executeUpdate();

        System.out.println("Rows affected: " + rowsAffectted);

    }

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            example2(conn);
            example3(conn);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
