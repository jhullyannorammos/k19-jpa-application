package br.com.application.jpaTest;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.application.model.Produto;
import br.com.application.test.EntityManagerTest;

public class inserirProduto extends EntityManagerTest {
	
	@Test
    public void inserirOPrimeiroObjeto() {
        
		Produto produto = new Produto();

        produto.setNome("Câmera Canon");
        produto.setDescricao("A melhor definição para suas fotos.");
        produto.setPreco(new BigDecimal(5000));

        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();

        entityManager.clear();

        Produto produtoVerificacao = entityManager.find(Produto.class, produto.getId());
        Assert.assertNotNull(produtoVerificacao);
    }

}
