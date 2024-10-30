package com.eoi.firstspringproject.puntaciones;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public puntuacion findById(@PathVariable int id){  // @PathVariable es para que el id se pase por la url
        return puntuacionesService.findById(id);
    }

    @PostMapping //
    @ResponseStatus(HttpStatus.CREATED) // Para que devuelva el status 201
    public puntuacion insert(@RequestBody puntuacion puntuacion){ // @RequestBody es para que el objeto se pase por el body
        return puntuacionesService.save(puntuacion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Para que devuelva el status 204
    public void delete(@PathVariable int id){
        puntuacionesService.delete(id);
    }

}