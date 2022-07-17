package br.com.application.repository.implementation;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

import org.hibernate.query.Query;

import br.com.application.model.Dados;
import br.com.application.repository.DadosRepository;

public class DadosRepositoryImplementaion implements DadosRepository {

	@PersistenceContext private EntityManager manager;
	private Query query;
	
	@Override
	public List<Dados> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Dados findBy(Long codigo) {
		return manager.find(Dados.class, codigo, LockModeType.PESSIMISTIC_WRITE);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Dados findBy(Map properties, LockModeType lockMode, Long versao) {
		return manager.find(Dados.class, versao, LockModeType.PESSIMISTIC_READ, properties);
	}

	@Override
	public Dados delete(Dados dados) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dados merge(Dados dados) {
		return null;
	}

}
