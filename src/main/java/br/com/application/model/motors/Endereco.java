package br.com.application.model.motors;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	@Column(length = 3, nullable = false) 
	private String descricao;
	
	@Column(length = 20, nullable = false) 
	private String numero;
	
	@Column(length = 8) 
	private String cep;
	
	private String complemento;
	private String logradouro;
	private String cidade;
	private String estado;
	private String pais;

	public Endereco() {
		
	}

	public Endereco(String descricao, String numero, String cep) {
		super();
		this.descricao = descricao;
		this.numero = numero;
		this.cep = cep;
	}

	
	

}
