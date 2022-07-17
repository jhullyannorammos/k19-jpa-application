package br.com.application.repository;

import java.util.List;
import java.util.Map;

import javax.persistence.LockModeType;

import br.com.application.model.Dados;

public interface DadosRepository {
	
	public Dados findBy(Map properties, LockModeType lockMode, Long versao);
	public List<Dados> findAll();
	public Dados findBy(Long codigo);
	public Dados delete(Dados dados);
	public Dados merge(Dados dados);

}
