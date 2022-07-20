package br.com.application.jpaTest;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.application.model.motors.Automovel;
import br.com.application.persistence.util.JpaUtil;

public class PersistindoVeiculo {

	public void buscando() {
		EntityManager manager = JpaUtil.getEntityManager();
		Automovel veiculo = manager.find(Automovel.class, 1L);
		System.out.println("Veículo de código " + veiculo.getId() + " é um " + veiculo.getModelo());
		manager.close();
		JpaUtil.close();
	}

	public static void main(String[] args) {
		EntityManager manager = JpaUtil.getEntityManager();
		Automovel veiculo = manager.getReference(Automovel.class, 1L);
		System.out.println("Veículo de código " + veiculo.getId() + " é um " + veiculo.getModelo());
		manager.close();
		JpaUtil.close();
	}

	public void PersistindoVeiculo() {
		EntityManager manager = JpaUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		Automovel veiculo = new Automovel();
		veiculo.setFabricante("Honda");
		// veiculo.setModelo("Civic");
		veiculo.setAnoFabricacao(2012);
		veiculo.setAnoModelo(2013);
		veiculo.setValor(new BigDecimal(71300));

		manager.persist(veiculo);
		tx.commit();
		manager.close();
		JpaUtil.close();
	}

}
