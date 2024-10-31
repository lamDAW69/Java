package products;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") //para permitir peticiones desde cualquier origen
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class productController {
    private final productService ps;

    @GetMapping
    public List<product> getProducts() {
        return ps.getProducts();
    }

    @GetMapping("/{id}")
    public product getProductById(@PathVariable int id) {
        return ps.getProductById(id);
    }

    @PostMapping
    public product insertProduct(@RequestBody product pro) {
        return ps.insertProduct(pro);
    }

    @PutMapping("/{id}")
    public product updateProduct(@RequestBody product pro , @PathVariable int id) {
        return ps.updateProduct(pro, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id) {
        ps.deleteProductById(id);
    }

}
