package org.example.dao;

import org.example.entities.Products;
import java.util.List;

public interface ProductsDAO {
    public List<Products> getProducts();
    public  void insertProduct(Products product);
    public void deleteProduct(int id);
    public void updateProduct(Products product);
}
