package com.eoi.eventos_jpa_spring.eventos;


import com.eoi.eventos_jpa_spring.eventos.proyecciones.eventoSinUsuarios;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class eventoController {
    private final eventoService es;

    @GetMapping
    public List<eventoSinUsuarios> getAll() {
        return es.getAll();
    }

}
