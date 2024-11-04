package com.eoi.eventos_jpa_spring.eventos;

import com.eoi.eventos_jpa_spring.eventos.proyecciones.eventoSinUsuarios;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class eventoService {
    private final eventoRepository ev;

    public List<eventoSinUsuarios> getAll() {
        return ev.findBy();
    }
}
