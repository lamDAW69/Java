package com.eoi.eventos_jpa_spring.eventos;


import com.eoi.eventos_jpa_spring.eventos.proyecciones.eventoSinUsuarios;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public evento insert(@RequestBody evento e) {
        return es.insert(e);
    }
}
