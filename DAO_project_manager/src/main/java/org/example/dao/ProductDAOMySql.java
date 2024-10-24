package org.example.dao;


import org.example.entities.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOMySql implements ProductDAO {

    private static final String db = "jdbc:mariadb://localhost:3306/product-manager";
    private static final String user = "root";
    private static final String pass = "";

    @Override
    public List<Product> getProducts() {
        List<Product> Products = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from product");
            while(rs.next()) {
                // Product(int id, String referencia, String nombre, double precio, int categoria) {
                Products.add(new Product(rs.getInt("id"),
                        rs.getString("reference"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("category")));
            }
        }catch(SQLException e ) {
            System.err.println(e.getMessage());
        }
        return Products;
    }

    @Override
    public void insertProduct(Product product) {
        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement ps = conn.prepareStatement("INSERT INTO product (referece, name, price, category_id) VALUES (?),(?), (?), (?)");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getCategoria());

            ps.executeUpdate();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteProduct(int id) {
        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM product WHERE id = (?)");
            ps.setInt(1, id);

            ps.executeUpdate();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void updateProduct(Product product) {
        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement ps = conn.prepareStatement("UPDATE produt SET name = (?), reference = (?), price = (?), category_id = (?) WHERE id = (?)");
            ps.setString(1, product.getName());
            ps.setString(2, product.getReference());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getCategoria());
            ps.setInt(5, product.getId());
            ps.executeUpdate();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
