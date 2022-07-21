package br.com.application.model.motors;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	private String descricao;
	private String numero;
	private String cep;

	public Endereco() {
		
	}

	public Endereco(String descricao, String numero, String cep) {
		super();
		this.descricao = descricao;
		this.numero = numero;
		this.cep = cep;
	}

	@Column(length = 3, nullable = false)
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(length = 20, nullable = false)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(length = 8)
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
