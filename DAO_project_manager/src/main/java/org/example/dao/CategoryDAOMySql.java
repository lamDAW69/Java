package org.example.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.example.entities.Category;

public class CategoryDAOMySql implements CategoryDAO {
    private static final String db = "jdbc:mariadb://localhost:3306/product-manager";
    private static final String user = "root";
    private static final String pass = "";

    @Override
    public List<Category> getCategories() {
        List<Category> categorias = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from category");
            while(rs.next()) {
                categorias.add(new Category(rs.getInt("id"), rs.getString("name")));
            }
    }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return  categorias;
   }

    @Override
    public void insertCategory(Category category) {
        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement st = conn.prepareStatement("insert into category (name) values (?)");
            st.setString(1, category.getName());
            st.executeUpdate();
        }
        catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteCategory(int id) {
        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement ps = conn.prepareStatement("delete from category where id = (?)");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void updateCategory(Category category) {
        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement ps = conn.prepareStatement("update category set name = (?) where id  = (?)");
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            ps.executeUpdate();
        }catch(SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
