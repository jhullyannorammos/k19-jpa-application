package br.com.application.util;

import br.com.application.model.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceFactory {

    private static EntityManagerFactory entityManagerFactory;
    
    public PersistenceFactory() {
    	this.entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
	}
    
    public static EntityManager getEntitymanager() {
    	return entityManagerFactory.createEntityManager();
    }

    public void close(EntityManager entityManager) {
        entityManager.close();
    }
}
