package com.eoi.firstspringproject.puntaciones;


import org.springframework.data.annotation.Id;

public record puntuacion(@Id Integer id, String jugador, int puntuacion) {
}
