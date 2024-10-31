package com.eoi.product_manager.categories;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") //para permitir peticiones desde cualquier origen
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor

public class categoryController {
    private final categoryService categoryService;

    @GetMapping
    public List<category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Para que devuelva el status 201
    public category insertCategory(@RequestBody category category) {
        return categoryService.insertCategory(category);
    }

    @GetMapping("/{id}")
    public category getCategory(@PathVariable int id) {  //PathVariable es para que el id se pase por la url
        return categoryService.getCategory(id);
    }

}
