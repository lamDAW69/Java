package org.example.dao;

import java.util.List;
import org.example.entities.Product;

public interface ProductDAO {
    List<Product> getProdutosCategoria(int idCategoria);
}