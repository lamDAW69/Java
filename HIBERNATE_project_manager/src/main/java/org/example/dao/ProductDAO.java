package org.example.dao;

import java.util.List;
import org.example.entities.Product;

public interface ProductDAO {
    List<Product> getProdutosCategoria(int idCategoria);
    public List<Product> getProducts();
    public int insertProduct(Product product, int category);
    public void updateProduct(Product product, int category);
    public void deleteProduct(int id);

}
