package br.com.application.repository;

import java.util.List;

import br.com.application.model.Categoria;

public interface CategoriaRepository {
	
	public List<Categoria> findAll();
	public Categoria findBy(Long codigo);
	public Categoria delete(Categoria categoria);
	public Categoria merge(Categoria categoria);

}
