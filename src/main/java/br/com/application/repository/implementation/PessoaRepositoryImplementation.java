package br.com.application.repository.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.hibernate.query.Query;

import br.com.application.model.Pessoa;
import br.com.application.repository.PessoaRepository;

public class PessoaRepositoryImplementation implements PessoaRepository{
	
	String SQLSome = " SELECT Pessoa FROM Pessoa Pessoa WHERE Pessoa.nome = SOME(SELECT Pessoa2.titulo FROM Pessoa Pessoa2 WHERE Pessoa <> Pessoa2)";
	String SQLNot = " SELECT f FROM Funcionario f WHERE f NOT MEMBER OF f. empresa . diretoria ";
	String SQLWhere = " SELECT f FROM Funcionario f WHERE f MEMBER OF f. empresa . diretoria ";
	String SQLWhereNot = " SELECT p FROM Pessoa p WHERE NOT (p. idade >= : idade )";
	String SQLIsNotNull = " SELECT p FROM Pessoa p WHERE p.nome IS NOT NULL OR p. idade >= : idade ";
	String SQLWhereNotGreatestThan = "SELECT p FROM Pessoa p WHERE p.idade <: idade";
	String SQLWhereEqual = " SELECT p FROM Pessoa p WHERE p.idade <> : idade ";
	String SQLWhereNotGreatestOrEqualThan = " SELECT p FROM Pessoa p WHERE p.idade > : idade ";
	String SQLWhereGreatestOrEqualThan = " SELECT p FROM Pessoa p WHERE p.idade <= : idade ";
	String SQLWhereGreatestAndEqualThan = " SELECT p FROM Pessoa p WHERE p.idade >= : idade ";
	String SQLWhereEqualThan = " SELECT p FROM Pessoa p WHERE p.idade = : idade ";
	String SQLWhereIsNull = " SELECT p FROM Pessoa p WHERE p.nome IS NULL ";
	String SQLWhereIsNotNull = " SELECT p FROM Pessoa p WHERE p.nome IS NOT NULL ";
	String SQLBetween = " SELECT p FROM Pessoa p WHERE p.idade BETWEEN : minimo AND : maximo ";
	String SQLNotBetween = " SELECT p FROM Pessoa p WHERE p.idade NOT BETWEEN : minimo AND : maximo ";
	String SQLIsNotNullAnd = " SELECT p FROM Pessoa p WHERE p.nome IS NOT NULL AND p. idade >= : idade ";
	String SQLisNotEmpty = " SELECT a FROM Pessoa a WHERE a.Pessoas IS NOT EMPTY ";
	String SQLisEmpty = " SELECT a FROM Pessoa a WHERE a.Pessoas IS EMPTY ";
	String SQLExists = " SELECT d FROM Departamento d WHERE EXISTS(SELECT f FROM FUNCIONARIO f WHERE f. departamento = d)";
	String SQLNotExists = " SELECT d FROM Departamento d WHERE NOT EXISTS(SELECT f FROM FUNCIONARIO f WHERE f. departamento = d)";
	String SQLNotLike = " SELECT a FROM Pessoa a WHERE a.nome NOT LIKE Patrick %";
	String SQLike = " SELECT a FROM Pessoa a WHERE a.nome LIKE Patrick %";
	String SQLin = " SELECT a FROM Pessoa a WHERE a.nome IN ( ’ Patrick Cullen ’, ’Fraser Seitel ’)";
	String SQLnotIn = " SELECT a FROM Pessoa a WHERE a.nome NOT IN ( ’ Patrick Cullen ’, ’Fraser Seitel ’)";
	String SQLAll = " SELECT Pessoa FROM Pessoa Pessoa WHERE Pessoa.preco >= ALL( SELECT Pessoa.preco FROM Pessoa Pessoa )";
	String SQLany = " SELECT Pessoa FROM Pessoa Pessoa WHERE Pessoa.nome = ANY( SELECT Pessoa2.titulo FROM Pessoa Pessoa2 WHERE Pessoa <> Pessoa2 )";
	String SQLavg = " SELECT AVG(Pessoa.preco) FROM Pessoa Pessoa ";
	String SQLSum = " SELECT SUM(Pessoa.preco) FROM Pessoa Pessoa ";
	String SQLMin = " SELECT MIN(Pessoa.preco) FROM Pessoa Pessoa ";
	String SQLMax = " SELECT MAX(Pessoa.preco) FROM Pessoa Pessoa ";
	String SQLCount = " SELECT COUNT (Pessoa) FROM Pessoa Pessoa ";
	
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
		return manager.find(Pessoa.class, codigo, LockModeType.PESSIMISTIC_READ);
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
