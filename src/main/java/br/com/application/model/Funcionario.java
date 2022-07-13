package br.com.application.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PostPersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long id;
	
	private String nome;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar nascimento;
	
	@Temporal(TemporalType.DATE)
	private Calendar dataDeContratacao;
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Calendar getNascimento() {
		return nascimento;
	}

	public void setNascimento(Calendar nascimento) {
		this.nascimento = nascimento;
	}

	public Calendar getDataDeContratacao() {
		return dataDeContratacao;
	}

	public void setDataDeContratacao(Calendar dataDeContratacao) {
		this.dataDeContratacao = dataDeContratacao;
	}
	
	

}
