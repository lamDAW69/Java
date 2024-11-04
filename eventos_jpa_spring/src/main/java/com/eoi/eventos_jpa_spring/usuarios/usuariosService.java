package com.eoi.eventos_jpa_spring.usuarios;


import com.eoi.eventos_jpa_spring.usuarios.proyecciones.usuariosSinEventos;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class usuariosService {
    private final usuariosRepository ur;

    List<usuariosSinEventos> getAll() {
        return ur.findBy();
    }
}
