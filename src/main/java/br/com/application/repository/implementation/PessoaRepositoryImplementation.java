package br.com.application.repository.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;

import br.com.application.model.Pessoa;
import br.com.application.repository.PessoaRepository;

public class PessoaRepositoryImplementation implements PessoaRepository{
	
	@PersistenceContext private EntityManager manager;
	private Query query;
	
	private List<Pessoa> pessoas;
	private Pessoa pessoa;
	private String jpql = "SELECT p FROM Pessoa p";
	
	@Override
	public List<Pessoa> findByIdadeGreatesThen(int idade) {
		query = (Query) manager.createNamedQuery("Pessoa.findByIdadeGreatesThen");
		query.setParameter("idade", idade);
		pessoas = query.getResultList();
		return pessoas;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Pessoa> findByIdadeEquals(int idade) {
		query = (Query) manager.createNamedQuery("Pessoa.findByIdadeEquals");
		query.setParameter("idade", idade);
		pessoas = query.getResultList();
		return pessoas;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Pessoa> findAllByNamedQuery() {
		query = (Query) manager.createNamedQuery("Pessoa.findAll");
		pessoas = query.getResultList();
		return pessoas;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<String> findAllNomes() {
		TypedQuery<String> query = (Query) manager.createQuery("SELECT p.nome FROM Pessoa p", Pessoa.class);
		List<String> nomes = query.getResultList();
		return nomes;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Pessoa> findAllOrderBy() {
		TypedQuery<Pessoa> query = (Query) manager.createQuery(jpql, Pessoa.class);
		pessoas = query.getResultList();
		return pessoas;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Long findAllByidademaxima() {
		TypedQuery<Long> query = (Query) manager.createQuery("SELECT MAX(p.idade) FROM Pessoa p", Pessoa.class);
		return query.getSingleResult();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Long findAllCountBy() {
		TypedQuery<Long> query = (Query) manager.createQuery("SELECT COUNT(p) FROM Pessoa p", Pessoa.class);
		return query.getSingleResult();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Pessoa> findAll() {
		query = (Query) manager.createQuery(jpql);
		pessoas = query.getResultList();
		return pessoas;
	}

	@Override
	public Pessoa findBy(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa delete(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa merge(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

}
