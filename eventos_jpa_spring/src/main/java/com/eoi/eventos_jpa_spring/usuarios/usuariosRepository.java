package com.eoi.eventos_jpa_spring.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.eoi.eventos_jpa_spring.usuarios.proyecciones.usuariosSinEventos;

public interface usuariosRepository extends JpaRepository<usuario, Integer> {
    List<usuariosSinEventos> findBy();
}
