package br.com.application.jpaTest;

import org.junit.Assert;
import org.junit.Test;

import br.com.application.model.Estado;
import br.com.application.model.Governador;
import br.com.application.test.EntityManagerTest;

public class AdicionaEstadoGovernador extends EntityManagerTest {
	
	@Test
	public void AdicionaEstadoGovernador() {
		
		Governador g = new Governador();
		g.setNome("Rafael Cosentino");
		
		Estado e = new Estado();
		e.setNome("Goiás");
		e.setGovernador(g);
		
		entityManager.getTransaction().begin();
        entityManager.persist(g);
        entityManager.persist(e);
        entityManager.getTransaction().commit();
        
        entityManager.clear();
        
           
		
	}

}
