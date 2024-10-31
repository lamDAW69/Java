package com.eoi.product_manager.categories;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor

public class categoryService {

    private final categoryRepository categoryRepository;  //To initialize the repository

    public List<category> getCategories() {
        return (List<category>) categoryRepository.findAll();
    }

    public category getCategory(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found", null));
    }

    public category insertCategory(category cat) {
        cat.setId(0);// We set it to 0 so it will be inserted as a new category
        return categoryRepository.save(cat);
    }


    public category update(category cat, int id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found", null);
        }
        cat.setId(id);
        return categoryRepository.save(cat);
    }


    public void deleteById(Integer integer) {
        if (!categoryRepository.existsById(integer)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found", null);
        }
        categoryRepository.deleteById(integer);
    }
}
