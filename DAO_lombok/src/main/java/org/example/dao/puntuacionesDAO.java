package org.example.dao;

import org.example.entities.puntuaciones;

import java.util.List;

public interface puntuacionesDAO {

    public List<puntuaciones> getAll();
    public void insertPuntuacion(puntuaciones puntuacion);
    public void deletePuntuacion(puntuaciones puntuacion);
    public void updatePuntuacion(puntuaciones puntuacion);

}
