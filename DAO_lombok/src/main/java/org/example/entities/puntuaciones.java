package org.example.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class puntuaciones {
    private String jugador;
    private int puntuacion;

    @Override
    public String toString() {
        return "puntuaciones{" +
                "jugador='" + jugador + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}
