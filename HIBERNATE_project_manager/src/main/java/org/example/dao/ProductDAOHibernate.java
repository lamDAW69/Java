package org.example.dao;

import org.example.connection.EntityManagerBuilder;
import org.example.entities.Product;

import javax.persistence.EntityManager;
import java.util.List;

public class ProductDAOHibernate implements ProductDAO {

    @Override
    public List<Product> getProdutosCategoria(int idCategoria) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        List<Product> productos = em.createNamedQuery("Product.findByCategory", Product.class)
                .setParameter("idCategoria", idCategoria)
                .getResultList();

        return productos;
    }
}
