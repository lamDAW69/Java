package com.eoi.firstspringproject.puntaciones;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class puntuacionesService {

    private final puntuacionesRepository puntuacionesRepository;

    public List<puntuacion> findAll(){
        return (List<puntuacion>) puntuacionesRepository.findAll();
    }

    public puntuacion findById(int id) {
        return puntuacionesRepository.findById(id)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Puntuación no encontrada", null));
    }

    public puntuacion save(puntuacion p) {
        return puntuacionesRepository.save(p);
    }

    public void delete(int id) {
        puntuacionesRepository.deleteById(id);
    }

}
