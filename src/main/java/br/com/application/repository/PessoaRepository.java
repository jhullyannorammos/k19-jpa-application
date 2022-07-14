package br.com.application.repository;

import java.util.List;

import br.com.application.model.Pessoa;

public interface PessoaRepository {
	
	public List<Pessoa> findByIdadeGreatesThen(int idade);
	public List<Pessoa> findByIdadeEquals(int idade);
	public List<Pessoa> findAllByNamedQuery();
	public List<Pessoa> findAllOrderBy();
	public List<String> findAllNomes();
	public Long findAllByidademaxima();
	public List<Pessoa> findAll();
	public Long findAllCountBy();
	
	public Pessoa findBy(Long codigo);
	public Pessoa delete(Pessoa pessoa);
	public Pessoa merge(Pessoa pessoa);

}
