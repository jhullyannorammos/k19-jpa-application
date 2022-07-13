package br.com.application.repository.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import br.com.application.model.Categoria;
import br.com.application.repository.CategoriaRepository;
import br.com.application.util.PersistenceFactory;

public class CategoriaRepositoryImplemention implements CategoriaRepository{
	
	@PersistenceContext EntityManager manager;
	
	public CategoriaRepositoryImplemention() {
		manager = PersistenceFactory.getEntitymanager();
	}

	@Override
	public List<Categoria> findAll() {
		return null;
	}

	@Override
	public Categoria findBy(Long codigo) {
		return null;
	}

	@Override
	public Categoria delete(Categoria categoria) {
		return null;
	}

	@Override
	public Categoria merge(Categoria categoria) {
		return manager.merge(categoria);
	}

}
