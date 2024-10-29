package org.example.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerBuilder {

    private static EntityManagerFactory emf = null;  // EntityManagerFactory is a heavy object, so we only want one instance of it

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("HIBERNATE_project_manager"); // "HIBERNATE_project_manager" is the name of the persistence unit that connects with it through the persistence file
        }
        return emf;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;
        }
    }

}

//Test
