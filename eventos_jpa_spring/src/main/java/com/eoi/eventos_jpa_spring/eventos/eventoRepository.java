package com.eoi.eventos_jpa_spring.eventos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.eoi.eventos_jpa_spring.eventos.proyecciones.eventoSinUsuarios;

import java.util.List;


@Repository
public interface eventoRepository extends JpaRepository {
    List<eventoSinUsuarios> findBy();
    //EventoConUsuarios findEventoById(int);
}
