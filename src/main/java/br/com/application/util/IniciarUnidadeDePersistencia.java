package br.com.application.util;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.application.model.Produto;

public class IniciarUnidadeDePersistencia {
	
	public static void startPersistence(String usuario, String password, String state) {
		
		Map properties = new HashMap<String, String>();
		properties.put("javax.persistence.jdbc.url", "jdbc:postgresql://localhost:5432/k19-applicacao?createDatabaseIfNotExist=true&amp;useTimezone=true&amp;serverTimezone=UTC");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("javax.persistence.jdbc.driver", "org.postgresql.Driver");
		properties.put("javax.persistence.jdbc.password", password);
		properties.put("javax.persistence.jdbc.user", usuario);
		
		properties.put("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
		properties.put("hibernate.hbm2ddl.auto", state);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU", properties);
		
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.close();
        entityManagerFactory.close();
	}

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Ecommerce-PU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Produto produto = entityManager.find(Produto.class, 1);
        //System.out.println(produto.getNome());

        entityManager.close();
        entityManagerFactory.close();
    }
}
