package com.eoi.product_manager.products;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class productService  {

    private final productRepository pr; //final es para que lo pille y se pueda inicializar (buena práctica)

    public List<product> getProducts() {
        return (List<product>) pr.findAll();
    }

    public product getProductById(int integer) {
        return pr.findById(integer)
                .orElseThrow(() ->
                         new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found", null));

    }

    public product insertProduct(product pro) {
        pro.setId(0);

        return pr.save(pro);
    }

    public product updateProduct(product pro, int id) {
        if (!pr.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found", null);
    }
    pro.setId(id);
    return pr.save(pro);
    }

    public void deleteProductById(Integer integer)  {
        if (!pr.existsById(integer)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found", null);
        }
        pr.deleteById(integer);

    }
}
