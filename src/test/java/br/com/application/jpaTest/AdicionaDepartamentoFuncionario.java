package br.com.application.jpaTest;

import java.util.Calendar;

import org.junit.Test;

import br.com.application.model.Departamento;
import br.com.application.model.Funcionario;
import br.com.application.test.EntityManagerTest;
import br.com.application.util.DateUtil;

public class AdicionaDepartamentoFuncionario extends EntityManagerTest {
	
	@Test
	public void AdicionaDepartamentoFuncionario() throws Exception {
		
		Funcionario f = new Funcionario();
		f.setNascimento(DateUtil.converterStringToCalendar("21/09/1988"));
		f.setNome("Natasha Romanoff");
		
		Departamento d = new Departamento();
		d.setNome("Analise e estatistica criminal");
		d.getFuncionarios().add(f);
		
		entityManager.getTransaction().begin();
        entityManager.persist(f);
        entityManager.persist(d);
        entityManager.getTransaction().commit();
        
        entityManager.clear();
	}

}
