package org.example.dao;

import org.example.connection.EntityManagerBuilder;
import org.example.entities.Category;
import org.example.entities.Product;

import javax.persistence.Entity;
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

    @Override
    public int insertProduct(Product product, int idCategory) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();

        Category category = em.find(Category.class, idCategory);

        product.setCategoria(category); // We set the category to the product

        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();
        em.close();

        return product.getId();

    }

    @Override
    public void deleteProduct(int id) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();

        em.getTransaction().begin();
        Product product = em.find(Product.class, id); // We find the product by its id

        em.remove(product); // We remove the product
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void updateProduct(Product product, int idCategory) {

        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();

        Category category = em.find(Category.class, idCategory); // We find the category by its id

        product.setCategoria(category); // We set the category to the product

        em.getTransaction().begin();
        em.merge(product); // We merge the product
        em.getTransaction().commit();
        em.close();


    }
}
