package org.example.dao;

import org.example.entities.Category;

import java.util.List;
import javax.persistence.EntityManager;

import org.example.connection.EntityManagerBuilder;

public class CategoryDAOHibernate implements CategoryDAO {


    @Override
    public List<Category> getCategories() {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        List<Category> list = em.createNamedQuery("Category.findAll").getResultList();  // "Category.findAll" is the name of the query that we defined in the Category entity
        em.close();
        return list;
    }

    @Override
    public int insertCategory(Category categoria) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager(); // We create an EntityManager object to interact with the database
        em.getTransaction().begin();    // We start a transaction
        em.persist(categoria);          // We insert the category into the database
        em.getTransaction().commit();   // We commit the transaction
        em.close();                     // We close the EntityManager object
        return categoria.getId();       // We return the id of the category s
    }

    @Override
    public void deleteCategory(int id) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        Category categoria = em.getReference(Category.class, id);  // We get the category by its id
        em.remove(categoria);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void updateCategory(Category categoria) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
        em.close();
    }
}
