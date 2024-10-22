package org.example;

import java.sql.*;
import java.util.Scanner;

public class JDBCPractice1 {
    static final String DB_URL = "jdbc:mariadb://localhost:3306/eoi2";
    static final String USER = "root";
    static final String PASS = "";


    public static void listarCategorias(Connection conn) throws SQLException {
        PreparedStatement st = conn.prepareStatement("SELECT categoria, titulo FROM categorias");

      ResultSet rs = st.executeQuery();

      while(rs.next()) {
          int categoria = rs.getInt("categoria");
          String titulo = rs.getString("titulo");

          System.out.printf("Categoria: %d --- Titulo: %s%n", categoria, titulo);
      }

    }

    public static void listarEmpleadosCuarenta(Connection conn) throws SQLException {
        PreparedStatement st = conn.prepareStatement("SELECT nombre FROM empleados WHERE contrato <= ? ");
        st.setDate(1, Date.valueOf("1980-01-01"));

        ResultSet rs = st.executeQuery();

        while(rs.next()) {
            String nombre = rs.getString("nombre");
            System.out.println(String.format("Nombre: %s", nombre));
        }
    }

    public static void insertarDepartamento(Connection conn, int numeroDepartamento, String nombreDepartamento) throws SQLException {
        PreparedStatement st = conn.prepareStatement(("INSERT INTO departamentos (deptno, nombre) VALUES (?, ?)"));
        st.setInt(1, numeroDepartamento);
        st.setString(2, nombreDepartamento);

        int rowsAffected = st.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);

    }

    public static void listarDepartamentos(Connection conn) throws  SQLException {
        PreparedStatement st = conn.prepareStatement(("SELECT deptno, nombre FROM departamentos"));

        ResultSet rs = st.executeQuery();

        while(rs.next()) {
            int deptno = rs.getInt("deptno");
            String nombre = rs.getString("nombre");

            System.out.println(String.format("Departamento: %d --- Nombre: %s", deptno, nombre));
        }
    }

    public static void eliminarDepartamento(Connection conn, int numeroDepartamento, String nombreDepartamento) throws SQLException {
        PreparedStatement st = conn.prepareStatement("DELETE FROM departamentos WHERE deptno = ? OR nombre = ?");
        st.setInt(1, numeroDepartamento);
        st.setString(2, nombreDepartamento);
        int rowsAffected = st.executeUpdate();
        System.out.println("Rows affected: " + rowsAffected);
    }

    public static void main(String[]args) {
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            listarCategorias(conn);
            listarEmpleadosCuarenta(conn);

            Scanner sc = new Scanner(System.in);

            System.out.println("Introduce el numero de departamento: ");
           int numeroDepartamento = sc.nextInt();
           sc.nextLine();

           System.out.println("Introduce el nombre del departamento: ");
           String nombreDepartamento = sc.nextLine();
           insertarDepartamento(conn, numeroDepartamento, nombreDepartamento);
           listarDepartamentos(conn);
           eliminarDepartamento(conn, numeroDepartamento, nombreDepartamento);
           listarDepartamentos(conn);
        }

        catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
