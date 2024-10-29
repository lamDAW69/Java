package com.eoi.firstspringproject.puntaciones;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class puntuacionesService {

    private final puntuacionesRepository puntuacionesRepository;

    public List<puntuacion> findAll(){
        return (List<puntuacion>) puntuacionesRepository.findAll();
    }

}
