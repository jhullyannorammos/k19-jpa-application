package br.com.application.jpaTest;

import org.junit.Test;

import br.com.application.test.EntityManagerTest;

public class StartAndCloseConnection extends EntityManagerTest{
	
	@Test
    public void abrirEFecharATransacao() {

        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
    }

}
