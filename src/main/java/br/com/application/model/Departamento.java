package br.com.application.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.JoinTable;
import javax.persistence.JoinColumns;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Departamento implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "codigo")
	private Long id;
	
	private String nome;
	
	@OneToMany
	@JoinTable(name="departamento_funcionarios", 
	           joinColumns=@JoinColumn(name="departamento_id"), 
	           inverseJoinColumns=@JoinColumn(name="funcionario_id"))
	private Collection<Funcionario> funcionarios;
	
	public Departamento() {
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

	public Collection<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	

}
