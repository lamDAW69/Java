package org.example.dao;

import org.example.connection.EntityManagerBuilder;
import org.example.entities.User;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAOHibernate implements UserDAO {
    @Override
    public List<User> getUsers() {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        List<User> users = em.createNamedQuery("User.findAll").getResultList();
        em.close();
        return users;
    }

    @Override
    public int insertUser(User user) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return user.getId();
    }

    public void deleteUser(int id) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, id);
        em.remove(user);
        em.getTransaction().commit();
        em.close();

    }

    public void updateUser(User user) {
        EntityManager em = EntityManagerBuilder.getEntityManagerFactory().createEntityManager();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }

}
