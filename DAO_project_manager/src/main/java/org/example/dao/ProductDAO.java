package org.example.dao;

import org.example.entities.Product;
import java.util.List;

public interface ProductDAO {
    public List<Product> getProducts();
    public void insertProduct(Product product);
    public void deleteProduct(int id);
    public void updateProduct(Product product);
}
