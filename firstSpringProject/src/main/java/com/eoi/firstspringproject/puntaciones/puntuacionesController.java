package com.eoi.firstspringproject.puntaciones;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/puntuaciones")
@RequiredArgsConstructor
public class puntuacionesController {

    private final puntuacionesService puntuacionesService;
    @GetMapping()
    public List<puntuacion> findAll(){
        return puntuacionesService.findAll();
    }
}