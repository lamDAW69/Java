package org.example.dao;

import org.example.entities.puntuaciones;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class puntuacionesDAOMySql implements puntuacionesDAO {

    private final String url = "jdbc:mysql://localhost:3306/puntuaciones";
    private final String user = "root";
    private final String pass ="";

    @Override
    public List<puntuaciones> getAll() {

        List<puntuaciones> puntuaciones = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(db, user, pass)) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM puntuaciones");

            while(rs.next()) {
                puntuaciones.add(new puntuaciones(rs.getString("jugador"), rs.getInt("puntuacion")));
            }
        }   catch(SQLException e) {
            e.getMessage();
        }

        return puntuaciones;
    }

    @Override
    public void insertPuntuacion(puntuaciones puntuacion) {

        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement ps = conn.prepareStatement(("INSERT INTO puntuaciones (jugador, puntuacion VALUES (?), (?))"));
            ps.setString(1, puntuacion.getJugador());
            ps.setInt(2, puntuacion.getPuntuacion());
            ps.executeUpdate();
        } catch(SQLException e) {
            e.getMessage();
        }

    }

    @Override
    public void deletePuntuacion(puntuaciones puntuacion) {
        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement ps = conn.prepareStatement("DELETE FROM puntuaciones WHERE jugador = ?");
            ps.setString(1, puntuacion.getJugador());
            ps.executeUpdate();
        } catch(SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void updatePuntuacion(puntuaciones puntuacion) {
        try(Connection conn = DriverManager.getConnection(db, user, pass)) {
            PreparedStatement ps = conn.prepareStatement("UPDATE puntuaciones SET puntuacion = ? WHERE jugador = ?");
            ps.setInt(1, puntuacion.getPuntuacion());
            ps.setString(2, puntuacion.getJugador());
            ps.executeUpdate();
        } catch(SQLException e) {
            e.getMessage();
        }
    }
}
