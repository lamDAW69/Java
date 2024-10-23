package org.example;
import java.sql.*;

public class JBDCPractice2 {

    public final static String DB_URL = "jdbc:mariadb://localhost:3306/product-manager";
    public final static String USER = "root";
    public final static String PASS = "";

    private static boolean insertCategoriaProducto(Connection conn, String nombreCategory, int referenceProduct, String nameProduct, double priceProduct) throws SQLException {

        boolean ok = true;

        try {
            conn.setAutoCommit(false); // Disable auto-commit
            PreparedStatement st = conn.prepareStatement("INSERT INTO category VALUES (NULL, ?)", Statement.RETURN_GENERATED_KEYS);  //Return the generated keys to get the id

            st.setString(1, nombreCategory);
            st.executeUpdate();
            ResultSet keys = st.getGeneratedKeys(); // Get the generated keys
            keys.first(); // Move the cursor to the first row
            int idCategory = keys.getInt(1); // Get the value of the first column of the first row

            // Now time to insert the product
            PreparedStatement stProduct = conn.prepareStatement("INSERT INTO product (reference, name, price, category) VALUES (?, ?, ?, ?)");
            stProduct.setInt(1, referenceProduct);
            stProduct.setString(2, nameProduct);
            stProduct.setDouble(3, priceProduct);
            stProduct.setInt(4, idCategory);
            stProduct.executeUpdate();

            conn.commit(); // Commit the transaction

        } catch (SQLException e) {
            conn.rollback(); // Rollback the transaction
            ok = false;
            System.err.println(e.getMessage());
        } finally {
            conn.setAutoCommit(true); // Enable auto-commit again
        }

        return ok;
    }



    public static void main(String[]args) {

        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            insertCategoriaProducto(conn, "Electronicos", 123, "Laptop", 1200);
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }

    }

}
