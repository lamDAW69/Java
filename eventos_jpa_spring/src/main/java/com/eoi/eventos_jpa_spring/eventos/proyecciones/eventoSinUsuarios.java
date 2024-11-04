package com.eoi.eventos_jpa_spring.eventos.proyecciones;

import java.time.LocalDate;

public interface eventoSinUsuarios {

    int getId();
    String getTitulo();
    String getDescripcion();
    double getPrecio();
    LocalDate getFecha();
}
