package com.eoi.eventos_jpa_spring.usuarios;

import com.eoi.eventos_jpa_spring.usuarios.proyecciones.usuariosSinEventos;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class usuarioController {
    private final usuariosService us;

    @GetMapping
    public List<usuariosSinEventos> getAll() {
        return us.getAll();
    }

    @PostMapping
    public usuario insert(@RequestBody usuario u) {
        return us.insert(u);
    }
}